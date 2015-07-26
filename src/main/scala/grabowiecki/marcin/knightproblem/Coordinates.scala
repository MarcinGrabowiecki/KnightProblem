package grabowiecki.marcin.knightproblem

/**
 * Created by marcin grabowiecki on 2015-07-25.
 */
case class Coordinates (val x:Int,val y:Int){
  def apply(x:Int,y:Int)=new Coordinates(x,y)
  def add(coordinates: Coordinates) = Coordinates(coordinates.x+x,coordinates.y+y)
}
