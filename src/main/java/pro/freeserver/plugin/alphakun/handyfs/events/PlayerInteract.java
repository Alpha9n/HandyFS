package pro.freeserver.plugin.alphakun.handyfs.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class PlayerInteract implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (Objects.equals(item, new ItemStack(Material.BOOK))) {
            Bukkit.dispatchCommand(p,"menu");
            p.sendMessage("menuコマンドを実行しました");
        }
    }
}
