package multiplechoice.hcf.hcf.Kits.Events;

import multiplechoice.hcf.hcf.Profile.Class;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ArcherArrowHitEvent implements Listener {

    @EventHandler
    public void playerArrowHitEvent(EntityDamageByEntityEvent e) {

        if(e.getDamager() instanceof Player && e.getDamager() instanceof Player) {

            Player target = (Player) e.getEntity();
            Player hitter = (Player) e.getDamager();

            if(e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {

                if(hitter.getClass().equals(Class.Archer)) {

                    target.damage(e.getDamage() * 2);

                }

            }


        }


    }

}
