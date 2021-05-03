package pro.freeserver.plugin.alphakun.handyfs.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class EntityDamage implements Listener {
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntityType() == EntityType.PLAYER) {
            Player p = (Player) e.getEntity();
            ItemStack mainhand = p.getInventory().getItemInMainHand();
            ItemStack offhand = p.getInventory().getItemInOffHand();
            if ( mainhand.hasItemMeta() && mainhand.getItemMeta().hasDisplayName() && mainhand.getItemMeta().hasLore() && offhand.hasItemMeta() && offhand.getItemMeta().hasDisplayName() && offhand.getItemMeta().hasLore() ) {
                List<String> lore = mainhand.getItemMeta().getLore();
                if (mainhand.getItemMeta().getDisplayName().equalsIgnoreCase("マジックスティック") && lore.get(0).equalsIgnoreCase("半分にでダメージを無効化する")) {
                    Random rand = new Random();
                    int result = rand.nextInt(2);
                    if (result == 1) {
                        e.setCancelled(true);
                        p.sendMessage("§f>>§aMasicStick§f:" + "§bラッキー！");
                    }
                }
            }
        }
    }
}
