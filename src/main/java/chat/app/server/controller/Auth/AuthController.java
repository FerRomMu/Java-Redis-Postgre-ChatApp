package chat.app.server.controller.Auth;

import chat.app.server.Exceptions.EmailInUseException;
import chat.app.server.Exceptions.MobileInUseException;
import chat.app.server.Exceptions.UserInUseException;
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
@RequestMapping("/login")
public class AuthController {

  @Autowired
  private TokenService service;

  /**
   * Endpoint para devolver la token si obtuvo usuario y clave validos.
   * @param AuthenticationRequest la información de login.
   * @return AuthenticationResponse la token de autenticación del usuario
   */
  @PostMapping("/signin")
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
  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ) {

    if (request.getEmail() == null || request.getPassword() == null
            || request.getUsername() == null || request.getMobile() < 1000000000) {
      return ResponseEntity.badRequest().body(new AuthenticationResponse("Username, email, password and mobile are needed."));
    }

    try {
      return ResponseEntity.ok(service.register(request));
    } catch (UserInUseException e) {
      return ResponseEntity.badRequest().body(new AuthenticationResponse("Username already in use"));
    } catch (EmailInUseException e) {
      return ResponseEntity.badRequest().body(new AuthenticationResponse("Email already in use"));
    } catch (MobileInUseException e) {
      return ResponseEntity.badRequest().body(new AuthenticationResponse("Mobile already in use"));
    }
  }
}