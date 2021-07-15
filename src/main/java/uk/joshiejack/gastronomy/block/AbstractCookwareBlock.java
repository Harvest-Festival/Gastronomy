package uk.joshiejack.gastronomy.block;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

public abstract class AbstractCookwareBlock extends AbstractRotatableBlock {
    public AbstractCookwareBlock(Properties properties) {
        super(properties);
        setHasInventory();
    }

    @Override
    protected int getInsertAmount(IItemHandler handler, ItemStack held) {
        return held.isEmpty() ? 0 : 1;
    }
}
