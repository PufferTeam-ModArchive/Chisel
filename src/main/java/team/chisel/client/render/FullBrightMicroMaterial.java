package team.chisel.client.render;

import net.minecraft.block.Block;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.ColourMultiplier;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Vector3;
import codechicken.microblock.BlockMicroMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FullBrightMicroMaterial extends BlockMicroMaterial {

    public FullBrightMicroMaterial(final Block block, final int meta) {
        super(block, meta);
    }

    @SideOnly(Side.CLIENT)
    public void renderMicroFace(final Vector3 pos, final int pass, final Cuboid6 bounds) {
        CCRenderState.instance().pipeline.builder()
            .add((CCRenderState.IVertexOperation) pos.translation())
            .add((CCRenderState.IVertexOperation) this.icont())
            .add((CCRenderState.IVertexOperation) ColourMultiplier.instance(FULL_BRIGHT_COLOR_MULTIPLIER))
            .add((CCRenderState.IVertexOperation) FullBrightLighting.instance)
            .render();
    }

    // magic number from 'RenderBlocksCTMFullbright'
    // this is what makes the neonite, anti, glotek blocks burn bright as my ass does
    // so we use it for custom microblock render
    private final static int FULL_BRIGHT_COLOR_MULTIPLIER = 0xFFFFFFFF;
}
