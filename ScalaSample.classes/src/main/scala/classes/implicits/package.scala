package classes

import scala.reflect.ClassTag

package object implicits {
  implicit def arrayWrapper[A: ClassTag](x: Array[A]) =
    new {
      def sort(p: (A, A) => Boolean) = {
        util.Sorting.stableSort(x, p); x
      }
    }

}