package funcs

object TestFuncs extends App {
  def doSomethingA1(op: => Any){
      println("Begin....")
      op
      println("End....")
  }

  def doSomethingA2(prefix: String)(op: => Any){
    println(prefix + "Begin....")
    op
    println(prefix + "End....")
  }

  doSomethingA1{
    println("hello!")
  }

  doSomethingA2("DDD."){
    println("hello!")
  }

  val aaa: ( => Any)=>Unit = doSomethingA2("DDD.")
  aaa{
    println("hello")
  }

  def doSomethingB1(op: ()=> Any){
    println("Begin....")
    op()
    println("End....")
  }

  def doSomethingB2(prefix: String)(op: ()=> Any){
    println(prefix + "Begin....")
    op()
    println(prefix + "End....")
  }

  doSomethingB1(()=> println("hello"))

  doSomethingB2("DDD.")(()=> println("hello"))

  val bbb: ( ()=> Any)=>Unit = doSomethingB2("DDD.")
  bbb(()=> println("hello"))


  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x+" is even"
  }

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x+" is odd"
  }

  val sample = 1 to 10

  val numbers = sample map (isEven orElse isOdd)

  testPartialFunction()

  def testPartialFunction(){
    val divide1 = new PartialFunction[Int, Int] {
      def apply(x: Int) = 42 / x
      def isDefinedAt(x: Int) = x != 0
    }
    divide1.isDefinedAt(0)
    divide1.isDefinedAt(100)
    if (divide1.isDefinedAt(100)) divide1(100)

    val divide2: PartialFunction[Int, Int] = {
      case d: Int if d != 0 => 42 / d
    }
    divide2.isDefinedAt(0)
    divide2.isDefinedAt(100)
    if (divide2.isDefinedAt(100)) divide2(100)

    // converts 1 to "one", etc., up to 5
    val convert1to5 = new PartialFunction[Int, String] {
      val nums = Array("one", "two", "three", "four", "five")
      def apply(i: Int) = nums(i-1)
      def isDefinedAt(i: Int) = i > 0 && i < 6
    }
    convert1to5(3)

    // converts 6 to "six", etc., up to 10
    val convert6to10 = new PartialFunction[Int, String] {
      val nums = Array("six", "seven", "eight", "nine", "ten")
      def apply(i: Int) = nums(i-6)
      def isDefinedAt(i: Int) = i > 5 && i < 11
    }
    convert6to10(8)

    val handle1to10 = convert1to5 orElse convert6to10

    if (handle1to10.isDefinedAt(3)) handle1to10(3)

    if (handle1to10.isDefinedAt(8)) handle1to10(8)

    if (handle1to10.isDefinedAt(11)) handle1to10(11)
  }
}
