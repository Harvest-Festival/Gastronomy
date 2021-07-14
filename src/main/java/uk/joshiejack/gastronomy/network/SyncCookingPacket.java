package uk.joshiejack.gastronomy.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkDirection;
import uk.joshiejack.gastronomy.tileentity.base.CookerTileEntity;
import uk.joshiejack.penguinlib.network.PenguinPacket;
import uk.joshiejack.penguinlib.util.PenguinLoader;

@PenguinLoader.Packet(NetworkDirection.PLAY_TO_CLIENT)
public class SyncCookingPacket extends PenguinPacket {
    private BlockPos pos;
    private boolean isCooking;
    private int cookTimer;

    public SyncCookingPacket() {}
    public SyncCookingPacket(BlockPos pos, boolean isCooking, int cookTimer) {
        this.pos = pos;
        this.isCooking = isCooking;
        this.cookTimer = cookTimer;
    }

    @Override
    public void encode(PacketBuffer to) {
        to.writeLong(pos.asLong());
        to.writeBoolean(isCooking);
        to.writeByte(cookTimer);
    }

    @Override
    public void decode(PacketBuffer from) {
        pos = BlockPos.of(from.readLong());
        isCooking = from.readBoolean();
        cookTimer = from.readByte();
    }

    @Override
    public void handle(PlayerEntity player) {
        TileEntity tile = player.level.getBlockEntity(pos);
        if (tile instanceof CookerTileEntity) {
           // (((CookerTileEntity)tile)).setCooking(isCooking, cookTimer);
        }
    }
}
