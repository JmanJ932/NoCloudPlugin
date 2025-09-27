package com.example.nocloud;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class NoCloudPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[NoCloudPlugin] Enabled! Blocking area_effect_cloud entities.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[NoCloudPlugin] Disabled!");
    }

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.AREA_EFFECT_CLOUD) {
            event.setCancelled(true);
            getLogger().info("Blocked area_effect_cloud spawn at " + event.getEntity().getLocation());
        }
    }
}
