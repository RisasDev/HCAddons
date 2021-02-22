package dev.risas.hcaddons;

import dev.risas.hcaddons.commands.HCAddonsCommand;
import dev.risas.hcaddons.commands.effects.FireResistanceCommand;
import dev.risas.hcaddons.commands.effects.InvisibilityCommand;
import dev.risas.hcaddons.commands.effects.SpeedCommand;
import dev.risas.hcaddons.commands.support.SupportCommand;
import dev.risas.hcaddons.managers.support.PartnerManager;
import dev.risas.hcaddons.managers.support.data.SupportData;
import dev.risas.hcaddons.utils.CC;
import dev.risas.hcaddons.utils.command.CommandManager;
import dev.risas.hcaddons.utils.menu.ButtonListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class HCAddons extends JavaPlugin {

    private CommandManager commandManager;
    private PartnerManager partnerManager;

    @Override
    public void onEnable() {
        CC.log("&7[&6HCAddons&7] &aLoading plugin...");

        this.loadManagers();
        this.loadListeners();
        this.loadCommands();

        SupportData.load();

        this.getPartnerManager().loadSupport();

        CC.log("&7[&6HCAddons&7] &aSuccessfully loaded :)");
    }

    @Override
    public void onDisable() {
        CC.log("&7[&6HCAddons&7] &cDisabling plugin...");

        SupportData.save();
    }

    private void loadManagers() {
        CC.log("&7[&6HCAddons&7] &aLoading managers...");

        this.commandManager = new CommandManager(this);
        this.partnerManager = new PartnerManager();
    }

    private void loadListeners() {
        CC.log("&7[&6HCAddons&7] &aLoading listeners...");

        new ButtonListener();
    }

    private void loadCommands() {
        CC.log("&7[&6HCAddons&7] &aLoading commands...");

        new HCAddonsCommand();
        new FireResistanceCommand();
        new InvisibilityCommand();
        new SpeedCommand();
        new SupportCommand();
    }

    public static HCAddons get() {
        return getPlugin(HCAddons.class);
    }
}
