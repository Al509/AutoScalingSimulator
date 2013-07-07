package simulator

object Application {
  def main(args: Array[String]) {
    WindowUtilities.openInJFrame(new Engine(), 200, 200)
  }
}
