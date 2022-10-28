package multiplechoice.hcf.hcf.Events;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static core.main.core.Chat.StriketroughCreator.Striketrough;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.HCF.RegenerateDtr;
import static multiplechoice.hcf.hcf.HCF.hour;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;
import static org.bukkit.util.NumberConversions.round;

public class DeathBan implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        Player p = e.getEntity();
        HCFProfile pHCFProfile = HCFprofiles.get(p.getUniqueId());
        Profile pProfile = pHCFProfile.profile;
        Faction pFaction = pHCFProfile.getFaction();

        Long until = System.currentTimeMillis() + hour;

        Boolean nowRaidable = false;

        if(pFaction.DTR > 0) {

            nowRaidable = true;
            pFaction.DTR = pFaction.DTR - 1;

        }

        Double Dtr = pFaction.DTR;
        Integer x = round(p.getLocation().getX());
        Integer y = round(p.getLocation().getY());
        Integer z = round(p.getLocation().getZ());

        Integer fX1 = round(pFaction.getClaim().cuboid.getX1());
        Integer fX2 = round(pFaction.getClaim().cuboid.getX2());
        Integer fZ1 = round(pFaction.getClaim().cuboid.getZ1());
        Integer fZ2 = round(pFaction.getClaim().cuboid.getZ2());
        Integer centerCoordsX = (fX1 + fX2)/2;
        Integer centerCoordsZ = (fZ1 + fZ2)/2;

        pProfile.setDeathBanned(true);
        pProfile.setDeathBanTime(until);

        String standardMsg = HCFPrefix + ChatColor.DARK_RED + "You have been Deathbanned!\n";
        String dtrMessage = "";

        if(nowRaidable == true) {

            String broadcastMsg = HCFPrefix + "The faction " + pFaction.getName() + " is now raidable!" + "Coords: x:" + centerCoordsX.toString() + " z:" + centerCoordsZ.toString() + "      ";
            String strike = Striketrough(broadcastMsg);
            dtrMessage = ChatColor.DARK_RED + "Your faction is now raidable!";

            Bukkit.broadcastMessage(ChatColor.STRIKETHROUGH + strike);
            Bukkit.broadcastMessage(HCFPrefix + ChatColor.GREEN + "The faction " + pFaction.getName() + " is now raidable!\n" + ChatColor.YELLOW + "Coords: x:" + ChatColor.WHITE + centerCoordsX + ChatColor.YELLOW + " z:" + ChatColor.WHITE + centerCoordsZ);
            Bukkit.broadcastMessage(ChatColor.STRIKETHROUGH + strike);

            RegenerateDtr(pFaction);

        }
        else {
            if(Dtr == 0) {

                dtrMessage = ChatColor.RED + "Your faction's DTR is 0";

            }
            else if(Dtr > 0) {

                dtrMessage = ChatColor.YELLOW + "Your faction's DTR is " + Dtr;

            }
        }

        p.kickPlayer(HCFPrefix + ChatColor.DARK_RED + "You have been Deathbanned!\n" + ChatColor.YELLOW + "You have died at: " + x + y + z + "\n" + dtrMessage);


    }

}
