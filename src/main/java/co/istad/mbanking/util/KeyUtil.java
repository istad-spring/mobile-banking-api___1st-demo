package co.istad.mbanking.util;

import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
public class KeyUtil {

    private String accessTokenPrivateKeyPath;
    private String accessTokenPublicKeyPath;
    private String refreshTokenPrivateKeyPath;
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
