package hash;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashUtil {

    public static long hash(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] digest = md.digest(input.getBytes());

            BigInteger num = new BigInteger(1, digest);

            return Math.abs(num.longValue());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}