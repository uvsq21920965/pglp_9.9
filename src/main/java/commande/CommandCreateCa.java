package commande;

import shape.Carre;
import shape.Point;

/**
 * CommandCreateCa
 * @author Sarra Belmahdi.
 *
 */
public class CommandCreateCa implements CommandCreate<Carre> {
  /**
   * nom du carre.
   */
  private String name;

  /**
   * le cote du carre.
   */
  private double side;

  /**
   * le point leftTop du carre.
   */
  private Point point;

  /**
   * id du groupe de carre
   */
  private int groupId;

  /**
   * Constructeur.
   * @param nameCarre le nom du carrée. 
   * @param pointR point de reference.
   * @param side le coté du carrée.
   * @param groupId le id du groupe du caree.
   */
  public CommandCreateCa(String nameAtt,Point pointAtt,double sideAtt,int groupIdAtt) {
    name = nameAtt;
    point = pointAtt;
    side = sideAtt;
    groupId = groupIdAtt;
  }

  /**
   * methode pour appliquer creer un nouveau carre .
   */
  @Override
  public Carre execute() {
    // TODO Auto-generated method stub
    return new Carre(name,point,side,groupId);
  }
}
