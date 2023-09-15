//if表达式
def whichInt(x: Int) = {
    if(x == 0)
        "Zero"
    else if(x > 0)
        "Positive Number"
    else 
        "Negative Number"
    }


//while循环
def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) { 
    val temp = a
    a = b % a
    b = temp
  }
  b
}


//for表达式

for( seq ) yield expression

/* 
 整个for表达式算一个语句。在这里，seq代表一个序列。
 换句话说，能放进for表达式里的对象，必须是一个可迭代的集合。
 关键字“yield”是“产生”的意思，也就是把前面序列里符合条件的元素拿出来，
 逐个应用到后面的“expression”，得到的所有结果按顺序产生一个新的集合对象。

*/

for {
  p <- persons          // 一个生成器
  n = p.name            // 一个定义
  if(n startsWith "To")  // 一个过滤器
} yield n


//match表达式
def something(x: String) = x match {
        case "Apple" => println("Fruit!")
        case "Tomato" => println("Vegetable!")
        case "Cola" => println("Beverage!")
        case _ => println("Huh?")
    }











