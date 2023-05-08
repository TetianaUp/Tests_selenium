package utils;

import java.security.SecureRandom;

public class RandomUtils {

    public static int randomNum(int size) {
        return new SecureRandom().nextInt(size);
    }
}
