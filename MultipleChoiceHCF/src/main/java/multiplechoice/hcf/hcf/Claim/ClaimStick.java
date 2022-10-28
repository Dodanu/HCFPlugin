package multiplechoice.hcf.hcf.Claim;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static multiplechoice.hcf.hcf.HCF.HCFPrefix;

public class ClaimStick {

    public static ItemStack claimStick() {

        List<String> lores  = new ArrayList<>();
        lores.add("Use this stick to claim land for your faction!");
        ItemStack claimStick = new ItemStack(Material.STICK);
        ItemMeta csM = claimStick.getItemMeta();
        csM.setDisplayName(ChatColor.GREEN + "Claim Stick");
        csM.setLore(lores);
        claimStick.setItemMeta(csM);
        return claimStick;

    }

    public static void getClaimStick(Player p) {

        ItemStack claimStick = claimStick();
        p.getInventory().addItem(claimStick);

        p.sendMessage(HCFPrefix + ChatColor.RED + "You received a claim stick!");
        p.sendMessage(ChatColor.WHITE + "Left-Click" + ChatColor.RED + " on a block to select the first set of coords and Right-Click to select the second set.");
        p.sendMessage(ChatColor.WHITE + "Shift+Left-Click air " + ChatColor.RED + "to buy the selected claim.");

    }

}
