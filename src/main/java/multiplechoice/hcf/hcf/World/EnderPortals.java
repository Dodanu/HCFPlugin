package multiplechoice.hcf.hcf.World;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class EnderPortals {

    public static void buildEnderPortals() {

        Location l = new Location(Bukkit.getWorld("HCFWorld"), 1000, 70, 1000);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 1000, 70, 1001);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 1000, 70, 999);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 1001, 70, 1000);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 1001, 70, 1001);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 1001, 70, 999);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 999, 70, 1000);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 999, 70, 1001);
        l.getBlock().setType(Material.ENDER_PORTAL);

        l = new Location(Bukkit.getWorld("HCFWorld"), 999, 70, 999);
        l.getBlock().setType(Material.ENDER_PORTAL);

    }

}
