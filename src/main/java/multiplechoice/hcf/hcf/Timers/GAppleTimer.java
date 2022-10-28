package multiplechoice.hcf.hcf.Timers;

import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import static multiplechoice.hcf.hcf.HCF.decreaseGAppleTimer;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class GAppleTimer implements Listener {

    @EventHandler
    public void playerGappleEvent(PlayerItemConsumeEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

        if(e.getItem().equals(Material.GOLDEN_APPLE)) {

            if(pHCFP.getGAppleTimer() == 0) {

                pHCFP.setGAppleTimer(15f);
                decreaseGAppleTimer(pHCFP);

            }
            else {

                e.setCancelled(true);

            }

        }

    }

}
