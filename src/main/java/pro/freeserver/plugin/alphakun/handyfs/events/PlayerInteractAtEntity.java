package pro.freeserver.plugin.alphakun.handyfs.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerInteractAtEntity implements Listener {

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();
        if (p.hasPermission("essentials.invsee")) {
            if (e.getRightClicked() instanceof Player) {
                Player clickedp = (Player) e.getRightClicked();
                Bukkit.dispatchCommand(p, "invsee " + clickedp.getName());
            }
        }
    }
}
