package grabowiecki.marcin.knightproblem

import scala.annotation.tailrec
/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    val start=System.currentTimeMillis
    Knight.moveTo(new CheckBoard(Coordinates(5, 5)), Coordinates(0,0))
    println((System.currentTimeMillis()-start)/1000)
  }



}
