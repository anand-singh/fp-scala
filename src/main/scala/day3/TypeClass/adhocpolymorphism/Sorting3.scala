package day3.TypeClass.adhocpolymorphism

import day1.Shape
import day3.Implicits.sample.models.Employee
import day3.TypeClass.subtypingpolymorphism.Company

object Sorting3 {
  def sort[A](collection: List[A])(compare: (A, A) => Int): List[A] = collection match {
    case Nil => Nil
    case h :: t => insert(h, sort(t)(compare))(compare)
  }

  private def insert[A](elem: A, collection: List[A])(compare: (A, A) => Int): List[A] = {
    collection match {
      case Nil => List(elem)
      case h :: t if compare(elem, h) < 0 => h :: collection
      case h :: t => h :: insert(elem, t)(compare)
    }
  }
}

object Sorting3_helper {
  val compareCompany: (Company, Company) => Int = (c1 , c2) => {
    if(c1.strength < c2.strength) -1
    else if(c1.strength > c2.strength) 1
    else 0
  }

  def compare(s: String, t: String): Int = ???
  def compare(d: Employee, t: Employee): Int = ???

  val compareShape: (Shape, Shape) => Int = (c1, c2) => ???

  val listCompanies: List[Company] = ???

  Sorting3.sort(listCompanies)(compareCompany)
  Sorting3.sort(List.empty[Employee])(compare)
}
