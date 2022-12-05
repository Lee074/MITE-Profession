package net.lee.mitemod.mitepfn.item.potions;

import net.lee.mitemod.mitepfn.util.Constant;
import net.minecraft.*;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.MobEffectList.potionTypes;


public class Potions {

    public static final MobEffectList PFNMINER = new MobEffectPFN(getnextPotionID(),false, EnumChatFormat.WHITE.rgb).setEffectiveness(1.5f).setPotionName("point.pfnminer");
    public static final MobEffectList PFNSWORDS  = new MobEffectPFN(getnextPotionID(), false, EnumChatFormat.WHITE.rgb ).setEffectiveness(1.5f).setPotionName("point.pfnswords");

    public static List<MobEffectList> individualMobEffectLists = new ArrayList<>();
    public static void registerPoints(){Potions.registerPoints(PFNMINER,PFNSWORDS);}

    public static void registerPoints(MobEffectList... buff) {
        for (int i = 0, pL = potionTypes.length; i < pL; i++) {
            if (potionTypes[i] == null) {
                for (int h = 0,potionsLength = buff.length; h < potionsLength; h++) {
                    potionTypes[i + h] = potionTypes[h];
                }
                break;
            }
        }
    }

    public static int getnextPotionID(){
        return Constant.nextPotionID++;
    }
}
