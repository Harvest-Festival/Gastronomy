package uk.joshiejack.gastronomy.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import uk.joshiejack.penguinlib.block.base.AbstractRotatableBlock;

public class OvenBlock extends AbstractRotatableBlock {
    public OvenBlock() {
        super(Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).strength(2F).sound(SoundType.METAL));
    }
}
