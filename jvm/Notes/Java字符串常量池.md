# Java中字符串常量池

1. java中创建字符串的两种方式：
   1. 字面量方式:
   
      `String str1 = "iamstring";`
   2. 标准对象创建方式:
   
      `String str2 = new String("iamstring");`
      
      然而这两种实现其实存在着一些性能和内存占用的差别。这一切都是源于JVM为了减少字符串对象的重复创建，其维护了一个特殊的内存，这
   段内存被成为字符串常量池或者字符串字面量池。

2. 工作原理：
   - 当代码中出现字面量形式创建字符串对象时，JVM首先会对这个字面量进行检查，如果字符串常量池中存在相同内容的字符串对象的引用，则
   将这个引用返回，否则新的字符串对象被创建，然后将这个***引用放入字符串常量池，并返回该引用***。
   - 当我们使用了new来构造字符串对象的时候，不管字符串常量池中有没有相同内容的对象的引用，新的字符串对象都会创建。

3. intern
   
   如果使用new创建时想查找字符串常量池中的引用，可以使用intern.
   ```java
   public class t11 {
   
       public static void main(String[] args) {
   
           String str1 = "hello";
   
           String str2 = "hello";
   
           //true，表示是一个对象
           System.out.println(str1 == str2);
   
   
           String str3 = new String("hello");
   
           //false
           System.out.println(str1 == str3);
   
   
           String str4 = str3.intern();
           //true
           System.out.println(str1 == str4);
   
       }
   }
   ```

4. 引用 or 对象
   
   字符串常量池中存放的时引用还是对象，这个问题是最常见的。字符串常量池存放的是**对象引用**，不是对象。在Java中，对象都创建在堆内存中。

   你知道下面的代码，会创建几个字符串对象，在字符串常量池中保存几个引用么？
  
   `String test = "a" + "b" + "c";`
  
   答案是只创建了一个对象，在常量池中也只保存一个引用。

   实际上在编译期间，已经将这三个字面量合成了一个。这样做实际上是一种优化，避免了创建多余的字符串对象，也没有发生字符串拼接问题。

5. Java中的字符串拼接:
   1. 不可变的String对象
    在Java中,String对象是不可变的(Immutable)。在代码中，可以创建多个某一个String对象的别名。但是这些别名的引用都是相同的。
    在Java中，唯一被重载的运算符就是字符串的拼接相关的。+,+=。除此之外，Java设计者不允许重载其他的运算符。
   2. 真的有性能代价吗?
      ```java
      String userName = "Andy";
      String age = "24";
      String job = "Developer";
      String info = userName + ag;
      ```
   3. 编译器的优化处理
      
      真的会有上面的性能代价么，字符串拼接这么常用，没有特殊的处理优化么，答案是有的，这个优化进行在编译器编译.java到bytecode时。

      然后我们使用javap反编译一下编译出来的Concatenation.class文件。javap -c Concatenation。如果没有找到javap命令，请考虑
      将javap所在目录加入环境变量或者使用javap的完整路径。

      ```java
      public class Concatenation {
          public Concatenation();
            Code:
               0: aload_0
               1: invokespecial #1                  // Method java/lang/Object."<init>":()V
               4: return
      
          public static void main(java.lang.String[]);
            Code:
               0: ldc           #2                  // String Andy
               2: astore_1
               3: ldc           #3                  // String 24
               5: astore_2
               6: ldc           #4                  // String Developer
               8: astore_3
               9: new           #5                  // class java/lang/StringBuilder
              12: dup
              13: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
              16: aload_1
              17: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
              20: aload_2
              21: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
              24: aload_3
              25: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
              28: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
              31: astore        4
              33: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
              36: aload         4
              38: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
              41: return
      }
      ```

      我们可以看到上面有很多StringBuilder,但是我们在Java代码里并没有显示地调用，这就是Java编译器做的优化，当Java编译器遇到字符串
      拼接的时候，会创建一个StringBuilder对象，后面的拼接，实际上是调用StringBuilder对象的append方法。这样就不会有我们上面担心的问题了。

   4. 仍然低效率的情况:

      ```java
      public void  implicitUseStringBuilder(String[] values) {
          String result = "";
          for (int i = 0 ; i < values.length; i ++) {
              result += values[i];
          }
            System.out.println(result);
          }
        ```        

      > 该种情况会在循环内新建StringBuffer对象，StringBuilder对象创建发生在循环之间，也就是意味着有多少次循环会创建多少个
         StringBuilder对象

      ```java
      // 优化
      public void explicitUseStringBuider(String[] values) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i ++) {
            result.append(values[i]);
        }
      }
      ```

      ```java
      public class t11 {
      
          public static void main(String[] args) {
      
              String str1 = "hello";
      
              String str2 = "hello";
      
              //true，表示是一个对象
              System.out.println(str1 == str2);
              
      
              String str3 = new String("hello");
      
              //false
              System.out.println(str1 == str3);
              
      
              String str4 = str3.intern();
              //true
              System.out.println(str1 == str4);
              
          }
      }
      ```