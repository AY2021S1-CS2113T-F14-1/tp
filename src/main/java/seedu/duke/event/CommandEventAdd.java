package seedu.duke.event;

import seedu.duke.Command;
import seedu.duke.backend.UserInput;


public class CommandEventAdd extends Command {
    private UserInput userInput;
    private Event cachedEvent;

    @Override
    public String execute() {
        if (cachedEvent == null) {
            return "Unable to create event! Please check your inputs again!";
        }
        String output = EventList.addEvent(cachedEvent);
        return output;
    }

    @Override
    public int validate(UserInput ui) {
       // assert ui!= null;
        userInput = ui;
        if (userInput.getCategory().equals("event") && (userInput.getCommand().equalsIgnoreCase("addEvent")
                || userInput.getCommand().equalsIgnoreCase("add")
                || userInput.getCommand().equalsIgnoreCase("a"))) {
            if (ui.getNumArgs() >= 3) {
                if ((ui.getArg("n") == null) || (ui.getArg("d") == null) || (ui.getArg("t") == null)) {
                    return ARGUMENT_ERR;
                }
                if ((ui.getArg("n").equals("")) || (ui.getArg("d").equals("")) || (ui.getArg("t").equals(""))) {
                    return ARGUMENT_ERR;
                }
                cachedEvent = new Event(userInput.getArg("n"), userInput.getArg("d"), userInput.getArg("t"));
                if (cachedEvent.date != null) {
                    return ACCEPT;
                }
            }
            return ARGUMENT_ERR;
        } else {
            return NO_MATCH;
        }
    }


    @Override
    public String help() {
        return "Syntax: event addEvent /n <Name> /d <Date YYYY-MM-DD> /t <Time>";
    }
}
