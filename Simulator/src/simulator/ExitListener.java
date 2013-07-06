package simulator;

/**
 * Created with IntelliJ IDEA.
 * User: Al
 * Date: 6/8/13
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 */
import java.awt.event.*;

/** A listener that you attach to the top-level Frame or JFrame of
 *  your application, so quitting the frame exits the application.
 *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class ExitListener extends WindowAdapter {
    public void windowClosing(WindowEvent event) {
        System.exit(0);
    }
}
