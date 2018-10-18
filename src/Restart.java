import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 * Restart
 */
public class Restart {

    private static final String RESTART_NOW = "shutdown -r -t 0";

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
        Restart.getInstance().run();
    }

    public void run() {
        Runtime runtime = Runtime.getRuntime();
        try {
            LOG.log(Level.INFO, "Trying to restart...");
            runtime.exec(RESTART_NOW);
        } catch (IOException e) {
            LOG.log(Level.INFO, "IOException");
        }
    }
}