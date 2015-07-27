package grabowiecki.marcin.knightproblem

import scala.annotation.tailrec
/**
 * @author ${user.name}
 */
object App {

  def main(args: Array[String]) {
    //for(i <- 1 to 100){
    val start=System.currentTimeMillis
    Knight.moveTo(new CheckBoard(Position(5, 5)), Position(0,0))
    println((System.currentTimeMillis()-start))
      //}
  }

}
