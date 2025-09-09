

import com.rethabile.auth.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService service;

    @BeforeEach
    public void setUp() {
        service = new UserService(); // fresh service before each test
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User("Rethabile", "Velelo", "0781234567", "rylan", "12345");
        String result = service.registerUser(user);
        assertEqual("User registered successfully!", result);
    }
s
    @Test
    public void testRegisterUser_Fail_UsernameExists() {
        User user1 = new User("Rethabile", "Velelo", "0781234567", "rylan", "12345");
        User user2 = new User("Dylan", "Smith", "0659876543", "rylan", "67890"); // same username

        service.registerUser(user1);
        String result = service.registerUser(user2);

        assertEquals("Username already exists!", result);
    }

    @Test
    public void testLoginUser_Success() {
        User user = new User("Rethabile", "Velelo", "0781234567", "rylan", "12345");
        service.registerUser(user);

        boolean loginResult = service.loginUser("rylan", "12345");
        assertTrue(loginResult);
    }

    @Test
    public void testLoginUser_Fail_WrongPassword() {
        User user = new User("Rethabile", "Velelo", "0781234567", "rylan", "12345");
        service.registerUser(user);

        boolean loginResult = service.loginUser("rylan", "wrongpass");
        assertFalse(loginResult);
    }

    @Test
    public void testLoginUser_Fail_UserNotFound() {
        boolean loginResult = service.loginUser("unknownUser", "12345");
        assertFalse(loginResult);
    }
}
