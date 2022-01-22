package me.agns.plantacaoautomatica;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class BreakPlant implements Listener {
    private final HashMap<UUID, Long> cooldownMenssage;

    public BreakPlant() {
        this.cooldownMenssage = new HashMap<>();
    }

    @EventHandler
    public void onBreakPlant(BlockBreakEvent blockBreakEvent){
        Player player = blockBreakEvent.getPlayer();
        String blockData = blockBreakEvent.getBlock().getBlockData().getAsString();
        Material typeBlock = blockBreakEvent.getBlock().getType();
        if (typeBlock.equals(Material.WHEAT)){
            for (int i = 0; i < blockData.length(); i++){
                char a = blockData.charAt(i);
                if (a == 55) {
                    player.getInventory().addItem(blockBreakEvent.getBlock().getDrops().toArray(new ItemStack[0]));
                    blockBreakEvent.getBlock().setType(typeBlock);
                    break;
                }else if(a == 48 || a == 49 || a == 50 || a == 51 || a == 52 || a == 53 || a == 54){
                    if (this.cooldownMenssage.containsKey(blockBreakEvent.getPlayer().getUniqueId())){
                        if (System.currentTimeMillis() - this.cooldownMenssage.get(blockBreakEvent.getPlayer().getUniqueId()) >= 2000){
                            blockBreakEvent.getPlayer().sendMessage("You can't do that yet");
                            this.cooldownMenssage.put(player.getUniqueId(), System.currentTimeMillis());
                        }
                    }else {
                        blockBreakEvent.getPlayer().sendMessage("You can't do that yet");
                        this.cooldownMenssage.put(player.getUniqueId(), System.currentTimeMillis());
                    }
                    break;
                }
            }
            blockBreakEvent.setCancelled(true);
        }

    }
}
