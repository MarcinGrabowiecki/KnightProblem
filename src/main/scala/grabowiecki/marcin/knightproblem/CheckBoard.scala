package grabowiecki.marcin.knightproblem

import java.util

/**
 * Created by m on 2015-07-25.
 */
case class CheckBoard (val size: Position){

  private var counter=1;
  private val checkBoardMatrix=Array.ofDim[Int](size.x,size.y)

  val width = size.x
  val height = size.y

  def getVisitOrder(coordinates: Position):Int = checkBoardMatrix(coordinates.x)(coordinates.y)

  def visit(position: Position) = {
    checkBoardMatrix(position.x)(position.y) = counter
    counter=counter+1
    if(isComplete) {
      //printCheckBoard
      CheckBoard.solutions=CheckBoard.solutions+1
    }
  }

  def this(oldCheckBoard: CheckBoard)={
    this(oldCheckBoard.size)
    counter=oldCheckBoard.counter
//    for(x <- 0 to size.x-1){
//      checkBoardMatrix(x)=util.Arrays.copyOf(oldCheckBoard.checkBoardMatrix(x),height)
//    }

    for(x <- 0 to size.x-1;
        y <- 0 to size.y-1)
          checkBoardMatrix(x)(y)=oldCheckBoard.checkBoardMatrix(x)(y)
  }

  def printCheckBoard={
    println(CheckBoard.solutions+ "---\t"*size.y)
    for( row <- checkBoardMatrix) {
      for( elem <- row) print(f"${elem}\t")
      println
    }
    println("---\t"*size.y)
  }

  def isComplete:Boolean={
    for { row  <- checkBoardMatrix ; elem <- row } yield if(elem==0) return false
    true
  }
}

object CheckBoard{
  private var solutions=0;
}