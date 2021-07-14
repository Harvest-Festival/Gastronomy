package uk.joshiejack.gastronomy.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

public class CupboardBlock extends AbstractRotatableBlock {
    public CupboardBlock() {
        super(Properties.of(Material.WOOD).harvestTool(ToolType.AXE).strength(1.5F).sound(SoundType.WOOD));
    }
}
