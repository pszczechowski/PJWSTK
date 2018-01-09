import fields.User;
import service.UserController;
import service.UserService;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        UserController uc = new UserController();
        UserService us = new UserService();

        List<User> users  = uc.initUserList();

        System.out.println(us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(users));

    }
}
