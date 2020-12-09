import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random =new Random();
        SecureRandom srandom= new SecureRandom();
        Scanner in = new Scanner(System.in);
        double usersWins = 0, compWins = 0;
        int len = args.length, uChoice;
        int cChoice;
        Mac sha256_HMAC = null;
        SecretKeySpec secret_key;
        byte key[] = new byte[128];
        srandom.nextBytes(key);
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
            secret_key = new SecretKeySpec(key, "HmacSHA256");
            sha256_HMAC.init(secret_key);
        }
        catch (Exception e){
            System.err.println("Error");
        }
        
        checkСondition(args);
        do {
            cChoice=random.nextInt(len)+1;
            try{
                srandom.nextBytes(key);
                secret_key = new SecretKeySpec(key, "HmacSHA256");
                sha256_HMAC.init(secret_key);
                System.out.println(cChoice);
                System.out.println("HMAC:"+Base64.encodeBase64String(sha256_HMAC.doFinal(Integer.toString(cChoice).getBytes())));
            }
            catch (Exception e){
                System.err.println("Error");
            }
            do {
                menu(args);
                uChoice = in.nextInt();
            } while (uChoice < 0 || uChoice > len);

            if(cChoice!=0) {
                System.out.println("You chose - "+args[uChoice-1]);
                System.out.println("Computer chose - "+args[cChoice-1]);
                int resultRound = round(uChoice-1, cChoice-1);
                if (resultRound == 1) {
                    usersWins++;
                    System.out.println("Your win");
                }
                if (resultRound == -1) {
                    compWins++;
                    System.out.println("Your lose");
                }
                if (resultRound == 0) {
                    System.out.println("TIE");
                }
            }
            System.out.println("HMAC key:"+key);
        } while (uChoice != 0);

        result(usersWins, compWins, len);
    }

    public static void checkСondition(String[] args) {
        if (args.length < 3) {
            System.err.println("Not enough arguments passed");
            System.exit(-1);
        }
        if (args.length % 2 == 0) {
            System.err.println("The number of moves must be odd");
            System.exit(-1);
        }
        HashSet<String> checkMoves = new HashSet<String>();
        for (int i = 0; i < args.length; i++) {
            if (!checkMoves.add(args[i].toUpperCase())) {
                System.err.println("Movements must be unique");
                System.exit(-1);
            }
        }
    }

    public static int round(int uChoice, int cChoice) {
        if (uChoice > cChoice) {
            return 1;
        }
        if (uChoice < cChoice) {
            return -1;
        }
        return 0;
    }

    public static void menu(String[] args) {
        System.out.println("Available moves:");
        System.out.println("0 - exit");
        for (int j = 1; j <= args.length; j++) {
            System.out.println(j + "-" + args[j - 1]);
        }
        System.out.println("Enter your move:");
    }

    public static void result(double users, double comp, int len) {
        System.out.print("+");
        printDashes(68);
        System.out.println("+");

        System.out.printf("|  Victory  |  Lose  |  Tie  |  Rounds  |  percent of wins  |\n");

        System.out.print("|");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(16);
        System.out.print("+");
        printDashes(18);
        System.out.println("|");

        System.out.println("|    " + users + "   |    " + comp + "  |  " + (len - comp - users) + "  |     " + len + "    |  " + (users / len * 100) + "%            |\n");

        System.out.print("+");
        printDashes(68);
        System.out.println("+");
    }

    private static void printDashes(int numberOfDashes) {
        for (int i = 0; i < numberOfDashes; i++) {
            System.out.print("-");
        }
    }
}
