import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


class SZABIST {

    public void WelcomeMessage(){
        System.out.println("Welcome to SZABIST University");
    }
    public void start(){
        System.out.println("Please Enter Your Information");
    }


}



class Students extends SZABIST {
    // Data of Student
    protected int[] regNo = new int[100];
    protected String[] FirstName = new String[100];
    protected String[] LastName = new String[100];
    protected String[] prgram = new String[100];


    protected int[] semester = new int[100];

    protected String[] section = new String[100];

    protected double[] CGPA = new double[100];

    protected static int studentNum = 0;


    Students(){
        getStudentNum();
    }
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        Students.studentNum = studentNum;
    }


    public void getStudentsData() {
        File file = new File("Marvel.txt");
        int temp0 = 0;
        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; scanner.hasNextLine(); i++) {
                String str = scanner.nextLine();
                String[] temp = str.split(" ");
                this.FirstName[i] = temp[0];
                this.LastName[i] = temp[1];
                this.regNo[i] = Integer.parseInt(temp[2]);
                this.prgram[i] = temp[3];
                this.semester[i] = Integer.parseInt(temp[4]);
                this.section[i] = temp[5];
                this.CGPA[i] = Double.parseDouble(temp[6]);
                temp0 = temp0 + 1;
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        setStudentNum(temp0);
    }


    public void createAccountStudent(String firstName, String lastName, int regNo, String program, int Semester, String section, double CGPA){
        int temp0 = 0;
        for (int i = 0; i < getStudentNum() ; i++) {
            if (this.regNo[i] == regNo){
                temp0 = temp0 + 1;
            }
        }



            if (temp0 == 0) {
                if (isSevenDigitNumber(regNo) && program.length() <= 4 && Semester > 0 && Semester < 9 && section.length() > 0 && section.length() <= 1 && CGPA >= 0 && CGPA <= 4.00) {
                    File file = new File("Marvel.txt");

                    String signInData = "\n" + firstName + " " + lastName + " " + regNo + " " + program + " " + Semester + " " + section + " " + CGPA;

                    String path = file.getAbsolutePath();

                    try {
                        Files.write(Paths.get(path), signInData.getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Account Created Successfully");

                } else {
                    System.out.println("Invalid Student Input Data");
                }
            }else {
                System.out.println("You are Already Registered in SZABIST");
            }

    }
    String name;

    public String getStudentName(int regNo){
        getStudentsData();
        
        for (int i = 0; i < studentNum; i++) {
            
        if (regNo == this.regNo[i]) {
            name = this.FirstName[i] + " " + this.LastName[i];
        }
        }
    return name;
    } 

    public void StudentsList(){
        getStudentsData();
        System.out.println("----------------------------------------------------Registered Students in SZABIST----------------------------------------------------");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s %-10s%n", "Names Of Students", "Registration Number", "Program", "Semester", "Section", "CGPA");
        for (int i = 0; i < getStudentNum(); i++) {
            System.out.printf("%-20s %-20d %-10s %-10d %-10s %-10.2f%n",
                    this.FirstName[i] + " " + this.LastName[i],
                    this.regNo[i],
                    this.prgram[i],
                    this.semester[i],
                    this.section[i],
                    this.CGPA[i]);
        }
    }

    public boolean isSevenDigitNumber(int number) {
        return number >= 1000000 && number <= 9999999;
    }






}





class Login extends Students{
    private String[] pass = new String[100];
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public void setPass() {
        for (int i = 0; i < getStudentNum() ; i++) {
            pass[i] = "abc.123";
        }
    }
    Login(){
        getStudentsData();
        setPass();
    }

    public void login(int regNo, String pass) {
        getStudentsData();
        setPass();
        int temp = 0;
        for (int i = 0; i < getStudentNum(); i++) {
            if (super.regNo[i] == regNo && this.pass[i].compareTo(pass) == 0) {
                printStylishInfo(i);
                temp++;
            } else if (super.regNo[i] == regNo && this.pass[i].compareTo(pass) != 0) {
                System.out.println("Wrong Password - !");
            }
        }
        if (temp == 0){
            System.out.println("Invalid Registration Number - !");


        }
    }

    private void printStylishInfo(int i) {
        final int CONSOLE_WIDTH = 136;

        String[] lines = {
                "╔════════════════════════════════════════════╗",
                String.format("║ %-42s ║", "           Student Information"),
                "╠════════════════════════════════════════════╣",
                String.format("║ %-12s: %-28s ║", "Name", super.FirstName[i] + " " + super.LastName[i]),
                String.format("║ %-12s: %-28s ║", "Program", super.prgram[i]),
                String.format("║ %-12s: %-28d ║", "Semester", super.semester[i]),
                String.format("║ %-12s: %-28s ║", "Section", super.section[i]),
                String.format("║ %-12s: %-28.2f ║", "CGPA", super.CGPA[i]),
                "╚════════════════════════════════════════════╝",
                String.format("Press Enter to continue...",null),
        };

        for (String line : lines) {
            int padding = (CONSOLE_WIDTH - line.length()) / 2;
            System.out.println(" ".repeat(padding) + line);
        }
    }




    public int isRegistered(int regNo){
        int temp = 0;
        for (int i = 0; i < getStudentNum() ; i++) {
        if (regNo == this.regNo[i]) {
            temp++;
        }
        }
        return temp;
    }



    public void classSchedule(int regNo) {
        if (isRegistered(regNo) != 0) {
            Scanner sc = new Scanner(System.in);

            String[] day = new String[7];
            String[] course = new String[7];
            String[] time = new String[7];

            File file = new File("Class Schedule.txt");
            try {
                Scanner scanner = new Scanner(file);
                for (int i = 0; scanner.hasNextLine(); i++) {
                    String str = scanner.nextLine();
                    String[] temp = str.split(",");
                    day[i] = temp[0];
                    course[i] = temp[1];
                    time[i] = temp[2];
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            System.out.print("Do you want Schedule of Specific Day / Entire Week: ");
            String input = sc.next();
            sc.nextLine();
            
            if (input.compareTo("Specific")== 0 || input.compareTo("specific")== 0) {
                System.out.print("Day: ");
                String changes0 = sc.nextLine();
                System.out.println();
                System.out.println();

                if (changes0.compareTo("Monday") == 0 || changes0.compareTo("monday") == 0) {

                    System.out.println(day[0] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[0]);
                    System.out.println("Timing: " + time[0]);


                } else if (changes0.compareTo("Tuesday") == 0 || changes0.compareTo("tuesday") == 0) {

                    System.out.println(day[1] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[1]);
                    System.out.println("Timing: " + time[1]);

                } else if (changes0.compareTo("Wednesday") == 0 || changes0.compareTo("wednesday") == 0) {
                    System.out.println(day[2] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[2]);
                    System.out.println("Timing: " + time[2]);

                } else if (changes0.compareTo("Thursday") == 0 || changes0.compareTo("thursday") == 0) {

                    System.out.println(day[3] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[3]);
                    System.out.println("Timing: " + time[3]);


                } else if (changes0.compareTo("Friday") == 0 || changes0.compareTo("friday") == 0) {

                    System.out.println(day[4] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[4]);
                    System.out.println("Timing: " + time[4]);

                } else if (changes0.compareTo("Saturday") == 0 || changes0.compareTo("saturday") == 0) {

                    System.out.println(day[5] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[5]);
                    System.out.println("Timing: " + time[5]);

                } else if (changes0.compareTo("Sunday") == 0 || changes0.compareTo("sunday") == 0) {

                    System.out.println(day[6] + " Classes: ");
                    System.out.println();
                    System.out.println("Course: " + course[6]);
                    System.out.println("Timing: " + time[6]);

                } else {
                    System.out.println("Invalid Day");

                }
                System.out.println("Press Enter To Continue....");
            }
            else if (input.compareTo("entire")== 0 || input.compareTo("Entire")== 0 ) {
                System.out.println();
                System.out.println();
                System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
                System.out.printf("║ %-9s │ %-40s │ %-50s ║%n", "Day", "Time", "Course");
                System.out.println("╠═══════════╪══════════════════════════════════════════╪════════════════════════════════════════════════════╣");
                
                for (int i = 0; i < 7; i++) {
                    System.out.printf("║ %-9s │ %-40s │ %-50s ║%n",
                            day[i],
                            time[i],
                            course[i]
                    );
                }
                
            
                System.out.println("╚═══════════╧══════════════════════════════════════════╧════════════════════════════════════════════════════╝");
                System.out.println("                                      Press Enter To Continue....     ");
                }else {
                    System.out.println("Invalid Input - !");
                }
                
        }else {
            System.out.println("You Doesn't have Registered at SZABIST");
        }

    }



    public static void header(){
        final String[] sensetiveInfo = new String[4];

        sensetiveInfo[0] = "Muhammad Hasnain";
        sensetiveInfo[1] = "SZABIST©";
        sensetiveInfo[2] = "2.18.6.13";
        sensetiveInfo[3] = "2024";

        long year = System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365;
        year = 1970 + year;

        Date date = new Date();
        String temp0 = date.toString();
        String temp1[] = temp0.split(" ");
        String month = temp1[1];
        String dateNumber = temp1[2];

        LocalTime lt = LocalTime.now();

        DateTimeFormatter tf = DateTimeFormatter.ofPattern("h:mm a");

        String formattedTime = lt.format(tf);



        printCentered("                                                                                                                        ");
        printCentered("                             ***************************************************************************************");
        printCentered("                             *                                                                                     *");
        printCentered("                             *    ███████╗    █████╗    ██████╗    ██████╗    ███████╗   ███████╗   ██╗   ██╗      *");
        printCentered("                             *    ╚══███╔╝   ██╔══██╗   ██╔══██╗   ██╔══██╗   ██╔════╝   ██╔════╝   ██║  ██╔╝      *");
        printCentered("                             *      ███╔╝    ███████║   ██████╔╝   ██║  ██║   █████╗     ███████╗   █████╔╝        *");
        printCentered("                             *     ███╔╝     ██╔══██║   ██╔══██╗   ██║  ██║   ██╔══╝     ╚════██║   ██╔═██╗        *");
        printCentered("                             *    ███████╗   ██║  ██║   ██████╔╝   ██████╔╝   ███████╗   ███████║   ██║  ██╗       *");
        printCentered("                             *    ╚══════╝   ╚═╝  ╚═╝   ╚═════╝    ╚═════╝    ╚══════╝   ╚══════╝   ╚═╝  ╚═╝       *");
        printCentered("                             *                                                                                     *");
        printCentered("                             ***************************************************************************************");
        printCentered("                             * This program is designed to manage student information for a university. It include *");
        printCentered("                             * features such as adding, updating, deleting, and displaying student records.        *");
        printCentered("                             *                                                                                     *");
        printCentered("                             * Developer: " + sensetiveInfo[0]  + "                     Copyright : " + sensetiveInfo[1] + "                *");
        printCentered("                             * Date: "+ dateNumber + " " + month + " " + year +"                               Time: "+ formattedTime + "                       *");
        printCentered("                             * Version: " + sensetiveInfo[2] + "                              Build In: " + sensetiveInfo[3] + "                      *");
        printCentered("                             ***************************************************************************************");


    }

    public  void printExamSchedule() {
        System.out.println(CYAN + "                                            ╔═════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "                                            ║                " + YELLOW + "EXAM SCHEDULE" + CYAN + "                ║" + RESET);
        System.out.println(CYAN + "                                            ╠═════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "                                            ║ " + GREEN + "Midterm:    " + WHITE + "4th November - 10th November" + CYAN + "    ║" + RESET);
        System.out.println(CYAN + "                                            ╠═════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "                                            ║ " + PURPLE + "Dead Week:  " + WHITE + "30th December - 5th January" + CYAN + "     ║" + RESET);
        System.out.println(CYAN + "                                            ╠═════════════════════════════════════════════╣" + RESET);
        System.out.println(CYAN + "                                            ║ " + RED + "Final Exams: " + WHITE + "6th January - 19th January" + CYAN + "     ║" + RESET);
        System.out.println(CYAN + "                                            ╚═════════════════════════════════════════════╝" + RESET);
        System.out.println("                                                       Press Enter To Continue...           ");
    }


    public static void printCentered(String s) {
        int width = 100;
        int padding = (width - s.length()) / 2;
        String paddedString = String.format("%" + (padding + s.length()) + "s", s);
        System.out.println(paddedString);
    }

    public static void footer(){

        printCentered("                                                   ***************************************************************************************");
        printCentered("                                                   *                                                                                     *");
        printCentered("                                                   *    ███████╗███╗   ██╗██████╗        ██████╗  ██████╗                                *");
        printCentered("                                                   *    ██╔════╝████╗  ██║██╔══██╗       ██╔══██╗██╔═══██╗                               *");
        printCentered("                                                   *    █████╗  ██╔██╗ ██║██████╔╝       ██║  ██║██║   ██║                               *");
        printCentered("                                                   *    ██╔══╝  ██║╚██╗██║██╔══██╗       ██║  ██║██║   ██║                               *");
        printCentered("                                                   *    ███████╗██║ ╚████║██║  ██║██╗    ██████╔╝╚██████╔╝                               *");
        printCentered("                                                   *    ╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝    ╚═════╝  ╚═════╝                                *");
        printCentered("                                                   *                                                                                     *");
        printCentered("                                                   **************************************************************************************");
        printCentered("                                                   * This program is developed to help manage student records efficiently.               *");
        printCentered("                                                   * Thank you for using our system.                                                     *");
        printCentered("                                                   ***************************************************************************************");
        printCentered("                                                   *                       © 2024 SZABIST. All rights reserved.                          *");
        printCentered("                                                   *_____________________________________________________________________________________*");
    }





    public static void Delay(int miliSec) {

            try{
                Thread.sleep(miliSec);

            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }

    }











}

class Course extends Login {

    protected int registrationNo;
    protected String[] course = new String[6];


    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    Course(int regNo) {
        setRegistrationNo(regNo);
    }


    public int getCourseRegistered() {
        int temp0 = 0;
        File file = new File("Courses.txt");

        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0; scanner.hasNextLine(); i++) {
                String str = scanner.nextLine();
                String[] temp = str.split(",");

                if (registrationNo == Integer.parseInt(temp[0])) {

                    registrationNo = Integer.parseInt(temp[0]);
                    course[0] = temp[1];
                    course[1] = temp[2]; 
                    course[2] = temp[3];
                    course[3] = temp[4];
                    course[4] = temp[5];
                    course[5] = temp[6];
                    temp0++;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


        if (temp0 == 0) {
            System.out.println("You doesn't have Registered Course");
        }

        return temp0;
    }

    public void RegistrationCourse() {
        Scanner sc = new Scanner(System.in);
        if (isRegistered(getRegistrationNo()) != 0) {
            if (getCourseRegistered() == 0) {
                String RegistrationCourses = null;

                System.out.println("Courses Offered By SZABIST");
                System.out.println();
                System.out.println("Compulsory Courses");
                System.out.println("1. Data Structure and Algorithms");
                System.out.println("2. Lab: Data Structure and Algorithms");
                System.out.println("3. Software Requirement Engineering");
                System.out.println("4. Human Computer Interaction");
                System.out.println("5. Linear Algebra");



                System.out.println();
                System.out.println("Now, The Courses you want to Register by Tick / Leave obliviously for leave");
                System.out.println("Compulsory Courses");
                System.out.print("1. Data Structure and Algorithms: ");
                String input0 = sc.nextLine();
                System.out.println();
                if (input0.compareTo("tick") == 0 || input0.compareTo("Tick") == 0) {
                    RegistrationCourses = "Data Structure and Algorithms";
                } else {
                    RegistrationCourses = "Leaved Course";
                }

                System.out.print("2. Lab: Data Structure and Algorithms: ");
                input0 = sc.nextLine();
                System.out.println();
                if (input0.compareTo("tick") == 0 || input0.compareTo("Tick") == 0) {
                    RegistrationCourses = RegistrationCourses + ",Lab: Data Structure and Algorithms";
                } else {
                    RegistrationCourses = RegistrationCourses + ",Leaved Course";
                }

                System.out.print("3. Software Requirement Engineering: ");
                input0 = sc.nextLine();
                System.out.println();
                if (input0.compareTo("tick") == 0 || input0.compareTo("Tick") == 0) {
                    RegistrationCourses = RegistrationCourses + ",Software Requirement Engineering";
                } else {
                    RegistrationCourses = RegistrationCourses + ",Leaved Course";
                }

                System.out.print("4. Human Computer Interaction: ");
                input0 = sc.nextLine();
                System.out.println();
                if (input0.compareTo("tick") == 0 || input0.compareTo("Tick") == 0) {
                    RegistrationCourses = RegistrationCourses + ",Human Computer Interaction";
                } else {
                    RegistrationCourses = RegistrationCourses + ",Leaved Course";
                }

                System.out.print("5. Linear Algebra: ");
                input0 = sc.nextLine();
                System.out.println();
                if (input0.compareTo("tick") == 0 || input0.compareTo("Tick") == 0) {
                    RegistrationCourses = RegistrationCourses + ",Linear Algebra";
                } else {
                    RegistrationCourses = RegistrationCourses + ",Leaved Course";
                }


                System.out.println();
                System.out.println("Electives");
                System.out.println("1. Foreign Languages");
                System.out.println("2. Management Principles");
                System.out.println("3. Sociology");
                System.out.println("4. Psychology");
                System.out.println("5. Introduction to Management");
                System.out.println("6. Financial Accounting");
                System.out.println("7. Human Resource Management");
                System.out.println("8. Leave Elective");
                System.out.println("Now Choose Any one Elective: ");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        RegistrationCourses = RegistrationCourses + ",Foreign Languages";
                        break;
                    case 2:
                        RegistrationCourses = RegistrationCourses + ",Management Principles";
                        break;
                    case 3:
                        RegistrationCourses = RegistrationCourses + ",Sociology";
                        break;
                    case 4:
                        RegistrationCourses = RegistrationCourses + ",Psychology";
                        break;
                    case 5:
                        RegistrationCourses = RegistrationCourses + ",Introduction to Management";
                        break;
                    case 6:
                        RegistrationCourses = RegistrationCourses + ",Financial Accounting";
                        break;
                    case 7:
                        RegistrationCourses = RegistrationCourses + ",Human Resource Management";
                        break;
                    case 8:
                        RegistrationCourses = RegistrationCourses + ",Leaved Course";
                        System.out.println("You have Leave Elective");
                        break;
                    default:
                        System.out.println("Invalid Course");


                }

                File file = new File("Courses.txt");

                RegistrationCourses = "\n" + Integer.toString(registrationNo) + "," + RegistrationCourses;

                String path = file.getAbsolutePath();

                try {
                    Files.write(Paths.get(path), RegistrationCourses.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                getDataInFileDSA();
                getAttendenceInFileDSA();
                getProjectinFileDSA();
                
                getDataInFileDSALab();
                getAttendenceInFileDSALab();
                getProjectinFileDSALab();
                
                getDataInFileSRE();
                getAttendenceInFileSRE();
                getProjectinFileSRE();
                
                getDataInFileHCI();
                getAttendenceInFileHCI();
                getProjectinFileHCI();
                
                getDataInFileLA();
                getAttendenceInFileLA();
                getProjectinFileLA();



                System.out.println("Courses Registered Successfully");

            } else {
                System.out.println("You have Already Registered Courses");
            }
        }else {
            System.out.println("You are not Registered at SZABIST - !");
        }

    }


    public void RegisteredCourse() {
        if (getCourseRegistered() != 0) {

            for (int i = 0; i < getStudentNum(); i++) {
                if (super.regNo[i] == this.registrationNo) {
                    System.out.println("╔══════════════════════════════════════════════════════════╗");
                    System.out.printf("║ %-56s ║%n", "Registered Courses By " + super.FirstName[i] + " " + super.LastName[i]);
                    System.out.println("╠══════════════════════════════════════════════════════════╣");
                    for (int j = 0; j < course.length; j++) {
                        if (course[j] != null && !course[j].isEmpty()) {
                            System.out.printf("║ %-56s ║%n", course[j]);
                        }
                    }
                    System.out.println("╚══════════════════════════════════════════════════════════╝");
                }
            }

        }

    }


    public void getDataInFileDSA() {
        File file = new File("DSA.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getAttendenceInFileDSA() {
        File file = new File("DSAAttendance1.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }


    public void getProjectinFileDSA(){
        File file = new File("DSAProject.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }





    }

    public void getProjectinFileHCI(){
        File file = new File("HCIProject.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }





    }


    public void getDataInFileDSALab() {
        File file = new File("DSALab.txt");
        getCourseRegistered();


        if (course[1].compareTo("Lab: Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getAttendenceInFileDSALab() {
        File file = new File("DSALabAttendence.txt");
        getCourseRegistered();


        if (course[1].compareTo("Lab: Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getProjectinFileDSALab(){
        File file = new File("DSALabProject.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }





    }



    public void getDataInFileSRE() {
        File file = new File("SRE.txt");
        getCourseRegistered();


        if (course[2].compareTo("Software Requirement Engineering") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getProjectinFileSRE(){
        File file = new File("SREProject.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }





    }

    public void getAttendenceInFileSRE() {
        File file = new File("SREAttendance.txt");
        getCourseRegistered();


        if (course[2].compareTo("Software Requirement Engineering") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }


    public void getDataInFileHCI() {
        File file = new File("HCI.txt");
        getCourseRegistered();


        if (course[3].compareTo("Human Computer Interaction") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getAttendenceInFileHCI() {
        File file = new File("HCIAttendance.txt");
        getCourseRegistered();


        if (course[3].compareTo("Human Computer Interaction") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getDataInFileLA() {
        File file = new File("LinearAlgebra.txt");
        getCourseRegistered();


        if (course[4].compareTo("Linear Algebra") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }

    public void getAttendenceInFileLA() {
        File file = new File("LinearAlgebraAttendance.txt");
        getCourseRegistered();


        if (course[4].compareTo("Linear Algebra") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }




    }

    public void getProjectinFileLA(){
        File file = new File("LAProject.txt");
        getCourseRegistered();


        if (course[0].compareTo("Data Structure and Algorithms") == 0) {

            String temp = "Not Entered,Not Entered,Not Entered";

            String marks = "\n" + getRegistrationNo() + "," + temp;

            String path = file.getAbsolutePath();

            try {
                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }





    }





}

class DSA extends Course{
    protected static String teacher = "Ayesha Ghayas";
    protected String RegistrationNum;
    protected String quiz1 ;
    protected String quiz2;
    protected String quiz3;
    protected String project;
    protected String mids;
    protected String finals;
    protected String assignments;
    protected String presentation;
    protected String classParticipation;

    protected static String Teacher = "Ayesha Ghayas";
    protected static String TeacherPas = "szabist zindabad";

    protected String[] week = new String[16];


    public String getRegistrationNum() {
        return RegistrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        RegistrationNum = registrationNum;
    }

    DSA(int regNo, String pass){
        super(regNo);
        setRegistrationNum(Integer.toString(regNo));
    }



    public int getMarks(){
        int temp0 = 0;
        File file = new File("DSA.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] temp = str.split(",");
            if (RegistrationNum.compareTo(temp[0])== 0) {
                quiz1 = temp[1];
                quiz2 = temp[2];
                quiz3 = temp[3];
                project = temp[4];
                mids = temp[5];
                finals = temp[6];
                assignments = temp[7];
                presentation = temp[8];
                classParticipation = temp[9];
                temp0++;
            }
        }

        if (temp0 == 0){
            System.out.println("You Doesn't have Registered DSA");
        }
        return temp0;
    }




    public void printMarks() {
        if (getMarks() != 0) {
            for (int i = 0; i < getStudentNum(); i++) {
                if (super.regNo[i] == Integer.parseInt(this.RegistrationNum)) {
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.printf("║ %-42s ║%n", "           Marks Of " + super.FirstName[i] + " " + super.LastName[i]);
                    System.out.println("╠════════════════════════════════════════════╣");
                    System.out.printf("║ %-12s: %-28s ║%n", "Quiz - 1", quiz1);
                    System.out.printf("║ %-12s: %-28s ║%n", "Quiz - 2", quiz2);
                    System.out.printf("║ %-12s: %-28s ║%n", "Quiz - 3", quiz3);
                    System.out.printf("║ %-12s: %-28s ║%n", "Assignment", assignments);
                    System.out.printf("║ %-12s: %-28s ║%n", "Mid Term", mids);
                    System.out.printf("║ %-12s: %-28s ║%n", "Final Term", finals);
                    System.out.printf("║ %-12s: %-28s ║%n", "Presentation", presentation);
                    System.out.printf("║ %-12s: %-28s ║%n", "Project", project);
                    System.out.printf("║ %-12s: %-21s ║%n", "Class Participation", classParticipation);
                    System.out.println("╚════════════════════════════════════════════╝");
                }
            }
            System.out.println("Press Enter To Continue...");
        }


    }


    public void addMarksByTeacher(String teacherName,String pass){
        if(pass.compareTo(TeacherPas)==0) {
            Scanner sc = new Scanner(System.in);

            if (getMarks() != 0) {
                File file = new File("DSA.txt");

                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String temp0 = "";
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    String[] temp = str.split(",");


                    if (RegistrationNum.compareTo(temp[0]) != 0) {
                        quiz1 = temp[1];
                        quiz2 = temp[2];
                        quiz3 = temp[3];
                        project = temp[4];
                        mids = temp[5];
                        finals = temp[6];
                        assignments = temp[7];
                        presentation = temp[8];
                        classParticipation = temp[9];
                        temp0 = temp0 + temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "," + temp[6] + "," + temp[7] + "," + temp[8] + "," + temp[9] + "\n";
                    }
                }


                System.out.println("Press Number to Enter Marks of ");
                System.out.println("1. Quiz - 1 ");
                System.out.println("2. Quiz - 2 ");
                System.out.println("3. Quiz - 3 ");
                System.out.println("4. Assignment ");
                System.out.println("5. Mid Term ");
                System.out.println("6. Final Term");
                System.out.println("7. Project");
                System.out.println("8. Presentation ");
                System.out.println("9. Class Participation ");
                System.out.print("Input: ");
                int input = sc.nextInt();
                sc.nextLine();


                getMarks();
                switch (input) {
                    case 1: {
                        System.out.print("Quiz - 1 (out of 5): ");
                        quiz1 = sc.nextLine();

                        if (Integer.parseInt(quiz1) <= 5 && Integer.parseInt(quiz1) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks for Quiz");
                        }

                        break;
                    }
                    case 2: {
                        System.out.print("Quiz - 2 (out of 5): ");
                        quiz2 = sc.nextLine();

                        if (Integer.parseInt(quiz2) <= 5 && Integer.parseInt(quiz2) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Quiz");
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("Quiz - 3 (out of 5) : ");
                        quiz3 = sc.nextLine();

                        if (Integer.parseInt(quiz3) <= 5 && Integer.parseInt(quiz3) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Quiz");
                        }

                        break;
                    }
                    case 4: {
                        System.out.print("Assignment (out of 10): ");
                        assignments = sc.nextLine();

                        if (Integer.parseInt(assignments) <= 10 && Integer.parseInt(assignments) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Assignment");
                        }


                        break;
                    }
                    case 5: {
                        System.out.print("Mid Term (out of 20): ");
                        mids = sc.nextLine();


                        if (Integer.parseInt(mids) <= 20 && Integer.parseInt(mids) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println( teacherName + " It's Invalid Marks For Mid Term");
                        }
                        break;
                    }
                    case 6: {
                        System.out.print("Final Term (out of 35): ");
                        finals = sc.nextLine();

                        if (Integer.parseInt(finals) <= 35 && Integer.parseInt(finals) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Finals");
                        }
                        break;
                    }
                    case 7: {
                        System.out.print("Project (out of 15): ");
                        project = sc.nextLine();
                        if (Integer.parseInt(project) <= 15 && Integer.parseInt(project) >= 0) {
                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's  Invalid Marks For Project");
                        }
                        break;
                    }
                    case 8: {
                        System.out.print("Presentation (out of 5): ");
                        presentation = sc.nextLine();

                        if (Integer.parseInt(presentation) <= 5 && Integer.parseInt(presentation) >= 0) {
                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Presentation");
                        }

                        break;
                    }
                    case 9: {
                        System.out.print("Class Participation (out of 5): ");
                        classParticipation = sc.nextLine();

                        if (Integer.parseInt(classParticipation) <= 5 && Integer.parseInt(classParticipation) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSA.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + project + "," + mids + "," + finals + "," + assignments + "," + presentation + "," + classParticipation;

                            String marks = getRegistrationNo() + "," + temp;

                            String path = file.getAbsolutePath();

                            try {
                                Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                        }else {
                            System.out.println(teacherName + " It's Invalid Marks For Class Participation");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Invalid Input - !");
                    }


                }


            }


        }else {
            System.out.println("Wrong Password");
        }
    }

    public void GPA() {
        double total = 0;
        if (getMarks() != 0) {
            if (quiz1.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(quiz1);
            }
            if (quiz2.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(quiz2);
            }
            if (quiz3.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(quiz3);
            }
            if (assignments.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(assignments);
            }
            if (mids.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(mids);
            }
            if (finals.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(finals);
            }
            if (presentation.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(presentation);
            }
            if (project.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(project);
            }
            if (classParticipation.compareTo("Not Entered") != 0) {
                total = total + Integer.parseInt(classParticipation);
            }

            System.out.println("Total: " + total);
            double per = total;
            double GPA;

            if (per >= 90 && per <= 100) {
                GPA = 4.0;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: A+");
            } else if (per >= 85 && per < 90) {
                GPA = 3.75;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: A");
            } else if (per >= 80 && per < 85) {
                GPA = 3.5;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: A-");
            } else if (per >= 75 && per < 80) {
                GPA = 3.25;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: B+");
            } else if (per >= 70 && per < 75) {
                GPA = 3.0;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: B");
            } else if (per >= 66 && per < 70) {
                GPA = 2.75;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: B-");
            } else if (per >= 63 && per < 66) {
                GPA = 2.5;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: C+");
            } else if (per >= 60 && per < 63) {
                GPA = 2.0;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: C");
            } else if (per >= 55 && per < 60) {
                GPA = 1.5;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: C-");
            } else if (per >= 0 && per < 55) {
                GPA = 0.0;
                System.out.println("GPA: " + GPA);
                System.out.println("Grade: FAIL");
            } else {
                System.out.println("Invalid Input or Error !");
            }


        }


    }


            public int getAttendence(){
                File file = new File("DSAAttendence1.txt");
                int temp0 = 0;

                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                while(scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    String[] temp = str.split(",");
                    if (RegistrationNum.compareTo(temp[0])== 0) {
                        week[0] = temp[1];
                        week[1] = temp[2];
                        week[2] = temp[3];
                        week[3] = temp[4];
                        week[4] = temp[5];
                        week[5] = temp[6];
                        week[6] = temp[7];
                        week[7] = temp[8];
                        week[8] = temp[9];
                        week[9] = temp[10];
                        week[10] = temp[11];
                        week[11] = temp[12];
                        week[12] = temp[13];
                        week[13] = temp[14];
                        week[14] = temp[15];
                        week[15] = temp[16];
                        temp0++;
                    }
                }

                if (temp0 == 0){
                    System.out.println("You Doesn't have Registered DSA");
                }

                return temp0;

            }




            public void printAttendance(){

                if (getAttendence() != 0){
                    for (int i = 0; i < studentNum; i++) {
                        if (Integer.parseInt(RegistrationNum) == regNo[i]) {
                            System.out.println(FirstName[i] + " " + LastName[i] + "'s Attendance in DSA");

                            System.out.println("+-----------------+-------------+");
                            System.out.println("| Number of Week  | Attendance  |");
                            System.out.println("+-----------------+-------------+");
                            for (int j = 0; j < 16; j++) {
                                System.out.printf("| Week %-11d | %-11s |%n", j + 1, week[j]);
                            }
                            System.out.println("+-----------------+-------------+");
                        }
                    }
                    System.out.println("Press Enter To Continue...");



                }

            }


            public void addAttendanceByTeacher(String teacherName, String pass){
                int courseChosenStudents = 0;
                if(pass.compareTo(TeacherPas)==0) {
                    Scanner sc = new Scanner(System.in);
        
                    if (getAttendence() != 0) {
                        File file = new File("DSAAttendence1.txt");
        
                        Scanner scanner = null;
                        try {
                            scanner = new Scanner(file);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        String temp0 = "";
                        while (scanner.hasNextLine()) {
                            String str = scanner.nextLine();
                            String[] temp = str.split(",");
                            courseChosenStudents++;
        
                            if (RegistrationNum.compareTo(temp[0]) != 0) {
                                temp0 = temp0 + temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "," + temp[6] + "," + temp[7] + "," + temp[8] + "," + temp[9] + "," + temp[10] + "," + temp[11]+ "," + temp[12] + "," + temp[13] + "," + temp[14] + "," + temp[15] + "," + temp[16] + "\n";
                            }
                        }
                        String[] week1 = new String[100];
                        String[] week2 = new String[100];
                        String[] week3 = new String[100];
                        String[] week4 = new String[100];
                        String[] week5 = new String[100];
                        String[] week6 = new String[100];
                        String[] week7 = new String[100];
                        String[] week8 = new String[100];
                        String[] week9 = new String[100];
                        String[] week10 = new String[100];
                        String[] week11 = new String[100];
                        String[] week12 = new String[100];
                        String[] week13 = new String[100];
                        String[] week14 = new String[100];
                        String[] week15 = new String[100];
                        String[] week16 = new String[100];
                        int[] registNum = new int[courseChosenStudents];
        
        
                        try {
                            scanner = new Scanner(file);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
        
                        for (int i = 0; scanner.hasNextLine() ; i++) {
                            String str =  scanner.nextLine();
                            String[] temp = str.split(",");
                            registNum[i] = Integer.parseInt(temp[0]);
                            week1[i] = temp[1];
                            week2[i] = temp[2];
                            week3[i] = temp[3];
                            week4[i] = temp[4];
                            week5[i] = temp[5];
                            week6[i] = temp[6];
                            week7[i] = temp[7];
                            week8[i] = temp[8];
                            week9[i] = temp[9];
                            week10[i] = temp[10];
                            week11[i] = temp[11];
                            week12[i] = temp[12];
                            week13[i] = temp[13];
                            week14[i] = temp[14];
                            week15[i] = temp[15];
                            week16[i] = temp[16];
        
                        }
        
        
        
                        System.out.print("Enter Number of Week: ");
                        int input = sc.nextInt();
                        sc.nextLine();
        
        
        
                            switch (input) {
                                case 1: {
                                    System.out.println("Attendance Of Week - 1");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week1[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 2: {
                                    System.out.println("Attendance Of Week - 2");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week2[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 3: {
                                    System.out.println("Attendance Of Week - 3");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week3[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 4: {
                                    System.out.println("Attendance Of Week - 4");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week4[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 5: {
                                    System.out.println("Attendance Of Week - 5");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week5[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 6: {
                                    System.out.println("Attendance Of Week - 6");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week6[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 7:{
                                    System.out.println("Attendance Of Week - 7");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week7[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 8: {
                                    System.out.println("Attendance Of Week - 8");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week8[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 9: {
                                    System.out.println("Attendance Of Week - 9");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week9[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 10: {
                                    System.out.println("Attendance Of Week - 10");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week10[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 11: {
                                    System.out.println("Attendance Of Week - 11");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week11[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 12: {
                                    System.out.println("Attendance Of Week - 12");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week12[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 13: {
                                    System.out.println("Attendance Of Week - 13");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week13[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 14: {
                                    System.out.println("Attendance Of Week - 14");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week14[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 15: {
                                    System.out.println("Attendance Of Week - 15");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week15[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
        
                                case 16: {
                                    System.out.println("Attendance Of Week - 16");
                                    System.out.println();
                                    for (int i = 0; i < courseChosenStudents; i++) {
                                        for (int j = 0; j < getStudentNum(); j++) {
                                            if (registNum[i] == regNo[j]) {
                                                System.out.print(FirstName[j] + " " + LastName[j] + ": ");
                                                String temp3 = sc.nextLine();
        
                                                if (temp3.compareTo("Present")== 0 || temp3.compareTo("present")== 0 || temp3.compareTo("Absent")== 0 || temp3.compareTo("absent")== 0 || temp3.compareTo("Leave")== 0 || temp3.compareTo("leave")== 0 ) {
                                                    week16[i] = temp3;
                                                }else {
                                                    System.out.println("Invalid Input -  !");
                                                }
        
                                            }
                                        }
                                    }
                                    break;
                                }
                                default:{
                                    System.out.println("Invalid Week - !");
                                }
                            }
                            
        
                        String dataCollector = "";
        
                        for (int i = 0; i < courseChosenStudents ; i++) {
        
                            dataCollector = dataCollector + registNum[i] + "," + week1[i] + "," + week2[i] + "," + week3[i] + "," + week4[i] + "," + week5[i] + "," + week6[i] + "," + week7[i] + "," + week8[i] + "," + week9[i] + "," + week10[i] + "," + week11[i] + "," + week12[i] + "," + week13[i] + "," + week14[i] + "," + week15[i] + "," + week16[i];
                            if (courseChosenStudents-1 != i ){
                                dataCollector = dataCollector + "\n";
                            }
        
                        }
        
                        try {
                            FileWriter fileWriter = new FileWriter("DSAAttendence1.txt");
                            fileWriter.write(dataCollector);
                            fileWriter.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
        
        
                    }
        
        
                    }
                else {
                    System.out.println("Wrong Password");
                }
        
        
        
        
            }




public static void outline() {
        String teacherName = "Ayesha Ghayas";
        int creditHours = 3;
        String roomNumber = "50 - 99 Campus";
        String courseDay = "Tuesday";
        String[][] courseContent = {
            {"1", "Introduction to DSA", "Week 1"},
            {"2", "Arrays and Strings", "Week 2"},
            {"3", "Linked Lists", "Week 3"},
            {"4", "Stacks and Queues", "Week 4"},
            {"5", "Trees", "Week 5"},
            {"6", "Graphs", "Week 6"},
            {"7", "Sorting Algorithms", "Week 7"},
            {"8", "Searching Algorithms", "Week 8"},
            {"9", "Dynamic Programming", "Week 9"},
            {"10", "Hashing and Hash Tables", "Week 10"},
            {"11", "Recursion and Backtracking", "Week 11"},
            {"12", "Greedy Algorithms", "Week 12"},
            {"13", "Divide and Conquer", "Week 13"},
            {"14", "Complexity Analysis", "Week 14"},
            {"15", "Final Project Work", "Week 15"},
            {"16", "Final Exam Preparation", "Week 16"}
        };

        

        printCourseOutline(teacherName, creditHours, roomNumber, courseDay, courseContent);
    }

    public static void printCourseOutline(String teacherName, int creditHours, String roomNumber, String courseDay, String[][] courseContent) {
        String border = "===========================================================";
        String header = "DSA Course Outline";
        String divider = "-----------------------------------------------------------";
        
        
        int consoleWidth = 135;  
        int contentWidth = border.length(); 


        System.out.println(centerText(border, consoleWidth));
        System.out.println(centerText(header, consoleWidth));
        System.out.println(centerText(border, consoleWidth));

        System.out.println(centerText("Teacher's Name: " + teacherName, consoleWidth));
        System.out.println(centerText("Credit Hours: " + creditHours, consoleWidth));
        System.out.println(centerText("Room Number: " + roomNumber, consoleWidth));
        System.out.println(centerText("Course Day: " + courseDay, consoleWidth));
        System.out.println(centerText(border, consoleWidth));
        
        String tableHeader = String.format("| %-10s | %-30s | %-10s |", "Sr. No.", "Content", "Week");
        System.out.println(centerText(tableHeader, consoleWidth));
        System.out.println(centerText(divider, consoleWidth));

        for (String[] row : courseContent) {
            String tableRow = String.format("| %-10s | %-30s | %-10s |", row[0], row[1], row[2]);
            System.out.println(centerText(tableRow, consoleWidth));
        }

        System.out.println(centerText(border, consoleWidth));
    }

    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        if (padding < 0) padding = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            result.append(" ");
        }
        result.append(text);
        return result.toString();
    }





            












        }













class ProjectDSA extends DSA{

    ProjectDSA(int reg,String pass){
        super(reg,pass);
    }
    protected String project;
    protected String projectTitle;
    protected String projectMembers;

    public void setProjectDetails(){
        String temp0 = "";
        File file = new File("DSAProject.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                String[] temp = str.split(",");
                if (RegistrationNum.compareTo(temp[0]) != 0){
                    temp0 = temp0 + temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            FileWriter fileWriter = new FileWriter("DSAProject.txt");
            fileWriter.write(temp0);
            fileWriter.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        System.out.println("Enter Information of Project");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Project: ");
        project = sc.nextLine();
        System.out.print("Project Title: ");
        projectTitle = sc.nextLine();
        System.out.println("Project Members: (Please enter '/' between members) e.g (Muhammad Hasnain/Tahami Ishaq/Muhammad Hadi)");
        projectMembers = sc.nextLine();


        String temp = project + "," + projectTitle + "," + projectMembers;

        String marks = getRegistrationNo() + "," + temp;

        String path = file.getAbsolutePath();

        try {
            Files.write(Paths.get(path), marks.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }


    public int getProjectDetails(){
        int temp0 = 0;
        File file = new File("DSAProject.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String str = scanner.nextLine();
                String[] temp = str.split(",");
                if (RegistrationNum.compareTo(temp[0]) == 0){
                    project = temp[1];
                    projectTitle = temp[2];
                    projectMembers = temp[3];
                    temp0 = temp0 + 1;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (temp0 == 0){
            System.out.println("You doesn't have registered DSA");
        }
        return temp0;

    }


    public void printProjectDetails(){
        if (getProjectDetails() != 0){


            String border = "====================================";
            String header = "Project Information";
            String divider = "------------------------------------";

            System.out.println(border);
            System.out.println(centerText(header, border.length()));
            System.out.println(border);

            System.out.println(centerText("Project Name: " + project, border.length()));
            System.out.println(centerText("Project Title: " + projectTitle, border.length()));
            System.out.println(divider);

            System.out.println("          Project Members");
            String[] temp = projectMembers.split("/");

            for (String member : temp) {
                System.out.println(" - " + member);
            }

            System.out.println(border);
            System.out.println("Press Enter To Continue...");
        }

        }



    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            result.append(" ");
        }
        result.append(text);
        return result.toString();
    }














    }


















public class Main2 {
    public static void main(String[] args) {


        



        DSA dsa = new DSA(2380276, "abc.123");
        
        // dsa.addAttendanceByTeacher("bajc", "szabist zindabad");
        dsa.classSchedule(2380244);

    }


}


