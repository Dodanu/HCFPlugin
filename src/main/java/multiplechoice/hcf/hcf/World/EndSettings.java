package multiplechoice.hcf.hcf.World;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class EndSettings {

    public static void endSettings() {

        World w = Bukkit.getWorld("HCFEnd");
        w.setAmbientSpawnLimit(0);

    }

}
