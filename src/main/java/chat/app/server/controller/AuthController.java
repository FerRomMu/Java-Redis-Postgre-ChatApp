package chat.app.server.controller;

import chat.app.server.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  private final TokenService tokenService;

  public AuthController(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  /**
   * Endpoint para devolver la token si obtuvo usuario y clave validos.
   * @param authentication
   * @return token de autenticación
   */
  @PostMapping("/login")
  public String token(Authentication authentication) {
    return tokenService.generateToken(authentication);
  }

}
