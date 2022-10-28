package multiplechoice.hcf.hcf.StaffCommands;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static core.main.core.Chat.StriketroughCreator.Striketrough;
import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.Faction.FactionManager.factions;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class setDtr implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("setDtr")) {

            Player p = (Player) sender;
            Profile pProfile = profiles.get(p.getUniqueId());

            Faction target = null;

            if (pProfile.getRank().getStaffRank()) {

                if (args.length == 2) {

                    for (int i = 0; i < factions.toArray().length; i++) {

                        if (factions.get(i).getName().equalsIgnoreCase(args[0])) {

                            target = factions.get(i);
                            break;

                        }

                    }

                    Double value = Double.parseDouble(args[1]);

                    if (value >= 0) {

                        if (target != null) {

                            target.setDTR(value);

                            String message = HCFPrefix + ChatColor.RED + "Your faction's DTR has been set to: " + ChatColor.WHITE + value;
                            String strike = Striketrough("                                                         ");

                            for (Player plr : Bukkit.getOnlinePlayers()) {

                                Profile plrProfile = profiles.get(plr.getUniqueId());
                                HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                                if (plrHCFP.getFaction().equals(target)) {

                                    plr.sendMessage(ChatColor.STRIKETHROUGH + strike);
                                    plr.sendMessage(message);
                                    plr.sendMessage(ChatColor.STRIKETHROUGH + strike);

                                }


                            }

                        } else {

                            p.sendMessage(HCFPrefix + ChatColor.YELLOW + "Faction not found!");

                        }

                    } else {

                        p.sendMessage(HCFPrefix + ChatColor.YELLOW + "Value must be greater than 0!");

                    }

                } else {

                    p.sendMessage(HCFPrefix + ChatColor.YELLOW + "correct usage: /setDtr <factionName> <value>");

                }

            }
        }

        return false;
    }

}
