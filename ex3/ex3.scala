val f = (_:Int)+(_:Int)

f(1,2)

//重复函数

def add_many(msg:String,b:Int*)={
    var sum=0
    for (x< -num) sum +=x
    println(msg+sum)

}


//传名参数

var assertionEnabled = false
 
// predicate是类型为无参函数的函数入参
def myAssert(predicate: () => Boolean) =
  if(assertionEnabled && !predicate())
    throw new AssertionError
// 常规版本的调用
myAssert(() => 5 > 3)
 
// 传名参数的用法，注意因为去掉了空括号，所以调用predicate时不能有括号
def byNameAssert(predicate: => Boolean) =
  if(assertionEnabled && !predicate)
    throw new AssertionError
// 传名参数版本的调用，看上去更自然
byNameAssert(5 > 3)


// 可以看到，传名参数使得代码更加简洁、自然，而常规写法则很别扭。
//事实上，predicate的类型可以改成Boolean，而不必是一个返回布尔值的函数
//，这样调用函数时与传名参数是一致的。
// 使用布尔型参数的版本
def boolAssert(predicate: Boolean) =
  if(assertionEnabled && !predicate)
    throw new AssertionError
// 布尔型参数版本的调用
boolAssert(5 > 3)


//尽管byNameAssert和boolAssert在调用形式上是一样的，
//但是两者的运行机制却不完全一样。
//如果给函数的实参是一个表达式，比如“5 > 3”这样的表达式，
//那么boolAssert在运行之前会先对表达式求值，然后把求得的值传递给函数去运行。
//而myAssert和byNameAssert则不会一开始就对表达式求值，
//它们是直接运行函数，直到函数调用入参时才会对表达式求值，
//也就是例子中的代码运行到“!predicate”时才会求“5 > 3”的值。