package twilightforest.block;

import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;
import twilightforest.tileentity.TileEntityTFChest;

public class BlockTFChest extends BlockChest {

    public enum WoodType {
        TWILIGHT,
        CANOPY,
        MANGROVE,
        DARKWOOD,
        TIME,
        TRANS,
        MINING,
        SORT,
        NULL
    }

    private WoodType material = WoodType.CANOPY;

    protected BlockTFChest(int type, WoodType material) {
        super(type);
        this.material = material;
        this.setHardness(2.5F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(TFItems.creativeTab);
    }

    public WoodType getWoodType() {
        return material;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        this.blockIcon = reg
                .registerIcon(TwilightForestMod.ID + ":wood/planks_" + BlockTFWood.names[material.ordinal()] + "_0");
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return TwilightForestMod.proxy.getChestBlockRenderID();
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        TileEntityTFChest tileentitychest = new TileEntityTFChest();
        return tileentitychest;
    }

}
