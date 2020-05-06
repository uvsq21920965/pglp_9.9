package drawing;

/**
 * Rectangle classe.
 * @author Sarra Belmahdi.
 *
 */
public class Rectangle extends Shape {

  /**
   * la longueur du rectangle.
   */
  private double length;

  /**
   * la largeur du rectangle.
   */
  private double width;

  /**
   * constructeur.
   * @param nameRatt nom du rectangle.
   * @param pointR point de reference.
   * @param lengthAtt la longueur du rectangle.
   * @param widthAtt la largeur du rectangle.
   */
  public Rectangle(String nameRatt,Point pointR ,double lengthAtt,double widthAtt) {
    super(nameRatt,pointR);
    length = lengthAtt;
    width = widthAtt;
  }

  /**
   * methode pour acceder la longueur.
   * @return longueur.
   */
  public double getLength() {
    return length;
  }

  /**
   * methode pour acceder la largeur.
   * @return largeur.
   */
  public double getWidth() {
    return width;
  }

  /**
   * methode pour afficher les caractéristiques du rectangle.
   */
  @Override
  public String Affiche() {
	Point point = this.getPointRef();
    return this.getName()+" = Rectangle(point de reférence("+point.getX()+","
	    +point.getY()+"),longueur="+this.getLength()+", largeur="+this.getWidth()+")";
  }
}
