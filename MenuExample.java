import javax.print.DocFlavor.STRING;
import javax.print.attribute.HashAttributeSet;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;


class StylishMenuExample implements ActionListener {
    static String password0;
    static String regNo;
    JButton buttonLogin = new JButton("Login");
    JTextField UserBox = new JTextField();
    JPasswordField PassBox = new JPasswordField();
    JButton buttonForPass = new JButton("Forgot Password");
    JProgressBar jProgressBar = new JProgressBar();
    JComboBox<String> jComboBox;
    boolean userTyped = false;
    boolean passTyped = false;
    int temp = 0;
    final Object lock = new Object();
    JFrame jFrame = new JFrame("Apna ZABDESK");
    public void MyFrame2() {

        jFrame.setSize(500, 550);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("Logo.png");

        Image image = imageIcon.getImage();

        Image resizedImage = image.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon readyIcon = new ImageIcon(resizedImage);

        JLabel jlabel = new JLabel(readyIcon);

        jlabel.setBounds(140, 4, 200, 80);
        jFrame.add(jlabel);
        jFrame.setIconImage(readyIcon.getImage());

        JLabel label = new JLabel("Login Page", SwingConstants.CENTER);

        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(12, 84, 163));
        label.setOpaque(true);
        label.setBounds(0, 90, 500, 50);
        jFrame.add(label);

        JPanel jPanelWhite = new JPanel();

        jPanelWhite.setBackground(Color.GRAY);
        jPanelWhite.setBounds(90, 180, 300, 40);
        JLabel jlabelUserID = new JLabel("User ID");
        jlabelUserID.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jlabelUserID.setForeground(Color.WHITE);
        jPanelWhite.add(jlabelUserID);
        jFrame.add(jPanelWhite);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        UserBox.setBounds(90, 230, 300, 40);
        UserBox.setBackground(Color.WHITE);
        UserBox.setBorder(border);
        UserBox.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        
        jFrame.add(UserBox);

        
        UserBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBarForUserBox();
            }

            private void updateProgressBarForUserBox() {
                if (!userTyped) {
                    userTyped = true;
                    temp += 25;
                    jProgressBar.setValue(temp);
                    jProgressBar.setString("User ID Started");
                }
            }
        });


        JPanel jPanelPass = new JPanel();

        jPanelPass.setBackground(Color.GRAY);
        jPanelPass.setBounds(90, 290, 300, 40);
        JLabel jLabelPass = new JLabel("Password");

        jLabelPass.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jLabelPass.setForeground(Color.WHITE);
        jPanelPass.add(jLabelPass);

        jFrame.add(jPanelPass);


        PassBox.setBounds(90, 340, 300, 40);
        PassBox.setBackground(Color.WHITE);
        PassBox.setBorder(border);
        PassBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        PassBox.setEchoChar('●');

        jFrame.add(PassBox);


        PassBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateProgressBarForPassBox();
            }

            private void updateProgressBarForPassBox() {
                if (!passTyped) {
                    passTyped = true;
                    temp += 25;
                    jProgressBar.setValue(temp);
                    jProgressBar.setString("Password Started");
                }
            }
        });



        buttonLogin.setBounds(90, 440, 120, 30);
        buttonLogin.setBackground(new Color(12, 84, 163));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setFocusable(false);
        buttonLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonLogin.addActionListener(this);
        
        jFrame.add(buttonLogin);

        
        buttonForPass.setBounds(220, 440, 170, 30);
        buttonForPass.setBackground(new Color(12, 84, 163));
        buttonForPass.setForeground(Color.WHITE);
        buttonForPass.setFocusable(false);
        buttonForPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonForPass.addActionListener(e -> JOptionPane.showMessageDialog(jFrame, "Toh Yaad Kar keh aa "));
        
        jFrame.add(buttonForPass);

        
        JLabel jLabel2 = new JLabel("Campus");
        
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 15));
        jLabel2.setForeground(Color.GRAY);
        jLabel2.setBounds(90, 382, 300, 30);
        jFrame.add(jLabel2);

        
        
        String[] Campus = {"Dubai", "Karachi", "Larkana", "Islamabad"};
        
        jComboBox = new JComboBox<>(Campus);
        jComboBox.setBounds(90, 410, 300, 20);
        jComboBox.addActionListener(this);
        
        jFrame.add(jComboBox);

        
        jProgressBar.setBounds(0, 493, 500, 20);
        jProgressBar.setValue(0);
        jProgressBar.setStringPainted(true);
        jProgressBar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        jProgressBar.setForeground(new Color(12, 84, 163));
        jProgressBar.setBackground(Color.lightGray);

        jFrame.add(jProgressBar);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            password0 = new String(PassBox.getPassword());
            regNo = UserBox.getText();

            if (temp >= 75) {
                jProgressBar.setValue(100);
                jProgressBar.setString("Login Successful");

                
                Timer timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        synchronized (lock) {
                            lock.notify();
                        }
                        jFrame.dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                synchronized (lock) {
                    lock.notify();
                }
            }
        }
        else if (e.getSource() == jComboBox) {
            if (temp < 75) {
                temp += 25;
            }


            jProgressBar.setValue(temp);
            jProgressBar.setString("Campus Selected");
        } else if (e.getSource() == buttonForPass) {
            JOptionPane.showMessageDialog(null, "Toh Yaad Kar Keh Aaa", "Error Message", JOptionPane.INFORMATION_MESSAGE, null);
        }
    }

    public String getRegNo() {
        return regNo;
    }
    public String getPassword0(){
        return password0;
    }


    public void clearScreen(int lines){
        for (int i = 0; i < lines ; i++) {
            System.out.println();
        }
    }
    public void waitForEnter() throws IOException {

        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    
    public static void main(String[] args) {
        StylishMenuExample example = new StylishMenuExample();
        Scanner scanner = new Scanner(System.in);
        int NOR = 0;
        int choice;
        

        int temp9 = 0;
    

        while (temp9 == 0) {
            Login.header();
            if (NOR == 0) {
                Login.Delay(3000);
                NOR++;
            }
            System.out.println();
            System.out.print("Login / Sign Up: ");
            String sign = scanner.nextLine();

            if (sign.compareTo("Login") == 0 || sign.compareTo("login") == 0) {
                example.MyFrame2();
                synchronized (example.lock) {
                    try {
                        example.lock.wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                
                Course course = new Course(Integer.parseInt(example.getRegNo()));
                example.clearScreen(10);
                course.login(Integer.parseInt(example.getRegNo()),example.getPassword0());
                example.clearScreen(21);
                try {
                    example.waitForEnter();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                int regist = Integer.parseInt(example.getRegNo());
                String pass = example.getPassword0();






                if (course.isRegistered(regist) != 0 && pass.compareTo("abc.123")== 0) {
                    temp9++;
                    do {
                        clearConsole();
                        example.clearScreen(4);
                        displayMenu();

                        System.out.print("Enter your choice (1-10): ");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                        DSA dsa = new DSA(regist, pass);

                        switch (choice) {
                            case 1:
                                clearConsole();
                                example.clearScreen(2);
                                course.classSchedule(regist);
                                
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 2:
                                clearConsole();
                                example.clearScreen(8);
                                course.printExamSchedule();
                                
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 3:
                                clearConsole();
                                example.clearScreen(3);
                                Scanner sc = new Scanner(System.in);

                                System.out.println("----------------------------------------------------Welcome to Result Calculator----------------------------------------------------");
                                System.out.println();

                                System.out.print("Please enter the number of 3 - cerdit Course: ");
                                int size3 = sc.nextInt();

                                System.out.print("Please enter the number of 2 - cerdit Course: ");
                                int size2 = sc.nextInt();

                                System.out.print("Please enter the number of 1 - cerdit Course: ");
                                int size1 = sc.nextInt();
                                sc.nextLine();

                                Result result = new Result(size1, size2, size3);

                                result.getMarks();
                                result.calculateResult();
                                System.out.println("Press Enter To Continue...");
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                
                                break;
                            case 4:
                                if (dsa.getCourseRegistered() != 0) {
                                clearConsole();
                                example.clearScreen(3);
                                courseSection(regist,pass);
                                }else{
                                    System.out.println("You didn't have registered course - !");
                                    System.out.println("Press Enter To Continue...");
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                }
                                break;
                            case 5:
                                gamesMenu(scanner);
                                break;
                            case 6:
                                clearConsole();
                                example.clearScreen(5);
                                Credits.Credits();
                                System.out.println("Press Enter To Continue...");
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                

                                break;
                            case 7:
                                clearConsole();
                                example.clearScreen(5);
                                MainCalender.AcademicCalender();
                                System.out.println("Press Enter To Continue...");
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 8:
                                clearConsole();
                                example.clearScreen(5);
                                new Calculator();
                                System.out.println("Press Enter To Continue...");

                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                
                                break;
                            case 9:
                                clearConsole();
                                example.clearScreen(3);
                                String projectPath = "C:\\Users\\hasna\\OneDrive\\Documents\\2nd Semester of SZABIST\\Java\\Apna ZABDESK Project Updated";
                                ProjectInfo.displayProjectInfo(projectPath);
                                System.out.println("Press Enter To Continue...");

                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 10:
                                clearConsole();
                                example.clearScreen(5);
                                dsa.RegistrationCourse();
                                System.out.println("Press Enter To Continue...");

                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case 11:
                                
                                example.clearScreen(3);
                                SwingUtilities.invokeLater(new Runnable() {
                                    public void run() {
                                        String name;
                                        name = dsa.getStudentName(regist);
                                        new FeedbackForm(name);
                                    }
                                });

                                System.out.println("Press Enter To Continue...");

                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }

                                clearConsole();
                                example.clearScreen(5);

                                Exit.displayExitMessage();
                                
                                break;
                            default:
                                System.out.println("Invalid choice! Please enter a number from 1 to 11.");
                                System.out.println("Press Enter To Continue...");
                                try {
                                    example.waitForEnter();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                        }

                        System.out.println(); 
                    } while (choice != 11);
                }

                scanner.close();
            } else if (sign.compareTo("Sign Up") == 0 || sign.compareTo("Sign up") == 0 || sign.compareTo("sign Up") == 0 || sign.compareTo("sign up") == 0) {

                Students SignUp = new Students();

                String firstName = getInput(scanner, "First Name");
                String lastName = getInput(scanner, "Last Name");
                String regNumber = getInput(scanner, "Registration Number");
                String program = getInput(scanner, "Program");
                String semester = getInput(scanner, "Semester");
                String section = getInput(scanner, "Section");
                double cgpa = getCGPA(scanner);


                SignUp.createAccountStudent(firstName, lastName, Integer.parseInt(regNumber), program, Integer.parseInt(semester), section, cgpa);


            } else {
                System.out.println("Invalid Input - !");
            }

        }
    }

    private static String getInput(Scanner scanner, String field) {
        String input;
        do {
            System.out.printf("Enter %s: ", field);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(field + " cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static double getCGPA(Scanner scanner) {
        double cgpa = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter CGPA (0.0 - 4.0): ");
                cgpa = Double.parseDouble(scanner.nextLine().trim());
                if (cgpa < 0.0 || cgpa > 4.0) {
                    System.out.println("CGPA must be between 0.0 and 4.0. Please try again.");
                } else {
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value for CGPA.");
            }
        }
        return cgpa;
    }



        public static void displayMenu () {
            System.out.println("========================================");
            System.out.println("           ░▒▓█ MAIN MENU █▓▒           ");
            System.out.println("========================================");
            System.out.println("1. -> Class Schedule                    ");
            System.out.println("2. -> Exam Schedule                     ");
            System.out.println("3. -> Result Calculator                 ");
            System.out.println("4. -> Course Section                    ");
            System.out.println("5. -> Games Section                     ");
            System.out.println("6. -> Credits                           ");
            System.out.println("7. -> Academic Calendar                 ");
            System.out.println("8. -> Calculator                        ");
            System.out.println("9. -> About This Code                   ");
            System.out.println("10.-> Course Registration               ");
            System.out.println("11. -> Exit                             ");
            System.out.println("========================================");
        }
   
        


        public static void handleCourseSectionDSA (Scanner scanner,int reg, String pass){
            StylishMenuExample example = new StylishMenuExample();
            example.clearScreen(2);
            System.out.println("Course Section - Are you a Student or Teacher?");
            System.out.print("Enter 's' for Student or 't' for Teacher: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("s")) {
                studentMenuDSA(scanner,reg,pass);
            } else if (role.equals("t")) {
                teacherMenuDSA(scanner,reg,pass);
            } else {
                System.out.println("Invalid choice!");
            }
        }

        public static void handleCourseSectionDSALab (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            example.clearScreen(2);
            System.out.println("Course Section - Are you a Student or Teacher?");
            System.out.print("Enter 's' for Student or 't' for Teacher: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("s")) {
                studentMenuDSALab(scanner,reg,pass);
            } else if (role.equals("t")) {
                teacherMenuDSALab(scanner,reg,pass);
            } else {
                System.out.println("Invalid choice!");
            }
        }

        public static void handleCourseSectionLA (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            example.clearScreen(2);
            System.out.println("Course Section - Are you a Student or Teacher?");
            System.out.print("Enter 's' for Student or 't' for Teacher: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("s")) {
                studentMenuLA(scanner,reg,pass);
            } else if (role.equals("t")) {
                teacherMenuLA(scanner,reg,pass);
            } else {
                System.out.println("Invalid choice!");
            }
        }

        public static void handleCourseSectionSRE (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            example.clearScreen(2);
            System.out.println("Course Section - Are you a Student or Teacher?");
            System.out.print("Enter 's' for Student or 't' for Teacher: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("s")) {
                studentMenuSRE(scanner,reg,pass);
            } else if (role.equals("t")) {
                teacherMenuSRE(scanner,reg,pass);
            } else {
                System.out.println("Invalid choice!");
            }
        }

        public static void handleCourseSectionHCI (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            example.clearScreen(2);
            System.out.println("Course Section - Are you a Student or Teacher?");
            System.out.print("Enter 's' for Student or 't' for Teacher: ");
            String role = scanner.nextLine().toLowerCase();

            if (role.equals("s")) {
                studentMenuHCI(scanner,reg,pass);
            } else if (role.equals("t")) {
                teacherMenuHCI(scanner,reg,pass);
            } else {
                System.out.println("Invalid choice!");
            }
        }


        private static void courseSection (int reg, String pass) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Course Section");
            System.out.println("1. Data Structure and Algorithms");
            System.out.println("2. Data Structure and Algorithms Lab");
            System.out.println("3. Linear Algebra");
            System.out.println("4. Human Computer Interaction");
            System.out.println("5. Software Requirement Engineering");
            System.out.print("Choose a course: ");

            int courseChoice = scanner.nextInt();
            scanner.nextLine();
            switch (courseChoice) {
                case 1:
                    handleCourseSectionDSA(scanner,reg,pass);
                    break;
                case 2:
                    handleCourseSectionDSALab(scanner,reg,pass);
                    break;
                case 3:
                    handleCourseSectionLA(scanner,reg,pass);
                    break;
                case 4:
                    handleCourseSectionHCI(scanner,reg,pass);
                    break;
                case 5:
                    handleCourseSectionSRE(scanner,reg,pass);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        public static void studentMenuDSA (Scanner scanner, int reg, String pass){
            int studentChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("            ░▒▓█ Student Menu █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Project Section                           ");
                System.out.println("4. -> Outline                                   ");
                System.out.println("5. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-5): ");
                studentChoice = scanner.nextInt();
                DSA user = new DSA(reg,pass);
                switch (studentChoice) {
                    case 1:
                        clearConsole();
                        example.clearScreen(5);
                        user.printMarks();
                        
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        break;
                    case 2:
                        clearConsole();
                        example.clearScreen(3);
                        user.printAttendance();
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        projectSectionDSA(scanner,reg,pass);
                        break;
                    case 4:
                        System.out.println("Print Outline");
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }

                System.out.println();
            } while (studentChoice != 5);
        }

        public static void teacherMenuDSA (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            int teacherChoice;
            example.clearScreen(3);
            System.out.print("Teacher Name: ");
            String tName = scanner.nextLine();
            System.out.print("Teacher's Password: "); 
            String temp = scanner.nextLine();
            String tPass = temp.toLowerCase(); 
         

            if (tPass.compareTo("szabist zindabad")== 0) {

            do {
                
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");   
                System.out.println("          ░▒▓█ Teacher's Menu █▓▒     ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Add Marks                                 ");
                System.out.println("4. -> Add Attendance                            ");
                System.out.println("5. -> Outline                          ");
                System.out.println("6. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-6): ");
                teacherChoice = scanner.nextInt();
                DSA user = new DSA(reg, pass);
                switch (teacherChoice) {

                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                    clearConsole();
                    example.clearScreen(5);
                    user.addMarksByTeacher(tName, tPass);
                   
                        break;
                    case 4:
                    clearConsole();
                    example.clearScreen(5);
                    user.addAttendanceByTeacher(tName, tPass);
                         
                        break;
                    case 5:
                        System.out.println("Print Outline");
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 6.");
                }
                System.out.println(); 
            } while (teacherChoice != 6);
        }
        else{
            System.out.println("Teacher's Details are Wrong - !");
        }

        }


        public static void projectSectionDSA (Scanner scanner,int reg,String pass){
            int projectChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Project Section █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Project Details                    ");
                System.out.println("2. -> Set Project Details                      ");
                System.out.println("3. -> Return To Student Menu                   ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-3): ");
                projectChoice = scanner.nextInt();
                scanner.nextLine(); 
                ProjectDSA user = new ProjectDSA(reg,pass);
                switch (projectChoice) {
                    case 1:
                        clearConsole();
                        example.clearScreen(5);
                        user.printProjectDetails();
                        
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2:
                        clearConsole();
                        example.clearScreen(5);
                        user.setProjectDetails();
                        break;
                    case 3:
                        System.out.println("Returning to Student Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                }

                System.out.println();
            } while (projectChoice != 3);
        }


        public static void studentMenuDSALab (Scanner scanner,int reg,String pass){
            int studentChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Student Menu █▓▒          ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Project Section                           ");
                System.out.println("4. -> Outline                          ");
                System.out.println("5. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-5): ");
                studentChoice = scanner.nextInt();
                DSALab user = new DSALab(reg, pass);
                switch (studentChoice) {
                    case 1:
                        clearConsole();
                        example.clearScreen(5);
                        user.printMarks();
                    
                        try {
                        example.waitForEnter();
                        } catch (IOException e) {
                         throw new RuntimeException(e);
                         }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                        projectSectionDSALab(scanner,reg,pass);
                        break;
                    case 4:
                        System.out.println("Print Outline");
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }

                System.out.println();
            } while (studentChoice != 5);
        }

        public static void teacherMenuDSALab (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            int teacherChoice;
            example.clearScreen(3);
            System.out.print("Teacher Name: ");
            String tName = scanner.nextLine();
            System.out.print("Teacher's Password: "); 
            String temp = scanner.nextLine();
            String tPass = temp.toLowerCase(); 
         

            if (tPass.compareTo("szabist zindabad")== 0) {



            do {
                
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Teacher's Menu █▓▒       ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Add Marks                                 ");
                System.out.println("4. -> Add Attendance                            ");
                System.out.println("5. -> Outline                          ");
                System.out.println("6. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-6): ");
                teacherChoice = scanner.nextInt();
                DSALab user = new DSALab(reg, pass);


                switch (teacherChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }   
                       
                        break;
                    case 3:
                    clearConsole();
                    example.clearScreen(5);
                    user.addMarksByTeacher(tName, tPass);
                    
                        break;
                    case 4:
                    clearConsole();
                    example.clearScreen(5);
                    user.addAttendanceByTeacher(tName, tPass);
                        break;
                    case 5:
                        System.out.println("Print Outline");
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 6.");
                }

                System.out.println(); 
            } while (teacherChoice != 6);
        }else{
            System.out.println("Teacher's Details are Wrong - !");
        }
        }


        public static void projectSectionDSALab (Scanner scanner,int reg,String pass){
            int projectChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("         ░▒▓█ Project Section █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Project Details                    ");
                System.out.println("2. -> Set Project Details                      ");
                System.out.println("3. -> Return To Student Menu                   ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-3): ");
                projectChoice = scanner.nextInt();
                scanner.nextLine(); 
                ProjectDSALab user = new ProjectDSALab(reg, pass);

                switch (projectChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printProjectDetails();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(5);
                    user.setProjectDetails();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                        System.out.println("Returning to Student Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                }

                System.out.println(); 
            } while (projectChoice != 3);
        }

        public static void studentMenuLA (Scanner scanner,int reg,String pass){
            int studentChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Student Menu █▓▒         ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Project Section                           ");
                System.out.println("4. -> Outline                          ");
                System.out.println("5. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-5): ");
                studentChoice = scanner.nextInt();
                LinearAlgebra user = new LinearAlgebra(reg, pass);

                switch (studentChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                        projectSectionLA(scanner,reg,pass);
                        break;
                    case 4:
                        System.out.println("Print Outline");
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }

                System.out.println(); 
            } while (studentChoice != 5);
        }

        public static void teacherMenuLA (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            int teacherChoice;
            example.clearScreen(3);
            System.out.print("Teacher Name: ");
            String tName = scanner.nextLine();
            System.out.print("Teacher's Password: "); 
            String temp = scanner.nextLine();
            String tPass = temp.toLowerCase(); 
         

            if (tPass.compareTo("szabist zindabad")== 0) {


            do {
                
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Teacher's Menu █▓▒              ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Add Marks                                 ");
                System.out.println("4. -> Add Attendance                            ");
                System.out.println("5. -> Outline                          ");
                System.out.println("6. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-6): ");
                teacherChoice = scanner.nextInt();

                LinearAlgebra user = new LinearAlgebra(reg, pass);
                switch (teacherChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                    clearConsole();
                    example.clearScreen(5);
                    user.addMarksByTeacher(tName, tPass);
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 4:
                    clearConsole();
                    example.clearScreen(5);
                    user.addAttendanceByTeacher(tName, tPass);
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 5:
                        System.out.println("Print Outline");
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 6.");
                }

                System.out.println(); 
            } while (teacherChoice != 6);
        }else{
            System.out.println("Teacher's Details are Wrong - !");
        }
    }


        public static void projectSectionLA (Scanner scanner,int reg,String pass){
            int projectChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("         ░▒▓█ Project Section █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Project Details                    ");
                System.out.println("2. -> Set Project Details                      ");
                System.out.println("3. -> Return To Student Menu                   ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-3): ");
                projectChoice = scanner.nextInt();
                scanner.nextLine(); 
                ProjectLA user = new ProjectLA(reg, pass);

                switch (projectChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printProjectDetails();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(5);
                    user.setProjectDetails();
                        break;
                    case 3:
                        System.out.println("Returning to Student Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                }

                System.out.println(); 
            } while (projectChoice != 3);
        }

        public static void studentMenuHCI (Scanner scanner,int reg,String pass){
            int studentChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Student Menu █▓▒         ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                       ");
                System.out.println("2. -> Print Attendance                  ");
                System.out.println("3. -> Project Section                   ");
                System.out.println("4. -> Outline                           ");
                System.out.println("5. -> Return To Main Menu               ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-5): ");
                studentChoice = scanner.nextInt();
                HCI user = new HCI(reg, pass);
                switch (studentChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                        projectSectionHCI(scanner,reg,pass);
                        break;
                    case 4:
                        System.out.println("Print Outline");
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }
                System.out.println();
            } while (studentChoice != 5);
        }

        public static void teacherMenuHCI (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            int teacherChoice;
            example.clearScreen(3);
            System.out.print("Teacher Name: ");
            String tName = scanner.nextLine();
            System.out.print("Teacher's Password: "); 
            String temp = scanner.nextLine();
            String tPass = temp.toLowerCase(); 
         

            if (tPass.compareTo("szabist zindabad")== 0) {


            do {
                
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Teacher's Menu █▓▒       ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Add Marks                                 ");
                System.out.println("4. -> Add Attendance                            ");
                System.out.println("5. -> Outline                          ");
                System.out.println("6. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-6): ");
                teacherChoice = scanner.nextInt();
                HCI user = new HCI(reg, pass);
                switch (teacherChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                    clearConsole();
                    example.clearScreen(5);
                    user.addMarksByTeacher(tName, tPass);
                    
                    
                        break;
                    case 4:
                    clearConsole();
                    example.clearScreen(5);
                    user.addAttendanceByTeacher(tName, tPass);
                
                        break;
                    case 5:
                        System.out.println("Print Outline");
                        break;

                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 6.");
                }

                System.out.println(); 
            } while (teacherChoice != 6);
        }else{
            System.out.println("Teacher's Details are Wrong - !");
        }
    }


        public static void projectSectionHCI (Scanner scanner,int reg,String pass){
            int projectChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Project Section █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Project Details                    ");
                System.out.println("2. -> Set Project Details                      ");
                System.out.println("3. -> Return To Student Menu                   ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-3): ");
                projectChoice = scanner.nextInt();
                scanner.nextLine(); 
                ProjectHCI user = new ProjectHCI(reg, pass);


                switch (projectChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printProjectDetails();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(5);
                    user.setProjectDetails();
                    
                
                        break;
                    case 3:
                        System.out.println("Returning to Student Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                }

                System.out.println(); 
            } while (projectChoice != 3);
        }


        public static void studentMenuSRE (Scanner scanner,int reg,String pass){
            int studentChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("            ░▒▓█ Student Menu █▓▒       ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                       ");
                System.out.println("2. -> Print Attendance                  ");
                System.out.println("3. -> Project Section                   ");
                System.out.println("4. -> Outline                           ");
                System.out.println("5. -> Return To Main Menu               ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-5): ");
                studentChoice = scanner.nextInt();
                SRE user = new SRE(reg, pass);

                switch (studentChoice) {
                    
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                        projectSectionSRE(scanner,reg,pass);
                        break;
                    case 4:
                        System.out.println("Print Outline");
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }
                System.out.println(); 
            } while (studentChoice != 5);
        }

        public static void teacherMenuSRE (Scanner scanner,int reg,String pass){
            StylishMenuExample example = new StylishMenuExample();
            int teacherChoice;
            example.clearScreen(3);
            System.out.print("Teacher Name: ");
            String tName = scanner.nextLine();
            System.out.print("Teacher's Password: "); 
            String temp = scanner.nextLine();
            String tPass = temp.toLowerCase(); 
         

            if (tPass.compareTo("szabist zindabad")== 0) {

            do {
                
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Teacher's Menu █▓▒       ");
                System.out.println("========================================");
                System.out.println("1. -> Print Marks                               ");
                System.out.println("2. -> Print Attendance                          ");
                System.out.println("3. -> Add Marks                                 ");
                System.out.println("4. -> Add Attendance                            ");
                System.out.println("5. -> Outline                          ");
                System.out.println("6. -> Return To Main Menu                       ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-6): ");
                teacherChoice = scanner.nextInt();
                SRE user = new SRE(reg, pass); 


                switch (teacherChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printMarks();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(3);
                    user.printAttendance();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 3:
                    clearConsole();
                    example.clearScreen(5);
                    user.addMarksByTeacher(tName, tPass);
                    
                    
                        break;
                    case 4:
                    clearConsole();
                    example.clearScreen(5);
                    user.addAttendanceByTeacher(tName, tPass);
                    
                    
                        break;
                    case 5:
                        System.out.println("Print Outline");
                        break;
                    case 6:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 6.");
                }

                System.out.println(); 
            } while (teacherChoice != 6);

        }else{
            System.out.println("Teacher's Details are Wrong - !");
        }
    }


        public static void projectSectionSRE (Scanner scanner,int reg,String pass){
            int projectChoice;

            do {
                StylishMenuExample example = new StylishMenuExample();
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("          ░▒▓█ Project Section █▓▒      ");
                System.out.println("========================================");
                System.out.println("1. -> Print Project Details                    ");
                System.out.println("2. -> Set Project Details                      ");
                System.out.println("3. -> Return To Student Menu                   ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-3): ");
                projectChoice = scanner.nextInt();
                scanner.nextLine(); 
                ProjectSRE user = new ProjectSRE(reg, pass);

                switch (projectChoice) {
                    case 1:
                    clearConsole();
                    example.clearScreen(5);
                    user.printProjectDetails();
                    
                    try {
                        example.waitForEnter();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                        break;
                    case 2:
                    clearConsole();
                    example.clearScreen(5);
                    user.setProjectDetails();
                    
                    
                        break;
                    case 3:
                        System.out.println("Returning to Student Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 3.");
                }

                System.out.println(); 
            } while (projectChoice != 3);
        }


        public static void gamesMenu (Scanner scanner){
            int gamesChoice;
            StylishMenuExample example = new StylishMenuExample();

            do {
                clearConsole();
                example.clearScreen(3);
                System.out.println("========================================");
                System.out.println("            ░▒▓█ Games Menu █▓▒         ");
                System.out.println("========================================");
                System.out.println("1. -> Tic Tac Toe                       ");
                System.out.println("2. -> Snake Game                        ");
                System.out.println("3. -> Rock Paper Scissors               ");
                System.out.println("4. -> Ping Pong Game                    ");
                System.out.println("5. -> Return To Main Menu               ");
                System.out.println("========================================");
                System.out.print("Enter your choice (1-4): ");
                gamesChoice = scanner.nextInt();
                DSA dsa0 = new DSA(gamesChoice, password0);
                String gameInterface;
                
                switch (gamesChoice) {
                    case 1:
                        System.out.println("Choose One  Graphical Interface / Textual Interface");
                         gameInterface = scanner.next();
                        if (gameInterface.compareTo("Graphical")== 0 || gameInterface.compareTo("graphical")== 0) {
                            TicTacToeVisual tacToeVisual = new TicTacToeVisual();
                            clearConsole();
                            example.clearScreen(7);
                            System.out.println("Thanks For Playing");
                            System.out.println("Press Enter To Continue...");
                            try {
                                example.waitForEnter();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            
                        }else if (gameInterface.compareTo("Textual")== 0 || gameInterface.compareTo("textual")== 0) {
                            clearConsole();
                            example.clearScreen(3);
                            TicTacToeCodic.TicTacToeCodix();
                            System.out.println();
                            System.out.println("Press Enter To Continue...");
                            try {
                                example.waitForEnter();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        
                        break;
                    case 2:
                    System.out.println("Choose One  Graphical Interface / Textual Interface");
                    gameInterface = scanner.next();
                    if (gameInterface.compareTo("Graphical")== 0 || gameInterface.compareTo("graphical")== 0) {
                        SnakeVisual snakeVisual = new SnakeVisual();
                        clearConsole();
                        example.clearScreen(7);
                        System.out.println("Thanks For Playing");
                        System.out.println("Press Enter To Continue...");
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        
                    }else if (gameInterface.compareTo("Textual")== 0 || gameInterface.compareTo("textual")== 0) {
                        clearConsole();
                        example.clearScreen(3);
                        SnakeCodic.SnakeCodix();
                        System.out.println("Press Enter To Continue...");
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                        break;
                    case 3:
                        clearConsole();
                        example.clearScreen(3);
                        RockPaperScissor.RockPaperScissorx();
                        System.out.println("Press Enter To Continue...");

                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        clearConsole();    
                        example.clearScreen(5);
                        new PongGame();
                        
                        
                        System.out.println("Press Enter To Continue...");
                        try {
                            example.waitForEnter();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 5:
                        
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number from 1 to 5.");
                }

                System.out.println(); 
            } while (gamesChoice != 5);
        
        
        
        
        
        
        
        
        
        }

    












}









