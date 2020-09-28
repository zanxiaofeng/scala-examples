package generics

object ~ {
  def unapply[T1, T2](p: Projection2[T1, T2]) =
    Some(p)
  def unapply[T1, T2, T3](p: Projection3[T1, T2, T3]) =
    Some((new Projection2(p.c1, p.c2), p.c3))
  def unapply[T1, T2, T3, T4](p: Projection4[T1, T2, T3, T4]) =
    Some((new Projection3(p.c1, p.c2, p.c3), p.c4))
  def unapply[T1, T2, T3, T4, T5](p: Projection5[T1, T2, T3, T4, T5]) =
    Some((new Projection4(p.c1, p.c2, p.c3, p.c4), p.c5))
  def unapply[T1, T2, T3, T4, T5, T6](p: Projection6[T1, T2, T3, T4, T5, T6]) =
    Some((new Projection5(p.c1, p.c2, p.c3, p.c4, p.c5), p.c6))
  def unapply[T1, T2, T3, T4, T5, T6, T7](p: Projection7[T1, T2, T3, T4, T5, T6, T7]) =
    Some((new Projection6(p.c1, p.c2, p.c3, p.c4, p.c5, p.c6), p.c7))
  def unapply[T1, T2, T3, T4, T5, T6, T7, T8](p: Projection8[T1, T2, T3, T4, T5, T6, T7, T8]) =
    Some((new Projection7(p.c1, p.c2, p.c3, p.c4, p.c5, p.c6, p.c7), p.c8))
}

class Projection2[T1, T2](val c1: Column[T1], val c2: Column[T2]) {
  def ~[T3](c: Column[T3]) = new Projection3(c1, c2, c)
}

class Projection3[T1, T2, T3](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3]) {
  def ~[T4](c: Column[T4]) = new Projection4(c1, c2, c3, c)
}

class Projection4[T1, T2, T3, T4](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3], val c4: Column[T4]) {
  def ~[T5](c: Column[T5]) = new Projection5(c1, c2, c3, c4, c)
}

class Projection5[T1, T2, T3, T4, T5](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3], val c4: Column[T4], val c5: Column[T5]) {
  def ~[T6](c: Column[T6]) = new Projection6(c1, c2, c3, c4, c5, c)
}

class Projection6[T1, T2, T3, T4, T5, T6](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3], val c4: Column[T4], val c5: Column[T5], val c6: Column[T6]) {
  def ~[T7](c: Column[T7]) = new Projection7(c1, c2, c3, c4, c5, c6, c)
}

class Projection7[T1, T2, T3, T4, T5, T6, T7](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3], val c4: Column[T4], val c5: Column[T5], val c6: Column[T6], val c7: Column[T7]) {
  def ~[T8](c: Column[T8]) = new Projection8(c1, c2, c3, c4, c5, c6, c7, c)
}

class Projection8[T1, T2, T3, T4, T5, T6, T7, T8](val c1: Column[T1], val c2: Column[T2], val c3: Column[T3], val c4: Column[T4], val c5: Column[T5], val c6: Column[T6], val c7: Column[T7], val c8: Column[T8]) {
}