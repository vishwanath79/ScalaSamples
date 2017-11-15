//Bufferred Input Stream

import java.io.FileInputStream
import java.io._

import scala.tools.nsc.interpreter.InputStream
trait Buffered extends InputStream {


  val SIZE = 1024
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {

      end = super.read(buffer, 0, SIZE)
      pos = 0

    }
    if (pos == end) -1 else {
      pos += 1
      buffer(pos - 1)
    }
  }
}

val myStream = new FileInputStream("/Users/vsubr2/Projects/Pyspark/FasterDataProcessingSpark2/data/dt_2017.txt") with Buffered

myStream.read()
myStream.read()