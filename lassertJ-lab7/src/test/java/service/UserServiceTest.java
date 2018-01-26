package service;

import fields.Person;
import fields.Role;
import fields.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang.StringUtils.substringsBetween;
import static org.assertj.core.api.Assertions.assertThat;


public class UserServiceTest {

    UserController uc;
    UserService us;
    List<User> users = new ArrayList<>();
    List<User> listWithNull = new ArrayList<>();
    List<User> nullList = new ArrayList<>();

    @Before
    public void classInit(){
        users = uc.initUserList();
        us = new UserService();
        uc = new UserController();
        listWithNull.add(null);
    }


    @Test (expected = IllegalArgumentException.class)
    public void findUsersWhoHaveMoreThanOneAddress_NulLAsCollectionArgumentPassed() throws Exception {
        us.findUsersWhoHaveMoreThanOneAddress(listWithNull);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findUsersWhoHaveMoreThanOneAddress_NullPassed() throws Exception {
        us.findUsersWhoHaveMoreThanOneAddress(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findUsersWhoHaveMoreThanOneAddress_EmptyCollectionPassed() throws Exception {
        //given
        List<User> userList = new ArrayList<>();
        //when
        us.findUsersWhoHaveMoreThanOneAddress(userList);

    }

    @Test
    public void findUsersWhoHaveMoreThanOneAddress_CorrectCollectionPassed() throws Exception {
        //given
        List<User> expectedList;

        //when
        expectedList = us.findUsersWhoHaveMoreThanOneAddress(users);
        int counter = 0;
        for(int i =0; i< users.size(); i++) {
            if(users.get(i).getPersonDetails().getAddresses().size() > 1 ){
                counter++;
            }
        }
        //then
        assertThat(counter).isEqualTo(expectedList.size());


    }

    @Test
    public void findUsersWhoHaveMoreThanOneAddress_EmptyCollectionReturned() throws Exception {
        //given
        User testedUser = new User("Jan","123",
                new Person("Marek","Markowski",new ArrayList<>(),new ArrayList<>(),
                        new Role("Admin",new ArrayList<>()),12));

        List<User> testedList = new ArrayList<>();
        testedList.add(testedUser);
        //when
        List<User> expectedList = us.findUsersWhoHaveMoreThanOneAddress(testedList);
        //then
        assertThat(expectedList).isEmpty();

    }

    @Test (expected = IllegalArgumentException.class)
    public void findOldestPerson_NullAsCollectionElementPassed() throws Exception {
        us.findOldestPerson(listWithNull);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findOldestPerson_NullPassed() throws Exception {
        us.findOldestPerson(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findOldestPerson_EmptyCollectionPassed() throws Exception {
        us.findOldestPerson(nullList);
    }

    @Test
    public void findOldestPerson_CorrectCollectionPassed() throws Exception {
        //given
        //when
        int highest = 0;
        for(int i = 0; i < users.size(); i++){
           if(highest < users.get(i).getPersonDetails().getAge()){
               highest = users.get(i).getPersonDetails().getAge();
           }
        }
        User oldestUser = us.findOldestPerson(users);

        //then
        assertThat(highest).isEqualTo(oldestUser.getPersonDetails().getAge());

    }

    @Test (expected = IllegalArgumentException.class)
    public void findUserWithLongestUsername_NullPassed() throws Exception {
        us.findUserWithLongestUsername(null);
    }

    @Test
    public void findUserWithLongestUsername_CorrectCollectionPassed() throws Exception {
        //given
        int usernameLenght =0 ;
        for(int i = 0; i < users.size(); i++){
            if( usernameLenght < users.get(i).getName().length()){
                usernameLenght = users.get(i).getName().length();
            }
        }
        //when
        User userWithLongestName = us.findUserWithLongestUsername(users);
        //then
        assertThat(usernameLenght).isEqualTo(userWithLongestName.getName().length());
    }

    @Test (expected = IllegalArgumentException.class)
    public void findUserWithLongestUsername_NullAsCollectionArgumentPassed() throws Exception {
        us.findUserWithLongestUsername(listWithNull);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findUserWithLongestUsername_NullCollectionPassed() throws Exception {
        us.findUserWithLongestUsername(nullList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18_NullPassed() throws Exception {
        us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18_NullAsCollectionArgumentPassed() throws Exception {
        us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(listWithNull);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18_NullCollectionPassed() throws Exception {
        us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(nullList);
    }

    @Test
    public void getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18_CorrectCollectionPassed() throws Exception {
        //given
        List<String> expectedValue = new ArrayList<>();
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getPersonDetails().getAge() < 18){
                expectedValue.add(users.get(i).getPersonDetails().getName()+" "+users.get(i).getPersonDetails().getSurname());
            }
        }
        //when
         String valueFromMethod = us.getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(users);
        //then
<<<<<<< HEAD
        assertThat(expectedValue.toString()).contains(valueFromMethod);


    }

    @Test (expected = IllegalArgumentException.class)
    public void getSortedPermissionsOfUsersWithNameStartingWithA_NullPassed() throws Exception {
        us.getSortedPermissionsOfUsersWithNameStartingWithA(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getSortedPermissionsOfUsersWithNameStartingWithA_NullAsCollectionArgumentPassed() throws Exception {
        us.getSortedPermissionsOfUsersWithNameStartingWithA(listWithNull);
    }

    @Test (expected = IllegalArgumentException.class)
    public void getSortedPermissionsOfUsersWithNameStartingWithA_NullCollectionPassed() throws Exception {
        us.getSortedPermissionsOfUsersWithNameStartingWithA(nullList);
=======
        //assertThat(NamesAndSurnames).contains(usersAbove18.get(0).getPersonDetails().getName());
        //TODO
>>>>>>> c8b5b4f47e395a66daf89529170d5746b9559bb1
    }

    @Test
    public void getSortedPermissionsOfUsersWithNameStartingWithA_CorrectCollectionPassed() throws Exception {
        //given
        List<String> permisions = new ArrayList<>();
        for(int i = 0; i < users.size();i++){
            if(users.get(i).getName().startsWith("A")){
                permisions.add(users.get(i).getPersonDetails().getRole().getPermissions().toString());
            }
        }
        String expected ="";
        String[] values = substringsBetween(permisions.toString(),"\'", "\'");
        Arrays.sort(values);
        for(int i =0; i< values.length;i++){
            expected = expected + values[i]+" ";
        }
        //when
        List<String> actualValue = new ArrayList<>();
        actualValue = us.getSortedPermissionsOfUsersWithNameStartingWithA(users);

        String actualStr = "";
        String[] actual = substringsBetween(actualValue.toString(),"\'", "\'");
        for(int i =0; i< values.length;i++){
            Arrays.sort(actual);
            actualStr = actualStr + actual[i]+ " ";
        }
        //then
        assertThat(expected).contains(actualStr);
    }

    @Test
    public void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS() throws Exception {
    }

    @Test
    public void groupUsersByRole() throws Exception {
    }

    @Test
    public void partitionUserByUnderAndOver18() throws Exception {
    }

}
