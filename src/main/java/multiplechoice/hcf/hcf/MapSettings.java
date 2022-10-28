package multiplechoice.hcf.hcf;

public class MapSettings {

    public Integer mapNumber;

    public Integer factionMemberLimit;

    public Boolean healingPotsDisabled;

    public Integer factionLimit;

    public Integer getMapNumber() {  return mapNumber; }

    public Integer getFactionMemberLimit() { return factionMemberLimit; }

    public Boolean getHealingPotsDisabled() { return healingPotsDisabled; }

    public Integer getFactionLimit() { return factionLimit; }

    public void setMapNumber(Integer mapNumber) { this.mapNumber = mapNumber; }

    public void setFactionMemberLimit(Integer factionMemberLimit) { this.factionMemberLimit = factionMemberLimit; }

    public void setHealingPotsDisabled(Boolean healingPotsDisabled) { this.healingPotsDisabled = healingPotsDisabled; }

    public void setFactionLimit(Integer factionLimit) { this.factionLimit = factionLimit; }
}
