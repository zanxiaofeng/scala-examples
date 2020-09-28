package classes.abstracttypes

abstract class SeqBuffer {
  type T
  val element: Seq[T]
  def length = element.length
}