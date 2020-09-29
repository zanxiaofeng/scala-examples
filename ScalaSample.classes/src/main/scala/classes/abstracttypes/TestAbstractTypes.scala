package classes.abstracttypes

object TestAbstractTypes extends App {
  def createIntBuffer(i: Int) = new Buffer { type T = Int; val element = i }
  def createIntBuffer(ia: Int*) = new SeqBuffer { type T = Int; val element = ia }

  println(createIntBuffer(1).element);
  println(createIntBuffer(1, 2, 3, 4, 5, 6).element)
}