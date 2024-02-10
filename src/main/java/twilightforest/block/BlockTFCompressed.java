package twilightforest.block;

import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;

import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;

public class BlockTFCompressed extends BlockCompressed {

    public enum BlockType {
        ARCTIC_FUR,
        CARMINITE,
        FIERY_METAL,
        IRONWOOD,
        STEELEAF
    }

    private BlockType type;

    protected BlockTFCompressed(BlockType blockType) {
        super(typeToMapColor(blockType));
        type = blockType;
        float hardness = 0;
        float resistance = 0;
        SoundType stepSound = null;
        String textureName = "";

        switch (type) {
            case ARCTIC_FUR:
                hardness = 0.8F;
                stepSound = soundTypeCloth;
                textureName = "arctic_fur_block";
                break;
            case CARMINITE:
                hardness = 5.0F;
                resistance = 10.0F;
                stepSound = soundTypeMetal;
                textureName = "carminite_block";
                break;
            case FIERY_METAL:
                hardness = 5.0F;
                resistance = 10.0F;
                stepSound = soundTypeMetal;
                textureName = "fiery_block";
                break;
            default:
            case IRONWOOD:
                hardness = 5.0F;
                resistance = 10.0F;
                stepSound = soundTypeMetal;
                textureName = "ironwood_block";
                break;
            case STEELEAF:
                hardness = 5.0F;
                resistance = 10.0F;
                stepSound = soundTypeGrass;
                textureName = "steeleaf_block";
                break;
        }

        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.setBlockTextureName(TwilightForestMod.ID + ":" + textureName);

        this.setCreativeTab(TFItems.creativeTab);
    }

    private static MapColor typeToMapColor(BlockType blockType) {
        MapColor mapColor = null;
        switch (blockType) {
            case ARCTIC_FUR:
                mapColor = MapColor.clothColor;
                break;
            case CARMINITE:
                mapColor = MapColor.tntColor;
                break;
            case FIERY_METAL:
                mapColor = MapColor.netherrackColor;
                break;
            case IRONWOOD:
                mapColor = MapColor.ironColor;
                break;
            case STEELEAF:
                mapColor = MapColor.foliageColor;
                break;
        }
        return mapColor;
    }

}
