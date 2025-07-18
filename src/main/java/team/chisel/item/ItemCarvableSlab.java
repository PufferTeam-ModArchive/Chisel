package team.chisel.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import team.chisel.block.BlockCarvable;
import team.chisel.block.BlockCarvableDoubleSlab;
import team.chisel.block.BlockCarvableSlab;

public class ItemCarvableSlab extends ItemCarvable {

    Block slabDouble;
    Block slabBlock;

    public ItemCarvableSlab(Block block, BlockCarvable slabd) {
        super(block);

        slabBlock = block;
        slabDouble = (Block) slabd;
    }

    public ItemCarvableSlab(Block block, BlockCarvableDoubleSlab slabd) {
        super(block);

        slabBlock = block;
        slabDouble = (Block) slabd;
    }

    @Override
    public boolean func_150936_a(World world, int x, int y, int z, int side, EntityPlayer player, ItemStack stack) {
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hx,
        float hy, float hz) {
        BlockCarvableSlab block = (BlockCarvableSlab) Block.getBlockFromItem(this);
        int meta = stack.getItemDamage();

        ForgeDirection dir = ForgeDirection.VALID_DIRECTIONS[side];
        Block clicked = world.getBlock(x, y, z);

        // the position of the block that we are attempting to place at
        int x2 = x + dir.offsetX;
        int y2 = y + dir.offsetY;
        int z2 = z + dir.offsetZ;

        Block at = world.getBlock(x2, y2, z2);

        boolean metaEquals = world.getBlockMetadata(x2, y2, z2) == meta;
        // if the metadata at the place target matches, and the block there matches either the top of bottom slab, try
        // to fill in the rest of the block
        if (metaEquals
            && ((at == block.top && (hy <= 0.5D || hy == 1.0D)) || (at == block.bottom && (hy > 0.5D || hy == 0)))) {
            return place(stack, world, x2, y2, z2, slabDouble, meta);
        }

        // else if the block clicked on is a top or bottom slab of this type, try to fill in that block if possible
        boolean clickedMetaEquals = world.getBlockMetadata(x, y, z) == meta;
        if (clickedMetaEquals && ((clicked == block.bottom && dir == ForgeDirection.UP)
            || (clicked == block.top && dir == ForgeDirection.DOWN))) {
            return place(stack, world, x, y, z, slabDouble, meta);
        }

        // finally just try to place a normal slab
        if (metaEquals || at.isReplaceable(world, x, y, z)) {
            boolean top = hy > 0.5D && dir != ForgeDirection.UP || dir == ForgeDirection.DOWN;
            Block toPlace = top ? block.top : block.bottom;
            // if we can replace the clicked block do so
            if (clicked.isReplaceable(world, x, y, z)) {
                return place(stack, world, x, y, z, toPlace, meta);
            } else {
                return place(stack, world, x2, y2, z2, toPlace, meta);
            }
        }
        return false;
    }

    private boolean place(ItemStack stack, World world, int x, int y, int z, Block toPlace, int metadata) {
        if (world.checkNoEntityCollision(toPlace.getCollisionBoundingBoxFromPool(world, x, y, z))
            && world.setBlock(x, y, z, toPlace, metadata, 3)) {
            world.setBlock(x, y, z, toPlace, metadata, 2);
            stack.stackSize -= 1;
            world.playSoundEffect(
                x + 0.5f,
                y + 0.5f,
                z + 0.5f,
                this.field_150939_a.stepSound.func_150496_b(),
                (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F,
                this.field_150939_a.stepSound.getPitch() * 0.8F);
            return true;
        } else {
            return false;
        }
    }
}
