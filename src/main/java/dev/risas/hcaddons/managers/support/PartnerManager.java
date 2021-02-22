package dev.risas.hcaddons.managers.support;

import dev.risas.hcaddons.managers.files.ConfigFile;
import dev.risas.hcaddons.utils.CC;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;

@Getter
public class PartnerManager {

    private final List<Partner> partners = new ArrayList<>();
    private final Map<UUID, Boolean> supported = new HashMap<>();

    public void loadSupport() {
        partners.clear();

        ConfigurationSection section = ConfigFile.getConfig().getConfigurationSection("SUPPORT-MENU.PARTNERS");

        section.getKeys(false).forEach(partner -> {
            String displayName = ConfigFile.getConfig().getString("SUPPORT-MENU.PARTNERS." + partner + ".ICON.DISPLAYNAME");
            List<String> description = ConfigFile.getConfig().getStringList("SUPPORT-MENU.PARTNERS." + partner + ".ICON.DESCRIPTION");
            int slot = ConfigFile.getConfig().getInt("SUPPORT-MENU.PARTNERS." + partner + ".ICON.SLOT");
            List<String> commands = ConfigFile.getConfig().getStringList("SUPPORT-MENU.PARTNERS." + partner + ".COMMANDS");

            partners.add(new Partner(partner, displayName, description, slot, commands));
        });

        CC.log("[&6HCAddons&7] &aSuccessfully loaded &f" + partners.size() + " &apartners.");
    }

    public boolean isSupported(UUID uuid) {
        return supported.get(uuid);
    }

    public void setSupported(UUID uuid, boolean b0) {
        supported.put(uuid, b0);
    }
}
