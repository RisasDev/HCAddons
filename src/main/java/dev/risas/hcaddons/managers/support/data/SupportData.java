package dev.risas.hcaddons.managers.support.data;

import dev.risas.hcaddons.HCAddons;
import dev.risas.hcaddons.managers.files.DataFile;
import dev.risas.hcaddons.utils.CC;
import java.util.Map;
import java.util.UUID;

public class SupportData {

    public static void save() {
        if (!HCAddons.get().getPartnerManager().getSupported().isEmpty()) {
            for (Map.Entry<UUID, Boolean> entry : HCAddons.get().getPartnerManager().getSupported().entrySet()) {
                DataFile.getConfig().set("DATA." + entry.getKey() + ".SUPPORTED", entry.getValue());
            }
        }
        DataFile.getConfig().saveAll();
        CC.log("&7[&6HCAddons&7] &aSaving data...");
    }

    public static void load() {
        DataFile.getConfig().getConfigurationSection("DATA").getKeys(false).forEach(uuid -> {
            boolean supported = DataFile.getConfig().getBoolean("DATA." + uuid + ".SUPPORTED");
            HCAddons.get().getPartnerManager().getSupported().put(UUID.fromString(uuid), supported);
        });
        CC.log("&7[&6HCAddons&7] &aLoading data...");
    }
}
