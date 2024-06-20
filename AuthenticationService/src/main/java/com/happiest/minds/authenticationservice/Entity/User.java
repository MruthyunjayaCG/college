package com.happiest.minds.authenticationservice.Entity;


import com.happiest.minds.authenticationservice.Validation.ValidateUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_table")
public class User implements UserDetails {

    @Id
    private String userId;

    @NotBlank(message = "Name should not be empty")
    private String username;

//    @Email(message = "Email should be valid")
//    @Pattern(regexp = "^[a-z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}",message = "Invalid email")
//    private String email;

    @NotBlank(message = "password should not be empty")
    //@Pattern(regexp = ("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"),message = "Invalid password")
    @Size(min = 6, max = 15, message = "Enter valid password")
    private String password;

    @ValidateUser
    private String userType;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
