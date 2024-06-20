package com.happiest.minds.userservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

     @NotBlank(message = "Name should not be empty")
    private String username;

    // @Email(message = "Email should be valid")
    //@Pattern(regexp = "^[a-z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}",message = "Invalid email")
//    private String email;


     @NotBlank(message = "password should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]+@",message = "Invalid password")
    @Size(min = 6, max = 15, message = "Enter valid password")
    private String password;

//     @ValidateUser
    private String usertype;
}