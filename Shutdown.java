import java.util.Optional;
import java.io.IOException;

/**
 * Shutdown
 */
public class Shutdown {

    private static final String SHUTDOWN_NOW = "shutdown -s -t 0";

    private static Shutdown instance;

    private Shutdown() {
    }

    public static Shutdown getInstance() {
        if (instance == null) {
            instance = new Shutdown();
        }
        return instance;
    }

    public static void main(String[] args) {
        Shutdown.getInstance().run();
    }

    public void run() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(SHUTDOWN_NOW);
        } catch (IOException e) {
            System.out.println("IO error");
        }
        System.exit(0);
    }
}