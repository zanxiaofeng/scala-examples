package generics

trait GetResult[+T] {
}

object GetResult {
  implicit object GetBigDecimal extends GetResult[BigDecimal]
  implicit object GetBoolean extends GetResult[Boolean]
  implicit object GetByte extends GetResult[Byte]
  implicit object GetDouble extends GetResult[Double]
  implicit object GetFloat extends GetResult[Float]
  implicit object GetInt extends GetResult[Int]
  implicit object GetLong extends GetResult[Long]
  implicit object GetShort extends GetResult[Short]
  implicit object GetString extends GetResult[String]
  object GetUpdateValue extends GetResult[Int]
}

trait SetParameter[-T] {
}

class SetTupleParameter[-T <: Product](val children: SetParameter[_]*) extends SetParameter[T] {
}

object SetParameter {
  implicit object SetBigDecimal extends SetParameter[BigDecimal]
  implicit object SetBoolean extends SetParameter[Boolean]
  implicit object SetByte extends SetParameter[Byte]
  implicit object SetDouble extends SetParameter[Double]
  implicit object SetFloat extends SetParameter[Float]
  implicit object SetInt extends SetParameter[Int]
  implicit object SetLong extends SetParameter[Long]
  implicit object SetShort extends SetParameter[Short]
  implicit object SetString extends SetParameter[String]
  implicit object SetUnit extends SetParameter[Unit]

  implicit def createSetTuple2[T1, T2](implicit c1: SetParameter[T1], c2: SetParameter[T2]): SetTupleParameter[(T1, T2)] = new SetTupleParameter[(T1, T2)](c1, c2)
  implicit def createSetTuple3[T1, T2, T3](implicit c1: SetParameter[T1], c2: SetParameter[T2], c3: SetParameter[T3]): SetTupleParameter[(T1, T2, T3)] = new SetTupleParameter[(T1, T2, T3)](c1, c2, c3)
}

abstract class StaticQuery[-P, +R](query: String, pconv1: SetParameter[P], rconv: GetResult[R]) {
  protected[this]type Self <: StaticQuery[P, R]
  protected[this] def copy(query: String = this.query): Self
  def +(s: String) = copy(query + s)

  def first(p: P)(implicit sn: Session): R = {
    throw new Exception()
  }

  def list(p: P)(implicit sn: Session): R = {
    throw new Exception()
  }

  def exec(p: P)(implicit sn: Session): R = {
    throw new Exception()
  }
}

class StaticQuery0[R](query: String, rconv: GetResult[R]) extends StaticQuery[Unit, R](query, SetParameter.SetUnit, rconv) {
  protected[this]type Self = StaticQuery0[R]
  protected[this] def copy(query: String): Self = new StaticQuery0(query, rconv)
}

class StaticQuery1[P, R](query: String, pconv1: SetParameter[P], rconv: GetResult[R]) extends StaticQuery[P, R](query, pconv1, rconv) {
  protected[this]type Self = StaticQuery1[P, R]
  protected[this] def copy(query: String): Self = new StaticQuery1(query, pconv1, rconv)
}

object StaticQuery {
  def apply[R](implicit conv: GetResult[R]) = queryNA("")(conv)

  def apply[P, R]()(implicit pconv1: SetParameter[P], rconv: GetResult[R]) = query[P, R]("")(pconv1, rconv)

  def query[P, R](query: String)(implicit pconv1: SetParameter[P], rconv: GetResult[R]) =
    new StaticQuery1[P, R](query, pconv1, rconv)

  def queryNA[R](query: String)(implicit rconv: GetResult[R]) =
    new StaticQuery0[R](query, rconv)

  def update[P](query: String)(implicit pconv: SetParameter[P]) =
    new StaticQuery1[P, Int](query, pconv, GetResult.GetUpdateValue)

  def updateNA(query: String) =
    new StaticQuery0[Int](query, GetResult.GetUpdateValue)
}