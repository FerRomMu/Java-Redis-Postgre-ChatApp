package chat.app.server.service;

import chat.app.server.model.User;
import chat.app.server.repository.UserRepository;
import chat.app.server.controller.Auth.AuthenticationRequest;
import chat.app.server.controller.Auth.AuthenticationResponse;
import chat.app.server.security.JwtService;
import chat.app.server.controller.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .mobile(request.getMobile())
            .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );
    var user = repository.findByUsername(request.getUsername())
            .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
  }
}