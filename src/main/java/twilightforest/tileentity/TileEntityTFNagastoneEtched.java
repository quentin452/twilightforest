package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFNagastoneEtched extends TileEntity {

    public enum Direction {
        DOWN,
        UP,
        EAST,
        WEST,
        SOUTH,
        NORTH,
        StairsLeftTop,
        StairsLeftBottom,
        StairsRightTop,
        StairsRightBottom
    };

    public Direction direction = Direction.UP;

    public TileEntityTFNagastoneEtched() {
        super();
        direction = Direction.UP;
    }

    public TileEntityTFNagastoneEtched(Direction dir) {
        super();
        direction = dir;
    }

    public TileEntityTFNagastoneEtched(int dir) {
        super();
        direction = GetDirection(dir);
    }

    public void SetDirection(Direction dir) {
        direction = dir;
    }

    private Direction GetDirection(int d) {
        switch (d) {
            case 0:
                return Direction.DOWN;
            default:
            case 1:
                return Direction.UP;
            case 2:
                return Direction.EAST;
            case 3:
                return Direction.WEST;
            case 4:
                return Direction.SOUTH;
            case 5:
                return Direction.NORTH;
        }
    }

    @Override
    public Packet getDescriptionPacket() {

        NBTTagCompound tagCompound = new NBTTagCompound();

        this.writeToNBT(tagCompound);

        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, tagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {

        NBTTagCompound tagCompound = packet.func_148857_g();

        this.readFromNBT(tagCompound);
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readFromNBT(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("Direction"))
            direction = GetDirection(par1NBTTagCompound.getInteger("Direction"));
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeToNBT(par1NBTTagCompound);
        if (direction != null) par1NBTTagCompound.setInteger("Direction", direction.ordinal());
    }

    /**
     * Determines if this TileEntity requires update calls.
     * 
     * @return True if you want updateEntity() to be called, false if not
     */
    @Override
    public boolean canUpdate() {
        return true;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    @Override
    public void updateEntity() {
        super.updateEntity();
    }

}
