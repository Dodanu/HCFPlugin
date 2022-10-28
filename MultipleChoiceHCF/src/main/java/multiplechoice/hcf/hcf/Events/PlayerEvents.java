package multiplechoice.hcf.hcf.Events;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Claim.Claim;
import multiplechoice.hcf.hcf.Claim.Cuboid;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import multiplechoice.hcf.hcf.Profile.OnDeathSave;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.Faction.FactionManager.factions;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.DeathSaveManager.deathSaveManager;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {

        Player p = e.getEntity();
        Profile pProfile = profiles.get(p.getUniqueId());
        HCFProfile pHCFProfile = HCFprofiles.get(p.getUniqueId());

        OnDeathSave pDS = new OnDeathSave();
        pDS.setDtr(pHCFProfile.getFaction().getDTR());
        pDS.setDeathInventory(p.getInventory());

        deathSaveManager.put(p.getUniqueId(), pDS);

        if(p.getKiller() != null) {

            Player k = p.getKiller();
            Profile kProfile = profiles.get(k.getUniqueId());
            HCFProfile kHCFProfile = HCFprofiles.get(k.getUniqueId());

            if(pHCFProfile.getFaction().getDTR() > 0) {

                pHCFProfile.getFaction().setDTR(pHCFProfile.getFaction().getDTR() - 1);

            }
            if(kHCFProfile.getFaction().getDTR() < kHCFProfile.getFaction().members.size()+1) {

                kHCFProfile.getFaction().setDTR(kHCFProfile.getFaction().getDTR() + 1);

            }

            kHCFProfile.getStats().setKills(kHCFProfile.getStats().getKills() + 1);
            pHCFProfile.getStats().setDeaths(pHCFProfile.getStats().getDeaths() + 1);

            String pKills = ChatColor.GRAY + "[" + ChatColor.WHITE + pHCFProfile.getStats().getKills() + ChatColor.GRAY + "]";
            String kKills = ChatColor.GRAY + "[" + ChatColor.WHITE + kHCFProfile.getStats().getKills() + ChatColor.GRAY + "]";

            e.setDeathMessage(ChatColor.YELLOW + p.getName() + pKills + ChatColor.RED + " has been killed by " + ChatColor.YELLOW + k.getName() + kKills);

        }

    }

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent e) {

        Player p = e.getPlayer();
        Profile pProfile = profiles.get(p.getUniqueId());
        HCFProfile pHCFProfile = HCFprofiles.get(p.getUniqueId());

        Block b = e.getBlock();

        //trebuie adaugat staffmode
        if(b.getLocation().getX() <= 1000 && b.getLocation().getX() >= -1000) {
            if(b.getLocation().getZ() <= 1000 && b.getLocation().getZ() >= -1000){

                e.setCancelled(true);

                p.sendMessage(HCFPrefix + ChatColor.RED + "You can't break blocks in the spawn and in the warzone and spawn");

            }
        }

        for(int i=0; i<factions.size(); i++) {

            Faction faction = factions.get(i);
            Claim claim = faction.getClaim();
            Cuboid cuboid = claim.cuboid;

            if(faction.equals(pHCFProfile.faction) == false) {
                if (b.getLocation().getX() <= claim.cuboid.getBiggerX() && b.getLocation().getX() >= claim.cuboid.getSmallerX()) {
                    if (b.getLocation().getZ() <= claim.cuboid.getBiggerZ() && b.getLocation().getZ() >= claim.cuboid.getSmallerZ()) {

                        e.setCancelled(true);

                        p.sendMessage(HCFPrefix + ChatColor.RED + "You can't break blocks in the " + faction.getName() + "'s claim because they are not raidable!");

                    }
                }
            }

        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();
        Profile pProfile = profiles.get(p.getUniqueId());
        HCFProfile pHCFProfile = HCFprofiles.get(p.getUniqueId());

        Block b = e.getBlock();

        //trebuie adaugat staffmode
        if(b.getLocation().getX() <= 1000 && b.getLocation().getX() >= -1000) {
            if(b.getLocation().getZ() <= 1000 && b.getLocation().getZ() >= -1000){

                e.setCancelled(true);

                p.sendMessage(HCFPrefix + ChatColor.RED + "You can't place blocks in the spawn and in the warzone and spawn");

            }
        }

        for(int i=0; i<factions.size(); i++) {

            Faction faction = factions.get(i);
            Claim claim = faction.getClaim();
            Cuboid cuboid = claim.cuboid;

            if(faction.equals(pHCFProfile.faction) == false) {
                if (b.getLocation().getX() <= claim.cuboid.getBiggerX() && b.getLocation().getX() >= claim.cuboid.getSmallerX()) {
                    if (b.getLocation().getZ() <= claim.cuboid.getBiggerZ() && b.getLocation().getZ() >= claim.cuboid.getSmallerZ()) {

                        e.setCancelled(true);

                        p.sendMessage(HCFPrefix + ChatColor.RED + "You can't place blocks in the " + faction.getName() + "'s claim because they are not raidable!");

                    }
                }
            }

        }

    }

}
