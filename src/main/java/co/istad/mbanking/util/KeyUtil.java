package co.istad.mbanking.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class KeyUtil {

    @Value("${access-token.private}")
    private String accessTokenPrivateKeyPath;
    @Value("${access-token.public}")
    private String accessTokenPublicKeyPath;
    @Value("${refresh-token.private}")
    private String refreshTokenPrivateKeyPath;
    @Value("${refresh-token.public}")
    private String refreshTokenPublicKeyPath;

    private KeyPair accessTokenKeyPair;
    private KeyPair refreshTokenKeyPair;

    private KeyPair getAccessTokenKeyPair() {
        return null;
    }

    private KeyPair getRefreshTokenKeyPair() {
        return null;
    }

    public RSAPublicKey getAccessTokenPublicKey() {
        return null;
    }

    public RSAPrivateKey getAccessTokenPrivateKey() {
        return null;
    }

}
