package simulator

import java.awt.{Graphics2D, Graphics}
import javax.swing.{Timer, JPanel}
import java.awt.event.{ActionEvent, ActionListener}

class Engine extends JPanel with ActionListener{

  def process(qps: Array[Int], function: (Double, Int) => Unit, strategy: NoOpStrategy, plotter: Plotter): Unit = {


  }

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
    init()

    plotter.paint(g)
  }
  val plotter = new Plotter(0,0,100,0)

  def init() {
    for (x <- 1 to 300) {
      plotter.addNextPoint(Math.sin(x*x.toDouble/200) * 50 + 50)
    }
  }

  def actionPerformed(e: ActionEvent) {
    repaint()
  }
}
