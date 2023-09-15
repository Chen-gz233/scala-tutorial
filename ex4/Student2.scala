// students2.scala
class Students2(val name: String, var score: Int) {
  def apply(s: Int) = score = s
  def display() = println("Current score is " + score + ".")
  override def toString = name + "'s score is " + score + "."
}
 
object Students2 {
  def apply(name: String, score: Int) = new Students2(name, score)
}
 
// main.scala
object Start {
  def main(args: Array[String]) = {
    try {
      val score = args(1).toInt
      val s = Students2(args(0), score)
      println(s.toString)
    } catch {
      case ex: ArrayIndexOutOfBoundsException => println("Arguments are deficient!")
      case ex: NumberFormatException => println("Second argument must be a Int!")
    }
  }
}


// main2.scala
object Start2 extends App {
  try {
    var sum = 0
    for(arg <- args) {
      sum += arg.toInt
    }
    println("sum = " + sum)
  } catch {
    case ex: NumberFormatException => println("Arguments must be Int!")
  }
}