import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 * Restart
 */
public class Restart {

    private static final String RESTART_NOW_WINDOWS = "shutdown -r -t 0";
    private static final String RESTART_NOW_LINUX = "shutdown -r -t 0";

    private static final Logger LOG = Logger.getGlobal();

    private static Restart instance;

    private Restart() {}

    public static Restart getInstance() {
        if (instance == null) {
            instance = new Restart();
        }
        return instance;
    }

    public static void main(String[] args) {
        Restart.getInstance().run(System.getProperty("os.name"));
    }

    public void run(String operatingSystem) {
        Runtime runtime = Runtime.getRuntime();
        String restartCommand = operatingSystem.equals("Windows") ? RESTART_NOW_WINDOWS : RESTART_NOW_LINUX;
        try {
            LOG.log(Level.INFO, "Executing " + restartCommand + " after any key press...");
            System.in.read();
            runtime.exec(restartCommand);
        } catch (IOException e) {
            LOG.log(Level.INFO, "IOException");
        }
    }
}