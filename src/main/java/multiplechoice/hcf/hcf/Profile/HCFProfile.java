package multiplechoice.hcf.hcf.Profile;

import core.main.core.Profile.Profile;
import multiplechoice.hcf.hcf.Faction.Faction;
import multiplechoice.hcf.hcf.Stats.Stats;

public class HCFProfile {

    public Profile profile;

    public Faction faction;

    public Integer balance = 1000;

    public Integer revives = 0;

    public Stats stats;

    public Class pClass;

    public Float combatTimer = 0.00f;

    public Float enderTimer = 0.00f;

    public Float GAppleTimer = 0.00f;

    public Float stuckTimer = null;

    public Boolean invited = false;

    public Faction invitedTo;

    public Faction getFaction() { return this.faction;}

    public Integer getBalance() { return this.balance; }

    public Integer getRevives() { return this.revives; }

    public Class getpClass() { return pClass; }

    public Stats getStats() { return this.stats; }

    public Float getCombatTimer() { return combatTimer; }

    public Float getEnderTimer() { return enderTimer; }

    public Float getGAppleTimer() { return GAppleTimer; }

    public Float getStucktimer() { return stuckTimer; }

    public Boolean getInvited() { return invited; }

    public Faction getInvitedTo() { return invitedTo; }

    public void setBalance(Integer balance) { this.balance = balance; }

    public void setFaction(Faction faction) { this.faction = faction; }

    public void setRevives(Integer revives) { this.revives = revives; }

    public void setpClass(Class pClass) { this.pClass = pClass; }

    public void setCombatTimer(Float combatTimer) { this.combatTimer = combatTimer; }

    public void setEnderTimer(Float enderTimer) { this.enderTimer = enderTimer; }

    public void setGAppleTimer(Float GAppleTimer) { this.GAppleTimer = GAppleTimer; }

    public void setStucktimer(Float stucktimer) { this.stuckTimer = stuckTimer; }

    public void setInvited(Boolean invited) { this.invited = invited; }

    public void setInvitedTo(Faction invitedTo) { this.invitedTo = invitedTo; }
}
