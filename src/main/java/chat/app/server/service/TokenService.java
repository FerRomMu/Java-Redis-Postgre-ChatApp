package chat.app.server.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

  private final JwtEncoder encoder;

  public TokenService(JwtEncoder encoder) {
    this.encoder = encoder;
  }

  public String generateToken(Authentication authentication){

    /*
     * Crea las claims o payloads para la token
     */

    JwtClaimsSet claims = JwtClaimsSet.builder()
    .claim("scope","test")
    .build();
    
    /*
     * Codifica la token e inserta los payloads
     */

    return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
  }

}
