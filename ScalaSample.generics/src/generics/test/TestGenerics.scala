package generics.test

import generics.Column
import generics.~
import generics.{ StaticQuery => Q }
import generics.Session

object TestGenerics extends App {
  val bookid = Column[Int]("id")
  val bookname = Column[String]("name")
  val bookisbn = Column[String]("isbn")
  val booktitle = Column[String]("title")
  val bookprice = Column[Double]("price")

  var a2 = bookid ~ bookname
  var a3 = bookisbn ~ booktitle ~ bookprice

  //  a2 match {
  //    case ~(c1, c2) => println("2 fields")
  //  }

  //  def matchfunc(a: Any) = {
  //	  a match{
  //	    case c1 ~ c2 => println("2 fields")
  //	    case c1 ~ c2 ~ c3 => println("3 fields")
  //	  }
  //  }
  implicit def sn = new Session()

  (Q[Int] + "select top 1 id from task").first()

  (Q[String, Int] + "select top 1 id from task where name = ?").first("abc")

  Q.queryNA[Int]("select top 1 id from task").first()

  Q.query[String, Int]("select top 1 id from task where name = ?").first("abc")

  Q.query[(String, Int), Int]("select top 1 id from task where name = ? and id = ?").first("abc", 2)

  Q.updateNA("update task set endtTime='2012-03-12'")

  Q.update[String]("update task set endtTime='2012-03-12' where name = ?").exec("abc")

  Q.update[(String, Int)]("update task set endtTime='2012-03-12' where name = ? and id = ?").exec("abc", 2)

  //关于隐式参数的自动应用：方式一：通过Import明确的导入的val,var,def. 方式二：自动从伴生对象 查找对应的val,var,def--不需要显示的Import语句
}