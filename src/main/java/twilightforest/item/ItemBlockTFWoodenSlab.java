package twilightforest.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

import twilightforest.block.BlockTFWoodSlab;

public class ItemBlockTFWoodenSlab extends ItemSlab {

    public ItemBlockTFWoodenSlab(Block block, BlockTFWoodSlab singleSlab, BlockTFWoodSlab doubleSlab,
            Boolean isDouble) {
        super(block, singleSlab, doubleSlab, isDouble);
    }

}
