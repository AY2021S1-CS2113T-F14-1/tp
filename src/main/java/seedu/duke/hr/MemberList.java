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
     * find the member in the arraylist.
     * @param memberName name of the member to be found.
     * @return if member exists, returns the member, else returns null.
     */
    public static Member findMemberByName(String memberName) {
        for (int i = 0; i < Member.numOfMembers; i++) {
            if (members.get(i).getMemberName().equalsIgnoreCase(memberName)) {
                return members.get(i);
            }
        }
        return null;
    }

    /**
     * Changes the contact information and role of the member in the arraylist.
     * @param m member whose information is to be modified.
     * @param newPhone new phone number to replace the original phone number.
     * @param newEmail new email to replace the original email.
     * @param newRole new role to replace the original role.
     * @return output message for the user.
     */
    public static String changeMemberInfo(Member m, long newPhone, String newEmail, String newRole) {
        String output;
        Long phone = newPhone;
        if (phone != null) {
            m.setMemberPhone(phone);
        }

        if (newEmail != null) {
            m.setMemberEmail(newEmail);
        }

        if (newRole != null) {
            m.setMemberRole(newRole);
        }

        output = "I have changed the information of this member:\n";
        output = output.concat(m.toString());
        return output;
    }

    /**
     * Search for the members that include the any information the user want.
     * @param any whether there is any content the user want to search in any part of member information
     * @param name whether there is any content the user want to search in name part of member information
     * @param phone whether there is any content the user want to search in phone part of member information
     * @param email whether there is any content the user want to search in email part of member information
     * @param role whether there is any content the user want to search in role part of member information
     * @param anyS the string the user want to search for in any part of member information
     * @param nameS the string the user want to search for in name part of member information
     * @param phoneS the string the user want to search for in phone part of member information
     * @param emailS the string the user want to search for in email part of member information
     * @param roleS the string the user want to search for in role part of member information
     * @return all the members' information that match the content the user wants to search for
     */
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
            output = "I have found " + count + " result for you:\n" + output;
        }
        return output;
    }

    /**
     * Determine if any part of the member information with the particular index includes the target content.
     * @param index the index of member
     * @param target the information the user wants to search for
     * @return whether the member's information matches the target content
     */
    public static boolean searchAny(int index, String target) {
        if (searchName(index, target) || searchEmail(index, target)
            || searchPhone(index, target) || searchRole(index, target)) {
            return true;
        }
        return false;
    }

    /**
     * Determine if any part of the member's name with the particular index includes the target content.
     * @param index the index of member
     * @param target the information the user wants to search for
     * @return whether the member's name matches the target content
     */
    public static boolean searchName(int index, String target) {
        if (members.get(index).getMemberName().contains(target)) {
            return true;
        }
        return false;
    }

    /**
     * Determine if any part of the member's email with the particular index includes the target content.
     * @param index the index of member
     * @param target the information the user wants to search for
     * @return whether the member's email matches the target content
     */
    public static boolean searchEmail(int index, String target) {
        if (members.get(index).getMemberEmail().contains(target)) {
            return true;
        }
        return false;
    }

    /**
     * Determine if any part of the member's phone with the particular index includes the target content.
     * @param index the index of member
     * @param target the information the user wants to search for
     * @return whether the member's phone matches the target content
     */
    public static boolean searchPhone(int index, String target) {
        String phone = Long.toString(members.get(index).getMemberPhone());
        if (phone.indexOf(target) != -1) {
            return true;
        }
        return false;
    }

    /**
     * Determine if any part of the member's role with the particular index includes the target content.
     * @param index the index of member
     * @param target the information the user wants to search for
     * @return whether the member's role matches the target content
     */
    public static boolean searchRole(int index, String target) {
        if (members.get(index).getMemberRole().contains(target)) {
            return true;
        }
        return false;
    }

    public static String searchProfSpeaker() {
        String output = "";
        int count = 0;
        for (int i = 0; i < Member.numOfMembers; i++) {
            if (searchRole(i, "prof") || searchRole(i, "professor")) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
            if (searchRole(i, "admin")) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
                continue;
            }
        }
        if (count == 0) {
            output = "Sorry, there is no suitable result in the member list.\n";
        } else {
            output = "I have found " + count + " result for you:\n" + output;
        }
        return output;
    }

    public static String searchConnection() {
        String output = "";
        int count = 0;
        for (int i = 0; i < Member.numOfMembers; i++) {
            if (searchRole(i, "alumni") || searchRole(i, "speaker")) {
                output = output + (i + 1) + "." + members.get(i).toString() + "\n";
                count++;
            }
        }
        if (count == 0) {
            output = "Sorry, there is no suitable result in the member list.\n";
        } else {
            output = "I have found " + count + " result for you:\n" + output;
        }
        return output;
    }
}
