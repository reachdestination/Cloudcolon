package com.cloudcolon.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreference {
    private String userId;
    private boolean darkMode;
    private String socialMediaPlatform;
}