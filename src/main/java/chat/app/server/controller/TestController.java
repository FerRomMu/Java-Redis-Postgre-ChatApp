package chat.app.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  /**
   * Endpoints solo con fines de testeo de autentificación.
   */

  @GetMapping("/")
  public String pong() { return "Pong (estes o no logueado)"; }

  @GetMapping("/auth")
  public TestResponse test(Authentication authentication) { return new TestResponse(authentication.getName()); }

}
