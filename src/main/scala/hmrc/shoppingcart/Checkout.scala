package hmrc.shoppingcart

object Checkout {
  def total(basket: Basket) = basket.items.flatMap{i: Fruit => List(i.price)}.sum
}
