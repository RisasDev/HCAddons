package dev.risas.hcaddons.managers.files;

import dev.risas.hcaddons.HCAddons;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class DataFile extends YamlConfiguration {

    private static DataFile config;
    private final Plugin plugin;
    private final File configFile;

    public static DataFile getConfig() {
        if (DataFile.config == null) DataFile.config = new DataFile();
        return DataFile.config;
    }

    private Plugin main() {
        return HCAddons.get();
    }

    public DataFile() {
        this.plugin = this.main();
        this.configFile = new File(this.plugin.getDataFolder(), "data.yml");
        this.saveDefault();
        this.reload();
    }

    public void reload() {
        try {
            super.load(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            super.save(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        this.plugin.saveResource("data.yml", false);
    }

    public void saveAll() {
        this.save();
        this.reload();
    }
}
