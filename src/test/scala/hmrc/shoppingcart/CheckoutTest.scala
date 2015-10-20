package hmrc.shoppingcart

import org.scalatest._

class CheckoutTest extends FlatSpec with Matchers {
  "An empty Shopping Basket" should "return a total of 0" in {
    val emptyBasket = Basket(List.empty[Fruit])
    Checkout.total(emptyBasket) should be (0)
  }

  "A populated Shopping basket" should "be totalled correctly" in {
    val populatedBasket = Basket(List(Apple, Orange, Apple, Orange, Apple))
    Checkout.total(populatedBasket) should be (230)
  }
}
