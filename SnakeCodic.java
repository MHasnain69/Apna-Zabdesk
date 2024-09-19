import java.util.*;


class SnakeCodic {

    public static void set(String[][] board) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                board[i][j] = "*";

            }

        }
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();

        }
        System.out.println();
    }


    public static void point(String[][] board) {
        Random ran = new Random();

        int num1 = ran.nextInt(18);
        int num2 = ran.nextInt(48);


        if (board[num1][num2].compareTo("*") != 0) {
            board[num1][num2] = "P";
        } else {
            int num3 = ran.nextInt(18);
            int num4 = ran.nextInt(48);
            board[num3][num4] = "P";
        }


        printBoard(board);
    }




    public static int down(String[][] board,int x, int y,int length){
        if (board[x+1][y].compareTo("*")== 0)  {

            board[x][y] = "*";
            board[x + 1][y] = "S";
            check(board,x,y,length);
            eraseDown(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);

        }
        else if (board[x+1][y].compareTo("P")== 0) {
            board[x + 1][y] = "S";
            check(board,x,y,length);
            point(board);
            eraseDown(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);
            return 1;

        }
        return 0;

    }







    public static int up(String[][] board,int x, int y,int length){
        if (board[x - 1][y].compareTo("*")== 0)  {

            board[x][y] = "*";
            board[x - 1][y] = "S";
            check(board,x,y,length);
            eraseUp(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);

        }
        else if (board[x -1][y].compareTo("P")== 0) {
            board[x - 1][y] = "S";
            check(board,x,y,length);
            point(board);
            eraseUp(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);
            return 1;
        }
        return 0;


    }


    public static int right(String[][] board,int x, int y,int length){
        if (board[x][y+1].compareTo("*")== 0)  {

            board[x][y] = "*";
            board[x][y + 1] = "S";
            check(board,x,y,length);
            eraseUp(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseDown(board,x,y,length);
            printBoard(board);

        }
        else if (board[x][y+1].compareTo("P")== 0) {
            board[x][y + 1] = "S";
            check(board,x,y,length);
            point(board);
            eraseUp(board,x,y,length);
            eraseRight(board,x,y,length);
            eraseDown(board,x,y,length);
            printBoard(board);
            return 1;
        }
        return 0;

    }

    public static int left(String[][] board,int x, int y,int length){
        if (board[x][y - 1].compareTo("*")== 0)  {

            board[x][y] = "*";
            board[x][y - 1] = "S";
            check(board,x,y,length);
            eraseUp(board,x,y,length);
            eraseDown(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);

        }
        else if (board[x][y-1].compareTo("P")== 0) {
            board[x][y - 1] = "S";
            check(board,x,y,length);
            point(board);
            eraseUp(board,x,y,length);
            eraseDown(board,x,y,length);
            eraseLeft(board,x,y,length);
            printBoard(board);
            return 1;

        }
        return 0;
    }


    public static void checkDown(String[][] board,int x,int y,int length) {


        for (int i = 1; i < length; i++) {
            if (board[x - i][y].compareTo("S") == 0) {
                board[x - (i - 1)][y] = "S";
            }
        }
    }




    public static void checkRight(String[][] board,int x,int y,int length) {

        for (int i = 1; i < length; i++) {
            if (board[x][y - i].compareTo("S") == 0) {
                board[x][y - (i - 1)] = "S";
            }
        }
    }



    public static void checkBothUPDown(String[][] board,int x,int y,int length) {

        for (int i = 1; i < length; i++) {
            if (board[x - i][y - i].compareTo("S") == 0) {
                board[x - (i - 1)][y - (i - 1)] = "S";
            }
        }
    }


    public static void checkUp(String[][] board,int x,int y,int length) {


        for (int i = 1; i < length; i++) {
            if (board[x + i][y].compareTo("S") == 0) {
                board[x + (i - 1)][y] = "S";
            }

        }
    }

    public static void checkBoth(String[][] board,int x,int y,int length) {


        for (int i = 1; i < length; i++) {
            if (board[x + i][y + i].compareTo("S") == 0) {
                board[x + (i - 1)][y + (i - 1)] = "S";
            }
        }
    }




    public static void checkLeft(String[][] board,int x,int y,int length){



        for (int i = 1; i < length ; i++) {
            if (board[x][y + i].compareTo("S") == 0 ){
                board[x][y + (i-1)] = "S";
            }

        }


    }


    public static void check(String[][] board,int x,int y,int length){


        for (int i = 1; i < length; i++) {
            if (board[x - i][y].compareTo("S") == 0) {
                board[x - (i - 1)][y] = "S";
            }
        }


        for (int i = 1; i < length; i++) {
            if (board[x][y - i].compareTo("S") == 0) {
                board[x][y - (i - 1)] = "S";
            }
        }

        for (int i = 1; i < length; i++) {
            if (board[x - i][y - i].compareTo("S") == 0) {
                board[x - (i - 1)][y - (i - 1)] = "S";
            }
        }


        for (int i = 1; i < length; i++) {
            if (board[x + i][y].compareTo("S") == 0) {
                board[x + (i - 1)][y] = "S";
            }

        }

        for (int i = 1; i < length; i++) {
            if (board[x + i][y + i].compareTo("S") == 0) {
                board[x + (i - 1)][y + (i - 1)] = "S";
            }
        }

        for (int i = 1; i < length ; i++) {
            if (board[x][y + i].compareTo("S") == 0 ){
                board[x][y + (i-1)] = "S";
            }

        }




    }



    public static void eraseDown(String[][] board,int x,int y,int length){

        board[x - length][y] = "*";
    }

    public static void eraseUp(String[][] board,int x,int y,int length){

        board[x + length][y] = "*";
    }

    public static void eraseRight(String[][] board,int x,int y,int length){

        board[x][y - length] = "*";
    }

    public static void eraseLeft(String[][] board,int x,int y,int length){

        board[x][y + length] = "*";
    }


    public static void erase(String[][] board,int x,int y,int length){


        board[x][y + length] = "*";

        board[x][y - length] = "*";

        board[x + length][y] = "*";

        board[x - length][y] = "*";


    }






    public static void SnakeCodix() {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[20][50];
        int length = 1;
        set(board);




        int x = 1;
        int y = 2;

        board[x][y] = "S";
        point(board);
        printBoard(board);
int temp = 0;

        do {
            System.out.println("Input: ");
            String input = sc.nextLine();


            if (input.compareTo("up")== 0){
                length += up(board,x,y,length);
                x--;
            } else if (input.compareTo("down")==0) {
                length += down(board,x,y,length);
                x++;
            } else if (input.compareTo("right")== 0) {
                System.out.println("RRR");
                length += right(board,x,y,length);
                y++;
            } else if (input.compareTo("left")== 0) {
                length += left(board,x,y,length);
                y--;
            }else if (input.compareTo("Exit")== 0 || input.compareTo("exit")== 0 ) {
                temp = 1;
            }




        }while(temp != 1);

        



    }




















}
