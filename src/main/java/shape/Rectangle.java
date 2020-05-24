package shape;

/**
 * Rectangle classe.
 * @author Sarra Belmahdi.
 *
 */
public class Rectangle extends Shape {

  /**
   * point en haut à gauche du réference rectangle.
   */
  private Point leftTop;
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
   * @param groupId le id du groupe du rectangle.
   */
  public Rectangle(String nameRatt,Point pointR ,double lengthAtt,double widthAtt,int groupId) {
    super(nameRatt,groupId);
    this.leftTop = pointR;
    this.length = lengthAtt;
    this.width = widthAtt;
  }

  /**
   * methode poue accéderau point en haut à gaud=che du rectangle.
   * @return
   */
  public Point getLeftTop() {
    return leftTop;
  }

  /**
   * methode pour modifier le point en haut à gauche du rectangle.
   *  @param leftTop nouveuax point.
   */
  public void setLeftTop(Point leftTop) {
    this.leftTop = leftTop;
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
   * methode pour déplacer le rectagle par x et y.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  @Override
  public void move(double x, double y) {
	leftTop.setX(leftTop.getX()+x);
	leftTop.setY(leftTop.getY()+y);
  }

  /**
   * methode pour afficher les caractéristiques du rectangle.
   * @return les caractéristiques
   */
  @Override
  public String affiche() {
	Point point = this.getLeftTop();
    return this.getName()+" = Rectangle(point de reférence("+point.getX()+","
	    +point.getY()+"),longueur="+this.getLength()+", largeur="+this.getWidth()+")";
  }
}
