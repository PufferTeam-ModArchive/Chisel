package team.chisel.item.chisel;

import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.cricketcraft.chisel.api.IChiselItem;
import com.cricketcraft.chisel.api.carving.ICarvingRegistry;
import com.cricketcraft.chisel.api.carving.ICarvingVariation;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import team.chisel.Chisel;
import team.chisel.carving.Carving;
import team.chisel.config.Configurations;
import team.chisel.utils.General;

public class ItemChisel extends Item implements IChiselItem {

    public enum ChiselType {

        BRONZE(Configurations.bronzeChiselMaxDamage, Configurations.bronzeChiselAttackDamage),
        IRON(Configurations.ironChiselMaxDamage, Configurations.ironChiselAttackDamage),
        THAUMIUM(Configurations.thaumiumChiselMaxDamage, Configurations.thaumiumChiselAttackDamage),
        MANASTEEL(Configurations.manasteelChiselMaxDamage, Configurations.manasteelChiselAttackDamage),
        DIAMOND(Configurations.diamondChiselMaxDamage, Configurations.diamondChiselAttackDamage),
        STEEL(Configurations.steelChiselMaxDamage, Configurations.steelChiselAttackDamage),
        OBSIDIAN(Configurations.obsidianChiselMaxDamage, Configurations.obsidianChiselAttackDamage),
        NETHERSTAR(Configurations.netherStarChiselMaxDamage, Configurations.netherStarChiselAttackDamage);

        final int maxDamage;
        final int attackDamage;

        ChiselType(int maxDamage, int attackDamage) {
            this.maxDamage = maxDamage;
            this.attackDamage = attackDamage;
        }
    }

    public static ICarvingRegistry carving = Carving.chisel;

    private ChiselType type;

    public ItemChisel(ChiselType type) {
        super();
        this.type = type;
        setMaxStackSize(1);
        setTextureName(
            Chisel.MOD_ID + ":chisel_"
                + type.name()
                    .toLowerCase(Locale.ENGLISH));
        if (type == ChiselType.NETHERSTAR && Chisel.gtnhLoaded) {
            setUnlocalizedName(
                Chisel.MOD_ID + ".chisel_"
                    + type.name()
                        .toLowerCase()
                    + ".gtnh");
        } else {
            setUnlocalizedName(
                Chisel.MOD_ID + ".chisel_"
                    + type.name()
                        .toLowerCase());
        }
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        if (Configurations.allowChiselDamage) return type.maxDamage;
        return 0;
    }

    @Override
    public boolean isDamageable() {
        return Configurations.allowChiselDamage;
    }

    @Override
    public boolean getIsRepairable(ItemStack damagedItem, ItemStack repairMaterial) {
        switch (type) {
            case BRONZE:
                return General.containsOreDict(repairMaterial, "ingotBronze");
            case DIAMOND:
                return General.containsOreDict(repairMaterial, "gemDiamond");
            case IRON:
                return General.containsOreDict(repairMaterial, "ingotIron");
            case THAUMIUM:
                return General.containsOreDict(repairMaterial, "ingotThaumium");
            case MANASTEEL:
                return General.containsOreDict(repairMaterial, "ingotManasteel");
            case STEEL:
                return General.containsOreDict(repairMaterial, "ingotSteel");
            case OBSIDIAN:
                return repairMaterial.getItem()
                    .equals(Item.getItemFromBlock(Blocks.obsidian));
            case NETHERSTAR:
                return repairMaterial.getItem()
                    .equals(Items.nether_star);
        }
        return false;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean held) {
        String base = "item.chisel.chisel.desc.";
        String gui = I18n.format(base + "gui");
        String lc1 = I18n.format(base + "lc1");
        String lc2 = I18n.format(base + "lc2");
        String modes = I18n.format(base + "modes");
        list.add(gui);
        if (type == ChiselType.STEEL || type == ChiselType.DIAMOND
            || type == ChiselType.OBSIDIAN
            || type == ChiselType.NETHERSTAR
            || Configurations.ironChiselCanLeftClick) {
            list.add(lc1);
            list.add(lc2);
        }
        if (type == ChiselType.STEEL || type == ChiselType.DIAMOND
            || type == ChiselType.OBSIDIAN
            || type == ChiselType.NETHERSTAR
            || Configurations.ironChiselHasModes) {
            list.add("");
            list.add(modes);
        }
    }

    @Override
    public boolean isFull3D() {
        return true;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Multimap getAttributeModifiers(ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        multimap.put(
            SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
            new AttributeModifier(field_111210_e, "Chisel Damage", type.attackDamage, 0));
        return multimap;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return super.hitEntity(stack, attacker, target);
    }

    @Override
    public boolean canOpenGui(World world, EntityPlayer player, ItemStack chisel) {
        return true;
    }

    @Override
    public boolean canChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return true;
    }

    @Override
    public boolean onChisel(World world, ItemStack chisel, ICarvingVariation target) {
        return Configurations.allowChiselDamage;
    }

    @Override
    public boolean canChiselBlock(World world, EntityPlayer player, int x, int y, int z, Block block, int metadata) {
        return type == ChiselType.STEEL || type == ChiselType.DIAMOND
            || type == ChiselType.OBSIDIAN
            || type == ChiselType.NETHERSTAR
            || Configurations.ironChiselCanLeftClick;
    }

    @Override
    public boolean hasModes(ItemStack chisel) {
        return type == ChiselType.STEEL || type == ChiselType.DIAMOND
            || type == ChiselType.OBSIDIAN
            || type == ChiselType.NETHERSTAR
            || Configurations.ironChiselHasModes;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote && canOpenGui(world, player, itemStack)) {
            ChiselController.INSTANCE.openQueue.add(new ChiselController.GuiOpen(player, itemStack));
        }
        return itemStack;
    }
}
