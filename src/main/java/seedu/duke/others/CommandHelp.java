package seedu.duke.others;

import seedu.duke.Command;
import seedu.duke.backend.UserInput;

public class CommandHelp extends Command {
    @Override
    public String execute() {
        return "Commands: hr add, hr delete, hr list, events add, events delete, finance add, finance delete, "
                + "help, bye";
    }

    public int validate(UserInput input) {
        if (input.getCategory().equals("") && input.getCommand().equalsIgnoreCase("help")) {
            return ACCEPT;
        } else {
            return NO_MATCH;
        }
    }

    @Override
    public String help() {

        return "";
    }
}
