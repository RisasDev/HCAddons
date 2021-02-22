package dev.risas.hcaddons.utils.menu.buttons;

import dev.risas.hcaddons.utils.ItemBuilder;
import dev.risas.hcaddons.utils.menu.Button;
import dev.risas.hcaddons.utils.menu.pagination.PaginatedMenu;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

@AllArgsConstructor
public class PageInfoButton extends Button {

    private final PaginatedMenu paginatedMenu;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.NETHER_STAR)
                .name("&ePage Info")
                .lore(Collections.singletonList("&e" + paginatedMenu.getPage() + "&7/&a" + paginatedMenu.getPages(player)))
                .build();
    }

    @Override
    public boolean shouldCancel(Player player, int slot, ClickType clickType) {
        return true;
    }
}
