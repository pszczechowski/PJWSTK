package service;

import fields.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr
 */
public class UserController {

    private static List<User> users = new ArrayList<>();


    public static List<User> initUserList(){
        users.add(new User("Marian","133123",createFirstPerson()));
        users.add(new User("stefan","98533",createSecondPerson()));
        users.add(new User("Maniek","asxcxcwe",createThirdPerson()));
        users.add(new User("Jerry","1123675",createFourthPerson()));
        users.add(new User("Bubi","qwerty",createFifthPerson()));

        return users;
    }

    public static Person createFirstPerson(){
        List<String> phoneNumbers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();


        Address address1 = new Address("Powstancow Warszawy", 23,1,"Gdańsk","80-180",
                "Polska");
        Address address2 = new Address("Dluga", 1,23,"Sopot","00-180",
                "Polska");

        Permission permission1 = new Permission("Dodawanie użytkowników");
        Permission permission2 = new Permission("Modyfikacja użytkowników");

        addresses.add(address1);
        addresses.add(address2);
        phoneNumbers.add("78945613");
        phoneNumbers.add("123456789");
        permissions.add(permission1);
        permissions.add(permission2);

        Role role = new Role("Admin",permissions);

        Person person = new Person("Janusz","Januszewski", phoneNumbers,addresses, role, 98);

        return person;
    }

    private static Person createSecondPerson(){
        List<String> phoneNumbers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();


        Address address1 = new Address("Randomowa", 1,0,"Radom","14-111",
                "Polska");

        Permission permission1 = new Permission("Kopiowanie");
        Permission permission2 = new Permission("Modyfikacja");

        addresses.add(address1);
        phoneNumbers.add("60479321");
        permissions.add(permission1);
        permissions.add(permission2);

        Role role = new Role("Dodawacz",permissions);

        Person person = new Person("Marian","Sandomierski", phoneNumbers,addresses, role, 99);

        return person;
    }

    private static Person createThirdPerson(){
        List<String> phoneNumbers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();


        Address address1 = new Address("Kowalska", 12,3,"Zamosc","23-151",
                "Polska");
        Address address2 = new Address("Kontenerowa", 14,2,"Gdańsk","10-571",
                "Polska");
        Address address3 = new Address("Generała", 3,15,"Sopot","66-521",
                "Polska");

        Permission permission1 = new Permission("Dodawanie");
        Permission permission2 = new Permission("Odejmowanie");
        Permission permission3 = new Permission("Mnożenie");
        Permission permission4 = new Permission("Dzielenie");

        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        phoneNumbers.add("898147963");
        phoneNumbers.add("664799621");
        phoneNumbers.add("554789631");
        permissions.add(permission1);
        permissions.add(permission2);
        permissions.add(permission3);
        permissions.add(permission4);

        Role role = new Role("Matematyk",permissions);

        Person person = new Person("Mateusz","Mierzej", phoneNumbers,addresses, role, 12);

        return person;
    }

    private static Person createFourthPerson(){
        List<String> phoneNumbers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();


        Address address1 = new Address("Dluga", 5,6,"Bydgoszcz","37-661",
                "Polska");
        Address address2 = new Address("Krakowska", 1,1,"Torun","00-001",
                "Polska");


        Permission permission1 = new Permission("Bieganie");
        Permission permission2 = new Permission("Strzelanie");
        Permission permission3 = new Permission("Kucanie");


        addresses.add(address1);
        addresses.add(address2);
        phoneNumbers.add("698874221");
        phoneNumbers.add("553114786");
        phoneNumbers.add("776852147");
        permissions.add(permission1);
        permissions.add(permission2);
        permissions.add(permission3);

        Role role = new Role("Gracz",permissions);

        Person person = new Person("Adam","Kucajek", phoneNumbers,addresses, role, 17);

        return person;
    }

    private static Person createFifthPerson(){
        List<String> phoneNumbers = new ArrayList<>();
        List<Address> addresses = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();


        Address address1 = new Address("Warszawa", 10,6,"Mineralna","37-871",
                "Polska");


        Permission permission1 = new Permission("Kompilowanie");
        Permission permission2 = new Permission("Monitorowanie");
        Permission permission3 = new Permission("Debugowanie");


        addresses.add(address1);
        phoneNumbers.add("549874221");
        phoneNumbers.add("553114786");
        phoneNumbers.add("872352147");
        permissions.add(permission1);
        permissions.add(permission2);
        permissions.add(permission3);

        Role role = new Role("Informatyk",permissions);

        Person person = new Person("Miroslaw","Klose", phoneNumbers,addresses, role, 21);

        return person;
    }
}
