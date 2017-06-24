package net.chandol.study.security;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @ElementCollection
    private List<String> authorities;

    protected User() {
    }

    public User(String username, String password, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

}
