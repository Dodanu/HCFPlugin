package multiplechoice.hcf.hcf.Timers;

import multiplechoice.hcf.hcf.Profile.HCFProfile;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static multiplechoice.hcf.hcf.HCF.decreaseCombatTimer;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class CombatTimer implements Listener {

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e) {

        if(e.getDamager() instanceof Player) {

            Player p = (Player) e.getDamager();
            HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());
            pHCFP.setCombatTimer(15f);
            decreaseCombatTimer(pHCFP);

        }

    }

}
