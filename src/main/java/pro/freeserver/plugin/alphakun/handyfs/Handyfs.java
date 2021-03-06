package pro.freeserver.plugin.alphakun.handyfs;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pro.freeserver.plugin.alphakun.handyfs.events.EntityDamage;
import pro.freeserver.plugin.alphakun.handyfs.events.PlayerInteract;
import pro.freeserver.plugin.alphakun.handyfs.events.PlayerInteractAtEntity;

public final class Handyfs extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        generateEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void generateEvents() {
        PluginManager plm = getServer().getPluginManager();
        plm.registerEvents(new PlayerInteract(), plugin);
        plm.registerEvents(new EntityDamage(), plugin);
        plm.registerEvents(new PlayerInteractAtEntity(), plugin);
    }
}
