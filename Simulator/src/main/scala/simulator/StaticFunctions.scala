package simulator

object StaticFunctions {
  def generateCPUHistory(qps: Array[Double],
                         instanceHistory: Array[Int],
                         function: (Double, Int) => Double) : Array[Double] = {

    val result = new Array[Double](qps.length)
    var i = 0
    while( i < qps.length) {
      val x = qps(i)
      val y = instanceHistory(i)

      val z = function(x, y)
      result(i) = z
      i = i + 1
    }

    result
  }

}
