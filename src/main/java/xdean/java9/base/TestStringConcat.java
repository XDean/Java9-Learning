package xdean.java9.base;

public class TestStringConcat {
  public static final double constant = Math.random();

  public static void main(String[] args) throws Exception {
    double d1 = Math.random();
    System.out.println("random1: " + d1 + "\tconstant: " + constant);
  }
}

/*
<pre><code>
//Compiled from TestStringConcat.java (version 9 : 53.0, super bit)

public class xdean.java9.base.TestStringConcat {

// Field descriptor #10 D
public static final double constant;

// Method descriptor #12 ()V
// Stack: 1, Locals: 1
public TestStringConcat();
 0  aload_0 [this]
 1  invokespecial java.lang.Object() [1]
 4  return
   Line numbers:
     [pc: 0, line: 3]
   Local variable table:
     [pc: 0, pc: 5] local: this index: 0 type: xdean.java9.base.TestStringConcat

// Method descriptor #19 ([Ljava/lang/String;)V
// Stack: 5, Locals: 3
public static void main(java.lang.String[] args) throws java.lang.Exception;
  0  invokestatic java.lang.Math.random() : double [2]
  3  dstore_1 [d1]
  4  getstatic java.lang.System.out : java.io.PrintStream [3]
  7  dload_1 [d1]
  8  getstatic xdean.java9.base.TestStringConcat.constant : double [4]
 11  invokedynamic 0 makeConcatWithConstants(double, double) : java.lang.String [5]
 16  invokevirtual java.io.PrintStream.println(java.lang.String) : void [6]
 19  return
   Line numbers:
     [pc: 0, line: 7]
     [pc: 4, line: 8]
     [pc: 19, line: 10]
   Local variable table:
     [pc: 0, pc: 20] local: args index: 0 type: java.lang.String[]
     [pc: 4, pc: 20] local: d1 index: 1 type: double

// Method descriptor #12 ()V
// Stack: 2, Locals: 0
static {};
 0  invokestatic java.lang.Math.random() : double [2]
 3  putstatic xdean.java9.base.TestStringConcat.constant : double [4]
 6  return
   Line numbers:
     [pc: 0, line: 4]

Inner classes:
 [inner class info: #59 java/lang/invoke/MethodHandles$Lookup, outer class info: #63 java/lang/invoke/MethodHandles
  inner name: #60 Lookup, accessflags: 25 public static final]
Bootstrap methods:
0 : # 35 invokestatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
Method arguments:
 #36 null
}
</code></pre>
*/