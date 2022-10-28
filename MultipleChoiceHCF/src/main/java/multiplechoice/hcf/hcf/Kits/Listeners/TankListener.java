package multiplechoice.hcf.hcf.Kits.Listeners;

import multiplechoice.hcf.hcf.Kits.ArmorEvent;
import multiplechoice.hcf.hcf.Profile.Class;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;

import static multiplechoice.hcf.hcf.Kits.ArmorCheck.isArmour;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class TankListener implements Listener {

    @EventHandler
    public void TankCheck(ArmorEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

        if(isArmour(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, p)) {

            pHCFP.setpClass(Class.Tank);
            p.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE.createEffect(Integer.MAX_VALUE, 1), true);
            p.addPotionEffect(PotionEffectType.SPEED.createEffect(Integer.MAX_VALUE, 1), true);

        }

    }

}
