package multiplechoice.hcf.hcf.World;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class EndSettings {

    public void EndSettings() {

        World w = Bukkit.getWorld("HCFEnd");
        w.setAmbientSpawnLimit(0);

    }

}
