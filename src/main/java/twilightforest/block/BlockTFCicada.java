package twilightforest.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Explosion;
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

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);
        // stopSinging(worldIn, x, y, z);
    }

    @Override
    public boolean dropCritterIfCantStay(World world, int x, int y, int z) {
        if (super.dropCritterIfCantStay(world, x, y, z)) {
            stopSinging(world, x, y, z);
            return true;
        }
        return false;
    }

    /**
     * Called when the block is attempted to be harvested
     */
    public void onBlockHarvested(World worldIn, int x, int y, int z, int meta, EntityPlayer player) {
        stopSinging(worldIn, x, y, z);
    }

    /**
     * Called right before the block is destroyed by a player. Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World worldIn, int x, int y, int z, int meta) {
        stopSinging(worldIn, x, y, z);
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World worldIn, int x, int y, int z, Explosion explosionIn) {
        stopSinging(worldIn, x, y, z);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer player, int side, float subX,
            float subY, float subZ) {
        if (super.onBlockActivated(worldIn, x, y, z, player, side, subX, subY, subZ)) {
            stopSinging(worldIn, x, y, z);
            return true;
        }
        return false;
    }

    public void stopSinging(World worldIn, int x, int y, int z) {
        if (worldIn.isRemote) {
            ChunkCoordinates chunkcoordinates = new ChunkCoordinates(x, y, z);
            Minecraft mc = Minecraft.getMinecraft();
            ISound isound = (ISound) mc.renderGlobal.mapSoundPositions.get(chunkcoordinates);

            while (isound != null) {
                mc.getSoundHandler().stopSound(isound);
                mc.renderGlobal.mapSoundPositions.remove(chunkcoordinates);
                isound = (ISound) mc.renderGlobal.mapSoundPositions.get(chunkcoordinates);
            }
        }
    }

}
