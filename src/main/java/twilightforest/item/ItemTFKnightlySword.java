package twilightforest.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;

public class ItemTFKnightlySword extends ItemSword {

    private static final int BONUS_DAMAGE = 2;
    private Entity bonusDamageTarget;
    private EntityPlayer bonusDamageAttacker;

    public ItemTFKnightlySword(Item.ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.setCreativeTab(TFItems.creativeTab);
    }

    /**
     * Return an item rarity from EnumRarity
     * 
     * This is automatically rare
     */
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        // repair with knightmetal ingots
        return par2ItemStack.getItem() == TFItems.knightMetal ? true
                : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Called when the player Left Clicks (attacks) an entity. Processed before damage is done, if return value is true
     * further processing is canceled and the entity is not attacked.
     * 
     * @param stack  The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        // extra damage to armored targets
        if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getTotalArmorValue() > 0) {
            this.bonusDamageTarget = entity;
            this.bonusDamageAttacker = player;
        }

        return false;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (this.bonusDamageAttacker != null && this.bonusDamageTarget != null && target == this.bonusDamageTarget) {
            // System.out.println("Knightly Sword extra damage!");
            if (bonusDamageAttacker instanceof EntityPlayer)
                ((EntityPlayer) this.bonusDamageAttacker).onEnchantmentCritical(bonusDamageTarget);
            if (this.bonusDamageTarget instanceof EntityLivingBase) target.lastDamage = 0;
            this.bonusDamageTarget.attackEntityFrom(DamageSource.causeMobDamage(bonusDamageAttacker), BONUS_DAMAGE);
            this.bonusDamageAttacker = null;
            this.bonusDamageTarget = null;
        }
        return super.hitEntity(stack, target, attacker);
    }

    /**
     * Properly register icon source
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister
                .registerIcon(TwilightForestMod.ID + ":" + this.getUnlocalizedName().substring(5));
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List,
            boolean par4) {
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip"));
    }
}
