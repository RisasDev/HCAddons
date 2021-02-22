package dev.risas.hcaddons.commands;

import dev.risas.hcaddons.HCAddons;
import dev.risas.hcaddons.managers.files.ConfigFile;
import dev.risas.hcaddons.utils.Description;
import dev.risas.hcaddons.utils.command.BaseCommand;
import dev.risas.hcaddons.utils.command.Command;
import dev.risas.hcaddons.utils.command.CommandArgs;
import dev.risas.hcaddons.utils.CC;
import org.bukkit.command.CommandSender;

public class HCAddonsCommand extends BaseCommand {

    @Command(name = "hcaddons", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length == 0) {
            CC.sender(sender, CC.LINE);
            CC.sender(sender, "&6&lHCAddons");
            CC.sender(sender, "&eAuthor&7: &f" + Description.getAuthor());
            CC.sender(sender, "&eVersion&7: &f" + Description.getVersion());
            CC.sender(sender, CC.LINE);
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("hcaddons.reload")) return;

            ConfigFile.getConfig().reload();
            HCAddons.get().getPartnerManager().loadSupport();
            CC.sender(sender, "[&6HCAddons&7] &aSuccessfully reloaded HCAddons.");
        }
    }
}
