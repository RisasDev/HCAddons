package dev.risas.hcaddons.utils;

import dev.risas.hcaddons.HCAddons;

public class Description {

    public static String getName() {
        return HCAddons.get().getDescription().getName();
    }

    public static String getVersion() {
        return HCAddons.get().getDescription().getVersion();
    }

    public static String getAuthor() {
        return HCAddons.get().getDescription().getAuthors().toString()
                .replace("[", "")
                .replace("]", "");
    }
}
