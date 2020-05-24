package commande;

import shape.Point;
import shape.Triangle;

/**
 * CommandeCreateT classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandCreateT implements CommandCreate<Triangle> {

  /**
   * le nom du triangle.
   */
  private String name;

  /**
   * la base du triangle.
   */
  private double base;

  /**
   * la hauteur du triangle.
   */
  private double height;
 
  /**
   * le point sommet du triangle.
   */
  private Point point;

  /**
   * id du groupe de triangle.
   */
  private int groupId;

  /**
   * constructeur.
   * @param nameAtt nom du triangle.
   * @param pointAtt point de reference.
   * @param baseAtt la longueur du triangle.
   * @param heightAtt la largeur du triangle.
   * @param groupIdAtt le id du groupe du triangle.
   */
  public CommandCreateT(String nameAtt,Point pointAtt,
      double baseAtt,double heightAtt,int groupIdAtt) {
    name = nameAtt;
    point = pointAtt;
    base = baseAtt;
    height = heightAtt;
    groupId = groupIdAtt;
  }

  /**
   * methode pour creer nouveau triangle.
   */
  @Override
  public Triangle execute() {
    // TODO Auto-generated method stub
    return new Triangle(name,point,base,height,groupId);
  }
}
