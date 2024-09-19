import java.util.Scanner;

class TicTacToeCodic {

    public static void box(int size,String[][] tic){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                System.out.print(  tic[i][j] );
                if (j < size - 1) {
                    System.out.print("|");

                }
            }
            System.out.println();
            if (i < size - 1) {

                System.out.println("_____");
            }
        }


    }



    public static int input(String[][] tic,int size, int num,String player1,String player2){

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print(player1 + "'s turn : ");
        String cordinate1 = sc.nextLine();
        System.out.println();

        String[] temp = cordinate1.split(",");

        String cor1x = temp[0];
        String cor1y = temp[1];

        int cordX1 = Integer.parseInt(cor1x);
        int cordY1 = Integer.parseInt(cor1y);

        if (tic[cordX1][cordY1].compareTo(" ")== 0 ) {


            tic[cordX1][cordY1] = "O";
        }
        else{
            System.out.println("place already taken");
        }

        box(size, tic);


        if(check(tic, size)== 0 && num < 8){

            System.out.println();
            System.out.print(player2 + "'s Turn : ");

            String cordinate2 = sc.nextLine();
            System.out.println();

            if (cordinate2.compareTo(cordinate1) != 0) {


                String[] temp2 = cordinate2.split(",");


                String cor2x = temp2[0];
                String cor2y = temp2[1];

                int cordX2 = Integer.parseInt(cor2x);
                int cordY2 = Integer.parseInt(cor2y);

                if(tic[cordX2][cordY2].compareTo(" ")== 0){

                    tic[cordX2][cordY2] = "X";
                }
                else{
                    System.out.println("Place already Taken");
                }


                box(size, tic);
            }
            else{
                System.out.println("This place is already taken");
            }

        }

        return 2;
    }



    public static int check(String[][] tic, int size){

        for (int i = 0; i < size; i++) {




            if (tic[i][0].compareTo(tic[i][1])== 0  && tic[i][1].compareTo(tic[i][2])== 0 && tic[i][2].compareTo(" ") != 0) {
                if (tic[i][0].compareTo("O")== 0) {
                    return 1 ;
                }
                else{

                    return 2;
                }


            }

            if (tic[0][i].compareTo(tic[1][i])== 0  && tic[1][i].compareTo(tic[2][i])== 0 && tic[2][i].compareTo(" ") != 0) {
                if (tic[0][i].compareTo("O")== 0) {
                    return 1;
                }
                else{
                    return 2;
                }


            }


            if (tic[0][0].compareTo(tic[1][1])== 0  && tic[1][1].compareTo(tic[2][2])== 0 && tic[2][2].compareTo(" ") != 0) {
                if (tic[0][0].compareTo("O")== 0) {
                    return 1;
                }
                else{
                    return 2;                }
            }


            if (tic[0][2].compareTo(tic[1][1])== 0  && tic[1][1].compareTo(tic[2][0])== 0 && tic[2][0].compareTo(" ") != 0) {
                if (tic[0][2].compareTo("O")== 0) {
                    return 1;
                }
                else{
                    return 2;
                }


            }

        }
        return 0;

    }


    public static void initialize(String[][] tic,int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                tic[i][j] = " ";

            }

        }

    }




    public static void menu(){

        System.out.println("                                                                        Tic Tac Toe");
        System.out.println("Player Vs Player | P V P" );
        System.out.println();

    }

    public static void coordinates(){

        System.out.println("0,0|0,1|0,2");
        System.out.println("____________");
        System.out.println("1,0|1,1|1,2");
        System.out.println("____________");
        System.out.println("2,0|2,1|0,2");
        System.out.println("Coordinates of Table");
        System.out.println("Please Enter Coordinates e.g(0,1)");

    }



    public static void TicTacToeCodix() {
        Scanner sc = new Scanner(System.in);


        int num1 = 0;
        String[][] tic = new String[3][3];


        int size= 3;

        initialize(tic, size);

        menu();

        System.out.print("Player - 1's Name: ");
        String player1 = sc.nextLine();
        System.out.println();
        System.out.print("Player - 2's Name: ");
        String player2 = sc.nextLine();

        System.out.println();
        System.out.println();


        System.out.println("                                                                        " + player1 + " VS " + player2);
        System.out.println();


        System.out.println(player1 + "'s sign: O ");
        System.out.println(player2 + "'s sign: X ");
        System.out.println();

        coordinates();


        while (check(tic, size) == 0 && num1 < 9) {
            num1 += input(tic,size,num1,player1,player2);

        }


        System.out.println();

        if (check(tic, size) == 1) {
            if (player1.length() > player2.length() ) {


                System.out.println("Winner\t\t\t\t\t\t\t\tLoser");
                System.out.print("Congrats " + player1 + " You Win \t\t\t");
                System.out.print(player2 + " Better Luck Next Time ");
            }else {

                System.out.println("Winner\t\t\t\t\t\t\tLoser");
                System.out.print("Congrats " + player1 + " You Win \t\t\t");
                System.out.print(player2 + " Better Luck Next Time ");

            }

        }
        else if(check(tic, size) == 2){
            if (player1.length() > player2.length() ) {


                System.out.println("Winner\t\t\t\t\t\t\tLoser");
                System.out.print("Congrats " + player2 + " You Win \t\t\t");
                System.out.print(player1 + " Better Luck Next Time ");
            }else {

                System.out.println("Winner\t\t\t\t\t\t\t\tLoser");
                System.out.print("Congrats " + player2 + " You Win \t\t\t");
                System.out.print(player1 + " Better Luck Next Time ");

            }


        }
        else{
            System.out.println("Draw");
            System.out.println(player1 + " and " + player2 + " Both played Well");
        }















    }
}
