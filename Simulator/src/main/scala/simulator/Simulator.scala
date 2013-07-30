package simulator

import org.apache.log4j.{BasicConfigurator, Logger}

class Simulator(mtt : Double, lowerCPUThreshold: Double, upperCPUThreshold: Double) {
  val LOG = Logger.getLogger(this.getClass.getName)

  def simulate(qps: Array[Double], cpuFunction: (Double, Int) => Double, instanceLauncher : InstanceLauncher): Array[Int] = {

    for (time <- 0 to qps.length - 1) {

      val currentCPU = cpuFunction(qps(time), instanceLauncher.getEffectiveInstanceCount(time))

      LOG.debug(time + ": " + currentCPU)

      if (currentCPU > upperCPUThreshold) {
        LOG.debug(time + ":Launching one instance")
        instanceLauncher.scheduleLaunch(1)
      } else if (currentCPU < lowerCPUThreshold) {
        LOG.debug(time + ":Terminating one instance")
        instanceLauncher.scheduleTerminate(1)
      } else {
        instanceLauncher.scheduleLaunch(0) //no op
      }

    }

    instanceLauncher.getInstanceHistory
  }


}
