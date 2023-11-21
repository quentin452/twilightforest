package twilightforest.client.renderer.entity;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;

import com.mojang.authlib.GameProfile;

import lain.mods.skinport.init.forge.ClientProxy;
import lain.mods.skins.api.SkinProviderAPI;
import lain.mods.skins.api.interfaces.ISkin;
import lain.mods.skins.impl.PlayerProfile;
import lain.mods.skins.impl.SkinData;

public class RenderTFGiantSkinportIntegration {

    public static ResourceLocation getSkin(EntityClientPlayerMP player, ResourceLocation skin,
            ResourceLocation textureLoc) {
        ResourceLocation skin1 = ClientProxy.bindTexture(Minecraft.getMinecraft().thePlayer.getGameProfile(), skin);
        GameProfile profile = player.getGameProfile();
        if (profile != null) {
            ISkin iskin = SkinProviderAPI.SKIN.getSkin(PlayerProfile.wrapGameProfile(profile));
            if (iskin != null && iskin.isDataReady()) {
                ByteBuffer data = iskin.getData();
                try (InputStream in = SkinData.wrapByteBufferAsInputStream(data);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                    BufferedImage bufferedImage = ImageIO.read(in);
                    if (bufferedImage != null) {
                        if (bufferedImage.getWidth() == bufferedImage.getHeight()) {
                            bufferedImage = bufferedImage
                                    .getSubimage(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() / 2);
                        }
                        skin1 = Minecraft.getMinecraft().getTextureManager()
                                .getDynamicTextureLocation(" ", new DynamicTexture(bufferedImage));
                    }
                } catch (Throwable t) {
                    skin1 = textureLoc;
                }
            }
        }
        return skin1;
    }
}
