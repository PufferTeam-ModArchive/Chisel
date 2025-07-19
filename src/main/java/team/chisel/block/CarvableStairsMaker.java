package team.chisel.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.ChiselTabs;
import com.cricketcraft.chisel.api.carving.CarvableHelper;
import com.cricketcraft.chisel.api.carving.CarvingUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import team.chisel.carving.Carving;
import team.chisel.item.ItemCarvable;

public class CarvableStairsMaker {

    public final CarvableHelper carverHelper;
    private Block blockBase;

    public CarvableStairsMaker(Block base) {
        blockBase = base;
        carverHelper = new CarvableHelper(base);
    }

    public void create(String name, Block[] blocks) {
        create(null, name, blocks, false);
    }

    public void create(String name, Block[] blocks, boolean isWood) {
        create(null, name, blocks, isWood);
    }

    public void create(IStairsCreator creator, String name, Block[] blocks) {
        create(creator, name, blocks, false);
    }

    public void create(IStairsCreator creator, String name, Block[] blocks, boolean isWood) {
        for (int i = 0; i < blocks.length; i++) {
            String n = name + "." + i;
            blocks[i] = creator == null ? new BlockCarvableStairs(blockBase, i * 2, carverHelper)
                : creator.create(blockBase, i * 2, carverHelper);

            blocks[i].setBlockName("chisel." + name)
                .setCreativeTab(ChiselTabs.tabStairChiselBlocks);
            if (isWood) {
                blocks[i].setHarvestLevel("axe", 0);
            }
            GameRegistry.registerBlock(blocks[i], ItemCarvable.class, n);

            int k = 0;
            if (carverHelper.getVariation(0) == null) {
                k = 1;
            }
            for (int meta = 0; meta < 2 && i * 2 + meta < carverHelper.infoList.size() + k; meta++) {
                if (carverHelper.getVariation(0) != null
                    || (carverHelper.getVariation(0) == null && (i != 0 || meta != 0))) {
                    Carving.chisel.addVariation(name, CarvingUtils.getDefaultVariationFor(blocks[i], meta * 8, i));
                    GameRegistry.addRecipe(
                        new ItemStack(blocks[i], 4, meta * 8),
                        "*  ",
                        "** ",
                        "***",
                        '*',
                        new ItemStack(blockBase, 1, i * 2 + meta));
                }

            }
        }
    }
}
