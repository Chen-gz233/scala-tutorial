//https://blog.csdn.net/qq_34291505/article/details/86773401

class A {
    val a = "Class A"
}


trait B {
   val b = "Trait B"
}


trait C {
    def c = "Trait C"
}


object D extends A with B with C


//特质的线性化表示

//抽象类
//基类A的m的返回类型“String”的声明是必须的，因为抽象方法无法推断返回类型，不声明就默认是Unit。
abstract class A {
  def m(s: String): String
}
//类X实现了抽象方法m
class X extends A {
  def m(s: String) = "X -> " + s
}

//其余特质也用“abstract override”重写了m，这保证了m最终会回到类G。
trait B extends A {
  abstract override def m(s: String) = super.m("B -> " + s)
}

trait C extends A {
  abstract override def m(s: String) = super.m("C -> " + s)
}

trait D extends A {
  abstract override def m(s: String) = super.m("D -> " + s)
}

trait E extends C {
  abstract override def m(s: String) = super.m("E -> " + s)
}

trait F extends C {
  abstract override def m(s: String) = super.m("F -> " + s)
}

//类G重写了X的m
class G extends X {
  override def m(s: String) = "G -> " + s
}

val x = new G with D with E with F with B
println(x.m("End"))
