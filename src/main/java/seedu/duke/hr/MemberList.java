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

    public static String search(boolean any, boolean name, boolean phone, boolean email,
                                boolean role, String anyS, String nameS, String phoneS,
                                String emailS, String roleS) {
        if (!any && !name && !phone && !email && !role) {
            return "Please enter the content you want to search for.\n";
        }
        String output = "";
        int count = 0;
        for (int i = 0; i < Member.numOfMembers; i++) {
            if (any == true && searchAny(i, anyS)) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
            if (name && searchName(i, nameS)) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
            if (phone && searchPhone(i, phoneS)) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
            if (email && searchEmail(i, emailS)) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
            if (role && searchRole(i, roleS)) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
        }
        if (count == 0) {
            output = "Sorry, there is no suitable result in the member list.\n";
        } else {
            output = "I have found " + count + " results for you:\n" + output;
        }
        return output;
    }

    public static boolean searchAny(int index, String target) {
        if (searchName(index, target) || searchEmail(index, target)
            || searchPhone(index, target) || searchRole(index, target)) {
            return true;
        }
        return false;
    }

    public static boolean searchName(int index, String target) {
        if (members.get(index).getMemberName().contains(target)) {
            return true;
        }
        return false;
    }

    public static boolean searchEmail(int index, String target) {
        if (members.get(index).getMemberEmail().contains(target)) {
            return true;
        }
        return false;
    }

    public static boolean searchPhone(int index, String target) {
        String phone = Integer.toString(members.get(index).getMemberPhone());
        if (phone.indexOf(target) != -1) {
            return true;
        }
        return false;
    }

    public static boolean searchRole(int index, String target) {
        if (members.get(index).getMemberRole().contains(target)) {
            return true;
        }
        return false;
    }
}
