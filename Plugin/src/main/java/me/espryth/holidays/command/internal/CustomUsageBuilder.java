package me.espryth.holidays.command.internal;

import me.fixeddev.commandflow.CommandContext;
import me.fixeddev.commandflow.usage.UsageBuilder;
import net.kyori.text.Component;

public class CustomUsageBuilder implements UsageBuilder {
    @Override
    public Component getUsage(CommandContext commandContext) {
        return null;
    }
}
