package twilightforest;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import gregtech.common.blocks.GT_TileEntity_Ores;

public class GT_Integration_Utils {

    public static boolean isIntegrationEnabled = false;

    public static int getMappedGTMetaForOre(Block mOre) {

        if (mOre == Blocks.coal_ore) {
            return TwilightForestMod.GT_coalOreMeta;
        }

        if (mOre == Blocks.iron_ore) {
            return TwilightForestMod.GT_ironOreMeta;

        }
        if (mOre == Blocks.gold_ore) {
            return TwilightForestMod.GT_goldOreMeta;
        }

        if (mOre == Blocks.redstone_ore) {
            return TwilightForestMod.GT_redstoneOreMeta;
        }

        if (mOre == Blocks.lapis_ore) {
            return TwilightForestMod.GT_lapisOreMeta;
        }

        if (mOre == Blocks.emerald_ore) {
            return TwilightForestMod.GT_emeraldOreMeta;
        }
        if (mOre == Blocks.diamond_ore) {
            return TwilightForestMod.GT_diamondOreMeta;
        }

        return -1;
    }

    public static boolean placeGTOre(World aWorld, int aX, int aY, int aZ, Block mcOreBlock) {

        if (!isIntegrationEnabled) {
            return false;
        }

        int mappedMeta = getMappedGTMetaForOre(mcOreBlock);
        // Something wrong
        if (mappedMeta <= 0) {
            return false;
        }

        return GT_TileEntity_Ores.setOreBlock(aWorld, aX, aY, aZ, mappedMeta, TwilightForestMod.GT_useSmallOres, true);

    }

    public static void init() {
        isIntegrationEnabled = true;
    }

    public static boolean isInit() {
        return isIntegrationEnabled;
    }
}
