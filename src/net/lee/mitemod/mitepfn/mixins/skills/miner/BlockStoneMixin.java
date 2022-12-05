package net.lee.mitemod.mitepfn.mixins.skills.miner;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(BlockStone.class)
public class BlockStoneMixin extends Block {
    protected BlockStoneMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }



    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo info) {

            if (!info.wasExploded() && info.wasHarvestedByPlayer()) {
            int fortune = info.getHarvesterFortune();
            if (fortune > 3) {
                fortune = 3;
            }
            Random rand = info.world.rand;
            EntityPlayer player = info.getResponsiblePlayer();
            if (rand.nextInt((player.PFNLevel * -1) + 14 - fortune * 2) > 2) {
               return super.dropBlockAsEntityItem(info, cobblestone);
            } else {
                int id_dropped = cobblestone.blockID;
                if (rand.nextInt(3) > 0) {
                    if (rand.nextInt(16) == 0) {
                        return super.dropBlockAsEntityItem(info, cobblestone);
                    }} else if (rand.nextInt(3) > 0) {
                         id_dropped = Item.ingotCopper.itemID;
                     } else if (rand.nextInt(3) > 0) {
                        id_dropped = Item.ingotSilver.itemID;
                     } else if (rand.nextInt(3) > 0) {
                         id_dropped = Item.ingotIron.itemID;
                     } else if (rand.nextInt(3) > 0) {
                        id_dropped = Item.ingotAncientMetal.itemID;
                     } else if (rand.nextInt(3) > 0) {
                        id_dropped = Item.ingotMithril.itemID;
                    } else {
                        id_dropped = Item.ingotAdamantium.itemID;
                    }
                return this.dropBlockAsEntityItem(info, id_dropped);
            }
        }else {
            return this.dropBlockAsEntityItem(info, cobblestone);
        }
    }



}
