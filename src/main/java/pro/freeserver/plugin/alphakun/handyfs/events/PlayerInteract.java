package pro.freeserver.plugin.alphakun.handyfs.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static pro.freeserver.plugin.alphakun.handyfs.Handyfs.*;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        delay(item,p);
    }

    private static void delay(ItemStack item, Player p) {
        new BukkitRunnable() {

            @Override
            public void run() {
                if (item.getType().equals(Material.BOOK) && !(p.getOpenInventory() instanceof PlayerInventory)) {
                    p.chat("/menu");
                }
            }
        }.runTaskLater(plugin,2L);
    }
}
