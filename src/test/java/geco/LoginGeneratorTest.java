package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp() {
        loginService = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void CT1AjoutPaulDurant() {
        String prenom = "Paul";
        String nom = "Durand";
        String resultatAttendu = "PDUR";
        String resultatObtenu = loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
        assertEquals("Expected generated login must be PDUR", resultatAttendu, resultatObtenu);
        assertTrue("loginService must contain PDUR", loginService.loginExists("PDUR"));
    }

    @Test
    public void CT2AjoutJohnRalling() {
        String prenom = "John";
        String nom = "Ralling";
        String resultatAttendu = "JRAL2";
        String resultatObtenu = loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
        assertEquals("Expected generated login must be JRAL2", resultatAttendu, resultatObtenu);
        assertTrue("loginService must contain JRAL2", loginService.loginExists("JRAL2"));
    }

    @Test
    public void CT3AjoutJeanRolling() {
        String prenom = "Jean";
        String nom = "Rolling";
        String resultatAttendu = "JROL1";
        String resultatObtenu = loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
        assertEquals("Expected generated login must be JROL1", resultatAttendu, resultatObtenu);
        assertTrue("loginService must contain JROL1", loginService.loginExists("JROL1"));
    }

    @Test
    public void CT4AjoutPaulDurandAccent() {
        String prenom = "Paul";
        String nom = "Dùrand";
        String resultatAttendu = "PDUR";
        String resultatObtenu = loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
        assertEquals("Expected generated login must be PDUR", resultatAttendu, resultatObtenu);
        assertTrue("loginService must contain PDU", loginService.loginExists("PDUR"));
    }

    @Test
    public void CTAjoutPaulDu() {
        String prenom = "Paul";
        String nom = "Du";
        String resultatAttendu = "PDU";
        String resultatObtenu = loginGenerator.generateLoginForNomAndPrenom(nom, prenom);
        assertEquals("Expected generated login must be PDU", resultatAttendu, resultatObtenu);
        assertTrue("loginService must contain PDU", loginService.loginExists("PDU"));
    }
}