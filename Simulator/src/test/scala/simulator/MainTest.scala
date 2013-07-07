package simulator

import org.scalatest.FunSuite
import java.util
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.util.EmptyStackException

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

}
