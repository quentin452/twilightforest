package twilightforest.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
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
        if (TwilightForestMod.isSkinportLoaded) {
            if (RenderTFGiantSkinportIntegration.isSlim(Minecraft.getMinecraft().thePlayer)) {
                this.modelBipedMain.bipedRightArm = new ModelRenderer(this.modelBipedMain, 40, 16);
                this.modelBipedMain.bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0);
                this.modelBipedMain.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);

                this.modelBipedMain.bipedLeftArm = new ModelRenderer(this.modelBipedMain, 40, 16);
                this.modelBipedMain.bipedLeftArm.mirror = true;
                this.modelBipedMain.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0);
                this.modelBipedMain.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            }
        }

        float scale = 4.0F;
        GL11.glScalef(scale, scale, scale);
    }
}
