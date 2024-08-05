package com.cloudcolon.demo.service;

import com.cloudcolon.demo.model.UserPreference;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserPreferenceService {

    private ConcurrentHashMap<String, UserPreference> preferences = new ConcurrentHashMap<>();

    public List<UserPreference> getAllPreferences() {
        return new ArrayList<>(preferences.values());
    }

    public Optional<UserPreference> getPreferenceByUserId(String userId) {
        return Optional.ofNullable(preferences.get(userId));
    }

    public UserPreference saveOrUpdatePreference(UserPreference preference) {
        preferences.put(preference.getUserId(), preference);
        return preference;
    }

    public void deletePreferenceByUserId(String userId) {
        preferences.remove(userId);
    }

    public UserPreference updateDarkMode(String userId, boolean darkMode) {
        UserPreference preference = preferences.get(userId);
        if (preference != null) {
            preference.setDarkMode(darkMode);
            preferences.put(userId, preference);
        }
        return preference;
    }

    public UserPreference updateSocialMediaPlatform(String userId, String socialMediaPlatform) {
        UserPreference preference = preferences.get(userId);
        if (preference != null) {
            preference.setSocialMediaPlatform(socialMediaPlatform);
            preferences.put(userId, preference);
        }
        return preference;
    }
}