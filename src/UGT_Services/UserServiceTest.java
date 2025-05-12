package UGT_Services;

import UGT_Controllers.LoginController;
import UGT_Data.User;
import org.junit.jupiter.api.*;

import static UGT_Controllers.populateProgram.userMap;
import static UGT_Services.UserService.Validator.verifySingleInfo;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    public UserServiceTest(){
        System.out.println("Testing VerifySingleInfo");
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("In setUpBeforeClass");
    }
    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("In tearDownAfterClass");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("In setUp");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("In tearDown");
    }


    //not calling a new instance, just a validation function to be used when user make an account

    //Testing email part of code
    @Test
    void Testing_ValidEmail1() {
        System.out.println("Testing Valid Email");
        //Input: fake@gmail.com
       //Expected Output: True
        assertTrue(verifySingleInfo("fake@gmail.com", "email"));
    }
    @Test
    void Testing_ValidEmail2() {
        System.out.println("Testing Valid Email");
        //Input: thisisaemailthatiuse@gmail.com
        //Expected Output: True
        assertTrue(verifySingleInfo("thisisaemailthatiuse@gmail.com", "email"));
    }
    @Test
    void Testing_InValidEmail1() {
        System.out.println("Testing Valid Email");
        //Input: $email@gmail.com
        //Expected Output: True
        assertFalse(verifySingleInfo("$email@gmail.com", "email"));
    }


    @Test
    void Testing_InValidEmail2() {
        System.out.println("Testing Valid Email");
        //Input: $email@mail.com
        //Expected Output: True
        assertFalse(verifySingleInfo("$email@mail.com", "email"));
        //System.out.println(verifySingleInfo("$email@mail.com", "email"));
    }





    @Test
    void Testing_ValidUsername1() {
        System.out.println("Testing Valid Username");
        //Input: username123
        //Expected Output: True
        assertTrue(verifySingleInfo("username123", "username"));
    }




    @Test
    void Testing_ValidUsername2() {
        System.out.println("Testing Valid Username");
        //Input: ilikecats10
        //Expected Output: True
        assertTrue(verifySingleInfo("ilikecats10", "username"));
    }




    @Test
    void Testing_ValidUsername3() {
        System.out.println("Testing Valid Username");
        //Input: 10catsAreMyLife10
        //Expected Output: True
        assertTrue(verifySingleInfo("10catsAreMyLife10", "username"));
    }




    @Test
    void Testing_InValidUsername1() {
        System.out.println("Testing Valid Username");
        //Input: myusername 123
        //Expected Output: True
        assertFalse(verifySingleInfo("myusername 123", "username"));
    }





    //Testing password part of code
    @Test
    void Testing_ValidPassword1() {
        System.out.println("Testing Valid Password");
        //Input: password
        //Expected Output: True
        assertTrue(verifySingleInfo("password", "password"));

    }


    @Test
    void Testing_ValidPassword2() {
        System.out.println("Testing Valid Password");
        //Input: apass@8*()^d
        //Expected Output: True
        assertTrue(verifySingleInfo("apass@8*()^d", "password"));

    }


    @Test
    void Testing_ValidPassword3() {
        System.out.println("Testing Valid Password");
        //Input: *$pass@(D9
        //Expected Output: True
        assertTrue(verifySingleInfo("*$pass@(D9", "password"));

    }



    @Test
    void Testing_InValidPassword1() {
        System.out.println("Testing Valid Password");
        //Input: abc
        //Expected Output: True
        assertFalse(verifySingleInfo("abc", "password"));

    }


    @Test
    void Testing_InValidPassword2() {
        System.out.println("Testing Valid Password");
        //Input: shh1
        //Expected Output: True
        assertFalse(verifySingleInfo("shh1", "password"));
    }




}