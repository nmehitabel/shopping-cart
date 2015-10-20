package hmrc.shoppingcart

import org.scalatest._

class CheckoutTest extends FlatSpec with Matchers {
  "An empty Shopping Basket" should "return a total of 0" in {
    val emptyBasket = Basket(List.empty[Fruit])
    Checkout.total(emptyBasket) should be (0)
  }

  "Apple Offer" should "be applied correctly" in {
    val apples1 = Basket(List(Apple))
    Checkout.total(apples1) should be (Apple.price)
    val apples2 = Basket(List(Apple, Apple))
    Checkout.total(apples2) should be (Apple.price)
    val apples5 = Basket(List(Apple, Apple, Apple, Apple, Apple))
    Checkout.total(apples5) should be (Apple.price * 3)
  }

  "Orange Offer" should "be applied correctly" in {
    val oranges1 = Basket(List(Orange))
    Checkout.total(oranges1) should be (Orange.price)
    val oranges2 = Basket(List(Orange, Orange))
    Checkout.total(oranges2) should be (Orange.price * 2)
    val oranges3 = Basket(List(Orange, Orange, Orange))
    Checkout.total(oranges3) should be (Orange.price * 2)
    val oranges5 = Basket(List(Orange, Orange, Orange, Orange, Orange))
    Checkout.total(oranges5) should be (Orange.price * 4)
  }

  "Non Offer Fruit" should "Enjoy no price amendment" in {
    val bananas5 = Basket(List(Banana, Banana, Banana, Banana, Banana))
    Checkout.total(bananas5) should be (Banana.price * 5)
  }

  "Mixed basket" should "be totalled correctly" in {
    val mixedBasket = Basket(List(Orange, Banana, Apple, Apple, Orange, Orange, Banana, Orange, Orange, Orange, Apple, Apple, Orange, Banana))
    Checkout.total(mixedBasket) should be (Apple.price * 2 + Orange.price * 5 + Banana.price * 3)
  }

}
