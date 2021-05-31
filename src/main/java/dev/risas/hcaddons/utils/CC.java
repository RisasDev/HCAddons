package dev.risas.hcaddons.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class CC {

    public static String LINE = "&7&m----------------------------------------";

    public static String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(List<String> in) {
        return in.stream().map(CC::translate).collect(Collectors.toList());
    }
    public static void sender(CommandSender sender, String in) {
        sender.sendMessage(translate(in));
    }

    public static void player(Player player, String in) {
        player.sendMessage(translate(in));
    }

    public static void log(String in) {
        Bukkit.getConsoleSender().sendMessage(translate(in));
    }
}
