package multiplechoice.hcf.hcf.Kits.Events;

import multiplechoice.hcf.hcf.Profile.Class;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class AssassinEvent implements Listener {

    @EventHandler
    public void AssassinHitCheckEvent(EntityDamageByEntityEvent e) {

        if(e.getDamager() instanceof Player && e.getDamager() instanceof Player) {

            Player target = (Player) e.getEntity();
            Player hitter = (Player) e.getDamager();

            if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {

                ItemStack item = hitter.getItemInHand();

                if(hitter.getClass().equals(Class.Assassin)) {

                    if(item.equals(Material.GOLD_SWORD)) {

                        if(target.getLocation().getYaw() - 45f <= hitter.getLocation().getYaw() && hitter.getLocation().getYaw() <= target.getLocation().getYaw() + 45f) {

                            e.setDamage(0);
                            target.damage(12);
                            hitter.getInventory().remove(item);

                        }
                    }

                }

            }


        }

    }

}
