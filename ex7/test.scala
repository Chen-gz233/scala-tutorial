class Person(val name: String)
 
object Alice extends Person("Alice")
object Tom extends Person("Tom")
object Tony extends Person("Tony")
object Bob extends Person("Bob")
object Todd extends Person("Todd")

object Main {
  def main(args:Array[String])
  {
    val persons = List(Alice, Tom, Tony, Bob, Todd)
 
	val To = for {
	  p <- persons          
	  n = p.name            
	  if(n startsWith "To") 
	} yield n

	println(To)
  }	
}