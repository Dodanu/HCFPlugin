package multiplechoice.hcf.hcf;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Date;

import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class onPlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Profile pProfile = profiles.get(p.getUniqueId());

        if(!HCFprofiles.containsKey(p.getUniqueId())) {

            HCFProfile HP = new HCFProfile();
            HP.balance = 1000;
            HP.profile = profiles.get(p.getUniqueId());

        }

        if(pProfile.getDeathBanned() == true) {

            Long howmore = pProfile.getDeathBanTime() - System.currentTimeMillis();
            Date hMDate = new Date(howmore);
            p.kickPlayer(HCFPrefix + ChatColor.RED + "You are deathbanned.\n" + ChatColor.YELLOW + "You may return at " + hMDate.toString());

        }

    }

}
