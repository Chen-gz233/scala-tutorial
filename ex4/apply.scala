//apply方法

class Students2(val name: String, var score: Int) {
  def apply(s: Int) = score = s
  def display() = println("Current score is " + score + ".")
  override def toString = name + "'s score is " + score + "."
}
 
object Students2 {
  def apply(name: String, score: Int) = new Students2(name, score)
}