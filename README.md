

### 函数字面量
函数式编程有两个主要思想，其中之一就是：函数是一等(first-class)的值。换句话说，一个函数的地位与一个Int值、一个String值等等，是一样的。既然一个Int值可以成为函数的参数、函数的返回值、定义在函数体里、存储在变量里，那么，作为地位相同的函数，也可以这样。你可以把一个函数当参数传递给另一个函数，也可以让一个函数返回一个函数，亦可以把函数赋给一个变量，又或者像定义一个值那样在函数里定义别的函数(即前述的嵌套函数)。就像写一个整数字面量“1”那样，Scala也可以定义函数的字面量。

通常，函数字面量会赋给一个变量，这样就能通过“变量名(参数)”的形式来使用函数字面量。在参数类型可以被推断的情况下，可以省略类型，并且参数只有一个时，圆括号也可以省略。

函数字面量的形式可以更精简，即只保留函数体，并用下划线“_”作为占位符来代替参数。在参数类型不明确时，需要在下划线后面显式声明其类型。多个占位符代表多个参数，即第一个占位符是第一个参数，第二个占位符是第二个参数……因此不能重复使用某个参数。

        scala> val f = (_:Int)+(_:Int)
        f: (Int, Int) => Int = <function2>

        scala> f(1,4)
        res0: Int = 5


### 闭包

一个函数除了可以使用它的参数外，还能使用定义在函数以外的其他变量。其中，函数的参数称为绑定变量，因为完全可以根据函数的定义得知参数的信息；而函数以外的变量称为自由变量，因为函数自身无法给出这些变量的定义。这样的函数称为闭包，因为它要在运行期间捕获自由变量，让函数闭合，定义明确。自由变量必须在函数前面定义，否则编译器就找不到，会报错。


### 重复参数
Scala允许把函数的最后一个参数标记为重复参数，其形式为在最后一个参数的类型后面加上星号“*”。
重复参数的意思是可以在运行时传入任意个相同类型的元素，包括零个。

### 单例对象与伴生对象
在Scala里，除了用new可以构造一个对象，也可以用“object”开头定义一个对象。它类似于类的定义，只不过不能像类那样有参数，也没有构造方法。
因此，不能用new来实例化一个object的定义，因为它已经是一个对象了。
这种对象和用new实例化出来的对象没有什么区别，只不过new实例的对象是以类为蓝本构建的，并且数量没限制，而**object定义的对象只能有这一个**，故而得名“单例对象”。

如果某个单例对象和某个类同名，那么单例对象称为这个类的“伴生对象”，同样，类称为这个单例对象的“伴生类”。

伴生类和伴生对象必须在同一个文件里，而且两者可以互访对方所有成员。

在C++、Java等oop语言里，类内部可以定义静态变量。
这些静态变量不属于任何一个用new实例化的对象，而是它们的公有部分。

Scala追求纯粹的面向对象属性，即所有的事物都是类或对象，但是静态变量这种不属于类也不属于对象的事物显然违背了Scala的理念。
所以，Scala的做法是把类内所有的静态变量从类里移除，转而集中定义在伴生对象里，让静态变量属于伴生对象这个独一无二的对象。

#### C++中的静态成员
 - 静态成员变量属于整个类所有
    - 静态成员变量的生命期不依赖于任何对象，为程序的生命周期
    - 可以通过类名直接访问公有静态成员变量
    - 所有对象共享类的静态成员变量
    - 可以通过对象名访问公有静态成员变量
    - 静态成员变量需要在类外单独分配空间
    - 静态成员变量在程序内部位于全局数据区 (Type className::VarName = value)



### 工厂对象与工厂方法

如果定义一个方法专门用来构造某一个类的对象，那么这种方法就称为“工厂方法”。
包含这些工厂方法集合的单例对象，也就叫“工厂对象” 。
通常，工厂方法会定义在伴生对象里。尤其是当一系列类存在继承关系时，可以在基类的伴生对象里定义一系列对应的工厂方法。使用工厂方法的好处是可以不用直接使用new来实例化对象，改用方法调用，而且方法名可以是任意的，这样对外隐藏了类的实现细节。


### apply方法
有一个特殊的方法名——apply，如果定义了这个方法，那么既可以显式调用——“对象.apply(参数)” ，也可以隐式调用——“对象(参数)”。隐式调用时，编译器会自动插入缺失的“.apply”。如果apply是无参方法，应该写出空括号，否则无法隐式调用。无论是类还是单例对象，都能定义这样的apply方法。

### 主函数
主函数是Scala程序唯一的入口，即程序是从主函数开始运行的。要提供这样的入口，则必须在某个单例对象里定义一个名为“main”的函数，而且该函数只有一个参数，类型为字符串数组Array[String]，函数的返回类型是Unit。任何符合条件的单例对象都能成为程序的入口。
