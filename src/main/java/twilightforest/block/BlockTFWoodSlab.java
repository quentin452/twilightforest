package twilightforest.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFWoodSlab extends BlockSlab {

    public static final String[] names = new String[] { "twilight_oak", "canopy", "mangrove", "darkwood", "time",
            "trans", "mine", "sort" };

    public BlockTFWoodSlab(boolean p_i45437_1_) {
        super(p_i45437_1_, Material.wood);
        this.setCreativeTab(TFItems.creativeTab);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeWood);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return TFBlocks.planks.getIcon(side, meta & 7);
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(TFBlocks.woodenSlab);
    }

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int meta) {
        return new ItemStack(Item.getItemFromBlock(TFBlocks.woodenSlab), 2, meta & 7);
    }

    public String func_150002_b(int p_150002_1_) {
        if (p_150002_1_ < 0 || p_150002_1_ >= names.length) {
            p_150002_1_ = 0;
        }

        return super.getUnlocalizedName() + "." + p_150002_1_;
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<net.minecraft.item.ItemStack> list) {
        if (itemIn != Item.getItemFromBlock(TFBlocks.doubleWoodenSlab)) {
            for (int i = 0; i < names.length; ++i) {
                list.add(new ItemStack(itemIn, 1, i));
            }
        }
    }

    /**
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(this.getItem(world, x, y, z), 1, this.getDamageValue(world, x, y, z));
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    @Override
    public int damageDropped(int meta) {
        return meta % 8;
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    @Override
    public int getDamageValue(World worldIn, int x, int y, int z) {
        return this.damageDropped(worldIn.getBlockMetadata(x, y, z));
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, int x, int y, int z) {
        return Item.getItemFromBlock(TFBlocks.woodenSlab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {}
}
