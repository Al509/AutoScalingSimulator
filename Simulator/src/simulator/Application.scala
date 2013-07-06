package simulator

/**
 * Created with IntelliJ IDEA.
 * User: Al
 * Date: 6/8/13
 * Time: 12:10 PM
 */


object Application {
  def main(args: Array[String]) {
    WindowUtilities.openInJFrame(new Engine(), 200, 200)
  }
}
