
val x
x=1

var y =1

val a,b,c = 1

//在定义变量时，应该指明变量的类型，
//只不过Scala的编译器具有自动推断类型的功能，可以根据赋给变量的对象的类型，来自动推断出变量的类型。
//。如果要显式声明变量的类型，或者无法推断时，
//则只需在变量名后面加上一个冒号“ : ”，然后在等号与冒号之间写出类型名即可。
val x:Int = 3
val y:String = "10"
val z:Double = 3.14

//浮点数的字面量都是十进制的，类型默认是Double类型。
//可以增加一个字母“e”或者“E”，再添加一个整数作为指数，这样就构成10的n次幂。
scala> val a=1.2E3
    a: Double = 1200.0

//最末尾可以写一个“f”或者“F”，表示Float类型；
scala> val b= 3.2f
    b: Float = 3.2

//也可以写一个“d”或者“D”，表示Double类型。
    scala> val c= 3d
        c: Double = 3.0

//Double类型的字面量不能赋给Float类型的变量     
    scala> val d:Float = 3.2
    <console>:11: error: type mismatch;
    found   : Double(3.2)
    required: Float
        val d:Float = 3.2

//Float允许扩展成Double类型，但是会发生精度损失。
scala> val f:Double = 3.14f
    f: Double = 3.140000104904175


//字符字面量是以单引号' '包起来的一个字符，采用Unicode编码。
scala> val s='abc'
    <console>:1: error: unclosed character literal
    val s='abc'
          ^

scala> val s='a'
    s: Char = a


//Scala包括了一个灵活的机制来支持字符串插值，这使得表达式可以被嵌入在字符串字面量中并被求值。

//。第一种形式是s插值器，即在字符串的双引号前加一个s，形如s“…${表达式}…”。
//s插值器会对内嵌的每个表达式求值，对求值结果调用内置的toString方法，替换掉字面量中的表达式。
    scala> val name = "CN"
    name: String = CN

    scala> println(s"A $name man")
    A CN man

s"sum = ${1+1+1+2}"
res2: String = sum = 5

//。第二种形式是raw插值器，它与s插值器类似，只不过不识别转义字符。


//第三种形式是f插值器，允许给内嵌的表达式加上printf风格的指令，指令放在表达式之后并以百分号开始。
scala> printf(f"${math.Pi}%.5f")
3.14159