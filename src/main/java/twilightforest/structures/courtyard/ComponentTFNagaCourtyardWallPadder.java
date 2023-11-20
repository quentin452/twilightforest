package twilightforest.structures.courtyard;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.TFFeature;
import twilightforest.TwilightForestMod;
import twilightforest.block.TFBlocks;

public class ComponentTFNagaCourtyardWallPadder extends ComponentTFNagaCourtyardRotatedAbstract {

    @SuppressWarnings({"unused"})
    public ComponentTFNagaCourtyardWallPadder() {
        super();
    }

    public ComponentTFNagaCourtyardWallPadder(int i, int x, int y, int z, int rotation) {
        super(i, x, y, z, rotation);
        this.coordBaseMode = rotation;
        this.boundingBox = new StructureBoundingBox(x, y, z, x, y + 8, z + 2);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
    	//Brick base
    	this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 0, 0, 2, Blocks.stonebrick, Blocks.air, false);
    	
    	//Middle brick layer
    	this.fillWithBlocks(world, structureBoundingBox, 0, 1, 1, 0, 7, 1, Blocks.stonebrick, Blocks.air, false);

    	//Upper slab rows
    	this.placeBlockAtCurrentPosition(world, Blocks.stone_slab, 0, 0, 8, 0, structureBoundingBox);
    	this.placeBlockAtCurrentPosition(world, Blocks.stone_slab, 0, 0, 8, 2, structureBoundingBox);
    	
    	//Columns
    	this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 2, 0, 0, 7, 0, TFBlocks.nagastonePillar, 0, Blocks.air, 0, false);
    	this.fillWithMetadataBlocks(world, structureBoundingBox, 0, 2, 2, 0, 7, 2, TFBlocks.nagastonePillar, 0, Blocks.air, 0, false);
    	
    	//Spiral bricks
    	this.placeBlockAtCurrentPosition(world, TFBlocks.spiralStoneBricks, rotatedStairs1, 0, 4, 0, structureBoundingBox);
    	this.placeBlockAtCurrentPosition(world, TFBlocks.spiralStoneBricks, rotatedStairs0, 0, 4, 2, structureBoundingBox);
    	
    	//Chiseled stone bricks
    	this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 5, 0, structureBoundingBox);
    	this.placeBlockAtCurrentPosition(world, Blocks.stonebrick, 3, 0, 5, 2, structureBoundingBox);
    	
    	//Stone brick stairs
    	this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, rotatedStairs5, 0, 1, 0, structureBoundingBox);
    	this.placeBlockAtCurrentPosition(world, Blocks.stone_brick_stairs, rotatedStairs4, 0, 1, 2, structureBoundingBox);
        return true;
    }
}
