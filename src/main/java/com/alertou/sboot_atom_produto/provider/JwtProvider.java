package com.alertou.sboot_atom_produto.provider;

import com.alertou.sboot_atom_produto.config.TokenProperties;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final TokenProperties tokenProperties;

    public DecodedJWT validateToken(String token){

        token = token.replace("Bearer ","");
        try{
            Algorithm algorithm = Algorithm.HMAC256(tokenProperties.getSecret());
            var tokenDecode =  JWT.require(algorithm)
                    .build()
                    .verify(token);
            return tokenDecode;
        }catch(JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }


    public DecodedJWT validateToken(String token,String secret){

        token = token.replace("Bearer ","");
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            var tokenDecode =  JWT.require(algorithm)
                    .build()
                    .verify(token);
            return tokenDecode;
        }catch(JWTVerificationException e){
            e.printStackTrace();
            return null;
        }
    }
}
