package twilightforest.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import twilightforest.TwilightForestMod;

public class RenderTFGiant extends RenderBiped {

    private ResourceLocation textureLoc;

    public RenderTFGiant() {
        super(new ModelBiped(), 0.625F);

        this.textureLoc = new ResourceLocation("textures/entity/steve.png");
    }

    /**
     * Return our specific texture
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        ResourceLocation skin;
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        if (player.getLocationSkin() != null) {
            skin = Minecraft.getMinecraft().thePlayer.getLocationSkin();
        } else {
            skin = textureLoc;
        }
        if (TwilightForestMod.isSkinportLoaded) {
            skin = RenderTFGiantSkinportIntegration.getSkin(player, skin, textureLoc);
        }
        return skin;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        float scale = 4.0F;
        GL11.glScalef(scale, scale, scale);
    }
}
