package twilightforest;

import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class GT_Integration_Utils {

    ///

    static Class<?> GT_TileEntity_OresClass;
    static Method methodSetOreBlock;
    //

    static boolean isFailed;

    public static void init() {

        try {
            // Try GetNeededClass
            extractClasses();

            extractMhetods();

        } catch (Exception e) {
            isFailed = true;
            e.printStackTrace();
        }
    }

    public static boolean isIntegrationFailed() {
        return isFailed;
    }

    static void extractClasses() throws ClassNotFoundException {
        GT_TileEntity_OresClass = Class.forName("gregtech.common.blocks.GT_TileEntity_Ores");
    }

    static void extractMhetods() throws NoSuchMethodException {
        // Extract Method

        methodSetOreBlock = GT_TileEntity_OresClass.getDeclaredMethod(
                "setOreBlock",
                World.class,
                int.class,
                int.class,
                int.class,
                int.class,
                boolean.class);

    }

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

    public static boolean placeGTOre(World aWorld, int aX, int aY, int aZ, Block mcOreBlock, boolean isSmallOre) {

        if (isIntegrationFailed()) {
            return false;
        }
        int mappedMeta = getMappedGTMetaForOre(mcOreBlock);
        // Something wrong
        if (mappedMeta <= 0) {
            return false;
        }

        return setOreBlock(aWorld, aX, aY, aZ, mappedMeta, isSmallOre);

    }

    public static boolean setOreBlock(World aWorld, int aX, int aY, int aZ, int aMetaData, boolean isSmallOre) {

        if (isIntegrationFailed()) {
            return false;
        }

        try {
            return (boolean) methodSetOreBlock.invoke(null, aWorld, aX, aY, aZ, aMetaData, isSmallOre);

        } catch (Exception e) {
            e.printStackTrace();
            isFailed = true;
        }

        return false;
    }

}
