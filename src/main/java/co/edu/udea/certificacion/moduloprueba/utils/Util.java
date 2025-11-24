package co.edu.udea.certificacion.moduloprueba.utils;

import java.time.Instant;
import java.util.Random;

public class Util {
    private Util(){}
    
    public static String generateRandomUsername() {
        return "user" + Instant.now().getEpochSecond() + new Random().nextInt(1000);
    }
}