package com.wtrue.rical.usercenter.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wtrue.rical.common.adam.domain.BaseException;
import com.wtrue.rical.common.eve.utils.RSAUtil;
import com.wtrue.rical.usercenter.domain.enums.BusinessErrorEnum;
import com.wtrue.rical.usercenter.domain.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

/**
 * @description: Token工具类
 * @author: meidanlong
 * @date: 2021/11/28 7:37 PM
 */
public class TokenUtil {

    private static final String ISSUER = "WTrue";

    @Value("${rsa.public.key}")
    public String publicKey;
    @Value("${rsa.private.key}")
    private String privateKey;

    public String generateToken(Long userId) {
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(publicKey), RSAUtil.getPrivateKey(privateKey));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 1);
        return JWT.create().withKeyId(String.valueOf(userId))
                .withIssuer(ISSUER)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }

    public String generateRefreshToken(Long userId){
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(publicKey), RSAUtil.getPrivateKey(privateKey));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        return JWT.create().withKeyId(String.valueOf(userId))
                .withIssuer(ISSUER)
                .withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }

    public Long verifyToken(String token){
        Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(publicKey), RSAUtil.getPrivateKey(privateKey));
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String userId = jwt.getKeyId();
        return Long.valueOf(userId);
    }

}
