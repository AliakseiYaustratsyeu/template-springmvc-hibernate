package com.stepbysteptopro.template.service.profile;

import org.springframework.beans.factory.annotation.Autowired;

import com.stepbysteptopro.template.model.user.User;
import com.stepbysteptopro.template.service.user.UserService;


public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserService userService;
    
    @Override
    public UserProfileService getUserProfile(Long userId) {
       // User user = userService.getUser(userId);
        
        return null;
    }

}
