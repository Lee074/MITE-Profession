package net.lee.mitemod.mitepfn.item.LevelUp;

import net.minecraft.*;

public class LevelUPIII extends Item {
    public LevelUPIII(int par1) {
        super(par1, Material.iron, "itemsforup/level3");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
    }
    @Override
    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        if (player.PFNLevel < 3 && player.isPFN) {
            player.isSucceed = true;
            player.PFNLevel = 3;
            if (!player.inCreativeMode()) {
                player.convertOneOfHeldItem((ItemStack)null);
            }
            if (player.isSucceed) {
                player.sendChatToPlayer(ChatMessage.createFromTranslationKey("您的职业等级为:" + player.PFNLevel).setColor(EnumChatFormat.DARK_PURPLE));
            }
        }else if (player.PFNLevel >= 3) {
            player.isOverLevel = true;
            if (player.isOverLevel) {
                player.sendChatToPlayer(ChatMessage.createFromTranslationKey("您的职业等级为:" + player.PFNLevel + "已无法再使用").setColor(EnumChatFormat.DARK_PURPLE));
                return false;
            }
        }
        return true;
    }
}
