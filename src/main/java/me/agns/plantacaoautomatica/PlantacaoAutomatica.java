package me.agns.plantacaoautomatica;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlantacaoAutomatica extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BreakPlant(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
