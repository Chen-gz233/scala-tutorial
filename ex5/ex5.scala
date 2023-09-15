//https://blog.csdn.net/qq_34291505/article/details/86766873

//普通继承
class A{
    val a = "class A"

}

class B extends A {
    val b = "class B inherits from A" 

}

//带参继承


class A（n:Int）{
    val a = n

}

class B(giveA:Int ,m:Int ) extends A (giveA){
    val b = m+giveA 

}


//重写成员函数

class Metal{
    val state = "solid"
    final val species = "Metal" //加入final关键字，成员无法被重写
}

class Mercury extends Metal{
    override val state = "liquid"
}


