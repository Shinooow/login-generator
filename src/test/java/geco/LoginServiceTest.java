package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() {
        String loginsExistants[] = { "Log", "Name", "TestName", "Jean", "Dupont", "Naame"};
        loginService = new LoginService(loginsExistants);
    }

    @Test
    public void loginExistsTest() {
        assertTrue("loginExists must return true", loginService.loginExists("Name"));
    }

    @Test
    public void loginDoesNotExistTest() {
        assertFalse("loginExists must return false", loginService.loginExists("aa"));
    }

    @Test
    public void addLoginTest() {
        assertFalse("loginExists(new login) before add must return false", loginService.loginExists("newLogin"));
        loginService.addLogin("newLogin");
        assertTrue("loginExists(new login) after add must return true", loginService.loginExists("newLogin"));
    }

    @Test
    public void findAllLoginsTest() {
        List<String> resultatAttendu = new ArrayList<>(Arrays.asList("Name", "Naame"));
        Collections.sort(resultatAttendu);
        List<String> resultatObtenu = loginService.findAllLoginsStartingWith("Na");
        Collections.sort(resultatObtenu);
        assertTrue("Equals method must return true", resultatAttendu.equals(resultatObtenu));
    }

    @Test
    public void findAllLoginsStartingWithTest() {
        List<String> resultatAttendu = new ArrayList<>(Arrays.asList("Log", "Name", "TestName", "Jean", "Dupont", "Naame"));
        Collections.sort(resultatAttendu);
        List<String> resultatObtenu = loginService.findAllLogins();
        Collections.sort(resultatObtenu);
        assertTrue("Equals method must return true", resultatAttendu.equals(resultatObtenu));
    }
}