import java.util.Scanner;

class Result {
    private double[] course1;
    private double[] course2;
    private double[] course3;
    private double[] gpa1;
    private double[] gpa2;
    private double[] gpa3;

    private int size1;
    private int size2;
    private int size3;

    Scanner sc = new Scanner(System.in);

    public void setSize1(int size1) {
        if (size1 >= 0) {
            this.size1 = size1;
        }
        else{
            System.out.println("Invalid Size - !");
        }

    }

    public int getSize1() {
        if (this.size1 != 0) {
            return size1;
        }else{
            return 1;
        }
    }


    public void setSize2(int size2) {
        if (size2 >= 0) {
            this.size2 = size2;
        }
        else{
            System.out.println("Invalid Size - !");
        }

    }

    public int getSize2() {
        if (this.size2 != 0) {
            return size2;
        }else{
            return 1;
        }
    }


    public void setSize3(int size3) {
        if (size3 >= 0) {
            this.size3 = size3;
        }
        else{
            System.out.println("Invalid Size - !");
        }

    }

    public int getSize3() {
        if (this.size3 != 0) {
            return size3;
        }else{
            return 1;
        }
    }






    Result(int size1, int size2, int size3){

        setSize1(size1);
        setSize2(size2);
        setSize3(size3);

        course1 = new double[size1];
        gpa1 = new double[size1];

        course2 = new double[size2];
        gpa2 = new double[size2];

        course3 = new double[size3];
        gpa3 = new double[size3];
    }




    public void getMarks(){
        System.out.println("Total Courses: " + (size1+size2+size3));
        System.out.println();

        System.out.println("Enter 3 Cerdit Course Marks");
        for (int i = 0; i < getSize3(); i++) {
            System.out.print("Course - " + (i+1) + ": ");
            course3[i] = sc.nextDouble();
        }
        System.out.println();

        System.out.println("Enter 2 Credit Course Marks");

        for (int i = 0; i < getSize2(); i++) {
            System.out.print("Course - " + (i+1) + ": ");
            course2[i] = sc.nextDouble();
        }
        System.out.println();

        System.out.println("Enter 1 Credit Course Marks");

        for (int i = 0; i < getSize1(); i++) {
            System.out.print("Course - " + (i+1) + ": ");
            course1[i] = sc.nextDouble();
        }
        System.out.println();
    }


    public double calculateGPA(double courseMarks){

        double per = courseMarks ;
        double GPA = 0.0;

        if (per >= 90 && per <= 100) {
            GPA = 4.0;
        } else if (per >= 85 && per < 90) {
            GPA = 3.75;
        } else if (per >= 80 && per < 85) {
            GPA = 3.5;
        } else if (per >= 75 && per < 80) {
            GPA = 3.25;
        } else if (per >= 70 && per < 75) {
            GPA = 3.0;

        } else if (per >= 66 && per < 70) {
            GPA = 2.75;
        } else if (per >= 63 && per < 66) {
            GPA = 2.5;
        } else if (per >= 60 && per < 63) {
            GPA = 2.0;
        } else if (per >= 55 && per < 60) {
            GPA = 1.5;
        } else if (per >= 0 && per < 55) {
            GPA = 0.0;

        } else {
            System.out.println("Invalid Input or Error !");
        }
        return GPA;


    }





    public void calculateResult(){

        double total = 0.0;

        total = total + getSize1();
        total = total + (getSize2()*2);
        total = total + (getSize3()*3);


        double total1 = 0.0;
        double total2 = 0.0;
        double total3 = 0.0;

        for (int i = 0; i < getSize1(); i++) {
            total1 = total1 + calculateGPA(course1[i]);
        }

        for (int i = 0; i < getSize2(); i++) {
            total2 = total2 + calculateGPA(course2[i]);
        }

        for (int i = 0; i < getSize3(); i++) {
            total3 = total3 + calculateGPA(course3[i]) ;
        }


        total2 = total2 * 2;
        total3 = total3 * 3;

        double megaTotal = total1 + total2 + total3;

        double CGPA = megaTotal / total;

        System.out.println("CGPA: " + CGPA);




    }






}




class Main5 {
    public static void main(String[] args) {


    }

}