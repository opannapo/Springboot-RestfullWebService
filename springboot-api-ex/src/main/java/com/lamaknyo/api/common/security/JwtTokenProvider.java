package com.lamaknyo.api.common.security;

import com.lamaknyo.api.common.exceptions.AuthException;
import com.lamaknyo.api.domain.UsersEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(UsersEntity user) {
        Date dateNow = new Date();
        Long dateTmp = (dateNow.getTime()) + (7 * 24 * 3600 * 1000);
        Date date1Week = new Date(dateTmp);
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setId(String.valueOf(user.getId()))
                .setIssuedAt(dateNow)
                .setExpiration(date1Week)
                .signWith(key).compact();
    }

    private Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        long id = Long.parseLong(claims.getSubject());
        System.out.println("JwtTokenProvider.getUserIdFromJWT : " + id + " ");
        return id;
    }

    public ClaimResult validateToken(String authToken) {
        System.out.println("JwtTokenProvider.validateToken : " + authToken);
        String e = null;
        ClaimResult claimResult = new ClaimResult();
        claimResult.setRight(false);
        claimResult.setError(e);
        claimResult.setClaimBody(null);

        if (authToken == null) {
            throw new AuthException("Null Token");
        }

        try {
            Claims claimBody = Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(authToken).getBody();
            claimResult.setRight(true);
            claimResult.setClaimBody(claimBody);
            return claimResult;
        } catch (SignatureException | MalformedJwtException ex) {
            e = "Invalid token signature";
        } catch (ExpiredJwtException ex) {
            e = "Expired token";
        } catch (UnsupportedJwtException ex) {
            e = "Unsupported token";
        } catch (IllegalArgumentException | NullPointerException ex) {
            e = "Token claims string is empty.";
        } catch (MissingClaimException | IncorrectClaimException mce) {
            e = mce.getMessage();
        }

        System.out.println(e);
        throw new AuthException(e);
    }
}
