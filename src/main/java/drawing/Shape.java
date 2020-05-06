package drawing;

/**
 * Shape classe.
 * @author Sarra Belmahdi.
 *
 */
public abstract class Shape implements Ishape{
  /**
   * point de réference de la forme.
   */
  private Point pointRef;

  /**
   * le nom de la forme.
   */
  private String name;

  /**
   * constructeur.
   * @param nameAtt le nom e la forme.
   */
  public Shape(String nameAtt,Point pointRefAtt) {
    name = nameAtt;
    pointRef = pointRefAtt;
  }

  /**
   * methode pour déplacer la forme.
   * @param x coordonnée x du deplacement.
   * @param y coordonnée y du deplacement.
   */
  public void move(double x,double y) {
    pointRef.setX(pointRef.getX()+x);
    pointRef.setY(pointRef.getY()+y);
  }

  /**
   * methode pour accéder au point de reference.
   */
  public Point getPointRef() {
    return pointRef;
  }

  /**
   * methode pour modifier les coordonnées du point de reference.
   * @param x la nouvelle coordonnée x du point de refrence.
   * @param y la nouvelle coordonnée y du point de refrence.
   */
  public void setPointRef(double x,double y ) {
    pointRef.setX(x);
    pointRef.setY(y);
  }

  /**
   * methode pour accéder au nom de la forme.
   * @return le nom de la forme.
   */
  public String getName() {
    return name;
  }

  /**
   * methode pour modifier le nom de la forme.
   * @param name1 le nouveau nom de la forme.
   */
  public void setName(String name1) {
    name = name1;
  }

  /**
   * methode pour afficher les caractéristiques de la forme.
   */
  public abstract String Affiche();
}
