package com.utn.ElBuenSabor.auth;

import com.utn.ElBuenSabor.entities.Usuario;
import com.utn.ElBuenSabor.enums.Rol;
import com.utn.ElBuenSabor.repositories.UsuarioRepository;
import com.utn.ElBuenSabor.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())); //springsecurity
        UserDetails user=usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        System.out.println(user.getUsername());
        String token=jwtService.getToken(user);
        System.out.println(token);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
                .auth0Id(request.getAuth0Id())
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .rol(Rol.CLIENTE)
                .build();
        System.out.println(user.getUsername());
        usuarioRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
