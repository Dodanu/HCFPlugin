package multiplechoice.hcf.hcf.Timers;

import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class StuckTimer implements Listener {

    @EventHandler
    public void onPlayerHitEvent(EntityDamageEvent e) {

        if(e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();
            HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

            if(pHCFP.getStucktimer() != null) {

                pHCFP.setStucktimer(null);

            }

        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

        if(pHCFP.stuckTimer != null) {

            e.setCancelled(true);

        }

    }

}
