package dev.risas.hcaddons.managers.support.menu.buttons;

import dev.risas.hcaddons.HCAddons;
import dev.risas.hcaddons.managers.files.ConfigFile;
import dev.risas.hcaddons.managers.support.Partner;
import dev.risas.hcaddons.managers.support.PartnerManager;
import dev.risas.hcaddons.utils.CC;
import dev.risas.hcaddons.utils.ItemBuilder;
import dev.risas.hcaddons.utils.menu.Button;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class PartnerButton extends Button {

    private final Partner partner;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.SKULL_ITEM)
                .data(3)
                .owner(partner.getPartner())
                .name(partner.getDisplayName())
                .lore(partner.getDescription())
                .build();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
        PartnerManager partnerManager = HCAddons.get().getPartnerManager();

        if (!partnerManager.getSupported().containsKey(player.getUniqueId())) {
            HCAddons.get().getPartnerManager().setSupported(player.getUniqueId(), false);
        }
        if (partnerManager.isSupported(player.getUniqueId())) {
            playFail(player);
            CC.player(player, ConfigFile.getConfig().getString("SUPPORT-MESSAGES.ALREADY"));
            return;
        }
        playSuccess(player);
        partnerManager.setSupported(player.getUniqueId(), true);
        partner.getCommands().forEach(command -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("<player>", player.getName())));
        player.sendMessage(CC.translate(ConfigFile.getConfig().getString("SUPPORT-MESSAGES.SUPPORT")
                .replace("<partner>", partner.getPartner())));
        player.closeInventory();
    }
}
