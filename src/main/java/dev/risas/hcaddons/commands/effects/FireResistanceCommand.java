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

public class FireResistanceCommand extends BaseCommand {

    private final List<UUID> fireResistance = Lists.newArrayList();

    @Command(name = "fireresistance", permission = "hcaddons.fireresistance", aliases = {"fire", "fireres"})
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (isFireResistance(player)) {
            fireResistance.remove(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        }
        else {
            fireResistance.add(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
        }

        player.sendMessage(CC.translate("&eYour fire resistance has been " + (isFireResistance(player) ? "&aenabled" : "&cdisabled") + "&e."));
    }

    private boolean isFireResistance(Player player) {
        return fireResistance.contains(player.getUniqueId());
    }
}
