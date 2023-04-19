package com.example.team_project.domain.domain.user.service.user;

import com.example.team_project.domain.domain.user.domain.User;
import com.example.team_project.enums.UserGrade;

public interface UserService {
    public User createUser(String userID, String password, String userName, String email, String phoneNumber);

    public User login(String userId, String password);

//    public User updateUser(String password, String userName, String phoneNumber, Long userId);

    public void deleteUser(String userId, String password);

}
