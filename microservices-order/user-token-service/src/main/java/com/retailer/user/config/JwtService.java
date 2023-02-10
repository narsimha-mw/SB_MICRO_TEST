package com.retailer.user.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Component
public class JwtService {
//    @Value("${jwt.secret}")
    private String SECRET_Key;
    public String extractUserEmail(String jwtToken) {
        System.err.println("token:"+ jwtToken);
        return extractClaim(jwtToken,Claims::getSubject);
    }
    public String getToken(UserDetails userDetails){
        System.err.println("getToken"+ userDetails.getUsername());
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        String token = Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1))
                .signWith(SignatureAlgorithm.HS256, getSIngInKey()).compact();
        System.err.println(userDetails.getUsername()+ "token"+ token);
        return token;
    }
    public boolean isValidateToken(String token, UserDetails userDetails) {
        System.err.println("User:"+ userDetails.getUsername());
        final String userEmail = extractUserEmail(token);
        System.err.println("userEmail token:"+userEmail);
        return (userEmail.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
        return extractClaim(token,
                Claims::getExpiration);
    }
    private <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);

    }
    private Claims extractAllClaims(String token){
        return (Claims) Jwts.parser()
                .setSigningKey(getSIngInKey()).parseClaimsJws(token).getBody();
    }
    private byte[] getSIngInKey() {
        System.err.println("getStrign"+ SECRET_Key);
        if(SECRET_Key == null ) {
            SECRET_Key = "user-jwt-token";
        }
        byte[] key = Base64.getUrlDecoder().decode(SECRET_Key);
        return key;
    }
}
