package grabowiecki.marcin.knightproblem

/**
 * Created by marcin grabowiecki on 2015-07-25.
 */
case class Position (val x:Int,val y:Int){
  def apply(x:Int,y:Int)=new Position(x,y)
  def add(coordinates: Position) = Position(coordinates.x+x,coordinates.y+y)
}
