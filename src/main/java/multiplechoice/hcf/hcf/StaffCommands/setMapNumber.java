package multiplechoice.hcf.hcf.StaffCommands;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Faction.Faction;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.HCF.mapNumber;

public class setMapNumber implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("setMapNumber")) {

            Player p = (Player) sender;
            Profile pProfile = profiles.get(p.getUniqueId());

            if (pProfile.getRank().getStaffRank()) {

                if (args.length == 1) {

                    mapNumber = "MAP" + args[0];

                } else {

                    p.sendMessage(HCFPrefix + ChatColor.YELLOW + "correct usage: /setMapNumber <number(in roman numerals)>");

                }

            }

        }

        return false;

    }

}
