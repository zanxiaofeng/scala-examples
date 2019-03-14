package logs

class TaskManager extends Log {
  def runTask(task: () => Unit) {
    log(3, "Run task with logers")
  }
}