package dev.risas.hcaddons.commands.effects;

import com.google.common.collect.Lists;
import dev.risas.hcaddons.utils.command.BaseCommand;
import dev.risas.hcaddons.utils.command.Command;
import dev.risas.hcaddons.utils.command.CommandArgs;
import dev.risas.hcaddons.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.UUID;

public class SpeedCommand extends BaseCommand {

    private final List<UUID> speed = Lists.newArrayList();

    @Command(name = "speed", permission = "hcaddons.speed")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (isSpeed(player)) {
            speed.remove(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.SPEED);
        }
        else {
            speed.add(player.getUniqueId());
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
        }

        player.sendMessage(CC.translate("&eYour speed has been " + (isSpeed(player) ? "&aenabled" : "&cdisabled") + "&e."));
    }

    private boolean isSpeed(Player player) {
        return speed.contains(player.getUniqueId());
    }
}
