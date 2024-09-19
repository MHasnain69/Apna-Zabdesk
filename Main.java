/*
import javax.sound.midi.Soundbank;
import java.util.*;


class Project{
    int course;
    String projectTitle;
    private String projectMembers;
    int projectSize;

    private String projectInfo;


    public void print(){
        System.out.print("Project Title: ");
        System.out.println(projectTitle);
        System.out.print("Number of Project Members: ");
        System.out.println(projectSize);

        if (projectMembers != null  && projectInfo != null ){

            System.out.print("Project Members: ");
            System.out.println(projectMembers);
            System.out.print("Project Information: ");
            System.out.println(projectInfo);

        }

    }

    Project(int cousre){
        switch (cousre){
            case 1:{
                projectTitle = "Software Tutorial";
                projectSize = 3;
                break;
            }
            case 2:{
                projectTitle = "Hackathon ";
                projectSize = 1;
                break;
            }
            case 3:{
                projectTitle = "Hackathon";
                projectSize = 1;
                break;
            }
            case 4:{
                projectTitle = "3 - Skits Related to Organization Behavior";
                projectSize = 4;
                break;
            }
            case 5:{
                projectTitle = "Role Play";
                projectSize = 4;
                break;
            }
            case 6:{
                projectTitle = "Collect Responses";
                projectSize = 4;
                break;
            }
            default:{
                System.out.println("Invalid Course");
            }

        }



    }

    public String getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(String projectMembers) {
        this.projectMembers = projectMembers;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }

    public String getProjectInfo() {
        return projectInfo;
    }
}



class SZABIST {

    // Data Require for Both (Students and Faculty)
    int regNo;
    String name;

    String prgram;

    public void WelcomeMessage(){
        System.out.println("Welcome to SZABIST University");
    }
    public void start(){
        System.out.println("Please Enter Your Information");
    }


}



class Students extends SZABIST{
    // Data of Student
    int semester;
    double CGPA;



    Students(String name,int regNo,int semester,double CGPA,String prgram){
        // Constructor taking and Assigning the Data of Student
        this.name = name;
        this.CGPA = CGPA;
        this.prgram = prgram;
        this.regNo = regNo;



    }


    public int menu(){
        // Menu for performing tasks for students
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + name + "! Welcome to this awesome code.");
        System.out.println("Tasks as a Student");
        System.out.println("1. Calculate Days Remaining in University");
        System.out.println("2. Check Your Grade");
        System.out.println("3. Calculate Your Result(Only for BSSE 1st Semester)");
        System.out.println("4. Class Schedule");
        System.out.println("5. Exams Date");
        System.out.println("6. Project");
        System.out.println("7. Gaming Section");
        System.out.println("8. Actual Calculator");

        System.out.println("10. Exit");

        System.out.print("Input: ");
        int temp = sc.nextInt();

        return temp;





    }






    public void daysCount(int semester){
        // Function used to count remaining day in university
        String temp = " ";


        temp += prgram.charAt(0);


        if(temp.compareTo(" B") == 0) {
            int temp1 = 0;

            temp1 = temp1 + 8;
            temp1 = temp1 - semester;
            temp1++;


            System.out.print("Remaining Days in SZABIST:  ");

            System.out.println(temp1 * 182.5);




        }
        else if(temp.compareTo(" M") == 0){

            int temp1 = 0;

            temp1 = temp1 + 4;
            temp1 = temp1 - semester;
            temp1++;


            System.out.print("Remaining Days in SZABIST:  ");

            System.out.println(temp1 * 182.5);



        }
        else if (temp.compareTo(" P") == 0) {

            int temp1 = 0;

            temp1 = temp1 + 6;
            temp1 = temp1 - semester;
            temp1++;


            System.out.print("Remaining Days in SZABIST:  ");

            System.out.println(temp1 * 182.5);

        }
        else{
            System.out.println("Invalid Program ! / dekh kar program daal");
        }
        System.out.println();








    }


    public void exam(){
        // Exams , Dead Week Date

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose One: ");
        System.out.print("(Midterm / Final / Dead Week):  ");
        String exam = sc.nextLine();

        if(exam.compareTo("Midterm") == 0 || exam.compareTo("midterm") == 0 || exam.compareTo("Mid") == 0 || exam.compareTo("mid") == 0){
            System.out.println();
            System.out.print("Midterm Exams Date: ");
            System.out.println("3rd April 2024  - 8th April 2024 ");
            System.out.println();

        }
        else if (exam.compareTo("Final") == 0 || exam.compareTo("final") == 0) {
            System.out.println();
            System.out.print("Final Exams Date: ");
            System.out.println("5th June 2024 - 18th June 2024");
            System.out.println();

        }
        else if (exam.compareTo("dead week") == 0 || exam.compareTo("Dead Week") == 0 || exam.compareTo("Dead week") == 0 || exam.compareTo("dead Week") == 0) {

            System.out.println();
            System.out.print("Dead Week Date: ");
            System.out.println("29th May 2024 - 4th June 2024");
            System.out.println();
        }
        else{
            System.out.println("Invalid Choice");
            System.out.println();
        }


    }





    public void result(){

        // To Calculate Your GPA

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Result Calculator");
        System.out.println("For BSSE ");

        System.out.println("Now Enter Marks For 3  Weightage Subject");
        System.out.println();
        System.out.print("English: ");
        float eng = sc.nextFloat();
        System.out.print("FOP  Theory: ");
        float Fop_Th = sc.nextFloat();
        System.out.print("Calculus: ");
        float Cal = sc.nextFloat();
        System.out.println();

        System.out.println("Now Enter Marks For 2  Weightage Subject");
        System.out.println();
        System.out.print("Physics Theory: ");
        float Phys_Th = sc.nextFloat();
        System.out.print("ITC Theory: ");
        float ITC_Th = sc.nextFloat();
        System.out.print("Pak Studies: ");
        float Pak = sc.nextFloat();
        System.out.println();

        System.out.println("Now Enter Marks For 1  Weightage Subject");
        System.out.println();
        System.out.print("FOP Lab: ");
        float Fop_lab = sc.nextFloat();
        System.out.print("Physics Lab: ");
        float Phy_lab = sc.nextFloat();
        System.out.print("ITC Lab: ");
        float ITC_lab = sc.nextFloat();
        System.out.println();

        float sum1 = Fop_lab + Phy_lab + ITC_lab;
        float sum2 = Phys_Th + ITC_Th + Pak;
        float sum3 = Cal + eng + Fop_Th;

        sum1 /= 3;
        sum2 /= 2;
        float sum  = sum1 + sum2 + sum3;
        float avg = sum / 550;
        float per = avg *100;

        System.out.println("Percentage: "+ per);
        System.out.println();

        double GPA;

        if(per >= 90 && per <= 100){
            GPA = 4.0;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: A+");
        }
        else if(per >= 85 && per < 90){
            GPA = 3.75;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: A");
        }
        else if(per >= 80 && per < 85){
            GPA = 3.5;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: A-");
        }
        else if(per >= 75 && per < 80){
            GPA= 3.25;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: B+");
        }
        else if(per >= 70 && per < 75){
            GPA = 3.0;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: B");
        }
        else if(per >=66 && per < 70){
            GPA = 2.75;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: B-");
        }
        else if(per >= 63 && per < 66 ){
            GPA = 2.5;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: C+");
        }
        else if(per >= 60 && per < 63){
            GPA = 2.0;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: C");
        }
        else if(per >= 55 && per < 60){
            GPA = 1.5;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: C-");
        }
        else if(per >= 0 && per < 55){
            GPA = 0.0;
            System.out.println("CGPA: "+ GPA);
            System.out.println("Grade: FAIL");
        }
        else{
            System.out.println("Invalid Input or Error !");
        }











    }



    public void grade(){

        // To Get Your Grade

        if(CGPA >= 4.00 && CGPA <= 4.00){
            System.out.println("Grade: A+");

        }
        else if(CGPA >= 3.75 && CGPA < 4.00){
            System.out.println("Grade: A");

        }
        else if(CGPA >= 3.50 && CGPA < 3.75){
            System.out.println("Grade: A-");


        }
        else if(CGPA >= 3.25 && CGPA < 3.50){
            System.out.println("Grade: B+");

        }
        else if(CGPA >= 3.00 && CGPA < 3.25){
            System.out.println("Grade: B");
        }
        else if(CGPA >= 2.75 && CGPA < 3.00){

            System.out.println("Grade: B-");
        }
        else if(CGPA >= 2.50 && CGPA < 2.75){

            System.out.println("Grade: C+");
        }
        else if(CGPA >= 2.00 && CGPA < 2.50){

            System.out.println("Grade: C");
        }
        else if(CGPA >= 1.5 && CGPA < 2.0){

            System.out.println("Grade: C-");
        }
        else if(CGPA >= 0.00 && CGPA < 1.50){

            System.out.println("Grade: FAIL");
        }
        else{
            System.out.println("Invalid Input or Error !");
        }










    }




    public void student(){

        // A Message on their Degree

        String temp = " ";

        temp += prgram.charAt(0);


        if(temp.compareTo(" B") == 0) {

            System.out.println("Hope You are enjoying your 4 years journey in SZABIST");
            System.out.println();
            System.out.println("Embarking on your Bachelor's journey is a significant milestone filled with opportunities for growth and learning. Wishing you an enriching and rewarding experience as you delve into your academic pursuits");
        }
        else if(temp.compareTo(" M") == 0){

            System.out.println("As you commence your Master's journey, may each lecture be enlightening, every assignment be a step towards expertise, and every challenge be an opportunity for growth. Embrace the depth of knowledge and the camaraderie of academia. Best of luck on this exciting chapter of your academic pursuit. Your dedication is commendable, and your success is inevitable!");
            System.out.println();

            System.out.println("Hope Your Masters Degree Will Help in your Career");

        }
        else if (temp.compareTo(" P") == 0) {

            System.out.println("Embarking on the challenging yet incredibly rewarding journey of pursuing a Ph.D. is a testament to your dedication and passion for knowledge. May your research be groundbreaking, your insights profound, and your academic journey fulfilling. Wishing you perseverance, inspiration, and the joy that comes with pushing the boundaries of understanding. Here's to a successful and enriching Ph.D. journey!");
            System.out.println();

        }
        else{
            System.out.println("Invalid Program ! / dekh kar program daal");
        }
        System.out.println();


    }






    public void ClassSchedule(){
        // Class Schedule

        Scanner sc = new Scanner(System.in);

        int nnn = 0; // use to count number of changes in Schedule

        // used for that days that have no changes in Current Schedule
        int tempMon = 0;
        int tempTues = 0;
        int tempWed = 0;
        int tempThurs = 0;
        int tempFri = 0;
        int tempSat = 0;

        String monday = "No Class";
        String monTime = "N/A";

        String Tuesday = "Object Oriented Programming (OPP) Lab";
        String tuesTime = "3:00 - 6:00";

        String Wednesday = "Software Engineering";
        String wedTime = "11:30 - 2:30";

        String Thursday = "Communication Presentation Skills (CPS) , Organizational Behaviour(OB)";
        String thursTime = "3:00 - 6:00 ,                            6:30 - 9:00";

        String Friday = "Object Oriented Programming (OPP) Theory, Islamiyat";
        String friTime = "9:00 - 12:00 ,                           3:00 - 6:00";

        String Saturday = "Discrete Mathematics";
        String satTime = "11:30 - 2:30";



        System.out.print("Do You want add any Changes to your current Schedule: ");
        String changes = sc.nextLine();

        if(changes.compareTo("No") == 0 || changes.compareTo("no") == 0) {

            monday = "No Class";
            monTime = "N/A";

            Tuesday = "Object Oriented Programming (OPP) Lab";
            tuesTime = "3:00 - 6:00";

            Wednesday = "Software Engineering";
            wedTime = "11:30 - 2:30";

            Thursday = "Communication Presentation Skills (CPS) , Organizational Behaviour(OB)";
            thursTime = "3:00 - 6:00 ,                            6:30 - 9:00";

            Friday = "Object Oriented Programming (OPP) Theory, Islamiyat";
            friTime = "9:00 - 12:00 ,                           3:00 - 6:00";

            Saturday = "Discrete Mathematics";
            satTime = "11:30 - 2:30";

        }
        else if(changes.compareTo("yes") == 0 || changes.compareTo("Yes") == 0) {

            do {

                System.out.print("Day you want to change: ");
                String changes0 = sc.nextLine();

                if (changes0.compareTo("Monday") == 0 || changes0.compareTo("monday") == 0) {

                    System.out.print("Monday Classes: ");
                    monday = sc.nextLine();

                    System.out.print("Monday Class Timing: ");
                    monTime = sc.nextLine();
                    tempMon++;

                } else if (changes0.compareTo("Tuesday") == 0 || changes0.compareTo("tuesday") == 0) {

                    System.out.print("Tuesday Classes: ");
                    Tuesday = sc.nextLine();

                    System.out.print("Tuesday Class Timing: ");
                    tuesTime = sc.nextLine();

                    tempTues++;

                } else if (changes0.compareTo("Wednesday") == 0 || changes0.compareTo("wednesday") == 0) {

                    System.out.print("Wednesday Classes: ");
                    Wednesday = sc.nextLine();

                    System.out.print("Wednesday Class Timing: ");
                    wedTime = sc.nextLine();

                    tempWed = tempWed + 1;

                } else if (changes0.compareTo("Thursday") == 0 || changes0.compareTo("thursday") == 0) {

                    System.out.print("Thursday Classes: ");
                    Thursday = sc.nextLine();

                    System.out.print("Thursday Class Timing: ");
                    thursTime = sc.nextLine();

                    tempThurs++;
                } else if (changes0.compareTo("Friday") == 0 || changes0.compareTo("friday") == 0) {

                    System.out.print("Friday Classes: ");
                    Friday = sc.nextLine();

                    System.out.print("Friday Class Timing: ");
                    friTime = sc.nextLine();

                    tempFri++;

                } else if (changes0.compareTo("Saturday") == 0 || changes0.compareTo("saturday") == 0) {

                    System.out.print("Saturday Classes: ");
                    Saturday = sc.nextLine();

                    System.out.print("saturday Class Timing: ");
                    satTime = sc.nextLine();

                    tempSat++;

                } else if (changes0.compareTo("Sunday") == 0 || changes0.compareTo("sunday") == 0) {

                    System.out.println("Choro Sunday ki Classes Ko");

                } else {
                    System.out.println("Invalid Day");

                }


                System.out.print("Do you want to do more changes: ");
                String nn = sc.nextLine();

                if (nn.compareTo("Yes") == 0 || nn.compareTo("yes") == 0) {
                    nnn = 0;
                }
                else if (nn.compareTo("No") == 0 || nn.compareTo("no") == 0) {
                    nnn = 1;
                }


            }while (nnn != 1);






        }


        if (tempMon == 0 ){

            monday = "No Class";
            monTime = "N/A";
        }
        else if (tempTues == 0) {

            Tuesday = "Object Oriented Programming (OPP) Lab";
            tuesTime = "3:00 - 6:00";

        }
        else if (tempWed == 0) {

            Wednesday = "Software Engineering";
            wedTime = "11:30 - 2:30";
        }
        else if (tempThurs == 0) {

            Thursday = "Communication Presentation Skills (CPS) , Organizational Behaviour(OB)";
            thursTime = "3:00 - 6:00 ,                            6:30 - 9:00";
        }
        else if (tempFri == 0) {

            Friday = "Object Oriented Programming (OPP) Theory, Islamiyat";
            friTime = "9:00 - 12:00 ,                           3:00 - 6:00";

        }
        else if (tempSat == 0) {

            Saturday = "Discrete Mathematics";
            satTime = "11:30 - 2:30";

        }

        System.out.print("Day's Schedule you want: ");
        String day = sc.nextLine();



        if (day.compareTo("Monday")== 0 || day.compareTo("monday")== 0){

            System.out.println("Classes on Monday");

            System.out.println("Class: " + monday);
            System.out.println("Timing: " + monTime);


        }
        else if (day.compareTo("Tuesday") == 0 || day.compareTo("tuesday") == 0) {

            System.out.println("Classes on Tuesday");

            System.out.println("Class: " + Tuesday);
            System.out.println("Timing: " + tuesTime);

        }
        else if (day.compareTo("Wednesday") == 0 || day.compareTo("wednesday") == 0) {

            System.out.println("Classes on Wednesday");

            System.out.println("Class: " + Wednesday);
            System.out.println("Timing: " + wedTime);

        }
        else if (day.compareTo("Thursday") == 0 || day.compareTo("thursday") == 0) {

            System.out.println("Classes on Thursday");

            System.out.println("Class: " + Thursday);
            System.out.println("Timing: " + thursTime);

        }
        else if (day.compareTo("Friday") == 0 || day.compareTo("friday") == 0) {

            System.out.println("Classes on Friday");

            System.out.println("Class: " + Friday);
            System.out.println("Timing: " + friTime);

        }
        else if (day.compareTo("Saturday") == 0 || day.compareTo("saturday") == 0) {

            System.out.println("Classes on Saturday");

            System.out.println("Class: " + Saturday);
            System.out.println("Timing: " + satTime);

        }
        else if (day.compareTo("Sunday") == 0 || day.compareTo("sunday") == 0) {

            System.out.println("Sunday ko bhi Chutti nhi hai ?");

        }
        else {
            System.out.println("Invalid Day");
        }





    }



    public void GameMenu(){
        System.out.println("1. Rock Paper Scissors");
        System.out.println("2. Tic Tac Toe ");
        System.out.println("3. Snake Game");
        System.out.println("4. Exit To Main Menu");
    }














    public void project(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Courses");
        System.out.println("Software Engineering - 1");
        System.out.println("Object Oriented Programming - 2");
        System.out.println("Object Oriented Programming Lab - 3");
        System.out.println("Organizational Behavior - 4");
        System.out.println("Communication Presentation Skills - 5");
        System.out.println("Discrete Mathematics - 6");
        System.out.println();
        System.out.println("Choose Course: ");
        int course = sc.nextInt();

        switch (course){

            case 1:{
                Project softwareEng = new Project(1);
                softwareEng.setProjectMembers( this.name + " , Mohibba Fatima Khan");
                softwareEng.setProjectInfo("Asana Software Tutorial and Simulation");
                softwareEng.print();
                break;
            }
            case 2:{
                Project OPPth = new Project(2);
                OPPth.setProjectMembers(this.name);
                OPPth.setProjectInfo("Task will be Assign by Sir Khalid ");
                OPPth.print();
                break;
            }
            case 3:{
                Project OPPlab = new Project(3);
                OPPlab.setProjectInfo("Same As Sir Khalid");
                OPPlab.setProjectMembers(this.name);
                OPPlab.print();
                break;
            }
            case 4:{
                Project OB = new Project(4);
                OB.setProjectMembers(this.name +  " , Rabi Khan , Rohaan Ali , Iqra Qasim");
                OB.setProjectInfo("Office Politics , Gender Discrimination , Maslow’s Hierarchy");
                OB.print();
                break;
            }
            case 5:{
                Project CPS = new Project(5);
                CPS.setProjectInfo("Vlogging / Ad Shoot / Acting ");
                CPS.setProjectMembers(this.name +   " , Iqra Qasim , Rohaan Ali , Mehmood Rashid , Junaid Waqar");
                CPS.print();
                break;
            }
            case 6:{
                Project DMS = new Project(6);
                DMS.setProjectMembers(this.name + " , Rabi Khan , Iqra Qasim");
                DMS.setProjectInfo("150 - Responses ");
                DMS.print();
                break;
            }
            default:{
                System.out.println("Inavlid Course");
            }


        }

















    }













    public void extra_feed(){

        // Used to provide a menu for feedback

        System.out.println();

        System.out.println("Please give your Feedback in one word");
        System.out.println("Best");
        System.out.println("Good");
        System.out.println("Average");
        System.out.println("Worst");
        System.out.println("Not interested");
        System.out.println("(Please Give Input using Same Words)");
        System.out.println();
    }
    public void student(String feedback){

        // Used to take Feedback

        if (feedback.compareTo("Good") == 0 || feedback.compareTo("good") == 0 ){
            System.out.println("We are glad to hear that you think the university is good! It's important to have a positive experience.");
        }
        else if (feedback.compareTo("best") == 0 || feedback.compareTo("Best") == 0) {
            System.out.println("Wow! It's fantastic to hear that you consider the university the best. That's quite an accomplishment!");
            System.out.println();
            System.out.println("Wese esaa kiya dekh gaya SZABIST mai ?");

        }
        else if (feedback.compareTo("Average") == 0 || feedback.compareTo("average") == 0) {
            System.out.println("Theek Hai");

        }
        else if(feedback.compareTo("Worst") == 0 || feedback.compareTo("worst") == 0){
            System.out.println("We're sorry to hear that you feel this way. Your feedback is valuable, and we appreciate your honesty.");

        }
        else if (feedback.compareTo("Not") == 0 || feedback.compareTo("Not interested") == 0 || feedback.compareTo("not") == 0 || feedback.compareTo("not Interested") == 0 ) {
            System.out.println("Phir phele Yes kyu bola ?");

        }
        else {
            System.out.println("Please Dekh kar Feedback de");
        }

        System.out.println();
    }









}

class Faculty extends SZABIST{
    Double salary;
    int rank;

    int[] attendence;


    public int menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + name + "! Welcome to this awesome code.");
        System.out.println("Tasks as a Faculty");
        System.out.println("1. Take Attendance");
        System.out.println("2. View Attendance ");



        System.out.println("4. Exit");

        System.out.print("Input: ");
        int temp = sc.nextInt();

        return temp;





    }








    public void takeAttendence(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Students: ");
        int students = sc.nextInt();
        int temp = 1;
        attendence = new int[students];

        System.out.println("If student is present press 1 or press 0 if student is absent");

        for (int i = 0; i < students; i++) {

            System.out.print("Student - " + temp + " : " );
            attendence[i] = sc.nextInt();
            temp++;
        }






    }


    public void printAtttendence(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Students: ");
        int students = sc.nextInt();
        int temp = 1;

        for (int i = 0; i < students; i++) {

            System.out.println("Student - " + temp + ": " + attendence[i]);
            temp++;
        }








    }




















}








public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("                                                                                Welcome to SZABIST University");

        System.out.println("Student / Faculty (Choose one)");
        System.out.print("Input: ");
        String choice = sc.nextLine();
        int input;



        if (choice.compareTo("Student") == 0 || choice.compareTo("student") == 0) { //student


            // Taking Info

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Registration Number: ");
            int reg = sc.nextInt();
            System.out.print("Degree: ");
            String program = sc.next();
            System.out.print("Semester: ");
            int semester = sc.nextInt();
            System.out.print("CGPA: ");
            double CGPA = sc.nextDouble();


            System.out.println();


            Students student = new Students(name, reg, semester, CGPA, program);


            // Starting of code





            student.student(); // a reply on your Degree

            do {

                input = student.menu();




                switch (input) {

                    // Days Remaining
                    case 1: {
                        student.daysCount(semester);
                        System.out.println();
                        break;

                    }

                    // Grade
                    case 2: {
                        student.grade();
                        System.out.println();
                        break;
                    }

                    // Result
                    case 3: {
                        student.result();
                        System.out.println();
                        break;
                    }
                    // Class Schedule
                    case 4: {

                        student.ClassSchedule();
                        System.out.println();
                        break;
                    }
                    // Exams Date
                    case 5: {
                        student.exam();
                        break;
                    }
                    case 6:{
                        System.out.println();
                        student.project();
                        System.out.println();
                        break;
                    }
                    case 7: {
                        System.out.println();

                        student.GameMenu();
                        int input0 = 0;

                        do {
                            System.out.print("Input: ");
                            input0 = sc.nextInt();

                            if (input0 == 1) {
                                RockPaperSessisors RPS = new RockPaperSessisors(student.name);
                                RPS.compare();
                            } else if (input0 == 2) {
                                TicTacToe TTT = new TicTacToe();
                                TTT.PlayGame();
                            } else if (input0 == 3) {
                                Snake S = new Snake();
                                S.PlayGame();
                            } else if (input0 == 4) {
                                System.out.println("Back To Main Menu");
                            } else {
                                System.out.println("Invalid Number!");
                            }
                        }while (input0 != 4);
                        break;
                    }
                    case 8:{
                        System.out.println();
                        ActualCalculator AC = new ActualCalculator();
                        AC.Play();
                        break;
                    }

                    case 10:{
                        System.out.println("Thanks For Using");
                        break;
                    }


                    // Error Message
                    default: {
                        System.out.println("Dekh kar number daal");
                    }
                }
            } while (input != 10);


            // Feedback Side
            System.out.print("Do you want to give Feedback: ");
            String feedback0 = sc.next();

            if (feedback0.compareTo("Yes") == 0 || feedback0.compareTo("yes") == 0) {

                student.extra_feed();


                String feedback = sc.next();

                student.student(feedback);


            } else {
                System.out.println("ThankYou for Using Our Software");
            }

        }// Student
        else if (choice.compareTo("Faculty")== 0 || choice.compareTo("faculty")== 0) { //Faculty
            Faculty faculty = new Faculty();

            // Taking Info of Faculty
            System.out.print("Name: ");
            faculty.name = sc.nextLine();

            System.out.print("Registration Number: ");
            faculty.regNo = sc.nextInt();

            System.out.print("Program: ");
            faculty.prgram = sc.next();

            System.out.print("Rank: ");
            faculty.rank = sc.nextInt();

            System.out.print("Salary: ");
            faculty.salary = sc.nextDouble();


            do {


                input = faculty.menu();


                switch (input){
                    case 1:{
                        faculty.takeAttendence();
                        System.out.println();
                        break;
                    }
                    case 2:{
                        faculty.printAtttendence();
                        System.out.println();
                        break;
                    }
                    case 3:{

                        break;
                    }
                    case 4:{
                        System.out.println("Thanks For Using");
                        break;
                    }
                    default:{
                        System.out.println("Invalid Input");
                    }






                }// Switch Ending




            }while (input != 4);








        }// Faculty
        else {
            System.out.println("Invalid Choice !");
        }


    }

}







*/
