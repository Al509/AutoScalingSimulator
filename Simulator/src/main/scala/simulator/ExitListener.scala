package simulator

import java.awt.event.{WindowEvent, WindowAdapter}

class ExitListener extends WindowAdapter {
  override def windowClosing(event : WindowEvent) {
    System.exit(0)
  }
}
