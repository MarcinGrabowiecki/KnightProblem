package grabowiecki.marcin.knightproblem

/**
 * Created by marcin grabowiecki on 2015-07-25.
 */
object Knight {

  private val possibleMoves = List(
    Coordinates(1, 2),
    Coordinates(-1, 2),
    Coordinates(1, -2),
    Coordinates(-1, -2),
    Coordinates(2, 1),
    Coordinates(-2, 1),
    Coordinates(2, -1),
    Coordinates(-2, -1))

  //tood add
  //@tailrec
  def moveTo(checkBoard: CheckBoard, coordinates: Coordinates): Unit = {
    checkBoard.visit(coordinates)
    getPossibleMovesFor(coordinates, checkBoard)
      //.par
      .foreach(possibleMove => {
      moveTo(new CheckBoard(checkBoard), possibleMove)
    })
  }

  def getPossibleMovesFor(coordinate: Coordinates, onCheckBoard: CheckBoard): List[Coordinates] = {
    possibleMoves
      .map(possibleMove=>coordinate.add(possibleMove))
      .filter(possibleMove=>validateMove(possibleMove, onCheckBoard))
  }

  private def validateMove(moveTo: Coordinates, checkBoard: CheckBoard): Boolean = {
    if (moveTo.x < 0 || moveTo.y < 0) return false
    if (moveTo.x >= checkBoard.width||moveTo.y >= checkBoard.height) return false
    if (checkBoard.getVisitOrder(moveTo) > 0) return false
    true
  }

}
