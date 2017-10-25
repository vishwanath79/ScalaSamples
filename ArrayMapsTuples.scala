import java.util.Scanner
// Arrays , Maps and tuples

val a = new Array[Int](10)

for (i <- 0 until a.length) a(i) = i * i

a

for (elem <- a) println(elem)

//Array buffer for variable length arrays

import com.sun.java.swing.action.AlignCenterAction

import scala.collection.mutable.ArrayBuffer
val b =  ArrayBuffer("This","is","a","test")

b += "really"

b += ".And another one"

b ++= Array("or","such")

b.remove(3)

b.insert(3,"lots of tests")

b

b.trimEnd(5)

b


// TRANSFORM ARRAYS

val c = Array(2,3,4,5)

val result = for (elem <- c) yield 2*elem


//COMMON ARRAY ALGORITHMS

val d = ArrayBuffer(1,7,2,9)
d.sorted
d.reverse

Array(1,2,3).toString
Array(1,2,3).mkString("#")


//MAPS AND TUPLES


val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
scores

val mscores = scala.collection.mutable.Map("Alice" -> 10)

"Alice" -> 10

val bobScore = scores("Bob")

//scores("fred") will give key not found

scores.getOrElse("fred", 10)


//vars are mutable

for ((k,v) <- scores) yield (v,k)

//tuple postions start with 1

val t = (1,3.14, "fred")
t._2
t._1

//pattern matching method

val (_, second, third) = t


//Given an array buffer with positive nad negative integers. Remove all but the first negative number.
//U se until and for/yield.

val buf = ArrayBuffer(1,2,-3,4,-5,6,-7,8)

//get the indexes that are negative

/*val indexes = for (i<-0 until buf.length if buf(i) <0) yield i

print(indexes)

val indexesToRemove = indexes.drop(1)

print(indexesToRemove)

for (i <- indexesToRemove.reverse) buf.remove(i)

print(buf)*/

//wrap above statemetns into a function

def removeAllButFirstNegative(buf: ArrayBuffer[Int]): Unit = {

  val indexes = for (i<-0 until buf.length if buf(i) <0) yield i

  print(indexes)

  val indexesToRemove = indexes.drop(1)

  print(indexesToRemove)

  for (i <- indexesToRemove.reverse) buf.remove(i)

  print(buf)

}

removeAllButFirstNegative(buf)

//WORDCOUNT

val in = new java.util.Scanner(new java.net.URL (
  "http://horstmann.com/presentations/livelessons-scala-2016/alice30.txt").openStream)
var count = scala.collection.mutable.Map[String, Int]()
while (in.hasNext) {
  val word = in.next()
  count = count + (word -> (count.getOrElse(word,0) + 1))
}

count("Alice")
count("Rabbit")


//PARTITIONING

"New York IS ".partition(_.isUpper)

val buf1 = ArrayBuffer(1,2,-3, -4, -5,-6,7,8)
val (neg,pos) = buf1.partition(_ < 0)
val result1 = pos
result1 += neg(0)
result1




