## scala 运行脚本
    // hello.scala
    println("Hello, world!")
    $ scala hello.scala
    Hello, world!

##  scala 编译非脚本文件
    //非脚本文件一定是以定义结尾的，例如定义的class、object、package等等。
    class Hello {
    val hw = "Hello, world!"
    def display() = println(hw)
    }
    //编译结束后出现一个Hello.class
    $scalac ex1.scala
    $scala
    scala> val hello = new Hello
        hello: Hello = Hello@5460edd3
    scala> hello.display()
    Hello, world!

    scala> hello.hw
    res1: String = Hello, world!