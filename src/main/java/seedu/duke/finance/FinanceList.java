package seedu.duke.finance;

import java.util.ArrayList;
import java.util.logging.Logger;

public class FinanceList {
    public static ArrayList<FinanceLog>  financeLogs = new ArrayList<FinanceLog>();
    public static Logger logger = Logger.getGlobal();

    /**
     * Add one log into the finance list.
     * @param fl the new finance log user wants to add
     * @return the output when it successfully add one log
     */
    public static String addLog(FinanceLog fl) {
        financeLogs.add(fl);
        String output = "Got it! I've added this to the list.\n";
        String output1 = fl.toString();
        String output2;
        if (fl.getSize() > 1) {
            output2 = "There are " + fl.getSize() + " logs in the list now.\n";
        } else {
            output2 = "There is " + fl.getSize() + " log in the list now.\n";
        }
        output = output + output1 + output2;
        return output;
    }

    /**
     * Delete one particular log from the list.
     * @param index the index of the log which user wants to delete
     * @return the output when successfully delete a log
     */
    public static String dellog(int index) {
        try {
            logger.info("Start deleting...\n");
            assert index > 0 : "The index must > 0";
            financeLogs.remove(index - 1);
            FinanceLog.finSize--;
            String output2;
            if (FinanceLog.finSize > 1) {
                output2 = "There are " + FinanceLog.finSize + " logs in the list now.\n";
            } else {
                output2 = "There is " + FinanceLog.finSize + " log in the list now.\n";
            }
            String output1 = "Got it! I've removed this from list.\n";
            String output = output1 + output2;
            logger.info("End deleting...\n");
            return output;
        } catch (IndexOutOfBoundsException e) {
            logger.warning("The index is out of bound.\n");
            return "Your index input does not exist in the list";
        }
    }

    /**
     * Show the all the logs in the list and shows the total budget amount.
     * @return the finance list
     */
    public static String summary() {
        logger.info("Start listing summary...\n");
        if (FinanceLog.getSize() == 0) {
            logger.warning("The list is empty.\n");
            return "Sorry, your finance list is empty.\n";
        }
        String output = "Here is the list:\n";
        for (int i = 0;i < FinanceLog.getSize();i++) {
            output = output.concat("\t" + (i + 1) + "." + financeLogs.get(i).getLog() + " $"
                    + financeLogs.get(i).getLogVal() + "\n");
        }
        output = output.concat("Total budget: $" + String.format("%.2f",FinanceLog.getSum()) + "\n");
        logger.info("End processing...");
        return output;
    }
}
