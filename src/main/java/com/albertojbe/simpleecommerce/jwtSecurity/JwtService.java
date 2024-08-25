package com.albertojbe.simpleecommerce.jwtSecurity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key:secret}")
    private String secretKey;

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    public String generateToken(String email) {
        JWT.create()
                .withSu
    }
}
