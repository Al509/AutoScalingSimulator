package simulator

import org.scalatest.FunSuite
import java.util
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.util.EmptyStackException
import java.awt.{Color, Graphics}
import simulator.NoOpStrategy
import com.sun.xml.internal.ws.api.pipe.Engine
import simulator.Engine

@RunWith(classOf[JUnitRunner])
class MainTest extends FunSuite {

  test("pop is invoked on a non-empty stack") {
    val stack = new util.Stack[Int]
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
    val result = stack.pop()
    assert(result === 2)
    assert(stack.size === oldSize - 1)
  }

  test("pop is invoked on an empty stack") {
    val emptyStack = new util.Stack[Int]
    intercept[EmptyStackException] {
      emptyStack.pop()
    }
    assert(emptyStack.isEmpty)
  }

  /*test("test plotter") {
    val plotter = new Plotter(0, 0, 100, 100)
    plotter.addNextPoint(0)
    plotter.addNextPoint(10)
    //TODO: make mock Graphics
    //val gr = new Graphics
    plotter.paint(null)
  }*/

  test("test engine") {
    val qps = Array(1,1,1)
    val initialGroupSize = 1
    def f(qps : Double, hostsCount : Int) {
      qps/hostsCount
    }

    val engine = new Engine()
    val strategy = new NoOpStrategy()
    //val instancesHistory = engine.process(qps, f, strategy, `initialGroupSize) //maybe some other parameters

    //generate CPU history based on the engine output
    // cpuHistory = generate(qps, instanceHistory, f)

  }
  // input CSV file with the QPS, # of instances, f(QPS, N) function

  test("test scaleStrategy") {

    val cpuHistory = Array(50,50,50)
    val scaleStrategy = new NoOpStrategy()
    val delta = scaleStrategy.makeDecision(cpuHistory)

    assert(delta === 0)
  }

  test("generate CPU history") {
    val qps = Array(1.0, 2.0, 3.0)
    val instanceHistory = Array(1,1,1)

    def linearFunction(qps : Double, hostsCount : Int) : Double =  {
      qps/hostsCount
    }

    val cpuHistory = StaticFunctions.generateCPUHistory(qps, instanceHistory, linearFunction)
    val expectedCPUHistory = Array(1.0, 2.0, 3.0)
    assert(expectedCPUHistory === cpuHistory)
  }

  def linearCPU(qps : Double, hostsCount : Int) : Double = {
    qps/hostsCount
  }

  test("generate CPU history 2") {
    val qps = Array(1.0, 2.0, 3.0)
    val instanceHistory = Array(1,2,3)

    val cpuHistory = StaticFunctions.generateCPUHistory(qps, instanceHistory, linearCPU)
    val expectedCPUHistory = Array(1.0, 1.0, 1.0)
    assert(expectedCPUHistory === cpuHistory)
  }

  val mtt = 10 //how long it takes to bring instance up in time units
  val lowerCPUThreshold = 40.0 //40% CPU
  val upperCPUThreshold = 60.0 //60% CPU

  test("main interface") {
    val qps = Array(1.0, 2.0, 3.0)

    val simulator = new Simulator(mtt, lowerCPUThreshold, upperCPUThreshold)
    val instanceLauncher = new InstanceLauncher
    val instanceHistory = simulator.simulate(qps, linearCPU, instanceLauncher)
    assert(4 === instanceHistory.length)
  }

  test("0 MTT test") {
    val qps = Array(41.0, 50.0, 100.0, 81.0, 50.0)
    val expectedInstanceHistory = Array(1, 1, 1, 2, 2, 1) //it's one time unit off

    val simulator = new Simulator(mtt, lowerCPUThreshold, upperCPUThreshold)
    val instanceLauncher = new InstanceLauncher
    val instanceHistory = simulator.simulate(qps, linearCPU, instanceLauncher)

    assert(expectedInstanceHistory === instanceHistory)

  }



  test("launcher component interface") {

  }

}
