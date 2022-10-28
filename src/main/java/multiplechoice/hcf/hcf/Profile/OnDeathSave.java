package multiplechoice.hcf.hcf.Profile;

import org.bukkit.inventory.Inventory;

public class OnDeathSave {

    public Inventory deathInventory;

    public Double dtr;

    public Inventory getDeathInventory() { return this.deathInventory; }

    public Double getDtr() { return this.dtr; }

    public void setDeathInventory(Inventory deathInventory) { this.deathInventory = deathInventory; }

    public void setDtr(Double dtr) { this.dtr = dtr; }
}
