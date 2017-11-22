// Functional Programming

import scala.math._

val num = 3.14 // type: Double
val fun = ceil _
ceil(num)

// Currying = turning a function that takes two arguments into a function that takes one argument
// That function retuns a function that consumes the second argument

def mul(x: Int, y:Int) = x * y
def mulOneAtATime(x:Int) = (y:Int) => x * y
mulOneAtATime(3)(14)

// Higher order functions instead of loops

val zones = java.util.TimeZone.getAvailableIDs
zones.map(s => s.split("/")).filter(a => a.length >1).map(a => a(1))

// short cut for above
//zones.map(s => s.split("/")).filter(_.length >1).map(a => a(1))
zones.map(s => s.split("/")).filter(a => a.length >1).map(a => a(1)).grouped(10).toArray.map(a => a(0))


//reduce Left
1.to(10).reduceLeft(_ * _)
def fac(n :Int) = 1.to(n).reduceLeft(_ * _)
fac(10)


1.to(10).map(n => 2).reduceLeft(_ * _)

def pow(a: Int, b:Int) = 1.to(b).map(n => a).reduceLeft(_ * _)
pow(2,16)

// While
def While(cond: () => Boolean, body:() => Unit) {
  if (cond()) {
    body(); While(cond, body)
  }
}

val n  = 10
var i = 1
var f = 1

While(() => i < n, () => { f *= i; i += 1} )
