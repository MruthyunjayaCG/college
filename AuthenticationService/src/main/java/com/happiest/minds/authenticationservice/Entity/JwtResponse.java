package com.happiest.minds.authenticationservice.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {

    private String username;

    private String jwtToken;

}
