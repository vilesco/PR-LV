import java.io.IOException;

public class Launcher {

    public static <classGiven> void main(String classGiven) {
        // Get the Java runtime command
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + "\\bin\\java";
        String classpath = System.getProperty("java.class.path");
        String className = classGiven; // Fully qualified name of the class you want to run

        // Command to open a new command prompt window and run the Java program
        String[] command = {
                "cmd.exe", "/c", "start", "cmd.exe", "/k",
                "\"" + javaBin + "\" -cp \"" + classpath + "\" " + className
        };

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
