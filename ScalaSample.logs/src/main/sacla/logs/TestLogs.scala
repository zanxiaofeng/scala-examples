package logs

object TestLogs extends App {
  //case 1:
  println("case 1:")
  val manager = new TaskManager() with ConsoleLog with TimeStampLog;
  manager.runTask(() => println("Hello"));

  //case 2:
  println("\ncase 2:")
  val loger1 = new Log() with ConsoleLog with TimeStampLog with MaxLengthLog {
    val maxLength: Int = 30
  }
  loger1.log(1, "Hello Davis.Zan, You are welcome!")

  //case 3:
  println("\ncase 3:")
  val loger2 = new Log() with ConsoleLog with TimeStampLog with MaxLengthLog with LevelFilterLog {
    val maxLength: Int = 30
    def isAllow(level: Int): Boolean = level < 2
    val doesAllow = null;
  }
  loger2.log(1, "Hello Davis.Zan, You are welcome!")
  loger2.log(2, "Hello Davis.Zan, You are welcome!")

  //case 3:
  println("\ncase 4:")
  val loger3 = new Log() with ConsoleLog with TimeStampLog with MaxLengthLog with LevelFilterLog {
    val maxLength: Int = 30
    def isAllow(level: Int): Boolean = level < 2
    val doesAllow = (level: Int) => true;
  }
  loger3.log(1, "Hello Zanxiaofeng, You are welcome!")
  loger3.log(2, "Hello Zanxiaofeng, You are welcome!")
  
  
  
}