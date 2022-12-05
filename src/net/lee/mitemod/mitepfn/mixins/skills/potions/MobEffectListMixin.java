package net.lee.mitemod.mitepfn.mixins.skills.potions;

import net.lee.mitemod.mitepfn.item.potions.Potions;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.MobEffectList.potionTypes;


@Mixin(MobEffectList.class)
public class MobEffectListMixin {

    @Inject(method = "<clinit>",at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callbackInfo){
       Potions.registerPoints();
         for (MobEffectList point : potionTypes) {
            if (point != null && !Potions.individualMobEffectLists.contains(point)) {
                Potions.individualMobEffectLists.add(point);
            }
       }
    }
}
