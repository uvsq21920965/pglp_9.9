package shape;

public class Carre extends Rectangle {

  /**
   * le coté du carrée.
   */
  private double side;

  /**
   * constructeur.
   * @param nameCarre le nom du carrée. 
   * @param pointCa point de reference.
   * @param sideAtt le coté du carrée.
   * @param groupId le id du groupe du caree.
   */
  public Carre(String nameCarre,Point pointCa, double sideAtt,int groupId) {
    super(nameCarre, pointCa, sideAtt, sideAtt,groupId);
    side = sideAtt;
  }
 
  /**
   * methode pour acceder au coté.
   * @return lle coté.
   */
  public double getSide() {
    return side;
  }

  /**
   * methode pour afficher les caractéristiques du Carre.
   * @return les caractéristiques.
   */
  @Override
  public String affiche() {
    Point point = this.getLeftTop();
    return this.getName() + " = Carre( point de reférence(" + point.getX() + ","
        + point.getY() + "),coté = " + this.getSide() + ")";
  }

}
