package twilightforest.tileentity;

import net.minecraft.tileentity.TileEntityChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.block.BlockTFChest.WoodType;

public class TileEntityTFChest extends TileEntityChest {

    public WoodType cachedMaterial = WoodType.NULL;

    public TileEntityTFChest() {
        super();
    }

    @SideOnly(Side.CLIENT)
    public TileEntityTFChest(WoodType material) {
        super();
        this.cachedMaterial = material;
    }

}
