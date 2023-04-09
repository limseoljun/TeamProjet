package com.example.team_project.domain.domain.user.domain;

import com.example.team_project.enums.UserGrade;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserGrade userGrade;

    public boolean isEncodePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
        return passwordEncoder.matches(password, this.password);
    }

    public boolean isValidPassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(password, this.password);
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    protected User() {
    }

    public User(String userId, String password, String userName, String phoneNumber) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public User(String password, String userName, String phoneNumber, Long userId) {
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public User(String userId, String password, String userName, String phoneNumber, UserGrade userGrade, PasswordEncoder passwordEncoder) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userGrade = userGrade;
        encodePassword(passwordEncoder);
    }

}