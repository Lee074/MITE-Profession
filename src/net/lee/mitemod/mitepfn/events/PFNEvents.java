package net.lee.mitemod.mitepfn.events;

import com.google.common.eventbus.Subscribe;

import net.lee.mitemod.mitepfn.item.potions.Potions;
import net.lee.mitemod.mitepfn.util.Constant;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.HandleChatCommandEvent;
import net.xiaoyu233.fml.reload.event.PlayerLoggedInEvent;


public class PFNEvents {

    public boolean buff;

    @Subscribe
    public void handleChatCommand(HandleChatCommandEvent event) {
        String command = event.getCommand();
        EntityPlayer player = event.getPlayer();
        ICommandListener commandLtr = event.getListener();

        if (command.startsWith("pfn miner")) {
            if (!player.isPFN) {
                player.isPFNMiner = true;
                player.isPFN = true;
                commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您选择的职业是：矿工").setColor(EnumChatFormat.WHITE));
            } else {
                commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您已选择职业").setColor(EnumChatFormat.WHITE));
            }
            event.setExecuteSuccess(true);
        }
        if (command.startsWith("pfn swords")) {
            if (!player.isPFN) {
                player.isPFNSwords = true;
                player.isPFN = true;
                commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您选择的职业是：剑士").setColor(EnumChatFormat.WHITE));
            } else {
                commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您已选择职业").setColor(EnumChatFormat.WHITE));
            }
            event.setExecuteSuccess(true);
        }

        if (command.startsWith("pfn check")) {
            if(player.isPFN) {
                if (player.isPFNMiner) {
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您选择的职业是：矿工").setColor(EnumChatFormat.WHITE)
                            .appendComponent(ChatMessage.createFromText("    等级为" + player.getPFNLevel()).setColor(EnumChatFormat.DARK_RED)));
                } else if (player.isPFNSwords) {
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您选择的职业是：剑士").setColor(EnumChatFormat.WHITE)
                            .appendComponent(ChatMessage.createFromText("    等级为" + player.getPFNLevel()).setColor(EnumChatFormat.DARK_RED)));
                } else {
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您未选择职业").setColor(EnumChatFormat.WHITE));
                }
            }
            event.setExecuteSuccess(true);
        }

        if (command.startsWith("pfnbuff")) {
            if (player.isPFNMiner) {
                player.addPotionEffect(new MobEffect(Potions.PFNMINER.id, Integer.MAX_VALUE, player.getPFNLevel()-1));
                commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("已给予您矿工buff,等级" + player.getPFNLevel()).setColor(EnumChatFormat.DARK_PURPLE));
            }
            event.setExecuteSuccess(true);
        }


        if(Minecraft.inDevMode()) {
            int digit;
            if (command.startsWith("pfn setlevel")) {
                digit = Integer.parseInt(command.substring(13));
                if (player.isPFN) {
                    if (digit <= player.PFNMaxLevel)
                        player.PFNLevel = digit;
                    commandLtr.sendChatToPlayer(ChatMessage.createFromText("您的职业等级为:" + player.PFNLevel).setColor(EnumChatFormat.WHITE));
                } else if(digit >= player.PFNMaxLevel){
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您设置的职业等级超出正常范围").setColor(EnumChatFormat.WHITE));
                }
                event.setExecuteSuccess(true);
            }
            if (command.startsWith("pfnbuff miner")) {
                digit = Integer.parseInt(command.substring(14));
                if (player.isPFNMiner) {
                    player.addPotionEffect(new MobEffect(Potions.PFNMINER.id, Integer.MAX_VALUE, digit-1));
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("已给予您矿工buff,等级" + digit).setColor(EnumChatFormat.DARK_PURPLE));
                }
                event.setExecuteSuccess(true);
            }
            if (command.startsWith("pfnbuff swords")) {
                digit = Integer.parseInt(command.substring(15));
                if (player.isPFNSwords) {
                    player.addPotionEffect(new MobEffect(Potions.PFNSWORDS.id, Integer.MAX_VALUE, digit-1));
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("已给予您剑士buff,等级" + digit).setColor(EnumChatFormat.DARK_PURPLE));
                }
                event.setExecuteSuccess(true);
            }
            if (command.startsWith("pfn clear")) {
                if (player.isPFN) {
                    player.isPFN =false;
                    player.isPFNMiner = false;
                    player.isPFNSwords =false;
                    commandLtr.sendChatToPlayer(ChatMessage.createFromTranslationKey("您已清空职业").setColor(EnumChatFormat.WHITE));
                }
                event.setExecuteSuccess(true);
            }

        }

        }

    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        EntityPlayer player = event.getPlayer();
        player.sendChatToPlayer(ChatMessage.createFromTranslationKey("[Server]")
                .appendComponent(ChatMessage.createFromTranslationKey("MITE-PFN已加载,当前版本:").setColor(EnumChatFormat.DARK_GREEN))
                .appendComponent(ChatMessage.createFromText(Constant.PNF_VERSION).setColor(EnumChatFormat.DARK_RED)));
        player.sendChatToPlayer(ChatMessage.createFromTranslationKey("[MITE-PFN]")
                .appendComponent(ChatMessage.createFromTranslationKey("聊天+更新日志:kook.top/ObiLn6").setColor(EnumChatFormat.DARK_AQUA)));
        if(player.isFirstLogin){
            player.isFirstLogin = false;
        }
        if(!player.isPFN){
            player.sendChatToPlayer(ChatMessage.createFromTranslationKey("[MITE-PFN]").appendComponent(ChatMessage.createFromTranslationKey("请选择您的职业?").setColor(EnumChatFormat.DARK_RED))
                    .appendComponent(ChatMessage.createFromTranslationKey("/pfn miner 为矿工,/pfn swords为剑士").setColor(EnumChatFormat.DARK_AQUA)));
        }

    }


}


