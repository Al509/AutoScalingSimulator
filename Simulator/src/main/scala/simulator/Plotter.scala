package simulator

import java.awt.Graphics
import java.util

class Plotter(xPositionInput : Int, yPositionInput : Int,
              heightInput : Int, widthInput : Int) {

  val points = new util.ArrayList[Double]()

  def paint(g: Graphics) {
    var i = 1
    while(i < points.size()) {
      g.drawLine(i-1, height-points.get(i-1).toInt, i, height-points.get(i).toInt)
      i = i + 1
    }
  }

  def addNextPoint(y: Double) {
    points.add(y)
  }

  val xPosition = xPositionInput
  val yPosition = yPositionInput
  val height = heightInput
  val width = widthInput
}
