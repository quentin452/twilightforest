package twilightforest.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.client.renderer.TFFieryMetalBlockRenderer;

public class ItemBlockTFCompressed extends ItemBlock {

    public ItemBlockTFCompressed(Block block) {
        super(block);
        hasSubtypes = true;
        // if (block instanceof BlockTFCompressed && ((BlockTFCompressed) block).type == BlockType.FIERY_METAL)
        MinecraftForgeClient.registerItemRenderer(this, new TFFieryMetalBlockRenderer());
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List,
            boolean par4) {
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StatCollector.translateToLocal("itemBlock.compressed.tooltip"));
    }

}
