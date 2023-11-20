package twilightforest.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFNagastoneStairs extends BlockStairs {
	
	public boolean facingRight = false;
	public BlockTFNagastoneEtched parentBlock;
	public int parentMeta;
	
	BlockTFNagastoneStairs(int meta, boolean fr){
		super(new BlockTFNagastoneEtched(), meta);
		parentBlock = new BlockTFNagastoneEtched();
		parentMeta = meta;
		facingRight = fr;
		this.setCreativeTab(TFItems.creativeTab);
	}

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.parentBlock.getIcon(side, this.parentMeta);
    }
	
    /**
     * The type of render function that is called for this block
     */
    @Override
	public int getRenderType()
    {
    	return TwilightForestMod.proxy.getNagastoneEtchedStairsBlockRenderID();
    }
    
	/**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
}
