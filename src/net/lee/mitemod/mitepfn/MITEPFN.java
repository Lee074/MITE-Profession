package net.lee.mitemod.mitepfn;

import net.lee.mitemod.mitepfn.util.Constant;
import net.lee.mitemod.mitepfn.events.PFNEvents;
import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.classloading.Mod;
import net.xiaoyu233.fml.config.InjectionConfig;
import net.lee.mitemod.mitepfn.mixins.MinecraftMixin;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import org.spongepowered.asm.mixin.MixinEnvironment;

import javax.annotation.Nonnull;

@Mod
public class MITEPFN extends AbstractMod {
    @Override
    public void preInit() {
    }
    public static void registerAllEvents() {
        MITEEvents.MITE_EVENT_BUS.register(new PFNEvents());
    }

    @Nonnull
    @Override
    public InjectionConfig getInjectionConfig() {
        return InjectionConfig.Builder.of("MITE-PFN", MinecraftMixin.class.getPackage(), MixinEnvironment.Phase.INIT).setRequired().build();
    }

    @Override
    public void postInit() {
        registerAllEvents();
    }

    @Override
    public String modId() {
        return "MITE-PFN";
    }

    @Override
    public int modVerNum() {
        return Constant.PNF_VER_NUM;
    }

    @Override
    public String modVerStr() {
        return Constant.PNF_VERSION;
    }
}
