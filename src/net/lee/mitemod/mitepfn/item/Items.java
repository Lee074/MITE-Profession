package net.lee.mitemod.mitepfn.item;


import net.lee.mitemod.libs.Register;
import net.lee.mitemod.libs.register.ItemsRegister;
import net.lee.mitemod.mitepfn.item.LevelUp.*;
import net.lee.mitemod.mitepfn.util.Constant;
import net.minecraft.*;


public class Items extends Item{

    public static final Item LevelUpI = new LevelUPI(Constant.getNextItemID());
    public static final Item LevelUpICopy = new LevelUPICopy(Constant.getNextItemID());
    public static final Item LevelUpICopies = new LevelUPICopies(Constant.getNextItemID());
    public static final Item LevelUpII = new LevelUPII(Constant.getNextItemID());
    public static final Item LevelUpIII = new LevelUPIII(Constant.getNextItemID());
    public static final Item LevelUpIV = new LevelUPIV(Constant.getNextItemID());
    public static final Item LevelUpV = new LevelUPV(Constant.getNextItemID());
    public static final Item LevelUpVI = new LevelUPVI(Constant.getNextItemID());






    public static void registerItems() {
        ItemsRegister.register("itemsforup/level1", LevelUpI, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level1copy", LevelUpICopy, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level1copies", LevelUpICopies, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level2", LevelUpII, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level3", LevelUpIII, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level4", LevelUpIV, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level5", LevelUpV, CreativeModeTab.tabMaterials);
        ItemsRegister.register("itemsforup/level6", LevelUpVI, CreativeModeTab.tabMaterials);

    }
    public static void registerRecipes(Register register) {
        register.registerShapedRecipe(new ItemStack(LevelUpI), true,
                "#", "#",
                '#', Block.obsidian);

        register.registerShapedRecipe(new ItemStack(LevelUpICopy), true,
                "#", "#",
                '#', Block.obsidian);


    }
}
