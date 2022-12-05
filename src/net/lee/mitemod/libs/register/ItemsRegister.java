package net.lee.mitemod.libs.register;

import net.minecraft.CreativeModeTab;
import net.minecraft.Item;

public class ItemsRegister {
    public static Item register(String resourceLocation, Item item, CreativeModeTab tab) {
        item.setResourceLocation(item.getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        item.setCreativeTab(tab);
        return item;
    }
}
