package dev.risas.hcaddons.managers.support.menu;

import dev.risas.hcaddons.HCAddons;
import dev.risas.hcaddons.managers.files.ConfigFile;
import dev.risas.hcaddons.managers.support.menu.buttons.PartnerButton;
import dev.risas.hcaddons.utils.menu.Button;
import dev.risas.hcaddons.utils.menu.Menu;
import dev.risas.hcaddons.utils.CC;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SupportMenu extends Menu {

    private final HCAddons plugin = HCAddons.get();

    {
        setUpdateAfterClick(false);
        setAutoUpdate(false);
    }

    @Override
    public String getTitle(Player player) {
        return CC.translate(ConfigFile.getConfig().getString("SUPPORT-MENU.TITLE"));
    }

    @Override
    public int getSize() {
        return 9 * ConfigFile.getConfig().getInt("SUPPORT-MENU.SIZE");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        plugin.getPartnerManager().getPartners().forEach(partner ->
                buttons.put(partner.getSlot(), new PartnerButton(partner)));

        return buttons;
    }
}
