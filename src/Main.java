import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        if (args.length<3){
            System.err.println("Not enough arguments passed");
            System.exit(-1);
        }
        for (String i:args){
            if (!(i.equals("PAPER") || i.equals("ROCK") || i.equals("SCISSORS") || i.equals("LIZARD") || i.equals("SPOCK"))){
                System.err.println("Invalid commands. Example: PAPER, ROCK, SCISSORS, LIZARD, SPOCK");
                System.exit(-1);
            }
        }

        for (int i=0;i<args.length;i++){
            menu();
        }
    }



    public static void menu(){
        System.out.println("Available moves:");
        System.out.println("1 - rock");
        System.out.println("2 - paper");
        System.out.println("3 - scissors");
        System.out.println("4 - lizard");
        System.out.println("5 - Spock");
        System.out.println("0 - exit");
        System.out.println("Enter your move:");
    }
    public static void result(int num, int len){
        System.out.print("+");
        printDashes(68);
        System.out.println("+");

        System.out.printf("|  ПОБЕДА  |  ПОРАЖЕНИЕ  |  НИЧЬЯ  |  ВСЕГО ИГР  |  ПРОЦЕНТ ПОБЕД  |\n");

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

        System.out.printf("|  num  |  len-num  |  len  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

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
