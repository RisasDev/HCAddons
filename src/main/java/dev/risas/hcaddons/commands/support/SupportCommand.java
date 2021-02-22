package dev.risas.hcaddons.commands.support;

import dev.risas.hcaddons.managers.support.menu.SupportMenu;
import dev.risas.hcaddons.utils.command.BaseCommand;
import dev.risas.hcaddons.utils.command.Command;
import dev.risas.hcaddons.utils.command.CommandArgs;

public class SupportCommand extends BaseCommand {

    @Command(name = "support", permission = "hcaddons.support")
    @Override
    public void onCommand(CommandArgs command) {
        new SupportMenu().openMenu(command.getPlayer());
    }
}
