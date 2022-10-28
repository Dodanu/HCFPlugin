package multiplechoice.hcf.hcf.WorldBorder;

import core.main.core.Core;
import core.main.core.Profile.Profile;
import core.main.core.Profile.ProfileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;

public class WBNormal {

    public static void setNormalWB() {

        WorldBorder wb = Bukkit.getWorld("HCFWorld").getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(20000);

        String message = HCFPrefix + ChatColor.GREEN + "World border has been set to " + ChatColor.WHITE + "10000x10000" + ChatColor.GREEN + ".";

        for (Player staff : Bukkit.getOnlinePlayers()) {

            Profile sProfile = profiles.get(staff.getUniqueId());
            String staffFinalMessage = message;

            if (sProfile.getRank().getStaffRank().booleanValue() == true) {

                staff.sendMessage(staffFinalMessage);

            }

        }

    }

}
