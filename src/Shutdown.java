import java.io.IOException;
import java.util.logging.Logger;

/**
 * Shutdown
 */
public class Shutdown {

    private static final String SHUTDOWN_NOW_WINDOWS = "shutdown -s -t 0";
    private static final String SHUTDOWN_NOW_LINUX = "shutdown -h now";

    private static final Logger LOG = Logger.getGlobal();

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
        Shutdown.getInstance().run(System.getProperty("os.name"));
    }

    public void run(String operatingSystem) {
        Runtime runtime = Runtime.getRuntime();
        LOG.info(operatingSystem + " found.");
        String shutdownCommand = operatingSystem.contains("Windows") ? SHUTDOWN_NOW_WINDOWS : SHUTDOWN_NOW_LINUX;
        try {
            LOG.info("Executing " + shutdownCommand + " after any key press...");
            System.in.read();
            runtime.exec(shutdownCommand);
        } catch (IOException e) {
            System.out.println("IO error");
        }
        System.exit(0);
    }
}