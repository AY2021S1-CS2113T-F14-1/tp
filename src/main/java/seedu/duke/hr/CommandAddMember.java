package seedu.duke.hr;

import seedu.duke.Command;
import seedu.duke.backend.UserInput;

import static seedu.duke.hr.MemberList.isInteger;

/**
 * Represents add member command.
 */

public class CommandAddMember extends Command {

    private UserInput savedInput;

    @Override
    public int validate(UserInput input) {
        this.savedInput = input;
        if (input.getCategory().equals("hr") && (input.getCommand().equalsIgnoreCase("add")
                || input.getCommand().equalsIgnoreCase("a"))) {
            if (input.getNumArgs() >= 4) {
                if ((input.getArg("n") == null) || (input.getArg("p") == null) || (input.getArg("e") == null)
                        && (input.getArg("r") == null)) {
                    return ARGUMENT_ERR;
                }
                if ((input.getArg("n").equals("")) || (input.getArg("p").equals("")) || (input.getArg("e").equals(""))
                        && (input.getArg("r").equals("")) || isInteger(input.getArg("p"))) {
                    return ARGUMENT_ERR;
                }
                return ACCEPT;
            }
            return ARGUMENT_ERR;
        } else {
            return NO_MATCH;
        }
    }

    @Override
    public String execute() {
        int phone = Integer.parseInt(savedInput.getArg("p"));
        Member m = new Member(savedInput.getArg("n"), phone, savedInput.getArg("e"), savedInput.getArg("r"));
        String output = MemberList.addToList(m);
        return output;
    }

    @Override
    public String help() {

        return "You can use 'hr add' command this way:\n"
                + "hr add /n NAME /p PHONE_NUMBER (INTEGER) /e EMAIL /r ROLE\n";
    }
}
