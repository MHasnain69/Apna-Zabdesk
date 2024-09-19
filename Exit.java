

class Exit {

    public static void displayExitMessage() {
        final String RESET = "\033[0m";  
        final String BLUE = "\033[1;34m";
        final String GREEN = "\033[1;32m";
        final String YELLOW = "\033[1;33m";
        final String RED = "\033[1;31m";

        


        String[] messages = {
            BLUE + "                                                ________                      __          __        " + RESET,
            BLUE + "                                               /  _____/_____    ____   _____/  |_  ____  |  | __    " + RESET,
            BLUE + "                                              /   \\  ___\\__  \\  /    \\ /  _ \\   __\\/ __ \\ |  |/ /    " + RESET,
            BLUE + "                                              \\    \\_\\  / __ \\|   |  (  <_> )  | \\  ___/ |    <     " + RESET,
            BLUE + "                                               \\______  (____  /___|  /\\____/|__|  \\___  >|__|_ \\    " + RESET,
            BLUE + "                                                      \\/     \\/     \\/            /_____/      \\/    " + RESET,
            GREEN + "\n                                                       Thank you for using our tool!" + RESET,
            GREEN + "                                                       We hope you enjoyed the experience!" + RESET,
            YELLOW + "                                                       Stay tuned for more updates!" + RESET,
            YELLOW + "                                                       Press ENTER to exit..." + RESET
        };

        try {
            for (String message : messages) {
                System.out.println(message);
                Thread.sleep(300);
            }

            
            System.out.println("\n" + RED + "                                                    *************************************" + RESET);
            System.out.println(RED + "                                                    *                                   *" + RESET);
            System.out.println(RED + "                                                    *   THANK YOU FOR USING OUR TOOL!   *" + RESET);
            System.out.println(RED + "                                                    *                                   *" + RESET);
            System.out.println(RED + "                                                    *************************************" + RESET);
            System.out.println("\n                                                       ");

            
            try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
                scanner.nextLine();
            }

           
        } catch (InterruptedException e) {
            System.err.println("An error occurred during the exit animation.");
        }

        
        System.exit(0);
    }
    public static void main(String[] args) {
        displayExitMessage();
    }














}
