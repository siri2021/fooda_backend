package it.vkod.woo.auth.service.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 40)
    private String name;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 15)
    private String username;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Size(max = 100)
    private String password;

    @Getter
    @Setter
    @Singular
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String username, String email, String password) {
        setName(name);
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }
}