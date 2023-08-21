import entidade.Profile;
import org.junit.Before;
import org.junit.Test;
import service.ProfileManagerService;

import static org.junit.Assert.*;

public class NetflixProfileManagerServiceTest {
    private ProfileManagerService profileManager;

    @Before
    public void setUp() {
        profileManager = new ProfileManagerService();
    }

    @Test
    public void testAddProfile() {
        Profile profile = new Profile("Alice", 25);
        assertTrue(profileManager.addProfile(profile));
        assertFalse(profileManager.addProfile(profile));
    }

    @Test
    public void testRemoveProfile() {
       Profile profile = new Profile("Bob", 30);
        assertFalse(profileManager.removeProfile(profile));
        profileManager.addProfile(profile);
        assertTrue(profileManager.removeProfile(profile));
        assertFalse(profileManager.removeProfile(profile));
    }

    @Test
    public void testGetProfileByName() {
        assertNull(profileManager.getProfileByName("Camila"));

        Profile profile = new Profile("Camila", 22);
        profileManager.addProfile(profile);

        Profile retrievedProfile = profileManager.getProfileByName("Camila");
        assertNotNull(retrievedProfile);
        assertEquals("Camila", retrievedProfile.getName());
    }

    @Test
    public void testUpdateProfileAge() {
        assertFalse(profileManager.updateProfileAge("Davi", 30));

        Profile profile = new Profile("Davi", 28);
        profileManager.addProfile(profile);

        assertTrue(profileManager.updateProfileAge("Davi", 30));

        Profile updatedProfile = profileManager.getProfileByName("Davi");
        assertNotNull(updatedProfile);
        assertEquals(30, updatedProfile.getAge());
    }
}

