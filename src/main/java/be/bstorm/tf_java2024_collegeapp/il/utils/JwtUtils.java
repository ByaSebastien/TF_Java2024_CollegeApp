package be.bstorm.tf_java2024_collegeapp.il.utils;

import be.bstorm.tf_java2024_collegeapp.domain.entities.User;
import be.bstorm.tf_java2024_collegeapp.il.configs.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final JwtConfig jwtConfig;
    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;

    public JwtUtils(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.jwtBuilder = Jwts.builder().signWith(jwtConfig.secretKey);
        this.jwtParser = Jwts.parserBuilder().setSigningKey(jwtConfig.secretKey).build();
    }

    public String generateToken(User user) {
        return jwtBuilder
                .setSubject(user.getEmail())
                .claim("id",user.getId())
                .claim("login",user.getLogin())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtConfig.expireAt * 1000L ))
                .compact();
    }

    public Claims getClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Long getId(String token) {
        return getClaims(token).get("id",Long.class);
    }

    public String getLogin(String token) {
        return getClaims(token).get("login",String.class);
    }

    public boolean validateToken(String token) {

        Claims claims = getClaims(token);
        Date now = new Date();
        return now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
