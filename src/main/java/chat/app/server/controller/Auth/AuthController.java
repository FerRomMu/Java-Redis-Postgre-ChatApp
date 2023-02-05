package chat.app.server.controller.Auth;

import chat.app.server.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/login")
public class AuthController {

  @Autowired
  private TokenService service;

  /**
   * Endpoint para devolver la token si obtuvo usuario y clave validos.
   * @param AuthenticationRequest la información de login.
   * @return AuthenticationResponse la token de autenticación del usuario
   */
  @PostMapping("/login/signin")
  public ResponseEntity<AuthenticationResponse> authenticate(
          @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  /**
   * Endpoint para devolver la token si obtuvo usuario y clave validos.
   * @param RegisterRequest la información de registro.
   * @return AuthenticationResponse la token de autenticación del usuario
   */
  @PostMapping("/login/signup")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }

}