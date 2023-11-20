package twilightforest.client.renderer.entity;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Loader;
import lain.mods.skins.api.SkinProviderAPI;
import lain.mods.skins.api.interfaces.ISkin;
import lain.mods.skins.impl.LegacyConversion;
import lain.mods.skins.impl.PlayerProfile;
import lain.mods.skins.impl.SkinData;
import lain.mods.skinport.init.forge.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderTFGiant extends RenderBiped {

	private ResourceLocation textureLoc;

	public RenderTFGiant() {
		super(new ModelBiped(), 0.625F);
		
		this.textureLoc = new ResourceLocation("textures/entity/steve.png");
	}

	/**
	 * Return our specific texture
	 */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
    	ResourceLocation skin;
    	EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
    	if (player.getLocationSkin() != null) {
    		skin = Minecraft.getMinecraft().thePlayer.getLocationSkin();
    	} else {
    		skin = textureLoc;
    	}
    	if(Loader.isModLoaded("skinport")) {
    		skin = ClientProxy.bindTexture(Minecraft.getMinecraft().thePlayer.getGameProfile(), skin);
	    	GameProfile profile = player.getGameProfile();
	        if (profile != null) {
	            ISkin iskin = SkinProviderAPI.SKIN.getSkin(PlayerProfile.wrapGameProfile(profile));
	            if (iskin != null && iskin.isDataReady()) {
			        ByteBuffer data = iskin.getData();
			        try (InputStream in = SkinData.wrapByteBufferAsInputStream(data); ByteArrayOutputStream baos = new ByteArrayOutputStream())
			        {
			            BufferedImage bufferedImage = ImageIO.read(in);
			            if (bufferedImage != null)
			            {
			            	if(bufferedImage.getWidth() == bufferedImage.getHeight())
							{
								bufferedImage = bufferedImage.getSubimage(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() / 2);
							}
			            	/*else {
								int newW = bufferedImage.getWidth();
								int newH = bufferedImage.getHeight() * 2;
								BufferedImage dimg = new BufferedImage(newW, newH, bufferedImage.getType());
							    Graphics2D g = dimg.createGraphics();
							    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
							    g.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1, 0, 0, bufferedImage.getWidth() - 1, bufferedImage.getHeight() - 1, null);
							    //Копируем ногу
							    g.drawImage(bufferedImage, 0, bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 4 - 1, bufferedImage.getHeight() - 1, bufferedImage.getWidth() / 4, bufferedImage.getHeight() / 2 * 3, bufferedImage.getWidth() / 2 - 1, bufferedImage.getHeight() * 2 - 1, null);
							    //Копируем руку
							    g.drawImage(bufferedImage, bufferedImage.getHeight() / 8 * 5, bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 8 * 7 - 1, bufferedImage.getHeight() - 1, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2 * 3, bufferedImage.getWidth() / 4 * 3 - 1, bufferedImage.getHeight() - 1, null);
							    g.dispose();
							    bufferedImage = dimg;
			            	}*/
							skin = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation(" ", new DynamicTexture(bufferedImage));
			            }
			        }
			        catch (Throwable t)
			        {
			    		skin = textureLoc;
			        }
	            }
	        }
    	}
    	return skin;
    }
    
    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
    	float scale = 4.0F;
        GL11.glScalef(scale, scale, scale);
    }
}
