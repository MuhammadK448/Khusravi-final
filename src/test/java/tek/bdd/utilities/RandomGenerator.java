package tek.bdd.utilities;

import java.util.Random;

public class RandomGenerator {

    public static String generateRandomEmail(){
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(10);
        for(int i = 0; i < 10; i++){
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return randomString.toString() + "@hotmail.com";
    }

    public static String generateRandomUserName(){
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(5);
        for(int i = 0; i < 5; i++){
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }
        return "Khusravi_" + randomString.toString();
    }
}
