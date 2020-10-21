package seedu.duke.hr;

import java.util.ArrayList;

public class MemberList {
    public static ArrayList<Member> members = new ArrayList<>();

    /**
     * Adds member to the arraylist.
     * @param m member to be added.
     */
    public static String addToList(Member m) {
        members.add(m);
        String output = "Got it. I've added this member:\n" + m.toString() + "\n"
                + "Now you have " + Member.numOfMembers + " member" + ((Member.numOfMembers == 1) ? "" : "s")
                + " in the list.\n";
        return output;
    }

    /**
     * Returns the list of members.
     * @return output error message or member list
     */
    public static String listMembers() {
        String output;
        if (Member.numOfMembers == 0) {
            output = "OOPS!!! The member list is empty!\n";
        } else {
            output = "Here is the list of members in your CCA:\n";
            for (int i = 0; i < Member.numOfMembers; i++) {
                int index = i + 1;
                output = output.concat(index + ".");
                output = output.concat(members.get(i).toString() + "\n");
            }
        }
        return output;
    }

    /**
     * Deletes the member from the arraylist.
     * @param index index of member to be deleted.
     * @return output error message or info of deleted member.
     */
    public static String deleteFromList(int index) {
        String output;
        try {
            output = "Noted. I'll remove this member:\n";
            output = output.concat(members.get(index).toString() + "\n");
            members.remove(index);
            Member.numOfMembers--;
            output = output.concat("Now you have " + Member.numOfMembers + " member");
            output = output.concat(((Member.numOfMembers > 1) ? "s" : "") + " in the list.\n");
        } catch (IndexOutOfBoundsException e) {
            output = "OOPS!!! The member does not exist.\n";
        }
        return output;
    }

    /**
     * Checks whether input can be parsed into an integer.
     * @param s input to be checked
     * @return true if input can be parsed as an integer, false if input cannot be parsed as an integer.
     */
    public static boolean isNumber(String s) {
        try {
            long index = Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Changes the role of the member in the arraylist.
     * @param m
     * @param newRole
     * @return output
     */
    public static String changeMemberRole(Member m, String newRole) {
        String output;
        try {
            m.setMemberRole(newRole);
            output = "Noted. I have changed the role of this member:\n";
            output = output.concat(m.toString());
        } catch (IndexOutOfBoundsException e) {
            output = "OOPS!!! The member does not exist. You can add this member to the list instead. \n";
        }
        return output;
    }
}
