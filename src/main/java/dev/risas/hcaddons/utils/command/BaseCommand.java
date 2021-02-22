package dev.risas.hcaddons.utils.command;

import dev.risas.hcaddons.HCAddons;

public abstract class BaseCommand {

    public BaseCommand() {
        HCAddons.get().getCommandManager().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
