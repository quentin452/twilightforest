package twilightforest.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTFCake extends TileEntity {
	
	private boolean isSprinkled;

	public TileEntityTFCake() {
		super();
		isSprinkled = false;
	}
	
	public boolean getSprinkled()
	{
		return isSprinkled;
	}
	
	public void setSprinkled(boolean b)
	{
		isSprinkled = b;
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
		if(par1NBTTagCompound.hasKey("Sprinkled"))
			isSprinkled = par1NBTTagCompound.getBoolean("Sprinkled");
	}

    /**
     * Writes a tile entity to NBT.
     */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Sprinkled", isSprinkled);
	}

    /**
     * Determines if this TileEntity requires update calls.
     * @return True if you want updateEntity() to be called, false if not
     */
    @Override
	public boolean canUpdate()
    {
        return true;
    }
	
    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    @Override
	public void updateEntity()
    {
    	super.updateEntity();
    }

}
