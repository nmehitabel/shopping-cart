package hmrc.shoppingcart

object Checkout {

  /**
  * Apply the offer adjustment to a list of a particular item from a basket
  * @param item     a basket item
  * @param quantity number of item in basket
  $ @return adjusted quantity of items multiplied bt item price
  */
  def applyOffer(item: Fruit, quantity: Int): Int =
    Offer.priceAdjustment(item)(quantity) * item.price

  /**
  * Total price of basket after item offers have been applied
  * @param basket Basket containing list of items
  * @return total price of basket after offers applied for each constituent item
  */
  def total(basket: Basket): Int  = {
    // split basket contents into product type
    val groupedItems: Map[Fruit, List[Fruit]] = basket.items.groupBy(identity)

    val itemSubTotals: Iterable[Int] = for {
      (itemType, items ) <- groupedItems
    } yield applyOffer(itemType, items.length)

    itemSubTotals.sum
  }
}
