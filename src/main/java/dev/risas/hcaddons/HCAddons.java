package dev.risas.hcaddons;

import org.bukkit.plugin.java.JavaPlugin;

public class HCAddons extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static HCAddons get() {
        return getPlugin(HCAddons.class);
    }
}
