package dcls
import _root_.java.util.{ Date => DateTime }
import scala.runtime.RichInt

object TestDcls extends App {
  val now = new DateTime()

  val a = 2;
  val b = 1 to 20
  val c = 1.23
  val d = (1, 5, "Red")
  val (e, _, g) = d
  val h = Option(d);

  val tt = ((1, 2), ("a", "b", "b"))
  val tt11 = tt._1._1
  val tt23 = tt._2._3

  val map = Map(1 -> "Red", 2 -> "Yellow")
  val Some(red) = map.get(1)
  try {
    val Some(blue) = map.get(3)
  } catch {
    case t: Exception => println(t)
  }

  var str = """You can use any SQL database access library you like with Play, as 
    can easily retrieve either a Connection or a Datasource from the "play.api.db.DB helper"."""

  val res = 1 to 20
  val res1 = for (i <- res if i % 2 == 0) yield i * i
  res1.foreach(f => println(f))

  def fact(n: Int): Int = { n * fact(n - 1) }

  val l = List("abc", "eG", "tAY", "ui90")
  val lo = l map (_.toUpperCase())

  val l1 = Nil
  val l2 = List(3)
  val x :: Nil = l2
  val l3 = List(3, 2)
  val x1 :: x2 = l3
  val l4 = List(3, 2, 1)
  val l5 = List(2, 3, 4)
  val l6 = List("Red", "Yellow", "Blue")

  testMatch(l1)
  testMatch(l2)
  testMatch(l3)
  testMatch(l4)
  testMatch(l5)
  testMatch(l6)

  def testMatch(li: Any) {
    li match {
      case Nil => println("Nil");
      case hd :: Nil => println("one")
      case hd :: _ :: Nil => println("two")
      case 2 :: _ :: _ :: Nil => println("2 start three")
      case "Red" :: _ :: _ :: Nil => println("Red start three")
      case hd :: _ :: _ :: Nil => println("three")
      case _ =>
    }
  }

  testMatch1(l1)
  testMatch1(l2)
  testMatch1(l3)
  testMatch1(l4)
  testMatch1(l5)
  testMatch1(l6)
  def testMatch1(li: Any) {
    li match {
      case Nil => println("Nil");
      case head :: tail => println("head:" + head); println("tail:" + tail)
    }
  }

  testMatch2(l1)
  testMatch2(l2)
  testMatch2(l3)
  testMatch2(l4)
  testMatch2(l5)
  testMatch2(l6)
  def testMatch2(li: Any) {
    li match {
      case Nil => println("Nil");
      case List(x) => println("one:" + x)
      case List(x, y) => println("two:" + x + ", " + y)
      case List(x, y, z) => println("three:" + x + ", " + y + ", " + z)
      case _ => println("greater than three")
    }
  }

  val ll = List(Option(2), Option(3), Option(null))
  val ll1 = ll.collect { case Some(x: Int) if x % 2 == 0 => x * x }
  ll1.foreach(println(_))
  val ll2 = ll.collect { case Some(x: Int) if x % 2 == 0 => x * x }
  ll2.foreach(println)

  val ml = List(3, 5, 7, 9)
  testMitlePara(ml: _*)

  def testMitlePara(ar: Int*) = {
    ar.map { a => a * a }
  }

  highOrderFunc1((a) => a * a)
  highOrderFunc2 { (a) => a * a }
  highOrderFunc2(a => a * a)
  highOrderFunc1 { a => a * a }
  highOrderFunc1(_ * 2)

  highOrderFunc3((a, b) => a * b)
  highOrderFunc3 { (a, b) => a * b }
  highOrderFunc3(_ * _)
  highOrderFunc3 { _ * _ }

  highOrderFunc4(a => b => a * b)
  highOrderFunc4 { a => b => a * b }
  highOrderFunc4((a) => b => a * b)
  highOrderFunc4 { (a) => b => a * b }
  highOrderFunc4((a) => ((b) => a * b))
  highOrderFunc4 { (a) => { (b) => a * b } }

  highOrderFunc6(a => (b, c) => a * b * c)
  highOrderFunc6 { a => (b, c) => a * b * c }
  highOrderFunc6((a) => (b, c) => a * b * c)
  highOrderFunc6 { (a) => (b, c) => a * b * c }
  val fn = (x1: Int, x2: Int) => x1 * x2
  highOrderFunc6 { (a) => fn }

  def highOrderFunc1(f: Int => Int) = {
    f(20)
  }

  def highOrderFunc2(f: (Int) => Int) = {
    f(20)
  }

  def highOrderFunc3(f: (Int, Int) => Int) = {
    f(20, 10)
  }

  def highOrderFunc4(f: Int => Int => Int) = {
    val fn: Int => Int = f(20)
    fn(10)
    f(20)(10)
  }

  def highOrderFunc5(f: (Int) => Int => Int) = {
    f(20)(10)
  }

  def highOrderFunc6(f: (Int) => (Int, Int) => Int) = {

  }
  val abc: Unit = ()

  val aaa = "Hello World"
  //[value->func -> blank line]
  aaa toString

  //[value->(func->value)+]
  aaa substring 2 toString () charAt 2
  aaa substring 2 charAt 2
  aaa substring 2 substring 3 charAt 4

  intWrapper(2)
  val range = 1 to 4

  val valWapFunc: Int => RichInt = intWrapper

  val funval = TestObject.func
  val valObjFunc: () => Int = TestObject.func
  val valObjFunc1: (String) => Int = TestObject.func1
  val valObjFunc2: (String, String) => String = TestObject.func2
  val valApplyFunc: (Int, Int) => Int = TestObject.apply
  val valUnApplyFunc: Int => (Int, Int) = TestObject.unapply

  object TestObject {
    def func() = {
      2
    }

    def func1(a: String) = {
      3
    }

    def func2(a: String, b: String) = {
      a + b
    }

    def apply(time: Int, rest: Int) = {
      time * 10 + rest
    }

    def unapply(value: Int) = {
      (value / 10, value % 10)
    }
  }

  val classObj = new TestClass()
  val funclsObjval = classObj.func
  val valclsObjFunc: () => Int = classObj.func
  val valclsObjFunc1: (String) => Int = classObj.func1
  val valclsObjFunc2: (String, String) => String = classObj.func2
  val valclsApplyFunc: (Int, Int) => Int = classObj.apply
  val valclsUnApplyFunc: Int => (Int, Int) = classObj.unapply

  class TestClass {
    def func() = {
      2
    }

    def func1(a: String) = {
      3
    }

    def func2(a: String, b: String) = {
      a + b
    }

    def apply(time: Int, rest: Int) = {
      time * 10 + rest
    }

    def unapply(value: Int) = {
      (value / 10, value % 10)
    }
  }

  val caseApply1: (String, String, String) => CaseClass = CaseClass
  val caseApply2: (String, String, String) => CaseClass = CaseClass.apply
  val caseUnApply1: CaseClass => Option[(String, String, String)] = CaseClass.unapply
  val caseUnApply2: CaseClass => Option[(String, String, String)] = CaseClass.unapply _
  val caseUnApply3 = CaseClass.unapply _
  functest(CaseClass.unapply)
  functest(CaseClass.unapply _)

  def functest(para: CaseClass => Option[(String, String, String)]) = {
    println(para)
  }

  case class CaseClass(val id: String, val Name: String, val Value: String)
}