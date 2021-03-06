import org.apache.spark.rdd.RDD

def simpleWordCount(rdd: RDD[String]): RDD[(String, Int)] = {
  val words = rdd.flatMap(_.split(" "))
  val wordPairs = words.map((_, 1))
  val wordCounts = wordPairs.reduceByKey(_ + _)

  wordCounts

}


def withStopWordsFiltered(rdd: RDD[String], illegalTokens: Array[Char], stopWords :Set[String]): RDD[(String, Int)] = {
  val separators = illegalTokens ++ Array[Char](' ')
  val tokens: RDD[String] = rdd.flatMap(_.split(separators).map(_.trim.toLowerCase))
  val words = tokens.filter(token => !stopWords.contains(token) && (token.length >0))
  val wordPairs = words.map((_,1))
  val wordCounts = wordPairs.reduceByKey(_ + _)
  wordCounts

}


def simpleSparkProgram(rdd: RDD[Double]): Long = {
  //stage1
  rdd.filter(_<1000.0)
    .map(x => (x,x))
  //stage2
    .groupByKey()
    .map{ case (value,groups) => (groups.sum,value)}
  //stage3
    .sortByKey()
    .count()


}




