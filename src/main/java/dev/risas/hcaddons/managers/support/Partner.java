package dev.risas.hcaddons.managers.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Partner {

    private final String partner;
    private final String displayName;
    private final List<String> description;
    private final int slot;
    private final List<String> commands;

    public String getDisplayName() {
        return this.displayName.replace("<partner>", this.getPartner());
    }
}
