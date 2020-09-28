package logs

trait Log {
  def log(level: Int, message: String) = println("log...")
}