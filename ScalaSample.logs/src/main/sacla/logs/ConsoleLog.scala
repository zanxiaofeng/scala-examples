package logs

trait ConsoleLog extends Log {
  override def log(level: Int, message: String) = {
    println("Begin ConsoleLog.log...")
    println(message)
    println("End ConsoleLog.log...")
  }
}