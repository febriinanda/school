package com.nanda.school.entity;

import com.nanda.school.model.UserRegistrationRequest;
import com.nanda.school.security.BCrypt;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "m_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String token;
    private long tokenExpiredAt;

    public User(UserRegistrationRequest request) {
        this.username = request.getUsername();
        this.name = request.getName();
        this.password = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
    }
}
