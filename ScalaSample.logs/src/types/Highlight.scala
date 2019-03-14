package types

class Highlight extends Annotation {
  var color: String = null;

  def withColor(color: String) = {
    this.color = color
    this
  }

  override def toString(): String = {
    var result = super.toString;
    result += "color: " + color
    result
  }
}