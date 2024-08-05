package com.cloudcolon.demo.service;

import com.cloudcolon.demo.model.UserPreference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserPreferenceServiceTest {

    @InjectMocks
    private UserPreferenceService service;

    @Test
    public void testGetPreferenceByUserId() {
        UserPreference preference = new UserPreference("user1", true, "X");
        service.saveOrUpdatePreference(preference);

        Optional<UserPreference> found = service.getPreferenceByUserId("user1");

        assertTrue(found.isPresent());
        assertEquals("user1", found.get().getUserId());
    }

    @Test
    public void testSaveOrUpdatePreference() {
        UserPreference preference = new UserPreference("user1", true, "X");
        UserPreference saved = service.saveOrUpdatePreference(preference);

        assertEquals("user1", saved.getUserId());
    }

    @Test
    public void testDeletePreferenceByUserId() {
        UserPreference preference = new UserPreference("user1", true, "X");
        service.saveOrUpdatePreference(preference);

        service.deletePreferenceByUserId("user1");

        Optional<UserPreference> found = service.getPreferenceByUserId("user1");
        assertFalse(found.isPresent());
    }

    @Test
    public void testUpdateDarkMode() {
        UserPreference preference = new UserPreference("user1", false, "X");
        service.saveOrUpdatePreference(preference);

        UserPreference updatedPreference = service.updateDarkMode("user1", true);

        assertNotNull(updatedPreference);
        assertTrue(updatedPreference.isDarkMode());
    }

    @Test
    public void testUpdateSocialMediaPlatform() {
        UserPreference preference = new UserPreference("user1", true, "X");
        service.saveOrUpdatePreference(preference);

        UserPreference updatedPreference = service.updateSocialMediaPlatform("user1", "Facebook");

        assertNotNull(updatedPreference);
        assertEquals("Facebook", updatedPreference.getSocialMediaPlatform());
    }
}
