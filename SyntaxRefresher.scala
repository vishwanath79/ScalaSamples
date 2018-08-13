// Databricks notebook source
//syntax refresher
//pass objects to function

def changeCharacters(s: String, fun:Character => Character) = {
  val sb = new StringBuilder()
  val chars = s.toCharArray()
  for (i<-0 until s.length()) {
    sb += fun(chars(i))
  }
  sb.toString
}

def capitalize(c:Character) = Character.toUpperCase(c)

changeCharacters("Hello world", capitalize)

// COMMAND ----------

//varmutable
//regex
val testString = "Everything is 777"
val pattern = """.* ([\d]+).*""".r
val pattern(answerString) = testString
val answer = answerString.toInt
println(answer)

// COMMAND ----------

//for loops
for (x<-1 to 4) {
  val squared = x*x
  println(squared)
}

// COMMAND ----------

val number =3
number match {
  case 1 => println("One")
  case 2 => println("two")
  case 3 => println("three")
  case _ => println("etc")
                   
}

// COMMAND ----------

//while
var x = 10
while (x>= 0) {
  println(x)
  x -= 1
}

// COMMAND ----------

//do while

do {println(x); x+=1} while (x<=10)

// COMMAND ----------

//Expressions 
{val x =10; x+20}
print({val x =10; x+20})

// COMMAND ----------

def squareIt(x: Int): Int = {
  x* x
}

squareIt(2)
//function f expects an integer parameter
def transformInt(x:Int,f:Int => Int) : Int = {
  f(x)
}

val result = transformInt(2,squareIt)



// COMMAND ----------

//Lamdra functions - anonymous functions
transformInt(3, x => x*x*x)
transformInt(10, x=> x/2)
transformInt(2,x=> {val y =x*2;y*y})

// COMMAND ----------

//Data Structures
val stuff = ("val1","val2","val3")
println(stuff)


// COMMAND ----------

println(stuff._1)
println(stuff._2)
println(stuff._3)

// COMMAND ----------

//key value - start with 1
val kv = "key1" -> "value1"
println(kv._2)

// COMMAND ----------

//lists - start with 0
val shiplist = List("Enterprise", "Defiant", "voyager")
println(shiplist(1))
println(shiplist.head)
println(shiplist.tail)

// COMMAND ----------

//iterating through a list
for (ship <- shiplist) {println(ship)}

// COMMAND ----------

// Apply a function literal to a list! map() cna be used to apply any function to every item in a collection

val backwards = shiplist.map((ship: String) => {ship.reverse})

for (ship <- backwards) {println(ship)}

// COMMAND ----------

val numberList = List(1,2,3,4,5)
val sum = numberList.reduce((x:Int,y:Int) => x+y)

// COMMAND ----------

//filter () remove stuff you dont want
val ihatefives = numberList.filter((x:Int) => x!=5)

val ihatethrees = numberList.filter(_ != 3)


// COMMAND ----------

//Maps

val shipmap = Map("Kirk" -> "Enterpise", "Picard" -> "Enterprise-D")
println(shipmap("Kirk"))

// COMMAND ----------

println(shipmap.contains("Archer"))

// COMMAND ----------

val archership = util.Try(shipmap("archer")) getOrElse "unknown"

// COMMAND ----------


