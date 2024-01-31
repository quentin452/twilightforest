package twilightforest.gt_integration;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class GT_Integration_Utils {

    static GT_OrePlacer orePlacer;

    public static void init() {
        // Create worker obj
        orePlacer = new GT_OrePlacer();

    }

    public static boolean isInit() {
        return orePlacer != null;
    }

    public static boolean doPlaceGTOre(World aWorld, int aX, int aY, int aZ, Block mcOreBlock) {
        if (!isInit()) {
            return false;
        }
        return orePlacer.placeGTOre(aWorld, aX, aY, aZ, mcOreBlock);
    }

    public static GT_OrePlacer getOrePlacer() {
        return orePlacer;
    }

}
