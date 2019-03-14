package types

import logs.Log
import logs.ConsoleLog

object TestTypes extends App {
  //case 1
  def testType0(log: { def log(l: Int, m: String): Unit }) = {
    log.log(2, "test in")
  }

  def testType1(highlog: Highlight with Log) = {
    highlog.withColor("Yellow")
    highlog.log(1, highlog.toString())
  }

  def testType2(highnote: Highlight with Note) = {
    highnote.withColor("Yellow")
    highnote.withContent("content")
  }

  //Compile Ok, Works well
  var l1 = new Log with ConsoleLog
  testType0(l1);

  //Compile Ok, Works well
  var hlt1 = new Highlight with ConsoleLog
  hlt1.withEid(703756).withTitle("HSCB")
  testType1(hlt1);

  //Compile Error, because Highlight and Note are all class
  //var hnt1 = new Highlight with Note
  //hnt1.withEid(703756).withTitle("HSCB")
  //testType2(hnt1);

  //case 2
  //Compile Ok, Works well
  val hl1 = new Highlight().withEid(730756).withLocation("localtion").withTitle("Tile").withColor("Red")
  println(hl1)

  //Compile Error, because withId does not return a Highlight
  //val hl2 = new Highlight().withId(10).withEid(730756).withLocation("localtion").withTitle("Tile").withColor("Red")

  //case 3
  val singleTon: SingleTonObject.type = SingleTonObject
  singleTon.hello

  //case 4
  type DT = java.util.Date
  val d = new DT()
  println(d)

  val tc1 = new TestClass[String]("Hello types")
  tc1.printself(tc1)
  tc1.printself1(tc1)
  tc1.printself2(tc1)

  var st1 = new TestClass2()
  var st1s1 = st1.getsub();
  var st2 = new TestClass2()
  var st2s1 = st2.getsub();
  


}