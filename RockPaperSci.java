import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;
class Play{
    String playerName;
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int userNum;

    Play(String playerName){
        this.playerName = playerName;
    }

    public void move(int num){
        System.out.print("AI's Input: ");
        if(num == 0){
            System.out.println("Paper");
            System.out.println();
        }
        else if(num == 1){
            System.out.println("Scissors");
            System.out.println();
        }
        else if (num == 2) {
            System.out.println("Rock");
            System.out.println();

        }
    }


    public int choice(){
        System.out.print("Input: ");
        String in = sc.next();
        int n;
        if (in.compareTo("Paper") == 0 || in.compareTo("paper")== 0){
            n = 0;
        } else if (in.compareTo("Scissor")== 0 || in.compareTo("scissor")== 0 ) {
            n = 1;
        } else if (in.compareTo("Rock")== 0 || in.compareTo("rock")== 0 ) {
            n = 2;
        }
        else {
            System.out.println("Invalid Input !");
            return 69;
        }

        System.out.println();
        return n;

    }

    public void menu(){
        System.out.println("Welcome to Rock Paper Scissors Game");
        System.out.println(playerName + " VS AI");
        System.out.println();

    }

    public void compare(){
        int winUser = 0;
        int winCom = 0;
        menu();
        while (winCom < 2 && winUser < 2) {




            userNum = choice();
            if(userNum == 69){

            }
            else {

                int num = random.nextInt(3);

                move(num);


                if (userNum == num) {
                    System.out.println("Round Draw");
                    System.out.println();

                } else if (userNum == 0 && num == 1) {
                    System.out.println("Round Winner AI");
                    winCom++;
                    System.out.println("AI's Score: " + winCom);
                    System.out.println();
                } else if (userNum == 0 && num == 2) {
                    System.out.println("Round Winner " + playerName);
                    winUser++;
                    System.out.println(playerName + "'s Score: "  + winUser);
                    System.out.println();
                } else if (userNum == 1 && num == 0) {
                    System.out.println("Round Winner " + playerName);
                    winUser++;
                    System.out.println(playerName + "'s Score: "  + winUser);
                    System.out.println();
                } else if (userNum == 1 && num == 2) {
                    System.out.println("Round Winner AI");
                    winCom++;
                    System.out.println("AI's Score: " + winCom);
                    System.out.println();
                } else if (userNum == 2 && num == 0) {
                    System.out.println("Round Winner AI");
                    winCom++;
                    System.out.println("AI's Score: " + winCom);
                    System.out.println();
                } else if (userNum == 2 && num == 1) {
                    System.out.println("Round Winner " + playerName);
                    winUser++;
                    System.out.println(playerName + "'s Score: "  + winUser);
                    System.out.println();
                }
            }
        }
        if (winCom > winUser){
            System.out.println("AI Wins");
        }
        else {
            System.out.println(playerName + " Congrats");
            System.out.println("You Win");
        }

    }







}

class RockPaperScissor {
    public static void RockPaperScissorx() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player's Name: ");
        Play player = new Play(sc.nextLine());

        player.compare();


    }


}
