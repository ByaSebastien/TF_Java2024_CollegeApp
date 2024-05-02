package be.bstorm.tf_java2024_collegeapp.il.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private byte[] secret = "Laliluleilooooooooooooooooooooooooooooooo".getBytes(StandardCharsets.UTF_8);
    public int expireAt = 86400; // 1 Day
    public SecretKey secretKey = new SecretKeySpec(secret, "HmacSHA256");
}
