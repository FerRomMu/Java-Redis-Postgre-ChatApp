package chat.app.server.controller.Auth;

import lombok.Getter;

/**
 * Request para registro.
 * Contiene la información necesaria para registrar un usuario.
 */
@Getter
public class RegisterRequest {
    public String username;
    public String email;
    public String password;
    public int mobile;
}