https://blog.csdn.net/qq_34291505/article/details/86766873

在面向对象编程里，为了节省代码量，也为了反映实际各种类之间的联系，通常采取两种策略：**包含和继承**。

**包含**代表了一种has-a的关系，也就是一个类包括了另一个类的实例。
例如，午餐的菜单含有水果，那么就可以先编写一个水果类，然后再编写一个午餐类，并在午餐类里包含水果类的对象，**但这两者没有必然联系**。

**继承**代表了一种is-a的关系，也就是从一个宽泛的类可以派生出更加具体的类。
例如，编写的水果类包含了一些常见水果的公有属性，然后要编写一个更具体的苹果类。考虑到现实世界中，苹果就是(is-a，更准确来说应该是is-a-kind-of)一种特殊的水果，那么苹果类完全可以把水果类里定义的属性都继承过来，而且**这两者有必然联系**。


### 不被继承的成员

通常，超类的成员都会被子类继承，除了两种成员：
一是超类中用“private”修饰的私有成员，
二是被子类重写的成员。

私有成员无需过多解释。
重写的意思是，超类中的某个属性，在子类中可能并不一定符合，而是需要一个新的符合子类行为的版本。
重写超类的成员时，应该在定义的开头加上关键字“override”。

### 不可重写的成员

如果超类成员在开头用关键字“final”修饰，那么子类就只能继承，而不能重写。

“final”也可以用于修饰class，那么这个类就禁止被其他类继承。


### 抽象类

如果类里包含了没有具体定义的成员——没有初始化的字段或没有函数体的方法，那么这个类就是抽象类，必须用关键字“abstract”修饰。相应的成员称为抽象成员，不需要“abstract”的修饰。因为存在抽象成员，所以这个类不可能构造出具体的对象，因为有无法初始化抽象字段或者无法执行抽象方法，所以抽象类不能通过“new”来构造实例对象。

抽象类缺失的抽象成员的定义，可以由抽象类的子类来补充。也就是说，抽象类“声明”了抽象成员，却没有立即“定义”它。如果子类补齐了抽象成员的相关定义，就称子类“实现”了超类的抽象成员。相对的，我们称超类的成员是“抽象”的，而子类的成员是“具体”的。子类实现超类的抽象成员时，关键字“override”可写可不写。

抽象类常用于定义基类，因为基类会派生出很多不同的子类，这些子类往往具有行为不同的同名成员，所以基类只需要声明有哪些公共成员，让子类去实现它们各自期望的版本。 





