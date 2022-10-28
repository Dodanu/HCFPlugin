package multiplechoice.hcf.hcf.Kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ArmorCheck {

    //a = helmet, b = chestplate, c = leggings, d = boots!!!!
    public static boolean isArmour(Material a, Material b, Material c, Material d, Player p) {

        PlayerInventory pInv = p.getInventory();

        ItemStack pHelmet = pInv.getHelmet();
        ItemStack pChestplate = pInv.getChestplate();
        ItemStack pLeggings = pInv.getChestplate();
        ItemStack pBoots = pInv.getBoots();


        if(pHelmet.equals(a) && pChestplate.equals(b) && pLeggings.equals(c) && pBoots.equals(d)) {

            return true;

        }

        return false;

    }

}
