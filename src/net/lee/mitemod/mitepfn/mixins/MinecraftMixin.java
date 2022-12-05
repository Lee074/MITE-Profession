package net.lee.mitemod.mitepfn.mixins;

import net.lee.mitemod.mitepfn.util.Constant;
import net.minecraft.*;
import net.minecraft.client.main.Main;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow
    public ClientPlayer h;
    @Shadow
    public aul u;
    @Shadow
    public abstract void h();

    @Overwrite
    public static String getVersionDescriptor(boolean include_formatting) {
        String red = include_formatting ? EnumChatFormat.RED.toString() : "";
        return "1.6.4-MITE" + "-PFN-ITE-"+ (Main.is_MITE_DS ? "-DS" : "") + (Minecraft
                .inDevMode() ? red + " DEV": "");
    }

    @Inject(method = {"k"}, at = {@At("INVOKE")})
    public void k(CallbackInfo ci) {
        if (this.u.keyBindPersonView.c()) {
            if (!this.h.isLockedInFirstPersonView()) {
                ++this.u.aa;
                if (this.u.aa > 2) {
                    this.u.aa = 0;
                }
            }
        }
    }
}
