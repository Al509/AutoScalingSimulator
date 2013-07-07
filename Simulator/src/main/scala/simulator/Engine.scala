package simulator

import java.awt.{Graphics2D, Graphics}
import javax.swing.{Timer, JPanel}
import java.awt.event.{ActionEvent, ActionListener}

class Engine extends JPanel with ActionListener{

  var timer = new Timer(1000, this)
  timer.start()

  var flag: Boolean = true

  override def paint(g : Graphics) {
    super.paint(g)
    val g2d = g
    if(flag) {
      g2d.drawLine(0,0,100,100)
    } else {
      g2d.drawLine(100,0,0,100)
    }
    flag = !flag
  }

  def actionPerformed(e: ActionEvent) {
    repaint()
  }
}
