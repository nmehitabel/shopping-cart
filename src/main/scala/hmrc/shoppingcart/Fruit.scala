package hmrc.shoppingcart

/**
* Shopping cart item types
*/
sealed trait Fruit {
  def price: Int
}

final case object Apple extends Fruit {
  val price: Int = 60
}

final case object Orange extends Fruit {
  val price: Int = 25
}

final case object Banana extends Fruit {
  val price: Int = 35
}

case class Basket(items: List[Fruit])
