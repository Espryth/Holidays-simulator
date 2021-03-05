package me.espryth.holidays.command;

import me.espryth.holidays.command.subcommand.ArenaSubCommand;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.SubCommandClasses;

@SubCommandClasses(
        ArenaSubCommand.class
)
@Command(
        names = {"hs", "holidayssimulator", "holidays"}
)
public class MainCommand implements CommandClass {

    @Command(
            names = ""
    )
    public void runMainCommand() {

    }

}