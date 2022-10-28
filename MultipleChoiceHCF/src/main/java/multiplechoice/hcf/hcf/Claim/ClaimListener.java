package multiplechoice.hcf.hcf.Claim;

import core.main.core.Chat.Chat;
import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.NumberConversions;

import static core.main.core.Chat.StriketroughCreator.Striketrough;
import static core.main.core.Profile.ProfileManager.profiles;
import static java.lang.Math.round;
import static multiplechoice.hcf.hcf.Claim.ClaimStick.claimStick;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;


public class ClaimListener implements Listener {

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        HCFProfile pHCFP = HCFprofiles.get(p.getUniqueId());
        Profile pProfile = profiles.get(p.getUniqueId());

        ItemStack cS = claimStick();

        Boolean c1 = false, c2 = false;

        if(p.getInventory().getItemInHand().getItemMeta().getLore().equals(cS.getItemMeta().getLore())) {

            Claim claim = new Claim();
            Cuboid cuboid = new Cuboid();

            if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                cuboid.setX1(round(p.getLocation().getX()));
                cuboid.setZ1(round(p.getLocation().getZ()));

                p.sendMessage(HCFPrefix + ChatColor.RED + "x1:" +  ChatColor.WHITE + round(p.getLocation().getX()) + ChatColor.RED + " ,z1: " + ChatColor.WHITE + round(p.getLocation().getZ()));

                c1 = true;

            }

            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                cuboid.setX2(round(p.getLocation().getX()));
                cuboid.setZ2(round(p.getLocation().getZ()));

                p.sendMessage(HCFPrefix + ChatColor.RED + "x2:" +  ChatColor.WHITE + round(p.getLocation().getX()) + ChatColor.RED + " ,z2: " + ChatColor.WHITE + round(p.getLocation().getZ()));

                c2 = true;

            }

            if(p.isSneaking() && e.getAction().equals(Action.LEFT_CLICK_AIR)) {

                if(c1 == true && c2 == true) {

                    claim.cuboid = cuboid;
                    pHCFP.faction.setClaim(claim);

                    String message = HCFPrefix + ChatColor.GREEN + "Your faction's claim is now: x1:" + ChatColor.WHITE + NumberConversions.round(pHCFP.faction.getClaim().cuboid.getX1()) + ChatColor.GREEN + ", z1:" + ChatColor.WHITE + NumberConversions.round(pHCFP.faction.getClaim().cuboid.getZ1()) + ", x2:" + ChatColor.WHITE + NumberConversions.round(pHCFP.faction.getClaim().cuboid.getX1()) + ChatColor.GREEN + ", z2:" + ChatColor.WHITE + NumberConversions.round(pHCFP.faction.getClaim().cuboid.getZ1());
                    String strike = Striketrough("                                                                     ");

                    for (Player plr : Bukkit.getOnlinePlayers()) {

                        Profile plrProfile = profiles.get(plr.getUniqueId());
                        HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                        if (plrHCFP.getFaction().equals(pHCFP.getFaction())) {

                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);
                            plr.sendMessage(message);
                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);

                        }


                    }

                }
                else {

                    p.sendMessage(HCFPrefix + ChatColor.RED + "You need to select 2 points to claim land!");

                }

            }

        }

    }

}
