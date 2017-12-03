// Match statement

// delux version of the switch statement



// extractors can extract contents from tuples (bind variables to contents)

def swap(p : (Int, Int)) = p match { case (x,y) => (y,x)}

swap((3,4))

def swap2(a: Array[Int]) = a match {case Array(x,y, rest @_*) => Array(y,x) ++ rest}

swap2(Array(1,7,2,9))


// Article and Bundles

abstract class Item
case class Article(description: String, price : Double) extends Item
case class Bundle(description: String, discount: Double, items:Item*) extends Item

val book = Article("Scala for the impatient", 39.95)
val gift = Bundle("xmas special", 10, book, Article("Blah blah", 97.78))

def price(it: Item): Double = it match {
  case Article(_,p) => p
  case Bundle(_, disc, its @ _*) => its.map(price).sum - disc

}

price(book)
price(gift)

