package uk.joshiejack.gastronomy.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

public class FryingPanBlock extends AbstractRotatableBlock {
    public FryingPanBlock() {
        super(Properties.of(Material.METAL).strength(1F).sound(SoundType.METAL));
    }
}
