package hmrc.shoppingcart

object Checkout {
  import Offer._
  def applyOffer(item: Fruit, quantity: Int): Int =
    Offer.priceAdjustment(item)(quantity) * item.price

  def total(basket: Basket): Int  = {
    // split basket contents into product type
    val groupedItems: Map[Fruit, List[Fruit]] = basket.items.groupBy(identity)
    val itemSubTotals: Iterable[Int] = for {
      (itemType, items ) <- groupedItems
    } yield applyOffer(itemType, items.length)
    itemSubTotals.sum
  }
}
