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

  //������ʽ�������Զ�Ӧ�ã���ʽһ��ͨ��Import��ȷ�ĵ����val,var,def. ��ʽ�����Զ��Ӱ������� ���Ҷ�Ӧ��val,var,def--����Ҫ��ʾ��Import���
}