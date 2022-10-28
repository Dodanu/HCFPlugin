package multiplechoice.hcf.hcf.Kits.Listeners;

import multiplechoice.hcf.hcf.Kits.ArmorEvent;
import multiplechoice.hcf.hcf.Profile.Class;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static multiplechoice.hcf.hcf.Kits.ArmorCheck.isArmour;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class ArcherListener implements Listener {

    @EventHandler
    public void ArcherCheck(ArmorEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

        if(isArmour(Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, p)) {

            pHCFP.setpClass(Class.Archer);
            p.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect(Integer.MAX_VALUE, 2), true);
            p.addPotionEffect(PotionEffectType.SPEED.createEffect(Integer.MAX_VALUE, 2), true);

        }

    }

}
