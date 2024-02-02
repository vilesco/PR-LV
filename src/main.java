import java.io.IOException;
import java.util.Scanner;



public class main {

    public static void main(String[] args) throws IOException {
        boolean appStatus = true;
        String classGiven;
        Scanner scanner = new Scanner(System.in);
        while (appStatus) {
            //  --- Menu ----
            System.out.println("\n === Chat App Menu === \n");
            System.out.println("1. Start Server");
            System.out.println("2. Create Client");
            System.out.println("0. Exit");
            System.out.println("\nOption: ");
//            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
//                    createServer.main(new String[]{});
                    classGiven = "createServer";
                    Launcher.main(classGiven);
                    System.out.println("1");
                    break;
                case 2:
//                    createClient.main();
                    classGiven = "createClient";
                    Launcher.main(classGiven);
                    System.out.println("2");
                    break;
//                case 0:
//                    appStatus = false;
//                    new stopServer();
//                    System.out.println("App terminated");
//                    break;
                default:
                    System.out.println("Enter a valid option: ");
            }
//            scanner.close();
        }
        scanner.close();
    }
}

