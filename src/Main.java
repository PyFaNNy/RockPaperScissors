import java.util.Scanner;


public class Main {
     enum Move {
        ROCK,
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK
    }
//    public int compareMoves() {
//        // Ничья
//        if (this == otherMove)
//            return 0;
//
//        switch (this) {
//            case ROCK:
//
//            case PAPER:
//                return (otherMove == ROCK ? 1 : -1);
//            case SCISSORS:
//                return (otherMove == PAPER ? 1 : -1);
//        }
//    }

    public static void main(String[] args) {
        for (String i:args){
            System.out.println(i);
        }
        if (args.length<3){
            System.err.println("Not enough arguments passed");
            System.exit(-1);
        }
        for (String i:args){
            if (!(i.equals("PAPER") || i.equals("ROCK") || i.equals("SCISSORS") || i.equals("LIZARD") || i.equals("SPOCK"))){
                System.err.println("Invalid commands. Example:PAPER, ROCK, SCISSORS, LIZARD, SPOCK");
                System.exit(-1);
            }
        }

        
    }
}
