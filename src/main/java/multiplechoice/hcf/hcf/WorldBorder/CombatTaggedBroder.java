package multiplechoice.hcf.hcf.WorldBorder;

import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class CombatTaggedBroder implements Listener {

    @EventHandler
    public void onPlayerTryEnterSpawn(PlayerMoveEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());
        Location l = e.getTo();

        if(pHCFP.getCombatTimer() > 0) {

            if(-50 < l.getX() && l.getX() < 50 ) {
                if(-50 < l.getZ() && l.getZ() < 50) {

                    e.setCancelled(true);
                    p.sendMessage(HCFPrefix + ChatColor.RED + "You can't enter spawn while being combat-tagged!");

                }
            }

        }

    }

}
