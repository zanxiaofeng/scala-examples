package classes

import scala.reflect.BeanProperty

class Person1(val firstName: String, var lastName: String) extends Ordered[Person1] {
  def compare(that: Person1) = firstName.compareTo(that.firstName)

}

class Person2(@BeanProperty val firstName: String, @BeanProperty var lastName: String)

class Person3(var firstName: String, var lastName: String)