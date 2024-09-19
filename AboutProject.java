import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ProjectInfo {

    
    public static void displayProjectInfo(String path) {
        List<FileInfo> fileInfoList = new ArrayList<>();
        gatherFileInfo(new File(path), fileInfoList);

        int totalJavaFiles = 0;
        int totalTxtFiles = 0;
        int totalLines = 0;

        for (FileInfo info : fileInfoList) {
            if (info.fileName.endsWith(".java")) {
                totalJavaFiles++;
            } else if (info.fileName.endsWith(".txt")) {
                totalTxtFiles++;
            }
            totalLines += info.lineCount; 
        }

        System.out.println("Overall Project Information:");
        System.out.println("+---------------------+-------------------+-------------------+");
        System.out.println("| Total .java Files   | Total .txt Files  | Total Lines       |");
        System.out.println("+---------------------+-------------------+-------------------+");
        System.out.printf("| %-19d | %-17d | %-17d |\n", totalJavaFiles, totalTxtFiles, totalLines);
        System.out.println("+---------------------+-------------------+-------------------+");
        System.out.println("\nDetailed File Information:");
        System.out.println("+-----+-----------------------------+-------------------+---------------------------------+");
        System.out.println("| Sr. | File Name                   | Lines of Code/Data| Description                     |");
        System.out.println("+-----+-----------------------------+-------------------+---------------------------------+");

        int srNo = 1;
        for (FileInfo info : fileInfoList) {
            System.out.printf("| %-3d | %-27s | %-17d | %-31s |\n", srNo++, info.fileName, info.lineCount, info.description);
        }

        System.out.println("+-----+-----------------------------+-------------------+---------------------------------+");
    }

    
    private static void gatherFileInfo(File directory, List<FileInfo> fileInfoList) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        
                        Charset charset = StandardCharsets.ISO_8859_1;  
                        int lineCount = (int) Files.lines(Paths.get(file.getPath()), charset).count();
                        String description = file.getName().endsWith(".java") ? "Java Source File" : "Text Data File";
                        fileInfoList.add(new FileInfo(file.getName(), lineCount, description));
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file.getName());
                    }
                } else if (file.isDirectory()) {
                    gatherFileInfo(file, fileInfoList);
                }
            }
        }
    }

    static class FileInfo {
        String fileName;
        int lineCount;
        String description;

        FileInfo(String fileName, int lineCount, String description) {
            this.fileName = fileName;
            this.lineCount = lineCount;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        String projectPath = "C:\\Users\\hasna\\OneDrive\\Documents\\2nd Semester of SZABIST\\Java\\Apna ZABDESK Project Updated";
        displayProjectInfo(projectPath);
    }
}
