package me.agns.plantacaoautomatica;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BreakPlant implements Listener {
    @EventHandler
    public void onBreakPlant(BlockBreakEvent blockBreakEvent){
        char age = 0;
        String blockData = blockBreakEvent.getBlock().getBlockData().getAsString();
        if (blockBreakEvent.getBlock().getType().equals(Material.WHEAT)){
            for (int i = 0; i < blockData.length(); i++){
                char a = blockData.charAt(i);
                if (a == 48 || a == 49 || a == 50 || a == 51 || a == 52 || a == 53 || a == 54 || a == 55) {
                    age = a;
                }
            }


           if (age != 55) {
                blockBreakEvent.setCancelled(true);
            } else {
                blockBreakEvent.setCancelled(true);
                blockBreakEvent.getPlayer().getInventory().addItem(blockBreakEvent.getBlock().getDrops().toArray(new ItemStack[0]));
                blockBreakEvent.getBlock().setType(Material.WHEAT);
            }

        }
    }
}
