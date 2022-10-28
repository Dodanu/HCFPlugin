package multiplechoice.hcf.hcf.Faction;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Claim.Claim;
import multiplechoice.hcf.hcf.Profile.HCFProfile;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Faction {

    public List<HCFProfile> members = new ArrayList<HCFProfile>();

    public List<HCFProfile> officers = new ArrayList<HCFProfile>();

    public HCFProfile leader;

    public Integer memberNumber = members.size();

    public Claim claim;

    public String name;

    public Double DTR;

    public Integer balance;

    public Integer id;

    public Location home;

    public HCFProfile getMembers(Integer poz) { return members.get(poz); }

    public Claim getClaim() { return this.claim; }

    public String getName() { return this.name; }

    public Double getDTR() { return this.DTR; }

    public Integer getBalance() { return this.balance; }

    public Integer getId() { return this.id; }

    public Location getHome() { return this.home; }

    public HCFProfile getLeader() { return this.leader; }

    public void addMembers(HCFProfile p) { this.members.add(p); }

    public void setClaim(Claim claim) { this.claim = claim; }

    public void setName(String name) { this.name = name; }

    public void setDTR(Double DTR) { this.DTR = DTR; }

    public void setBalance(Integer balance) { this.balance = balance; }

    public void setId(Integer id) { this.id = id; }

    public void setHome(Location home) { this.home = home; }

    public void setLeader(HCFProfile leader) { this.leader = leader; }

}
