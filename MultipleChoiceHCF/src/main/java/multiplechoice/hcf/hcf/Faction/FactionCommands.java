package multiplechoice.hcf.hcf.Faction;

import core.main.core.Chat.Chat;
import core.main.core.Chat.StriketroughCreator;
import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.apache.commons.lang.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

import static core.main.core.Chat.ChatManager.chatManager;
import static core.main.core.Chat.StriketroughCreator.Striketrough;
import static core.main.core.Profile.ProfileManager.profiles;
import static multiplechoice.hcf.hcf.Claim.ClaimStick.claimStick;
import static multiplechoice.hcf.hcf.Claim.ClaimStick.getClaimStick;
import static multiplechoice.hcf.hcf.Faction.FactionManager.factions;
import static multiplechoice.hcf.hcf.HCF.HCFPrefix;
import static multiplechoice.hcf.hcf.Profile.HCFProfileManager.HCFprofiles;
import static org.bukkit.util.NumberConversions.round;

public class FactionCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("f")) {

            Player p = (Player) sender;
            HCFProfile pHCFProfile = HCFprofiles.get(p.getUniqueId());
            Profile pProfile = pHCFProfile.profile;
            Boolean claiming = false;

            if(args.length > 1) {

                if(args[0].equalsIgnoreCase("create")) {

                    if(args.length == 2) {

                        String fName = args[1];

                        if(pHCFProfile.getFaction() == null) {

                            Faction faction = new Faction();
                            faction.setName(fName);
                            faction.setDTR(1D);
                            faction.addMembers(pHCFProfile);
                            faction.setLeader(pHCFProfile);

                        }
                        else {

                            p.sendMessage(HCFPrefix + ChatColor.RED + "You are already in a faction!");

                        }

                    }
                    else {

                        p.sendMessage(HCFPrefix + ChatColor.YELLOW + "correct usage: /f create <factionName>");

                    }

                }
                else {
                    if(args[0].equalsIgnoreCase("who") || args[0].equalsIgnoreCase("show")) {

                        if(args.length == 2) {

                            String who = args[1];
                            Faction faction = new Faction();

                            for(int i=0; i < factions.size(); i++) {

                                Faction faction_ = factions.get(i);

                                if(faction_.getName().equalsIgnoreCase(who)) {

                                    faction = faction_;
                                    break;

                                }

                            }

                            String name = faction.getName();
                            Double DTR = faction.getDTR();
                            Integer memberNumber = faction.memberNumber;

                            Integer fX1 = round(faction.getClaim().cuboid.getX1());
                            Integer fX2 = round(faction.getClaim().cuboid.getX2());
                            Integer fZ1 = round(faction.getClaim().cuboid.getZ1());
                            Integer fZ2 = round(faction.getClaim().cuboid.getZ2());
                            Integer centerCoordsX = (fX1 + fX2)/2;
                            Integer centerCoordsZ = (fZ1 + fZ2)/2;

                            Location home = new Location(p.getWorld(), centerCoordsX, 0, centerCoordsZ);


                            String members = "";

                            for(int i=0; i<faction.members.size(); i++) {

                                Profile profile = faction.getMembers(i).profile;
                                UUID mUUID = new UUID(0L, 0L);

                                for(UUID key : profiles.keySet()) {

                                    if(profiles.get(key).equals(profile)){
                                        mUUID = key;
                                    }

                                }
                                members = members + Bukkit.getPlayer(mUUID).getName() + " ";

                            }

                            members = ChatColor.WHITE + members;

                            p.sendMessage(ChatColor.STRIKETHROUGH + "                                                       ");
                            p.sendMessage(ChatColor.RED + "Faction name: " + ChatColor.WHITE + name);
                            p.sendMessage(ChatColor.RED + "DTR: " + ChatColor.WHITE + DTR);
                            p.sendMessage(ChatColor.RED + "Members: " + ChatColor.WHITE + members);
                            p.sendMessage(ChatColor.RED + "Number of members: " + ChatColor.WHITE + memberNumber);
                            p.sendMessage(ChatColor.RED + "Home location: " + ChatColor.WHITE + " x: " + ChatColor.RED + round(home.getX()) + ChatColor.WHITE + " y: " + ChatColor.RED + round(home.getY()));
                            p.sendMessage(ChatColor.STRIKETHROUGH + "                                                       ");

                        }
                        else {

                            if(args[0].equalsIgnoreCase("leave")) {

                                Faction pFaction = pHCFProfile.getFaction();

                                if(pFaction != null) {

                                    p.sendMessage(HCFPrefix + ChatColor.RED + "You have left the " + ChatColor.WHITE + pFaction.getName() + ChatColor.RED + " faction.");

                                    String message = HCFPrefix + ChatColor.RED + "The player " + ChatColor.WHITE + p.getName() + ChatColor.RED + " has left your faction!";
                                    String strMsg = message + "                   ";
                                    String strike = Striketrough(strMsg);

                                    for(Player plr : Bukkit.getOnlinePlayers()) {

                                        Profile plrProfile = profiles.get(plr.getUniqueId());
                                        HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                                        if(plrHCFP.getFaction().equals(pFaction)) {

                                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);
                                            plr.sendMessage(message);
                                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);

                                        }


                                    }

                                    pFaction.members.remove(pHCFProfile);
                                    pHCFProfile.setFaction(null);


                                }
                                else {

                                    p.sendMessage(HCFPrefix + ChatColor.YELLOW + "You can't leave a factions since you aren't in one!");

                                }

                            }

                            else {

                                if(args[0].equalsIgnoreCase("chat")) {

                                    if(chatManager.get(p.getUniqueId()).getFactionChat() == false) {

                                        chatManager.get(p.getUniqueId()).setAllChat(false);
                                        chatManager.get(p.getUniqueId()).setPartyChat(false);
                                        chatManager.get(p.getUniqueId()).setStaffChat(false);
                                        chatManager.get(p.getUniqueId()).setFactionChat(true);

                                    }
                                    else {

                                        chatManager.get(p.getUniqueId()).setAllChat(true);
                                        chatManager.get(p.getUniqueId()).setPartyChat(false);
                                        chatManager.get(p.getUniqueId()).setStaffChat(false);
                                        chatManager.get(p.getUniqueId()).setFactionChat(false);

                                    }

                                }
                                else {

                                    if(args[0].equalsIgnoreCase("setHome")) {

                                        if(pHCFProfile.getFaction().getLeader().equals(pHCFProfile)) {
                                            pHCFProfile.getFaction().setHome(p.getLocation());


                                            String message = HCFPrefix + ChatColor.GREEN + "Your faction's home is now: " + ChatColor.WHITE + round(p.getLocation().getX()) + ChatColor.GREEN + "," + ChatColor.WHITE + round(p.getLocation().getY());
                                            String strike = Striketrough("                                         ");

                                            for (Player plr : Bukkit.getOnlinePlayers()) {

                                                Profile plrProfile = profiles.get(plr.getUniqueId());
                                                HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                                                if (plrHCFP.getFaction().equals(pHCFProfile.getFaction())) {

                                                    plr.sendMessage(ChatColor.STRIKETHROUGH + strike);
                                                    plr.sendMessage(message);
                                                    plr.sendMessage(ChatColor.STRIKETHROUGH + strike);

                                                }


                                            }
                                        }
                                        else {
                                            p.sendMessage(HCFPrefix + ChatColor.RED + "You need to be the faction leader to do that!");
                                        }

                                    }

                                    else {

                                        if(args[0].equalsIgnoreCase("claim")) {

                                            if(claiming == false) {

                                                getClaimStick(p);
                                                claiming = true;

                                            }
                                            else {

                                                p.getInventory().remove(claimStick());
                                                claiming = false;

                                            }

                                        }

                                        else {

                                            if(args[0].equalsIgnoreCase("kick")) {

                                                if(args.length == 2) {

                                                    Player target = Bukkit.getPlayer(args[1]);
                                                    HCFProfile tHCFP = HCFprofiles.get(target.getUniqueId());
                                                    tHCFP.setFaction(null);
                                                    HCFprofiles.put(target.getUniqueId(), tHCFP);

                                                    for (Player plr : Bukkit.getOnlinePlayers()) {

                                                        Profile plrProfile = profiles.get(plr.getUniqueId());
                                                        HCFProfile plrHCFP = HCFprofiles.get(plrProfile);

                                                        String strike = Striketrough("                                         ");
                                                        String message = HCFPrefix + ChatColor.YELLOW + target.getName() + ChatColor.RED + " has been kicked from your faction!";

                                                        if (plrHCFP.getFaction().equals(pHCFProfile.getFaction())) {

                                                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);
                                                            plr.sendMessage(message);
                                                            plr.sendMessage(ChatColor.STRIKETHROUGH + strike);

                                                        }


                                                    }


                                                }
                                                else {

                                                    if(pHCFProfile.getFaction().getLeader().equals(pHCFProfile)) {

                                                        p.sendMessage(HCFPrefix + ChatColor.RED + "You need to provide a player name to do that!");

                                                    }
                                                    else {

                                                        p.sendMessage(HCFPrefix + ChatColor.RED + "You need to be a faction leader to do that!");

                                                    }

                                                }

                                            }

                                        }

                                    }

                                }

                            }

                        }

                    }
                }


            }
            else{
                p.sendMessage(HCFPrefix);   //aici trebuie sa vina un help text ceva
            }

        }

        return false;

    }

}
