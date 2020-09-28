package dcls

import java.sql.Timestamp
import java.util.Date

object InferringTypeOfNone extends App {
  val t1 = Option(new Timestamp(new Date().getTime))
  val t2 = None

  //can inferring by t1 type
  if (t1 == None) {

  }
  //can inferring by t1 type
  if (t1 == t2) {

  }

  func(t1)
  //can inferring by parameter type
  func(None)
  //can inferring by parameter type
  func(t2)

  def func(t: Option[Timestamp]) = {
    t match {
      case Some(x) => println(x)
      case None => println("None")
    }
  }

  func2(t1, t2)
  func2(t1, None)

  def func2[T](t: T, x: T) {
    println(t)
    println(x)
  }

  func3(t1, t2)
  func3(t1, None)

  def func3[T](t: Option[T], x: Option[T]) {
    println(t)
    println(x)
  }

  func4(t1, t2)
  func4(t1, None)

  def func4[A, B](t: Option[A], x: Option[B]) {
    println(t)
    println(x)
  }

  funcforTestClass(new TestClass(t1, t2))
  funcforTestClass(new TestClass(t1, None))
  funcforTestClass(new TestClass(t1, Option.empty[Timestamp]))
  funcforTestClass(new TestClass(t1, None.asInstanceOf[Option[Timestamp]]))

  def funcforTestClass(t: TestClass[Timestamp, Timestamp]) = {

  }

  class TestClass[A, B](val firstValue: Option[A], val secondValue: Option[B])

}