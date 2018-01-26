import fields.User;
import service.UserController;
import service.UserService;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        UserController uc = new UserController();
        UserService us = new UserService();

        List<User> users  = uc.initUserList();

        //System.out.println(us.findOldestPerson(users).toString());

        //System.out.println(us.findUsersWhoHaveMoreThanOneAddress(users));
        //System.out.println(us.findUserWithLongestUsername(users));
        //us.printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(users);
        //System.out.println(us.groupUsersByRole(users));
        //System.out.println(us.partitionUserByUnderAndOver18(users));
        System.out.println(us.getSortedPermissionsOfUsersWithNameStartingWithA(users));
        //System.out.println(us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(users));

    }
}
