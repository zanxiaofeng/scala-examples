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
}
