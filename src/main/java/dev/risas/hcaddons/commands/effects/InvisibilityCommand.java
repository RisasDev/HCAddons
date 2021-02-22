package dev.risas.hcaddons.commands.effects;

import com.google.common.collect.Lists;
import dev.risas.hcaddons.utils.CC;
import dev.risas.hcaddons.utils.command.BaseCommand;
import dev.risas.hcaddons.utils.command.Command;
import dev.risas.hcaddons.utils.command.CommandArgs;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

public class InvisibilityCommand extends BaseCommand {

    private final List<UUID> invisibility = Lists.newArrayList();

    @Command(name = "invisibility", permission = "hcaddons.invisibility", aliases = {"invi"})
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (isSpeed(player)) {
            invisibility.remove(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        else {
            invisibility.add(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));
        }

        player.sendMessage(CC.translate("&eYour invisibility has been " + (isSpeed(player) ? "&aenabled" : "&cdisabled") + "&e."));
    }

    private boolean isSpeed(Player player) {
        return invisibility.contains(player.getUniqueId());
    }
}
