package simulator

import javax.swing.{JFrame, UIManager}
import java.awt.{Container, Color}
import java.lang.Exception


/** A few utilities that simplify testing of windows in Swing.
  *  1998 Marty Hall, http://www.apl.jhu.edu/~hall/java/
  */

object WindowUtilities {

  /** Tell system to use native look and feel, as in previous
    *  releases. Metal (Java) LAF is the default otherwise.
    */

  def setNativeLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch {
      case e: Exception => System.out.println("Error setting native LAF: " + e);
    }
  }

  /** A simplified way to see a JPanel or other Container.
    * Pops up a JFrame with specified Container as the content pane.
    */

  def openInJFrame(content: Container,
                   width: Int,
                   height: Int,
                   title: String,
                   bgColor: Color): JFrame = {
    val frame = new JFrame(title);
    frame.setBackground(bgColor);
    content.setBackground(bgColor);
    frame.setSize(width, height);
    frame.setContentPane(content);
    frame.addWindowListener(new ExitListener());
    frame.setVisible(true);
    return (frame);
  }

  /** Uses Color.white as the background color. */

  def openInJFrame(content : Container,
    width : Int,
    height : Int,
    title : String) : JFrame = {
    return(openInJFrame(content, width, height, title, Color.white));
  }

  /** Uses Color.white as the background color, and the
    *  name of the Container's class as the JFrame title.
    */

  def openInJFrame(content: Container,
    width: Int,
    height: Int) : JFrame = {
    return(openInJFrame(content, width, height,
      content.getClass().getName(),
      Color.white));
  }
}
