import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double usersWins=0,compWins=0;
        int len=args.length,choice;
        Scanner in=new Scanner(System.in);
        if (len<3){
            System.err.println("Not enough arguments passed");
            System.exit(-1);
        }
        for (String i:args){
            if (!(i.equals("PAPER") || i.equals("ROCK") || i.equals("SCISSORS") || i.equals("LIZARD") || i.equals("SPOCK"))){
                System.err.println("Invalid commands. Example: PAPER, ROCK, SCISSORS, LIZARD, SPOCK");
                System.exit(-1);
            }
        }
        for (int i=0;i<len;i++){
            menu();
            choice=in.nextInt();
            while(choice<0 && choice>6) choice=in.nextInt();
            if(choice==0){
                len-=(len-i);
                break;
            }
            int resultRound=round(choice,i,args);
            if(resultRound==1){
                usersWins++;
                System.out.println("Your win");
            }
            if(resultRound==-1){
                compWins++;
                System.out.println("Your lose");
            }
        }
        result(usersWins,compWins,len);
    }

    public static int round(int choice, int i,String [] args){
        switch (choice){
            case 1:
                if(args[i].equals("SPOCK") ||args[i].equals("PAPER"))
                    return -1;
                if(args[i].equals("LIZARD") ||args[i].equals("SCISSORS"))
                    return 1;
                    break;
            case 2:
                if(args[i].equals("SCISSORS") ||args[i].equals("LIZARD"))
                    return -1;
                if(args[i].equals("SPOCK") ||args[i].equals("ROCK"))
                    return 1;
                break;
            case 3:
                if(args[i].equals("SPOCK") ||args[i].equals("ROCK"))
                    return -1;
                if(args[i].equals("PAPER") ||args[i].equals("LIZARD"))
                    return 1;
                break;
            case 4:
                if(args[i].equals("SCISSORS") ||args[i].equals("ROCK"))
                    return -1;
                if(args[i].equals("SPOCK") ||args[i].equals("PAPER"))
                    return 1;
                break;
            case 5:
                if(args[i].equals("SCISSORS") ||args[i].equals("ROCK"))
                    return -1;
                if(args[i].equals("LIZARD") ||args[i].equals("PAPER"))
                    return 1;
                break;
        }
        return 0;
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
    public static void result(double users,double comp, int len){
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

        System.out.println("|    "+ users +"   |    "+ comp +"      |  "+ (len-comp-users) +"    |     "+ len +"      |  "+ (users/len*100) +"%            |\n");

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
