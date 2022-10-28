package multiplechoice.hcf.hcf;

import core.main.core.Core;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class HCF extends JavaPlugin {

    //&r&7┃

    public static String HCFPrefix = ChatColor.GOLD + "[" + ChatColor.RED + "HCF" + ChatColor.GOLD + "] ";

    public static Long hour = 3600000L;

    public static Plugin instance = null;

    public static String mapNumber = "MAP I";

    @Override
    public void onEnable() {

        instance = this;

        ScoreboardLib.setPluginInstance(this);

    }

    @Override
    public void onDisable() {

        instance = null;

    }

    public static void RegenerateDtr(Faction faction) {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        if(faction.DTR == 0) {
            scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
                @Override
                public void run() {

                    faction.DTR = faction.DTR + 0.01;

                }
            }, 72000);
        }
        else if(faction.DTR >= 0.01 && faction.DTR < 1) {
            scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
                @Override
                public void run() {
                    while(faction.DTR < 1) {
                        faction.DTR = faction.DTR + 0.01;
                    }

                }
            }, 12000);
        }
    }

    public static void decreaseEnderTimer(HCFProfile p) {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {
                while(p.enderTimer > 0) {
                    p.enderTimer = p.enderTimer - 1;
                }
            }
        }, 1000);

    }

    public static void decreaseCombatTimer(HCFProfile p) {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {
                while(p.combatTimer > 0) {
                    p.combatTimer = p.combatTimer - 1;
                }
            }
        }, 1000);

    }

    public static void decreaseGAppleTimer(HCFProfile p) {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {
                while(p.combatTimer > 0) {
                    p.combatTimer = p.combatTimer - 1;
                }
            }
        }, 1000);

    }

    public static void spawnCreeperTimer() {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {

                Location l = new Location(Bukkit.getWorld("HCFNether"), 0, 69, 0);

                for(int i = 0; i < 26; i++) {

                    //trebuie gamerule cu entity disable break sau ceva
                    Bukkit.getWorld("HCFNether").spawnEntity(l, EntityType.CREEPER);

                }

                Bukkit.broadcastMessage(HCFPrefix + ChatColor.GREEN + "Creeper's have been spawned in the nether at 0 0!");

            }
        }, 10000);
    }

    public static void spawnGlowStoneTimer() {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {

                Location l1 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, 100);
                Location l2 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, 99);
                Location l3 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, 101);
                Location l4 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, 100);
                Location l5 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, 99);
                Location l6 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, 101);
                Location l7 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, 100);
                Location l8 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, 99);
                Location l9 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, 101);

                Location l10 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, 100);
                Location l11 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, 99);
                Location l12 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, 101);
                Location l13 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, 100);
                Location l14 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, 99);
                Location l15 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, 101);
                Location l16 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, 100);
                Location l17 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, 99);
                Location l18 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, 101);

                Location l20 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, -100);
                Location l21 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, -99);
                Location l22 = new Location(Bukkit.getWorld("HCFNether"), 100, 69, -101);
                Location l23 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, -100);
                Location l24 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, -99);
                Location l25 = new Location(Bukkit.getWorld("HCFNether"), 101, 69, -101);
                Location l26 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, -100);
                Location l27 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, -99);
                Location l28 = new Location(Bukkit.getWorld("HCFNether"), 99, 69, -101);

                Location l30 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, -100);
                Location l31 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, -99);
                Location l32 = new Location(Bukkit.getWorld("HCFNether"), -100, 69, -101);
                Location l33 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, -100);
                Location l34 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, -99);
                Location l35 = new Location(Bukkit.getWorld("HCFNether"), -101, 69, -101);
                Location l36 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, -100);
                Location l37 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, -99);
                Location l38 = new Location(Bukkit.getWorld("HCFNether"), -99, 69, -101);

                for(int i = 0; i < 26; i++) {

                    l1.getBlock().setType(Material.GLOWSTONE);
                    l2.getBlock().setType(Material.GLOWSTONE);
                    l3.getBlock().setType(Material.GLOWSTONE);
                    l4.getBlock().setType(Material.GLOWSTONE);
                    l5.getBlock().setType(Material.GLOWSTONE);
                    l6.getBlock().setType(Material.GLOWSTONE);
                    l7.getBlock().setType(Material.GLOWSTONE);
                    l8.getBlock().setType(Material.GLOWSTONE);
                    l9.getBlock().setType(Material.GLOWSTONE);

                    l10.getBlock().setType(Material.GLOWSTONE);
                    l11.getBlock().setType(Material.GLOWSTONE);
                    l12.getBlock().setType(Material.GLOWSTONE);
                    l13.getBlock().setType(Material.GLOWSTONE);
                    l14.getBlock().setType(Material.GLOWSTONE);
                    l15.getBlock().setType(Material.GLOWSTONE);
                    l16.getBlock().setType(Material.GLOWSTONE);
                    l17.getBlock().setType(Material.GLOWSTONE);
                    l18.getBlock().setType(Material.GLOWSTONE);

                    l20.getBlock().setType(Material.GLOWSTONE);
                    l21.getBlock().setType(Material.GLOWSTONE);
                    l22.getBlock().setType(Material.GLOWSTONE);
                    l23.getBlock().setType(Material.GLOWSTONE);
                    l24.getBlock().setType(Material.GLOWSTONE);
                    l25.getBlock().setType(Material.GLOWSTONE);
                    l26.getBlock().setType(Material.GLOWSTONE);
                    l27.getBlock().setType(Material.GLOWSTONE);
                    l28.getBlock().setType(Material.GLOWSTONE);

                    l30.getBlock().setType(Material.GLOWSTONE);
                    l31.getBlock().setType(Material.GLOWSTONE);
                    l32.getBlock().setType(Material.GLOWSTONE);
                    l33.getBlock().setType(Material.GLOWSTONE);
                    l34.getBlock().setType(Material.GLOWSTONE);
                    l35.getBlock().setType(Material.GLOWSTONE);
                    l36.getBlock().setType(Material.GLOWSTONE);
                    l37.getBlock().setType(Material.GLOWSTONE);
                    l38.getBlock().setType(Material.GLOWSTONE);

                }

                Bukkit.broadcastMessage(HCFPrefix + ChatColor.GREEN + "The glowstone mountains have been refilled!");

            }
        }, 10000);
    }

    public static void spawnEnderManTimer() {

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        scheduler.scheduleSyncDelayedTask(instance, new Runnable() {
            @Override
            public void run() {

                Location l = new Location(Bukkit.getWorld("HCFEnd"), 0, 69, 0);

                for(int i = 0; i < 26; i++) {

                    //trebuie gamerule cu entity disable break sau ceva
                    Bukkit.getWorld("HCFEnd").spawnEntity(l, EntityType.ENDERMAN);

                }

                Bukkit.broadcastMessage(HCFPrefix + ChatColor.GREEN + "Creeper's have been spawned in the nether at 0 0!");

            }
        }, 10000);
    }

}
