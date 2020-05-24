package shape;

/**
 * Classe triangle.
 * @author sarra Belmahdi.
 *
 */
public class Triangle extends Shape {

  /**
   * la base du triangle.
   */
  private double base;

  /**
   * la hauteur du triangle .
   */
  private double height;

  /**
   * le point sommet du triangle.
   */
  private Point top;

  /**
   * constructeur.
   * @param nameT nom du triangle.
   * @param pointT point de reference.
   * @param baseAtt la longueur du triangle.
   * @param heightAtt la largeur du triangle.
   * @param groupId le id du groupe du triangle.
   */
  public Triangle(String nameT,Point pointT,double baseAtt,double heightAtt,int groupId) {
    super(nameT,groupId);
    base = baseAtt;
    height = heightAtt;
    top = pointT;
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
   * methode pour modifier le sommet.
   * @param top neveau sommet.
   */
  public void setTop(Point top) {
    this.top = top;
  }

  /**
   * methode pour déplacer le triagle par x et y.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  @Override
  public void move(double x, double y) {
    top.setX(top.getX() + x);
    top.setY(top.getY() + y);
  }

  /**
   * methode pour afficher les caractéristiques du triangle.
   * @return les caractéristiques.
   */
  @Override
  public String affiche() {
    Point point = this.getTop();
    return this.getName() + " = Triangle(Sommet(" + point.getX() + ","
        + point.getY() + "),base=" + this.getBase() + ", hauteur=" + this.getHeight() + ")";
  }
}
