package multiplechoice.hcf.hcf.Scoreboard;

import me.tigerhix.lib.scoreboard.ScoreboardLib;
import me.tigerhix.lib.scoreboard.common.EntryBuilder;
import me.tigerhix.lib.scoreboard.type.Entry;
import me.tigerhix.lib.scoreboard.type.Scoreboard;
import me.tigerhix.lib.scoreboard.type.ScoreboardHandler;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;
import static org.bukkit.Bukkit.getServer;

public class scoreboard implements Listener {

    public void scoreboard() {

        for (Player player: getServer().getOnlinePlayers()) {
            Scoreboard scoreboard = ScoreboardLib.createScoreboard(player)
                    .setHandler(new ScoreboardHandler() {

                        @Override
                        public String getTitle(Player player) {
                            return ChatColor.translateAlternateColorCodes('&', "&c&lCore &r&7┃ &f&lHCF");
                        }

                        @Override
                        public List<Entry> getEntries(Player player) {

                            HCFProfile pHCFP = HCFprofiles.get(player.getUniqueId());

                            if(pHCFP.faction != null) {
                                    return new EntryBuilder()
                                        .blank()
                                        .next("&7&m                                     ")
                                        .blank()
                                        .next("&cOnline&f: " + Bukkit.getServer().getOnlinePlayers())
                                        .next("&cFaction&f: " + pHCFP.getFaction().getName())
                                        .next("&cDTR&f: " + pHCFP.getFaction().getDTR() + "&c■")
                                        .next("&Combat Timer&f: " + pHCFP.getCombatTimer())
                                        .next("&Stuck Timer&f: " + pHCFP.getStucktimer())
                                        .next("&EnderPearl Timer&f: " + pHCFP.getEnderTimer())
                                        .next("&GApple Timer&f: " + pHCFP.getGAppleTimer())
                                        .blank()
                                        .next("&7&m                                     ")
                                        .build();

                            }
                            else {

                                return new EntryBuilder()
                                        .blank()
                                        .next("&7&m                                     ")
                                        .blank()
                                        .next("&cOnline&f: " + Bukkit.getServer().getOnlinePlayers())
                                        .next("&cUse &f/faction <factionName> &c to create a faction!")
                                        .blank()
                                        .next("&7&m                                     ")
                                        .build();

                            }
                        }

                    })
                    .setUpdateInterval(2l);
            scoreboard.activate();
        }
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        scoreboard();

    }

}
