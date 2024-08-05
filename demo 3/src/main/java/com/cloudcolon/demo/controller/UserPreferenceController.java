package com.cloudcolon.demo.controller;

import com.cloudcolon.demo.model.UserPreference;
import com.cloudcolon.demo.service.UserPreferenceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService service;

    @ApiOperation("Get all user preferences")
    @GetMapping
    public List<UserPreference> getAllPreferences() {
        return service.getAllPreferences();
    }

    @ApiOperation("Get preference by user ID")
    @GetMapping("/{userId}")
    public ResponseEntity<UserPreference> getPreferenceByUserId(@PathVariable String userId) {
        return ResponseEntity.of(service.getPreferenceByUserId(userId));
    }

    @ApiOperation("Save or update user preference")
    @PostMapping
    public UserPreference saveOrUpdatePreference(@RequestBody UserPreference preference) {
        return service.saveOrUpdatePreference(preference);
    }

    @ApiOperation("Delete preference by user ID")
    @DeleteMapping("/{userId}")
    public void deletePreference(@PathVariable String userId) {
        service.deletePreferenceByUserId(userId);
    }

    @ApiOperation("Update dark mode preference")
    @PatchMapping("/{userId}/darkmode")
    public ResponseEntity<UserPreference> updateDarkMode(@PathVariable String userId, @RequestParam boolean darkMode) {
        UserPreference updatedPreference = service.updateDarkMode(userId, darkMode);
        return updatedPreference != null ? ResponseEntity.ok(updatedPreference) : ResponseEntity.notFound().build();
    }

    @ApiOperation("Update social media platform preference")
    @PatchMapping("/{userId}/socialmedia")
    public ResponseEntity<UserPreference> updateSocialMediaPlatform(@PathVariable String userId, @RequestParam String socialMediaPlatform) {
        UserPreference updatedPreference = service.updateSocialMediaPlatform(userId, socialMediaPlatform);
        return updatedPreference != null ? ResponseEntity.ok(updatedPreference) : ResponseEntity.notFound().build();
    }
}