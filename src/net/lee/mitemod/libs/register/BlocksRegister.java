package net.lee.mitemod.libs.register;

import net.lee.mitemod.mitepfn.util.Constant;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemBlock;

public class BlocksRegister {

    private static void registerItemBlock(Block block, String resourceLocation) {
        block.setUnlocalizedName(resourceLocation);
        Item item = (new ItemBlock(block)).setUnlocalizedName(resourceLocation);
        Item.itemsList[Constant.getNextItemID()] = item;
        item.setMaxStackSize(block.getItemStackLimit());
    }
}
