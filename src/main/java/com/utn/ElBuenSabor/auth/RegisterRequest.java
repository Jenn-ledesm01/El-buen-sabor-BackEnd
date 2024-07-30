package com.utn.ElBuenSabor.auth;

import com.utn.ElBuenSabor.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    Rol rol;
    String auth0Id;
}
