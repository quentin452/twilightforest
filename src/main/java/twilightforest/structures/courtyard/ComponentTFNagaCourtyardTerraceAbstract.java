package twilightforest.structures.courtyard;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import twilightforest.block.TFBlocks;

public class ComponentTFNagaCourtyardTerraceAbstract extends ComponentTFNagaCourtyardRotatedAbstract {

    public ComponentTFNagaCourtyardTerraceAbstract() {
        super();
    }

    public ComponentTFNagaCourtyardTerraceAbstract(int i, int x, int y, int z, int rotation) {
        super(i, x, y, z, rotation);
        this.coordBaseMode = rotation;
        this.boundingBox = new StructureBoundingBox(x, y - 1, z, x + 16, y + 5, z + 16);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        /*
         * int groundAir = 0; int undergroundAir = 0; for(int i = 0; i < 17; i++) { for(int j = 0; j < 17; j++) {
         * if(this.getBlockAtCurrentPosition(world, i, 1, j, structureBoundingBox) == Blocks.air) groundAir++;
         * if(this.getBlockAtCurrentPosition(world, i, 0, j, structureBoundingBox) == Blocks.air) undergroundAir++; } }
         * if(groundAir > undergroundAir) this.boundingBox.minY--;
         */

        this.fillWithBlocks(world, structureBoundingBox, 1, 2, 1, 15, 3, 15, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(
                world,
                structureBoundingBox,
                0,
                1,
                0,
                16,
                1,
                16,
                Blocks.stonebrick,
                Blocks.stonebrick,
                true);
        this.fillWithMetadataBlocks(
                world,
                structureBoundingBox,
                1,
                1,
                1,
                15,
                1,
                15,
                Blocks.stone_slab,
                5,
                Blocks.stone_slab,
                5,
                true);
        this.fillWithBlocks(world, structureBoundingBox, 2, 1, 2, 14, 1, 14, Blocks.air, Blocks.air, true);
        this.fillWithBlocks(world, structureBoundingBox, 2, 0, 2, 14, 0, 14, Blocks.grass, Blocks.grass, true);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!((i == 2 || i == 3) && (j == 2 || j == 3))) {
                    int startX = i * 3;
                    int startZ = j * 3;
                    this.fillWithBlocks(
                            world,
                            structureBoundingBox,
                            startX,
                            0,
                            startZ,
                            startX + 1,
                            0,
                            startZ + 1,
                            TFBlocks.nagastoneEtched,
                            TFBlocks.nagastoneEtched,
                            true);
                }
            }
        }

        return true;
    }
}
