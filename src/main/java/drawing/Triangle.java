package drawing;

public class Triangle extends Shape{

  /**
   * la base du triangle.
   */
	  private double base;

  /**
   * la hauteur du triangle;
   */
  private double height;
  /**
   * le point sommet du triangle.
   */
   private Point top;

	  /**
	   * constructeur.
	   * @param nameRatt nom du rectangle.
	   * @param pointR point de reference.
	   * @param lengthAtt la longueur du rectangle.
	   * @param widthAtt la largeur du rectangle.
	   */
  public Triangle(String nameT,Point pointT ,double baseAtt,double heightAtt) {
    super(nameT,pointT);
    base = baseAtt;
    height= heightAtt;
    top=pointT;
  }

  /**
   * methode pour acceder la base.
   * @return base.
   */
  public double getBase() {
    return base;
  }

  /**
   * methode pour acceder la hauteur.
   * @return hauteur.
   */
  public double getHeight() {
    return height;
  }
  /**
   * methode pour acceder au sommet.
   * @return sommet.
   */
  public Point getTop() {
    return top;
  }

  /**
   * methode pour afficher les caractéristiques du triangle.
   * @return les caractéristiques.
   */
  @Override
  public String Affiche() {
    Point point = this.getPointRef();
      return this.getName()+" = Triangle(Sommet("+point.getX()+","
        +point.getY()+"),base="+this.getBase()+", hauteur="+this.getHeight()+")";
	  }
}
