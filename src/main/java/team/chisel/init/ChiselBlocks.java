package team.chisel.init;

import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import team.chisel.Chisel;
import team.chisel.block.*;

@ObjectHolder(Chisel.MOD_ID)
public final class ChiselBlocks {

    public static final Block autoChisel = null;
    public static final BlockCarvable antiBlock = null;
    public static final BlockCarvableBeacon beacon = null;
    public static final BlockCarvable marble = null;
    public static final BlockCarvable marble_pillar = null;
    public static final BlockCarvable limestone = null;
    public static final BlockCarvableSlab marble_slab = null;
    public static final BlockCarvableSlab limestone_slab = null;
    public static final BlockCarvableSlab marble_pillar_slab = null;
    public static final BlockCarvable cobblestone = null;
    public static final BlockCarvableWall cobblestoneWall = null;
    public static final BlockCarvableGlass glass = null;
    public static final BlockCarvableGlass glass2 = null;
    public static final BlockCarvablePane glass_pane = null;
    public static final BlockCarvable sandstone = null;
    public static final BlockCarvable sandstone_scribbles = null;
    public static final BlockConcrete concrete = null;
    public static final BlockRoadLine road_line = null;
    public static final BlockCarvable iron_block = null;
    public static final BlockCarvable gold_block = null;
    public static final BlockCarvable diamond_block = null;
    public static final BlockCarvableGlowstone glowstone = null;
    public static final BlockCarvable lapis_block = null;
    public static final BlockCarvable emerald_block = null;
    public static final BlockCarvable rebel = null;
    public static final BlockCarvable nether_brick = null;
    public static final BlockCarvable netherrack = null;
    public static final BlockCarvable mossy_cobblestone = null;
    public static final BlockCarvable stonebricksmooth = null;
    public static final BlockCarvablePane iron_bars = null;
    public static final BlockCarvableIce ice = null;
    public static final BlockCarvableIce ice_pillar = null;
    public static final BlockCarvablePackedIce packedice = null;
    public static final BlockCarvablePackedIce packedice_pillar = null;
    public static final BlockCarvable obsidian = null;
    public static final BlockCarvable obsidian2 = null;
    public static final BlockCarvablePowered redstone_block = null;
    public static final BlockHolystone holystone = null;
    public static final BlockGrimstone grimstone = null;
    public static final BlockLavastone lavastone = null;
    public static final BlockWaterstone waterstone = null;
    public static final BlockCarvable leaves = null;
    public static final BlockCarvable fantasyblock = null;
    public static final BlockCarvable fantasyblock2 = null;
    public static final BlockCarvable carpet_block = null;
    public static final BlockCarvableCarpet carpet = null;
    public static final BlockCarvable bookshelf = null;
    public static final BlockCarvable tyrian = null;
    public static final BlockCarvable dirt = null;
    public static final BlockCloud cloud = null;
    public static final BlockCarvable templeblock = null;
    public static final BlockCarvable mossy_templeblock = null;
    public static final BlockCarvable factoryblock = null;
    public static final BlockCarvable factoryblock2 = null;
    public static final BlockCarvablePane paperwall = null;
    public static final BlockCarvable paperwall_block = null;
    public static final BlockCarvable woolen_clay = null;
    public static final BlockCarvable laboratoryblock = null;

    public static final BlockCarvable voidstone = null;
    public static final BlockCarvable voidstone2 = null;
    public static final BlockCarvable voidstonerunic = null;
    public static final BlockCarvable voidstonePillar = null;
    public static final BlockCarvable voidstonePillar2 = null;
    public static final BlockSnakestone stone_snakestone = null;
    public static final BlockSnakestone sand_snakestone = null;
    public static final BlockSnakestoneObsidian obsidian_snakestone = null;
    public static final BlockCarvable hexPlating = null;
    public static final BlockCarvable hexLargePlating = null;
    public static final BlockCarvable technical = null;
    public static final BlockCarvableGlass technical2 = null;
    public static final BlockCarvable futura = null;
    public static final BlockCarvable circuits = null;
    public static final BlockCarvable brickCustom = null;
    public static final BlockCarvableLayered warningSign = null;
    public static final BlockCarvable arcane = null;
    public static final BlockCarvable thaumium = null;
    public static final BlockCarvable tallow = null;

    public static final BlockCarvable copperblock = null;
    public static final BlockCarvable bronzeblock = null;
    public static final BlockCarvable aluminumblock = null;
    public static BlockCarvableStairs[] aluminumStairs = new BlockCarvableStairs[3];
    public static final BlockCarvable leadblock = null;
    public static final BlockCarvable silverblock = null;
    public static final BlockCarvable steelblock = null;
    public static final BlockCarvable tinblock = null;
    public static final BlockCarvable uraniumblock = null;

    public static final BlockCarvable bloodRune = null;
    public static final BlockCarvable bloodBrick = null;

    // Holidays
    public static final BlockCarvable valentines = null;
    public static final BlockPresent present = null;

    // Jimbno additions
    public static final BlockCarvableSand hempcretesand = null;
    public static final BlockCarvable nucrete = null;
    public static final BlockCarvable neonite = null;
    public static final BlockCarvable glotek = null;
    public static final BlockCarvable hempcrete = null;
    public static final BlockCarvable sveltstone = null;
    public static final BlockCarvable cubit = null;

    public static CarvableStairsMaker[] planks_stairs = new CarvableStairsMaker[6];
    public static CarvableStairsMaker[] planks_bop_stairs = new CarvableStairsMaker[14];
    public static CarvableStairsMaker[] planks_tc_stairs = new CarvableStairsMaker[2];
    public static CarvableStairsMaker[] planks_wi_stairs = new CarvableStairsMaker[3];

    // Arrays can't be final because of how @ObjectHolder works
    public static BlockCarvableStairs[] planksStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] planksBOPStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] planksTCStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] planksWIStairs = new BlockCarvableStairs[8];

    public static BlockCarvableStairs[] cobblestoneStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] andesiteStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] graniteStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] dioriteStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] marbleStairs = new BlockCarvableStairs[8];
    public static BlockCarvableStairs[] limestoneStairs = new BlockCarvableStairs[8];
    public static BlockCarvableIceStairs[] iceStairs = new BlockCarvableIceStairs[8];
    public static BlockCarvablePackedIceStairs[] packediceStairs = new BlockCarvablePackedIceStairs[8];

    public static Block[] torches = new BlockCarvableTorch[16];

    public static BlockCarvable[] planks = new BlockCarvable[6];
    public static BlockCarvableSlab[] planks_slabs = new BlockCarvableSlab[6];
    public static BlockCarvableDoubleSlab[] planks_double_slabs = new BlockCarvableDoubleSlab[6];

    public static BlockCarvable[] planks_bop = new BlockCarvable[14];
    public static BlockCarvableSlab[] planks_bop_slabs = new BlockCarvableSlab[14];
    public static BlockCarvableDoubleSlab[] planks_bop_double_slabs = new BlockCarvableDoubleSlab[14];

    public static BlockCarvable[] planks_tc = new BlockCarvable[2];
    public static BlockCarvableSlab[] planks_tc_slabs = new BlockCarvableSlab[2];
    public static BlockCarvableDoubleSlab[] planks_tc_double_slabs = new BlockCarvableDoubleSlab[2];

    public static BlockCarvable[] planks_wi = new BlockCarvable[3];
    public static BlockCarvableSlab[] planks_wi_slabs = new BlockCarvableSlab[3];
    public static BlockCarvableDoubleSlab[] planks_wi_double_slabs = new BlockCarvableDoubleSlab[3];

    public static BlockCarvablePumpkin[] pumpkin = new BlockCarvablePumpkin[16];
    public static BlockCarvablePumpkin[] jackolantern = new BlockCarvablePumpkin[16];

    // 1.7
    public static BlockCarvableGlass[] stainedGlass = new BlockCarvableGlass[4];
    public static BlockCarvableGlass stainedGlassForestry;
    public static BlockCarvablePane[] stainedGlassPane = new BlockCarvablePane[8];

    // 1.8 or at least so you think :P
    public static final BlockCarvable granite = null;
    public static final BlockCarvable diorite = null;
    public static final BlockCarvable andesite = null;

    // 1.9... drull pls
    public static final BlockCarvable purpur = null;

    // 1.19, skipped 10 versions but thats fine
    public static final BlockCarvable froglight = null;

    private ChiselBlocks() {}
}
