package dev.risas.hcaddons.utils.menu.buttons;

import dev.risas.hcaddons.utils.CC;
import dev.risas.hcaddons.utils.menu.Button;
import dev.risas.hcaddons.utils.menu.Menu;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@AllArgsConstructor
public class BackButton extends Button {

    private final Menu back;

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemStack itemStack = new ItemStack(Material.BED);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(CC.translate("&cGo back"));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }
}
