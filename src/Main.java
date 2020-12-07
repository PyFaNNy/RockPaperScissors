public class Main {
    public static void main(String[] args) {
        if (args.length<3){
            System.err.println("Not enough arguments passed");
            System.exit(-1);
        }
        for (String i:args){
            if (!(i.equals("Paper") || i.equals("Rock") || i.equals("Scissors") || i.equals("Lizard") || i.equals("Spock"))){
                System.err.println("Invalid commands. Example:Paper, Rock, Scissors, Lizard, Spock");
            }
        }
    }
}
