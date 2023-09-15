//https://blog.csdn.net/qq_34291505/article/details/86760620

class Students{
    private val name = "None" //成员被外部访问，则可以在前面加上关键字“private”来修饰
    def register(n:String) {
        name = n
    } 
    def dispaly(){
        println(name)
    }
}


//类的主构造方法
class Students(n:String){
     val name = n 
    def dispaly(){
        println(name)
    }
}

//类的辅助构造方法
class Students(n:String，m:Int){
    def this(n:String,m:Int)=this(n,100)

    def dispaly(){
        println((n + "'s score is " + m)
    }
}

//私有主构造方法
class Students private(n:String，m:Int){
    val name = n
    val many = m


    def this(n:String,m:Int)=this(n,100)

    def dispaly(){
        println((n + "'s score is " + m)
    }
}

//重写toString方法
class Students (n:String){
    val name = n
    override def toString="A student name "+name+"."
}
scala> val stu = new Students("chen")
    stu: Students = A student name chen.


//单例对象与伴生对象
//既然单例对象和new实例的对象一样，那么类内可以定义的代码，单例对象同样可以拥有。
class A { val a = 10 }\
val x = new A
x.a
 (new A).a

object B { val b = "a singleton object" }
 B.b
//object 是单列对象，不能用new实例化多个对象。只有一个能有一个对象
val y = B
y.b

//工厂对象，工厂方法
class Students(val name: String, var score: Int) {
  def exam(s: Int) = score = s
  override def toString = name + "'s score is " + score + "."
}
 
object Students {
  def registerStu(name: String, score: Int) = new Students(name, score)
}

//apply方法

class Students2(val name: String, var score: Int) {
  def apply(s: Int) = score = s
  def display() = println("Current score is " + score + ".")
  override def toString = name + "'s score is " + score + "."
}
 
object Students2 {
  def apply(name: String, score: Int) = new Students2(name, score)
}

