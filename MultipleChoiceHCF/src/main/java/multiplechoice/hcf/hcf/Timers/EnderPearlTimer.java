package multiplechoice.hcf.hcf.Timers;

import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static multiplechoice.hcf.hcf.HCF.decreaseEnderTimer;
import static multiplechoice.hcf.hcf.HCF.decreaseGAppleTimer;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class EnderPearlTimer implements Listener {

    @EventHandler
    public void playerEnderpearlThrow(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

        ItemStack i = e.getItem();

        if(i.equals(Material.ENDER_PEARL)) {

            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                if(pHCFP.getEnderTimer() == 0) {

                    pHCFP.setEnderTimer(15f);
                    decreaseEnderTimer(pHCFP);

                }
                else {

                    e.setCancelled(true);

                }

            }

        }

    }

}
