# SportsAcademyPortal

Java is a general-purpose computer programming language that is concurrent, class-based,
object-oriented etc.
Java applications are typically compiled to byte code that can run on any Java virtual machine
(JVM) regardless of computer architecture.
• JDK (Java Development Kit): - JDK is intended for software developers and includes
development tools such as the Java compiler, Java doc, Jar, and a debugger.
• JRE (Java Runtime Environment): - JRE contains the parts of the Java libraries required
to run Java programs and is intended for end users. JRE can be view as a subset of JDK.
• JVM (Java Virtual Machine): - JVM is an abstract machine. It is a specification that
provides runtime environment in which java byte code can be executed. JVMs are
available for many hardware and software platforms.
JVM, JRE and JDK all three are platform dependent because configuration of each operating
system is different.
Java is: -
• Object Oriented−In Java, everything is an Object. Java can be easily extended since it
is based on the Object model.
• Platform Independent – Unlike many other programming languages including C and
C++, when Java is compiled, it is not compiled into platform specific machine, rather
into platform independent byte code. This byte code is interpreted by the Virtual
Machine (JVM) on whichever platform it is being run on.
• Simple − Java is designed to be easy to learn. If you understand the basic concept of
OOP Java, it would be easy to master.
• Robust − Java tries to eliminate error prone situations by emphasizing mainly on
compile time error checking and runtime checking.
P a g e 11 | 38
• Multithreaded − With Java's multithreaded feature it is possible to write programs that
can perform many tasks simultaneously. This design feature allows the developers to
construct interactive applications that can run smoothly.
• Interpreted − Java byte code is translated on the fly to native machine instructions and
is not stored anywhere. The development process is more rapid and analytical since the
linking is an incremental and light-weight process.
• Dynamic − Java is considered to be more dynamic than C or C++ since it is designed to
adapt to an evolving environment. Java programs can carry extensive amount of runtime information that can be used to verify and resolve accesses to objects on run-time.
4.2 Concepts Learned: -
4.2.1 OOPS: -
Java is one of the most popular object-oriented programming languages. Understanding
the key concepts of OOP was one of the first things I did learn at my internship. OOP is a
programming language model organized around objects.
Historically, a program has been viewed as a logical procedure that takes input data,
processes it, and produces output data. The programming challenge was seen as how to
write the logic, not how to define the data. Object-oriented programming takes the view
that what we really care about are the objects we want to manipulate rather than the
logic required to manipulate them.
Class is a collection of objects. It is a logical entity. A class can also be defined as a
blueprint from which you can create an individual object. Class does not consume any
space.
Object means a real-world entity such as a pen, chair, table, computer, watch etc. An
Object can be defined as an instance of a class. An object contains an address and takes
up some space in memory. Objects can communicate without knowing the details of each
other's data or code. The only necessary thing is the type of message accepted and the
type of response returned by the objects.
A dog is an object because it has states like color, name, breed, etc. as well as behaviors
like wagging the tail, barking, eating, etc.
P a g e 12 | 38
4.2.2 OOPS Concepts: -
Four Major OOPS Concepts are Inheritance, Encapsulation, Abstraction and
Polymorphism.
4.2.2.1 Inheritance: -
Inheritance in Java is a mechanism in which one object acquires all the properties
and behaviors of a parent object.
The idea behind inheritance in Java is that you can create new classes that are built
upon existing classes. When you inherit from an existing class, you can reuse
methods and fields of the parent class. Moreover, you can add new methods and
fields in your current class also.
Class: - Class is a group of objects which have common properties. It is a template or
blueprint from which objects are created.
Sub Class/Child Class: - Subclass is a class which inherits the other class. It is also
called a derived class, extended class or child class.
Super Class/Parent Class: - Superclass is the class from where a subclass inherits the
features. It is also called a base class or a parent class.
Reusability: - As the name specifies, reusability is a mechanism which facilitates you
to reuse the fields and methods of the existing class when you create a new class.
You can use the same fields and methods already defined in the previous class.
 Types of Inheritance in Java: -
1. Single Inheritance: - In single level Inheritance a child class inherits the properties
of a single parent class.
2. Multilevel Inheritance: - Here the child class derives from a parent class which in
turn derives its properties from another parent class.
3. Hierarchical Inheritance: - In this type of inheritance more than one class inherits
the properties of the same parent class.
Java does not support the concept of multiple inheritance where in a class can inherit
the properties of more than one parent class. The problem occurs when there exist 
P a g e 13 | 38
methods with same signature in the super classes from which it is extending. Here
the problem occurs cannot determine which class method to be called and even on
calling which class method gets the priority.
Interface in java helps us to achieve multiple inheritance. This is done through a class
implementing multiple interfaces, or an interface extending multiple interfaces.
 4.2.2.2 Encapsulation: -
Encapsulation in Java is a process of wrapping code and data together into a single
unit, for example, a capsule which is mixed of several medicines.
We can create a fully encapsulated class in Java by making all the data members of
the class private. Now we can use setter and getter methods to set and get the data
in it.
By providing only a setter or getter method, we can make the class read-only or
write- or write-only. In other words, you can skip the getter or setter methods.
It provides you the control over the data. Suppose you want to set the value of id
which should be greater than 100 only, you can write the logic inside the setter
method. You can write the logic not to store the negative numbers in the setter
methods.
It is a way to achieve data hiding in Java because other class will not be able to
access the data through the private data members. The encapsulate class is easy to
test. So, it is better for unit testing.
4.2.2.3 Abstraction: -
Abstraction is a process of hiding the implementation details and showing only
functionality to the user.
Another way, it shows only essential things to the user and hides the internal details,
for example, sending SMS where we type the text and send the message. We don't
know the internal processing about the message delivery.
Abstraction lets us focus on what the object does instead of how it does it.
There are two ways to achieve abstraction in Java: -
1. Abstract class (0 to 100 %)
P a g e 14 | 38
2. Interface (100%)
Abstract class must be declared with an abstract keyword. It can have abstract and
non-abstract methods and cannot be instantiated and needs to be extended. It can
have constructors and static methods also. It can have final methods which will force
the subclass not to change the body of the method.
Interface in java is a blueprint of a class. It has static constants and abstract
methods. Interface is mechanism to achieve 100% abstraction and multiple
inheritance in JAVA. There can be only abstract methods in the JAVA interface not
method body. It can have abstract methods and variables. It cannot have a method
body.
4.2.2.4 Polymorphism: -
Polymorphism in Java is a concept by which we can perform a single action in
different ways. Polymorphism is derived from 2 Greek words: poly and morphs. The
word "poly" means many and "morphs" means forms. So, polymorphism means many
forms. We can perform Polymorphism in java by method overloading and method
overriding.
Method Overloading: -
If a class has multiple methods having same name but different in parameters, it is
known as Method Overloading.
Example: - If we have to perform addition of the given numbers but there can be any
number of arguments, if we write the method such as a(int,int) for two parameters,
and b(int,int,int) for three parameters then it may be difficult for us as well as other
programmers to understand the behaviour of the method because its name differs.
So, we perform method overloading to figure out the program quickly.
Uses of method overloading: -
Method overloading increases the readability of the program.
It is used to achieve compile time polymorphism.
Different ways to overload the method: -
There are two ways to overload the method in java
P a g e 15 | 38
1. By changing number of arguments
2. By changing the data type of the parameters
In other words, if a subclass provides the specific implementation of the method that
has been declared by one of its parent class, it is known as method overriding.
Method Overriding: -
If subclass (child class) has the same method as declared in the parent class, it is
known as method overriding in Java.
In other words, if a subclass provides the specific implementation of the method that
has been declared by one of its parent class, it is known as method overriding.
Usage of Java Method Overriding: -
Method overriding is used to provide the specific implementation of a method which is
already provided by its superclass.
Method overriding is used for runtime polymorphism.
Rules for method Overriding: -
1. The method must have the same name as in the parent class
2. The method must have the same parameter as in the parent class.
3. There must be an IS-A (parent-child) relationship.
4.2.3 Advantages Of OOPS: -
It provides a clear modular structure for programs which makes it good for defining
abstract data types in which implementation details are hidden.
Objects can also be reused within an across applications. The reuse of software also
lowers the cost of development. More effort is put into the object-oriented analysis
and design, which lowers the overall cost of development.
It makes software easier to maintain. Since the design is modular, part of the
system can be updated in case of issues without a need to make large-scale
changes
P a g e 16 | 38
Reuse also enables faster development. Object-oriented programming languages
come with rich libraries of objects, and code developed during projects is also
reusable in future projects.
It provides a good framework for code libraries where the supplied software
components can be easily adapted and modified by the programmer. This is
particularly useful for developing graphical user interfaces.
