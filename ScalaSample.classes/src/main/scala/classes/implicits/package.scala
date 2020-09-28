package classes

package object implicits {
  implicit def arrayWrapper[A: ClassManifest](x: Array[A]) =
    new {
      def sort(p: (A, A) => Boolean) = {
        util.Sorting.stableSort(x, p); x
      }
    }

}