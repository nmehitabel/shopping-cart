package hmrc.shoppingcart

object Offer {
  /**
  * Return a function to cacluate the number of items to charge for based on the offer rule
  * of the item type e.g apples 2 for 1
  * @return funtion to apply quantity adjustment for basket item
  */
  def priceAdjustment(fruit: Fruit): (Int => Int) = fruit match {
    case Apple => apples: Int => apples / 2 + apples % 2
    case Orange => oranges: Int => (oranges / 3 * 2) + oranges % 3
    case _ => ignored: Int => ignored
  }
}
