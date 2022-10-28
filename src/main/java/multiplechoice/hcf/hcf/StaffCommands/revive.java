package multiplechoice.hcf.hcf.StaffCommands;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import multiplechoice.hcf.hcf.Profile.OnDeathSave;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static core.main.core.Core.CorePrefix;
import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.Profile.DeathSaveManager.deathSaveManager;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class revive implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("revive")) {

            Player p = (Player) sender;
            Profile pProfile = profiles.get(p.getUniqueId());
            HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

            if(pProfile.getRank().getStaffRank()) {

                if(args.length == 1) {

                    OnDeathSave oDs = deathSaveManager.get(p.getUniqueId());
                    Inventory rInv = oDs.getDeathInventory();

                    p.getInventory().setContents(rInv.getContents());
                    pHCFP.getFaction().setDTR(pHCFP.getFaction().getDTR() + 1);

                }

                else {
                    p.sendMessage(CorePrefix + ChatColor.YELLOW + "correct usage: /revive <playerName>");
                }

            }

        }

        return false;
    }

}
