package net.lee.mitemod.mitepfn.mixins.skills.miner;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(BlockOre.class)
public class BlockOreMixin extends Block {


    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }



    @Redirect(
            method = {"dropBlockAsEntityItem"},
            at = @At(value = "INVOKE", target = "Lnet/minecraft/Block;dropBlockAsEntityItem(Lnet/minecraft/BlockBreakInfo;IIIF)I"))
    private int redirectDropItem(Block caller, BlockBreakInfo info, int id_dropped, int subtype, int quantity, float chance) {
        EntityPlayer player = info.getResponsiblePlayer();
        ItemStack item_stack = new ItemStack(id_dropped, quantity, subtype);

        int XPSacrificed = ItemRock.getExperienceValueWhenSacrificed(item_stack);
        if (player != null && player.isPFNMiner) {
            if (XPSacrificed != 0) {
                if(info.getMetadata() == 0) {
                    player.addExperience(player.PFNLevel * 5);
                }
                return caller.dropBlockAsEntityItem(info, id_dropped, subtype, quantity, chance);
            } else if(XPSacrificed == 0) {
                if(info.getMetadata() == 0) {
                    player.addExperience(player.PFNLevel * 5);
                }
                return caller.dropBlockAsEntityItem(info, id_dropped, subtype, quantity, chance);
            }


            return 0;
        } else {
            return caller.dropBlockAsEntityItem(info, id_dropped, subtype, quantity, chance);
        }
    }
}


