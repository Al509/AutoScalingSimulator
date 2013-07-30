package simulator

import org.apache.log4j.Logger

class InstanceLauncher {
  var instanceHistory : List[Int] = List(1)


  def getInstanceHistory: Array[Int] = {
    instanceHistory.reverse.toArray
  }

  def scheduleLaunch(count : Int):Unit = {
    val current = instanceHistory.head
    instanceHistory = current + count :: instanceHistory
  }

  def scheduleTerminate(count: Int):Unit = {
    val current = instanceHistory.head
    instanceHistory = current - count :: instanceHistory
  }

  def getEffectiveInstanceCount(time: Int) : Int = {
    instanceHistory.head
  }

}
