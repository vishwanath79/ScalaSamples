//SIMPLE CLASS

class Point(val x:Double, val y:Double) {

  println (f"Welcome to (${x}, ${y})")
  def move(dx: Double, dy:Double) = new Point(x+dx,y+dy)
  def distanceFromOrigin = math.sqrt(x*x + y*y)
  override def toString = f"(${x},${y})"


}

val p = new Point(3,4)

p.move(10,20)

p.distanceFromOrigin

p.x
p.y
// move mthod generates a new point, does not mutate it

//Cannot mutate vals

//operator notation for binary methods

1 to 10 map (3 * _) filter (_ % 5 == 2)
// is the same as
1.to(10).map(3 *_).filter(_ % 5 == 2)


object Accounts {

  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber +=1; lastNumber}
}

Accounts.newUniqueNumber()
Accounts.newUniqueNumber()

