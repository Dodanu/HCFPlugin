package multiplechoice.hcf.hcf.Kits.Events;

import multiplechoice.hcf.hcf.Profile.Class;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static multiplechoice.hcf.hcf.Kits.Events.SetBuff.setBuff;
import static multiplechoice.hcf.hcf.Kits.Events.SetDebuff.setDebuff;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class BardEvent implements Listener {

    @EventHandler
    public void BardClickEvent(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());
        ItemStack cI = e.getItem();

        if(pHCFP.getClass().equals(Class.Bard)) {

            if (cI.equals(Material.BLAZE_POWDER)) {

                setBuff(p, pHCFP.getFaction(), PotionEffectType.INCREASE_DAMAGE, 3);

            }
            else {
                if(cI.equals(Material.GHAST_TEAR)) {

                    setBuff(p, pHCFP.getFaction(), PotionEffectType.REGENERATION, 3);

                }
                else {

                    if(cI.equals(Material.FERMENTED_SPIDER_EYE)) {

                        setDebuff(p, pHCFP.getFaction(), PotionEffectType.WEAKNESS, 3);

                    }

                }

            }

        }

    }

}
