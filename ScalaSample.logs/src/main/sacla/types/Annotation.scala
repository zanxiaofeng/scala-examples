package types

class Annotation {
  var id: Long = 0
  var eid: Long = 0
  var asset: String = null
  var location: String = null
  var title: String = null

  def withId(id: Long) = {
    this.id = id
    this
  }

  def withEid(eid: Long): this.type = {
    this.eid = eid
    this
  }

  def withAsset(asset: String): this.type = {
    this.asset = asset
    this
  }

  def withLocation(location: String): this.type = {
    this.location = location
    this
  }

  def withTitle(title: String): this.type = {
    this.title = title
    this
  }

  override def toString(): String = {
    var result = "";
    result += "id: " + id
    result += "eid: " + eid
    result += "asset: " + asset
    result += "location: " + location
    result += "title: " + title
    result
  }
}