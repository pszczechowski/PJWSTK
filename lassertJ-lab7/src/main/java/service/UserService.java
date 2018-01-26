package service;

import fields.Role;
import fields.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class UserService {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {
        if(users == null || users.contains(null)|| users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().filter(u -> u.getPersonDetails().getAddresses().size() > 1)
                .collect(Collectors.toList());
    }

    public static User findOldestPerson(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().reduce((u1, u2) ->
                u1.getPersonDetails().getAge() > u2.getPersonDetails().getAge() ? u1 : u2).get();
    }

    public static User findUserWithLongestUsername(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().max((u1, u2) ->
                Integer.compare(u1.getName().length(), u2.getName().length()))
                .get();
    }

    public static String getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().filter(u -> u.getPersonDetails().getAge() < 18)
                .map(u -> u.getPersonDetails().getName() + " " + u.getPersonDetails().getSurname())
                .collect(Collectors.joining(", "));
    }

    public static List<String> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().filter(u -> u.getName().startsWith("A"))
                .map(u -> u.getPersonDetails().getRole().getPermissions())
                .flatMap( u -> u.stream())
                .map(u -> u.toString()).sorted().collect(Collectors.toList());

    }

    public static void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        users.stream().filter(u -> u.getPersonDetails().getSurname().startsWith("S"))
                .map(u -> u.getPersonDetails().getRole().getName().toUpperCase())
                .forEach(System.out::println);
    }

    public static Map<Role, List<User>> groupUsersByRole(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().collect(Collectors.groupingBy(u -> u.getPersonDetails().getRole()));
    }

    public static Map<Boolean, List<User>> partitionUserByUnderAndOver18(List<User> users) {
        if(users == null || users.contains(null) || users.size() == 0) {
            throw new IllegalArgumentException();
        }
        return users.stream().collect(Collectors.partitioningBy(u -> u.getPersonDetails().getAge() > 18));
    }
}
