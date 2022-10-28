package multiplechoice.hcf.hcf.Events;

import core.main.core.Chat.Chat;
import core.main.core.Chat.ChatManager;
import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class FactionChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {

        e.setCancelled(true);
        String message = e.getMessage();
        Player p = e.getPlayer();
        Profile pProfile = profiles.get(p.getUniqueId());
        HCFProfile pHCF = HCFprofiles.get(p.getUniqueId());
        Faction pFaction = pHCF.getFaction();
        Chat chat = ChatManager.chatManager.get(p.getUniqueId());

        if(chat.getFactionChat() == true) {

            String factionName = ChatColor.GRAY + "[" + ChatColor.RED + pFaction.getName() + ChatColor.GRAY + "]";
            String pName = pProfile.getRank().getColor() + p.getName();
            String auxMessage = ChatColor.WHITE + ":" + message;
            String finalMessage = ChatColor.translateAlternateColorCodes('&', factionName + pName + auxMessage);

            for(Player plr : Bukkit.getOnlinePlayers()) {

                Profile plrProfile = profiles.get(plr.getUniqueId());
                HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                if(plrHCFP.getFaction().equals(pFaction)) {

                    plr.sendMessage(finalMessage);

                }

            }

        }

    }

}
