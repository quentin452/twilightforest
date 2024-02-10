package twilightforest.block;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFSpiralBricks extends Block {

    private IIcon spiralInnerDown;
    private IIcon spiralInnerLeft;
    private IIcon spiralInnerRight;
    private IIcon spiralInnerUp;
    private IIcon spiralShadowX;
    private IIcon spiralShadowXFix;
    private IIcon spiralShadowZ;
    private IIcon spiralCornerLeftDown;
    private IIcon spiralCornerLeftUp;
    private IIcon spiralCornerRightDown;
    private IIcon spiralCornerRightUp;
    private IIcon spiralCornerLeftDownMirrored;
    private IIcon spiralCornerLeftUpMirrored;
    private IIcon spiralCornerRightDownMirrored;
    private IIcon spiralCornerRightUpMirrored;
    private IIcon stonebrickCarvedFix;

    public enum RenderMode {
        UEX,
        UEY,
        UEXY,
        UWX,
        UWY,
        UWXY,
        USZ,
        USY,
        USZY,
        UNZ,
        UNY,
        UNZY,
        DEX,
        DEY,
        DEXY,
        DWX,
        DWY,
        DWXY,
        DSZ,
        DSY,
        DSZY,
        DNZ,
        DNY,
        DNZY,
        DEXInv,
        DEYInv
    };

    private RenderMode renderMode = RenderMode.DEX;

    public BlockTFSpiralBricks() {
        super(Material.rock);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundTypeStone);

        this.setCreativeTab(TFItems.creativeTab);
    }

    public void SetRenderMode(RenderMode rm) {
        renderMode = rm;
    }

    /**
     * Checks if the block is a solid face on the given side, used by placement logic.
     *
     * @param world The current world
     * @param x     X Position
     * @param y     Y position
     * @param z     Z position
     * @param side  The side to check
     * @return True if the block is solid on the specified side.
     */
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
        int meta = world.getBlockMetadata(x, y, z);

        switch (side) {
            case UP:
            case DOWN:
                return true;
            case EAST:
            case WEST:
                return meta == 0 || meta == 1 || meta == 4 || meta == 5;
            case NORTH:
            case SOUTH:
                return meta == 2 || meta == 3 || meta == 6 || meta == 7;
            default:
                return false;
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public IIcon getIcon(int side, int meta) {
        switch (renderMode) {
            case DEXInv:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralInnerUp;
                    case 2:
                        return spiralCornerRightDownMirrored;
                    case 3:
                        return spiralCornerLeftDown;
                    case 4:
                        return stonebrickCarvedFix;
                    case 5:
                        return spiralShadowX;
                }
            case DEYInv:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralCornerRightDownMirrored;
                    case 3:
                        return spiralCornerLeftDown;
                    case 4:
                        return stonebrickCarvedFix;
                    case 5:
                        return spiralInnerUp;
                }
            default:
            case DEX:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralInnerUp;
                    case 2:
                        return spiralCornerRightDownMirrored;
                    case 3:
                        return spiralCornerLeftDown;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralShadowXFix;
                }
            case DEY:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralCornerRightDownMirrored;
                    case 3:
                        return spiralCornerLeftDown;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralInnerUp;
                }
            case DEXY:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralInnerRight;
                    case 3:
                        return spiralInnerRight;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralShadowX;
                }
            case DWX:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralInnerUp;
                    case 2:
                        return spiralCornerLeftDownMirrored;
                    case 3:
                        return spiralCornerRightDown;
                    case 4:
                        return spiralShadowX;
                    case 5:
                        return stonebrickCarvedFix;
                }
            case DWY:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralCornerLeftDownMirrored;
                    case 3:
                        return spiralCornerRightDown;
                    case 4:
                        return spiralInnerUp;
                    case 5:
                        return stonebrickCarvedFix;
                }
            case DWXY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowZ;
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralInnerLeft;
                    case 3:
                        return spiralInnerLeft;
                    case 4:
                        return spiralShadowX;
                    case 5:
                        return spiralShadowX;
                }
            case UEX:
                switch (side) {
                    default:
                    case 0:
                        return spiralInnerUp;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralCornerRightUpMirrored;
                    case 3:
                        return spiralCornerLeftUp;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralShadowXFix;
                }
            case UEY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowZ;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralCornerRightUpMirrored;
                    case 3:
                        return spiralCornerLeftUp;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralInnerDown;
                }
            case UEXY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowZ;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralInnerRight;
                    case 3:
                        return spiralInnerRight;
                    case 4:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 5:
                        return spiralShadowX;
                }
            case UWX:
                switch (side) {
                    default:
                    case 0:
                        return spiralInnerUp;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralCornerLeftUpMirrored;
                    case 3:
                        return spiralCornerRightUp;
                    case 4:
                        return spiralShadowX;
                    case 5:
                        return stonebrickCarvedFix;
                }
            case UWY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowZ;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralCornerLeftUpMirrored;
                    case 3:
                        return spiralCornerRightUp;
                    case 4:
                        return spiralInnerDown;
                    case 5:
                        return stonebrickCarvedFix;
                }
            case UWXY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowZ;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralInnerLeft;
                    case 3:
                        return spiralInnerLeft;
                    case 4:
                        return spiralShadowX;
                    case 5:
                        return Blocks.stonebrick.getIcon(0, 3);
                }
            case DNZ:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralInnerUp;
                    case 2:
                        return spiralShadowXFix;
                    case 3:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 4:
                        return spiralCornerRightDown;
                    case 5:
                        return spiralCornerLeftDownMirrored;
                }
            case DNY:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowZ;
                    case 2:
                        return spiralInnerUp;
                    case 3:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 4:
                        return spiralCornerRightDown;
                    case 5:
                        return spiralCornerLeftDownMirrored;
                }
            case DNZY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return spiralShadowX;
                    case 2:
                        return spiralShadowX;
                    case 3:
                        return spiralShadowX;
                    case 4:
                        return spiralInnerLeft;
                    case 5:
                        return spiralInnerLeft;
                }
            case DSZ:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralInnerUp;
                    case 2:
                        return stonebrickCarvedFix;
                    case 3:
                        return spiralShadowX;
                    case 4:
                        return spiralCornerLeftDown;
                    case 5:
                        return spiralCornerRightDownMirrored;
                }
            case DSY:
                switch (side) {
                    default:
                    case 0:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 1:
                        return spiralShadowX;
                    case 2:
                        return stonebrickCarvedFix;
                    case 3:
                        return spiralInnerUp;
                    case 4:
                        return spiralCornerLeftDown;
                    case 5:
                        return spiralCornerRightDownMirrored;
                }
            case DSZY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return spiralShadowX;
                    case 2:
                        return spiralShadowX;
                    case 3:
                        return spiralShadowX;
                    case 4:
                        return spiralInnerRight;
                    case 5:
                        return spiralInnerRight;
                }
            case UNZ:
                switch (side) {
                    default:
                    case 0:
                        return spiralInnerUp;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralShadowXFix;
                    case 3:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 4:
                        return spiralCornerRightUp;
                    case 5:
                        return spiralCornerLeftUpMirrored;
                }
            case UNY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralInnerDown;
                    case 3:
                        return stonebrickCarvedFix;
                    case 4:
                        return spiralCornerRightUp;
                    case 5:
                        return spiralCornerLeftUpMirrored;
                }
            case UNZY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return spiralShadowX;
                    case 3:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 4:
                        return spiralInnerLeft;
                    case 5:
                        return spiralInnerLeft;
                }
            case USZ:
                switch (side) {
                    default:
                    case 0:
                        return spiralInnerUp;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return stonebrickCarvedFix;
                    case 3:
                        return spiralShadowX;
                    case 4:
                        return spiralCornerLeftUp;
                    case 5:
                        return spiralCornerRightUpMirrored;
                }
            case USY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return stonebrickCarvedFix;
                    case 3:
                        return spiralInnerDown;
                    case 4:
                        return spiralCornerLeftUp;
                    case 5:
                        return spiralCornerRightUpMirrored;
                }
            case USZY:
                switch (side) {
                    default:
                    case 0:
                        return spiralShadowX;
                    case 1:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 2:
                        return Blocks.stonebrick.getIcon(0, 3);
                    case 3:
                        return spiralShadowX;
                    case 4:
                        return spiralInnerRight;
                    case 5:
                        return spiralInnerRight;
                }
        }
    }

    /**
     * Properly register icon source
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.spiralInnerDown = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_inner_down");
        this.spiralInnerLeft = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_inner_left");
        this.spiralInnerRight = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_inner_right");
        this.spiralInnerUp = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_inner_up");
        this.spiralShadowX = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_shadow_x");
        this.spiralShadowXFix = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_shadow_x_fix");
        this.spiralShadowZ = par1IconRegister.registerIcon(TwilightForestMod.ID + ":spiral_shadow_z");
        this.spiralCornerLeftDown = par1IconRegister.registerIcon(TwilightForestMod.ID + ":stone_spiral_left_down");
        this.spiralCornerLeftUp = par1IconRegister.registerIcon(TwilightForestMod.ID + ":stone_spiral_left_up");
        this.spiralCornerRightDown = par1IconRegister.registerIcon(TwilightForestMod.ID + ":stone_spiral_right_down");
        this.spiralCornerRightUp = par1IconRegister.registerIcon(TwilightForestMod.ID + ":stone_spiral_right_up");
        this.spiralCornerLeftDownMirrored = par1IconRegister
                .registerIcon(TwilightForestMod.ID + ":stone_spiral_left_down_mirrored");
        this.spiralCornerLeftUpMirrored = par1IconRegister
                .registerIcon(TwilightForestMod.ID + ":stone_spiral_left_up_mirrored");
        this.spiralCornerRightDownMirrored = par1IconRegister
                .registerIcon(TwilightForestMod.ID + ":stone_spiral_right_down_mirrored");
        this.spiralCornerRightUpMirrored = par1IconRegister
                .registerIcon(TwilightForestMod.ID + ":stone_spiral_right_up_mirrored");
        this.stonebrickCarvedFix = par1IconRegister.registerIcon(TwilightForestMod.ID + ":stonebrick_carved_fix");
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType() {
        return TwilightForestMod.proxy.getSpiralBricksBlockRenderID();
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates. Args: blockAccess, x, y, z, side
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return true;
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        int i1 = world.getBlockMetadata(x, y, z) & 4;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2 | i1, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 1 | i1, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3 | i1, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 0 | i1, 2);
        }
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ,
            int metadata) {
        return side != 0 && (side == 1 || (double) hitY <= 0.5D) ? metadata : metadata | 4;
    }

}
