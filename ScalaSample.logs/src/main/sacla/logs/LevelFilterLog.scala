package logs

trait LevelFilterLog extends Log {
  val doesAllow: (Int) => Boolean
  def isAllow(level: Int): Boolean
  override def log(level: Int, message: String) {
    val isallow = if (doesAllow != null) this doesAllow level else this isAllow level;
    println("Begin LevelFilterLog.log...[isAllow=" + isallow + ", level: " + level + "]")
    if (isallow) {
      super.log(level, message);
    }
    println("End LevelFilterLog.log...")
  }
}