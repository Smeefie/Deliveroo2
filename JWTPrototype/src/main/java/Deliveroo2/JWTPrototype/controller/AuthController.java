package Deliveroo2.JWTPrototype.controller;

import Deliveroo2.JWTPrototype.model.Token;
import Deliveroo2.JWTPrototype.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final TokenProducer tokenProducer;

    public AuthController(TokenService tokenService, TokenProducer tokenProducer) {
        this.tokenService = tokenService;
        this.tokenProducer = tokenProducer;
    }

    @GetMapping("/token")
    public String token(Authentication authentication){
        LOG.debug("Token requested for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted {}", token);

        Token tk = new Token();
        tk.setToken(token);
        tokenProducer.produce(tk);

        return token;
    }
}
