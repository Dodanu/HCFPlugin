package multiplechoice.hcf.hcf.Kits.Events;

import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class SetDebuff {

    public static void setDebuff(Player p, Faction f, PotionEffectType pET, Integer t) {

        for (Player plr : Bukkit.getServer().getOnlinePlayers()) {

            HCFProfile plrHCFP = HCFprofiles.get(p.getUniqueId());

            if (!plrHCFP.equals(f)) {

                if (plr.getLocation().distance(p.getLocation()) <= 50) {

                    plr.addPotionEffect(pET.createEffect(t, 2), true);

                }

            }

        }

    }

}
