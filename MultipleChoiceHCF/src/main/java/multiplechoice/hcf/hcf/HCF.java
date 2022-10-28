package multiplechoice.hcf.hcf;

import core.main.core.Core;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

}
