package twilightforest.block;

import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import twilightforest.tileentity.TileEntityTFCicada;

public class BlockTFCicada extends BlockTFCritter {

    public static int sprCicada = 5;

    protected BlockTFCicada() {
        super();
        this.dropItem = Items.dye;
        this.dropMeta = 2;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityTFCicada();
    }

}
