import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class DSALab extends Course{
    protected static String teacher = "Sir Khalid Rasheed";
    protected String RegistrationNum;
    protected String quiz1 ;
    protected String quiz2;
    protected String quiz3;
    protected String quiz4;
    protected String project;
    protected String mids;
    protected String finals;
    protected String assignments1;
    protected String assignments2;
    protected String presentation;
    protected String classParticipation;

    protected static String Teacher = "Sir Khizer";
    protected static String TeacherPas = "szabist zindabad";

    protected String[] week = new String[16];

    public String getRegistrationNum() {
        return RegistrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        RegistrationNum = registrationNum;
    }

    DSALab(int regNo, String pass){
        super(regNo);
        setRegistrationNum(Integer.toString(regNo));
    }



    public int getMarks(){
        int temp0 = 0;
        File file = new File("DSALab.txt");

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
                quiz4 = temp[4];
                project = temp[5];
                mids = temp[6];
                finals = temp[7];
                assignments1 = temp[8];
                assignments2 = temp[9];
                presentation = temp[10];
                classParticipation = temp[11];
                temp0++;
            }
        }

        if (temp0 == 0){
            System.out.println("You Doesn't have Registered DSA - Lab");
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
                    System.out.printf("║ %-12s: %-28s ║%n", "Quiz - 4", quiz4);
                    System.out.printf("║ %-12s: %-26s ║%n", "Assignment - 1", assignments1);
                    System.out.printf("║ %-12s: %-26s ║%n", "Assignment - 2", assignments2);
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
                File file = new File("DSALab.txt");

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
                        quiz4 = temp[4];
                        project = temp[5];
                        mids = temp[6];
                        finals = temp[7];
                        assignments1 = temp[8];
                        assignments2 = temp[9];
                        presentation = temp[10];
                        classParticipation = temp[11];
                        temp0 = temp0 + temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "," + temp[6] + "," + temp[7] + "," + temp[8] + "," + temp[9] + "," + temp[10] + "," + temp[11] + "\n";
                    }
                }


                System.out.println("Press Number to Enter Marks of ");
                System.out.println("1. Quiz - 1 ");
                System.out.println("2. Quiz - 2 ");
                System.out.println("3. Quiz - 3 ");
                System.out.println("4. Quiz - 4 ");
                System.out.println("5. Assignment - 1 ");
                System.out.println("6. Assignment - 2 ");
                System.out.println("7. Mid Term ");
                System.out.println("8. Final Term");
                System.out.println("9. Project");
                System.out.println("10. Presentation ");
                System.out.println("11. Class Participation ");
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
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                        System.out.print("Quiz - 4 (out of 5) : ");
                        quiz4 = sc.nextLine();

                        if (Integer.parseInt(quiz4) <= 5 && Integer.parseInt(quiz4) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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


                    case 5: {
                        System.out.print("Assignment - 1 (out of 5): ");
                        assignments1 = sc.nextLine();

                        if (Integer.parseInt(assignments1) <= 5 && Integer.parseInt(assignments1) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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

                    case 6: {
                        System.out.print("Assignment - 2 (out of 5): ");
                        assignments2 = sc.nextLine();

                        if (Integer.parseInt(assignments2) <= 5 && Integer.parseInt(assignments2) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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


                    case 7: {
                        System.out.print("Mid Term (out of 20): ");
                        mids = sc.nextLine();


                        if (Integer.parseInt(mids) <= 20 && Integer.parseInt(mids) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                    case 8: {
                        System.out.print("Final Term (out of 35): ");
                        finals = sc.nextLine();

                        if (Integer.parseInt(finals) <= 35 && Integer.parseInt(finals) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                    case 9: {
                        System.out.print("Project (out of 15): ");
                        project = sc.nextLine();
                        if (Integer.parseInt(project) <= 15 && Integer.parseInt(project) >= 0) {
                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                    case 10: {
                        System.out.print("Presentation (out of 5): ");
                        presentation = sc.nextLine();

                        if (Integer.parseInt(presentation) <= 5 && Integer.parseInt(presentation) >= 0) {
                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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
                    case 11: {
                        System.out.print("Class Participation (out of 5): ");
                        classParticipation = sc.nextLine();

                        if (Integer.parseInt(classParticipation) <= 5 && Integer.parseInt(classParticipation) >= 0) {

                            try {
                                FileWriter fileWriter = new FileWriter("DSALab.txt");
                                fileWriter.write(temp0);
                                fileWriter.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            String temp = quiz1 + "," + quiz2 + "," + quiz3 + "," + quiz4  + "," + project + "," + mids + "," + finals + "," + assignments1 + "," + assignments2 + "," + presentation + "," + classParticipation;

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

    public void GPA(){
        double total = 0;
        if (getMarks() != 0) {
            if (quiz1.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(quiz1);
            }
            if (quiz2.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(quiz2);
            }
            if (quiz3.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(quiz3);
            }
            if (quiz4.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(quiz4);
            }
            if (assignments1.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(assignments1);
            }
            if (assignments2.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(assignments2);
            }
            if (mids.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(mids);
            }
            if (finals.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(finals);
            }
            if (presentation.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(presentation);
            }
            if (project.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(project);
            }
            if (classParticipation.compareTo("Not Entered")!= 0){
                total = total + Integer.parseInt(classParticipation);
            }

            System.out.println("Total: " + total);
            double per = total;
            double GPA;

            if(per >= 90 && per <= 100){
                GPA = 4.0;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: A+");
            }
            else if(per >= 85 && per < 90){
                GPA = 3.75;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: A");
            }
            else if(per >= 80 && per < 85){
                GPA = 3.5;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: A-");
            }
            else if(per >= 75 && per < 80){
                GPA= 3.25;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: B+");
            }
            else if(per >= 70 && per < 75){
                GPA = 3.0;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: B");
            }
            else if(per >=66 && per < 70){
                GPA = 2.75;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: B-");
            }
            else if(per >= 63 && per < 66 ){
                GPA = 2.5;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: C+");
            }
            else if(per >= 60 && per < 63){
                GPA = 2.0;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: C");
            }
            else if(per >= 55 && per < 60){
                GPA = 1.5;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: C-");
            }
            else if(per >= 0 && per < 55){
                GPA = 0.0;
                System.out.println("GPA: "+ GPA);
                System.out.println("Grade: FAIL");
            }
            else{
                System.out.println("Invalid Input or Error !");
            }



        }

    }





    public int getAttendence(){
        File file = new File("DSALabAttendence.txt");
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
            System.out.println("You Doesn't have Registered DSA - Lab");
        }

        return temp0;

    }




    public void printAttendance(){

        if (getAttendence() != 0){
            for (int i = 0; i < studentNum; i++) {
                if (Integer.parseInt(RegistrationNum) == regNo[i]) {
                    System.out.println(FirstName[i] + " " + LastName[i] + "'s Attendance in DSA - Lab");

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
                File file = new File("DSALabAttendence.txt");

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
                    FileWriter fileWriter = new FileWriter("DSALabAttendence.txt");
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
        
        String teacherName = "Danish Shehzad";
        int creditHours = 1;  
        String roomNumber = "Smart-Lab - 100 Campus";
        String courseDay = "Friday";
        String[][] courseContent = {
            {"1", "Introduction to Data St & IDE Setup", "Week 1"},
            {"2", "Practical on Arrays and Linked Lists", "Week 2"},
            {"3", "Lab Exercise on Stacks and Queues", "Week 3"},
            {"4", "Recursive Functions Implementation", "Week 4"},
            {"5", "Tree Structure Implementation", "Week 5"},
            {"6", "Graph Traversal Algorithms", "Week 6"},
            {"7", "Hashing Techniques Practical", "Week 7"},
            {"8", "Sorting Algorithms Implementation", "Week 8"},
            {"9", "Searching Algorithms Lab", "Week 9"},
            {"10", "Dynamic Programming Problems", "Week 10"},
            {"11", "Greedy Algorithms Implementation", "Week 11"},
            {"12", "Final Project Discussion and Planning", "Week 12"},
            {"13", "Advanced Tree Operations", "Week 13"},
            {"14", "Graph Algorithms (Advanced)", "Week 14"},
            {"15", "Complexity Analysis and Optimization", "Week 15"},
            {"16", "Final Project Submission & Presentation", "Week 16"}
        };
        printCourseOutline(teacherName, creditHours, roomNumber, courseDay, courseContent);
    }
    
    public static void printCourseOutline(String teacherName, int creditHours, String roomNumber, String courseDay, String[][] courseContent) {
        String border = "===========================================================";
        String header = "DSA Lab Course Outline";
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
        
        String tableHeader = String.format("| %-10s | %-40s | %-10s |", "Sr. No.", "Lab Content", "Week");
        System.out.println(centerText(tableHeader, consoleWidth));
        System.out.println(centerText(divider, consoleWidth));
    
        for (String[] row : courseContent) {
            String tableRow = String.format("| %-10s | %-40s | %-10s |", row[0], row[1], row[2]);
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


class ProjectDSALab extends DSALab{

    ProjectDSALab(int reg,String pass){
        super(reg,pass);
    }
    protected String project;
    protected String projectTitle;
    protected String projectMembers;

    public void setProjectDetails(){
        String temp0 = "";
        File file = new File("DSALabProject.txt");
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
            FileWriter fileWriter = new FileWriter("DSALabProject.txt");
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
        File file = new File("DSALabProject.txt");
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
            System.out.println("You doesn't have registered DSA Lab");
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




