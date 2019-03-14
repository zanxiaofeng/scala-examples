package logs

trait MaxLengthLog extends Log {
  val maxLength: Int
  override def log(level: Int, message: String) {
    println("Begin MaxLengthLog.log...[" + message.length() + ", max: " + maxLength + "]")
    super.log(level, if (message.length() > maxLength) message.substring(0, maxLength) else message)
    println("End MaxLengthLog.log...")
  }
}