package dcls

object TestTuple extends App {
  val t1 = (2, "sbc", 23.2)
  val (f1, f2, f3) = t1

  callTuple2("abc", 2)
  callTuple2(("abc", 2))
  callTuple2("abc" -> 2)
  def callTuple2(t: (String, Int)) = {
  }

  callTuple3("abc", 2, 6)
  callTuple3(("abc", 2, 6))
  def callTuple3(t: (String, Int, Int)) = {
  }
}