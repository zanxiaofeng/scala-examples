package types

class Note extends Annotation {
  var content: String = null

  def withContent(content: String) = {
    this.content = content
    this
  }

  override def toString(): String = {
    var result = super.toString;
    result += "content: " + content
    result
  }
}