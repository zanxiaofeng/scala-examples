package logs

import java.util.Date

trait TimeStampLog extends Log {
  override def log(level: Int, message: String) {
    println("Begin TimeStampLog.log...")
    super.log(level, new Date().toString() + ": " + message);
    println("End TimeStampLog.log...")
  }
}
