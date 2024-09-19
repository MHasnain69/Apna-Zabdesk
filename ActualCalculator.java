// Actual Calculator
import java.util.Scanner;

public class ActualCalculator {

    public static double cal(String secPart,double ans){

        String[] afterAns = secPart.split(" ");

        String f = afterAns[0];
        String s = afterAns[1];

        double sec = Double.parseDouble(s);

        if (f.compareTo("+") == 0) {
            System.out.print(ans + sec + " ");
            ans = ans + sec;
        }
        else if (f.compareTo("-") == 0) {
            System.out.print(ans - sec + " ");
            ans = ans - sec;
        }
        else if (f.compareTo("*") == 0) {
            System.out.print(ans * sec + " ");
            ans = ans * sec;
        }
        else if (f.compareTo("/") == 0) {
            System.out.print(ans / sec + " ");
            ans = ans / sec;

        }
        else if (f.compareTo("%") == 0) {
            System.out.print(ans % sec + " ");
            ans = ans % sec;
        }
        else {
            System.out.println("Invalid operator");
        }

        return ans;
    }


    public void Play() {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Calculator----------(+,-,/,*,%)");
        System.out.println("Please Use Space between numbers e.g (2 + 3)");
        System.out.println();



        String name = sc.nextLine();

        String[] temp = name.split(" ");

        String first = temp[0];
        String opt = temp[1];
        String second = temp[2];

        double f1 = Double.parseDouble(first);
        double f2 = Double.parseDouble(second);

        double ans = 0;
        if (opt.compareTo("+") == 0) {
            ans = f1 + f2;
            System.out.print(f1 + f2 + " ");

        }
        else if (opt.compareTo("-") == 0) {
            ans = f1 - f2;
            System.out.print(f1 - f2 + " ");

        }
        else if (opt.compareTo("*") == 0) {
            ans = f1 * f2;
            System.out.print(f1 * f2 + " ");

        }
        else if (opt.compareTo("/") == 0) {
            ans = f1 / f2;
            System.out.print(f1 / f2 + " ");


        }
        else if (opt.compareTo("%") == 0) {
            ans = f1 % f2;
            System.out.print(f1 % f2 + " ");

        }
        else {
            System.out.println("Invalid operator");
        }

        while(true) {

            ans = cal(sc.nextLine(), ans);
        }

    }
}