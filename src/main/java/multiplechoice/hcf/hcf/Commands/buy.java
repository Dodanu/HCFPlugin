package multiplechoice.hcf.hcf.Commands;

import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class buy implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("kit")) {

            if(args.length == 1) {

                if(args[1].equalsIgnoreCase("chainmail")) {

                    Player p = (Player) sender;
                    HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());

                    if(pHCFP.getBalance() >= 5000) {

                        ItemStack i1 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
                        ItemStack i2 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
                        ItemStack i3 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
                        ItemStack i4 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);

                        p.getInventory().addItem(i1, i2, i3, i4);
                        p.updateInventory();

                        pHCFP.setBalance(pHCFP.getBalance() - 5000);

                    }

                }

            }

        }

        return false;

    }

}
