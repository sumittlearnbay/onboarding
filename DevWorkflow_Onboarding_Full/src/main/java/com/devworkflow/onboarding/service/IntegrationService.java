package com.devworkflow.onboarding.service;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    @Value("${webhook.github.secret}")
    private String githubSecret;

    public boolean validateGithubSignature(String payload, String header){
        if(header == null) return false;
        try{
            String algo = header.startsWith("sha256=")? "HmacSHA256" : "HmacSHA1";
            String sig = header.split("=")[1];
            Mac mac = Mac.getInstance(algo);
            mac.init(new SecretKeySpec(githubSecret.getBytes(), algo));
            String calc = Hex.encodeHexString(mac.doFinal(payload.getBytes()));
            return sig.equalsIgnoreCase(calc);
        }catch(Exception e){ return false; }
    }
}
