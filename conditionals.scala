object scratch_2 {

  println("Conditional expression")
  val x = -4

  val result = if (x > 0) "something"

  //conditionals
  val n = 10
  for (i <- 1 to n) println(i)

  for (c <- "Hello") println(c)

  for (i <- 1 to 3; j <- 1 to 3) println((10 * i + j) + " ")

  //guards

  for (i <- 1 to 3; j <- 1 to 3 if i != j) println((10 * i + j) + " ")

  // yield

  val result2 = for (i <- 1 to 10) yield i % 3

  //Define functions
  val s = sum(1, 3, 4, 10)

  abs(-10)

  def abs(x: Double) = if (x >= 0) x else -x

  fac(5)

  //recursive
  //return type in inferred unless function is recursive
  def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

  box("Hello")


  // named and default arguments

  def box(s: String) {

    val border = "." * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)


  }

  decorate("Hello")
  decorate("Hello", ">>>")
  decorate("Hello", right = "<<<")

  // variable number of arguments

  def decorate(str: String, left: String = "[", right: String = "]") =
    left + str + right

  def sum(args: Int*) = { //args is a Seq[Int]
    var result = 0
    for (arg <- args) result += arg
    result
  }

  sum(1 to 3: _*)

  // Lab excercise check if its a vowel

  //def isVowel(ch : Char) = ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch == 'u'

  def vowels(s: String) = {

    var result = ""
    for (ch <- s) {
      if (isVowel(ch)) result += ch
    }

    result
  }

  isVowel('d')

  //With a for loop to identify vowels in a string

  def isVowel(ch: Char) = "aeiou".contains(ch)

  vowels("Nicaragua")

  // for yield is different from earlier one because it yields a value namely whatever we want to be collecting
  //shorter and easier to read

  def vowels2(s: String) = {

    for (ch <- s if isVowel(ch)) yield ch


  }

  vowels2("Nicaragua")

//Vowels as a recursive function with a while loop

  def vowels3(s: String): String = {

    if (s.length == 0) ""
    else {
      val ch = s(0)
      val rest = vowels3(s.substring(1))
      if (isVowel(ch)) ch + rest else rest
    }
  }


  vowels3("Nicaragua")


  //WHILE LOOP

  def vowels4(s: String) = {

    var i = 0
    var result = ""
    while (i < s.length) {
      val ch = s(i)
      if (isVowel(ch)) result += ch
      i += 1
    }

    result
    }

  vowels4("Nicaragua")

//Default paramters

  def isfinalVowel(ch: Char, vowelChars: String) = vowelChars.contains(ch)

  def finalvowels2(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true) : String =
    if (ignoreCase) vowels(s.toLowerCase, vowelChars,false)
    else for (ch <- s if isfinalVowel(ch, vowelChars)) yield ch

  finalvowels2("august")

}