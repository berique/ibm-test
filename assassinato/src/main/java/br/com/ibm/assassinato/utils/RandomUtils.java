package br.com.ibm.assassinato.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int random(int max) {
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
