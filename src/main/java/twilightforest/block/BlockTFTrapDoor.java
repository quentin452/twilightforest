package twilightforest.block;

import java.util.List;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import twilightforest.client.renderer.BetterIconFlipped;
import twilightforest.item.TFItems;

public class BlockTFTrapDoor extends BlockTrapDoor {

    public static final String[] names = new String[] { "twilight_oak", "canopy", "mangrove", "dark", "time", "trans",
            "mine", "sort" };
    private int material;
    /** Set this to allow trapdoors to remain free-floating */
    public static boolean disableValidation = false;
    private IIcon[] icons;

    protected BlockTFTrapDoor(int material) {
        super(Material.wood);
        this.material = material;
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setCreativeTab(TFItems.creativeTab);
    }

    protected BlockTFTrapDoor() {
        super(Material.wood);
        this.material = 0;
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setCreativeTab(TFItems.creativeTab);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        IIcon icon;

        switch (meta) {
            default:
            case 0:
            case 8:
            case 4:
            case 5:
            case 6:
            case 7:
                icon = icons[1];
                break;
            case 1:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
                icon = icons[0];
                break;
            case 2:
            case 10:
                icon = icons[2];
                break;
            case 3:
            case 11:
                icon = icons[3];
                break;
        }

        return icon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess worldIn, int x, int y, int z, int side) {
        return this.getIcon(side, worldIn.getBlockMetadata(x, y, z));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[4];
        this.icons[0] = reg
                .registerIcon(TwilightForestMod.ID + ":wood/trapdoor/" + names[material] + "_trapdoor_vertical");
        this.icons[1] = new BetterIconFlipped(this.icons[0], true, true);
        this.icons[2] = reg
                .registerIcon(TwilightForestMod.ID + ":wood/trapdoor/" + names[material] + "_trapdoor_horizontal");
        this.icons[3] = new BetterIconFlipped(this.icons[2], true, true);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List<ItemStack> itemList) {
        itemList.add(new ItemStack(item, 1, 0));

    }
}
