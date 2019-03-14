package classes

class date(day: Int, month: Int, year: Int) {
  print(day)
  
  
  def this(day: Int, month: Int) = {
    this(day, month, 2012)
    
    }
  def this(day:Int)={
    this(day,12)
  }
  def output = println(day + "/" + month + "/" + year)
  def `how are you` {
    print("how are you, ")
    output
  }
}

object date {
  def apply(day: Int, month: Int, year: Int) = {
    new date(day, month, year);
  }
}