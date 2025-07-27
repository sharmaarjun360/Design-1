import java.util.*

class MinStack() {
    var minV: Int = Int.MAX_VALUE
    val minStack = Stack<Int>().also { it.push(minV) }
    val curStack = Stack<Int>()
    fun push(`val`: Int) {
        if (`val` <= minV) {
            minStack.push(minV)
            minV = `val`
        }
        curStack.push(`val`)
    }

    fun pop() {
// // only if querying against empty stack
//        if (curStack.isEmpty()) {
//            return
//        }
        val temp = curStack.pop()
        if (temp == minV) {
            minV = minStack.pop()
        }
    }

    fun top(): Int {
// only if we are asked to query against empty stack
         if(curStack.isEmpty()) return minV
        return curStack.peek()
    }

    fun getMin(): Int {
        return minV
    }

}

fun main() {
//    Your MinStack object will be instantiated and called as such:
    var obj = MinStack()
    obj.push(2)
    obj.pop()
    var param_3 = obj.top()
    var param_4 = obj.getMin()

    println("$param_3, $param_4")

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */