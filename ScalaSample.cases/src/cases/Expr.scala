package cases

abstract class Expr {
  def eval(): Int = {
    this match {
      case Number(x) => x
      case Sum(left, right) => left.eval() + right.eval()
    }
  }
}

case class Number(n: Int) extends Expr

case class Sum(e1: Expr, e2: Expr) extends Expr