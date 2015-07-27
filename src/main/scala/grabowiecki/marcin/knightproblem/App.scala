package grabowiecki.marcin.knightproblem

import scala.annotation.tailrec
/**
 * @author ${user.name}
 */
object App {

  var solutionCount=0;
  
  def main(args: Array[String]) {
    val start=System.currentTimeMillis
    moveTo(new CheckBoard(Coordinates(5, 6)), Coordinates(0,0))
    println((System.currentTimeMillis()-start)/1000)
  }

  //tood add
  //@tailrec
  def moveTo(checkBoard: CheckBoard, coordinates: Coordinates): Unit = {
    checkBoard.visit(coordinates)
    printCheckBoardOnComplete(checkBoard)
    Knight
      .getPossibleMovesFor(coordinates, checkBoard)
      //.par
      .foreach(possibleMove => {
        moveTo(new CheckBoard(checkBoard), possibleMove)
      })
  }


  def printCheckBoardOnComplete(checkBoard: CheckBoard): Unit = {
    if (checkBoard.isComplete) {
      solutionCount = solutionCount + 1;
      println(solutionCount)
      checkBoard.printCheckBoard
    }
  }
}
