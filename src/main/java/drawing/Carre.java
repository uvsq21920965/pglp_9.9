package drawing;

public class Carre extends Rectangle {

  /**
   * le coté du carrée.
   */
  private double side;

  /**
   * constructeur.
   * @param nameCarre le nom du carrée. 
   * @param pointR point de reference.
   * @param side le coté du carrée.
   */
  public Carre(String nameCarre,Point pointCa, double sideAtt) {
    super(nameCarre, pointCa, sideAtt, sideAtt);
    side=sideAtt;
  }
 
  /**
   * methode pour acceder la largeur.
   * @return largeur.
   */
  public double getSide() {
    return side;
  }

  /**
   * methode pour afficher les caractéristiques du rectangle.
   */
  @Override
  public String Affiche() {
	Point point = this.getPointRef();
    return this.getName()+" = Carre( point de reférence("+point.getX()+","
	    +point.getY()+"),cote="+this.getSide()+")";
  }

}
