package net.lee.mitemod.libs;

import net.lee.mitemod.mitepfn.item.Items;
import net.minecraft.CraftingManager;
import net.minecraft.ItemStack;
import net.xiaoyu233.mitemod.miteite.util.RecipeRegister;
import net.xiaoyu233.mitemod.miteite.util.RecipesArgs;
import net.xiaoyu233.mitemod.miteite.util.RegisterHelper;


public class Register {
    public static void registerAllItems() {
        Items.registerItems();
    }

    public static void registerAllRecipes(CraftingManager crafters) {
        Items.registerRecipes(new Register());
    }

    public RecipesArgs registerShapedRecipe(ItemStack out, boolean include_in_lowest_crafting_difficulty_determination, Object... input){
        RecipesArgs args = new RecipesArgs(out, include_in_lowest_crafting_difficulty_determination, input);
        RegisterHelper.shapedRecipes.add(args);
        return args;
    }

    public RecipesArgs registerShapelessRecipe(ItemStack out, boolean include_in_lowest_crafting_difficulty_determination, Object... input){
        RecipesArgs args = new RecipesArgs(out, include_in_lowest_crafting_difficulty_determination, input);
        RegisterHelper.shapelessRecipe.add(args);
        return args;
    }
}
