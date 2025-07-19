package team.chisel.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.cricketcraft.chisel.api.ICarvable;

public class BlockCarvableDoubleSlab extends BlockCarvable implements ICarvable {

    Block carvableSlab;

    public BlockCarvableDoubleSlab(Material m, BlockCarvableSlab slab) {
        super(m);

        carvableSlab = (Block) slab;
    }

    @Override
    public int quantityDropped(Random random) {
        return 2;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return Item.getItemFromBlock(carvableSlab);
    }
}
