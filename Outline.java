class CourseOutline {
    public static void main(String[] args) {
        
        String teacherName = "Shamsa Kanwal";
        int creditHours = 3;
        String roomNumber = "410 - 100 Campus";
        String courseDay = "Thursday";
        String[][] courseContent = {
            {"1", "Introduction to Linear Algebra", "Week 1"},
            {"2", "Matrix Operations", "Week 2"},
            {"3", "Determinants and Inverses", "Week 3"},
            {"4", "Vector Spaces", "Week 4"},
            {"5", "Linear Transformations", "Week 5"},
            {"6", "Eigenvalues and Eigenvectors", "Week 6"},
            {"7", "Diagonalization", "Week 7"},
            {"8", "Orthogonality and Projections", "Week 8"},
            {"9", "Inner Product Spaces", "Week 9"},
            {"10", "Gram-Schmidt Process", "Week 10"},
            {"11", "Least Squares Solutions", "Week 11"},
            {"12", "Applications in Comp Graphics", "Week 12"},
            {"13", "Final Project Discussion", "Week 13"},
            {"14", "Complex Vector Spaces", "Week 14"},
            {"15", "Numerical Methods", "Week 15"},
            {"16", "Final Project Submission", "Week 16"}
        };


        printCourseOutline(teacherName, creditHours, roomNumber, courseDay, courseContent);
    }

    public static void printCourseOutline(String teacherName, int creditHours, String roomNumber, String courseDay, String[][] courseContent) {
        String border = "===========================================================";
        String header = "Linear Algebra Course Outline";
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
