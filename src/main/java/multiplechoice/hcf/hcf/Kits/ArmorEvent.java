package multiplechoice.hcf.hcf.Kits;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class ArmorEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    public Player p;

    public ArmorEvent(Player p) { this.p = p; }

    public Player getPlayer() { return p; }

    public void setPlayer(Player p) { this.p = p; }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

}
