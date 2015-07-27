package grabowiecki.marcin.knightproblem

/**
 * Created by marcin grabowiecki on 2015-07-25.
 */
object Knight {

  private val possibleMoves = List(
    Position(1, 2),
    Position(-1, 2),
    Position(1, -2),
    Position(-1, -2),
    Position(2, 1),
    Position(-2, 1),
    Position(2, -1),
    Position(-2, -1))

  //tood add
  //@tailrec
  def moveTo(checkBoard: CheckBoard, coordinates: Position): Unit = {
    checkBoard.visit(coordinates)
    getPossibleMovesFor(coordinates, checkBoard)
      //.par
      .foreach(possibleMove => {
      moveTo(new CheckBoard(checkBoard), possibleMove)
    })
  }

  def getPossibleMovesFor(coordinate: Position, onCheckBoard: CheckBoard): List[Position] = {
    possibleMoves
      .map(possibleMove=>coordinate.add(possibleMove))
      .filter(possibleMove=>validateMove(possibleMove, onCheckBoard))
  }

  private def validateMove(moveTo: Position, checkBoard: CheckBoard): Boolean = {
    if (moveTo.x < 0 || moveTo.y < 0) return false
    if (moveTo.x >= checkBoard.width||moveTo.y >= checkBoard.height) return false
    if (checkBoard.getVisitOrder(moveTo) > 0) return false
    true
  }

}
