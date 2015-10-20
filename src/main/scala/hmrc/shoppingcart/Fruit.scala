package hmrc.shoppingcart

sealed trait Fruit {
  def price: Int
}

final case object Apple extends Fruit {
  val price: Int = 60
}

final case object Orange extends Fruit {
  val price: Int = 25
}

case class Basket(items: List[Fruit])
