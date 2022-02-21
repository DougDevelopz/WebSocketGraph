package dev.wsgraph;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WSGraph extends JavaPlugin {

    public void onEnable() {
        CustomServerSocketController socketController = new CustomServerSocketController(30045);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, socketController::transferData, 20, 20 * 15);
    }
}
