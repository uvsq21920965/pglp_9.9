package commande;

import shape.Cercle;
import shape.Point;

/**
 * CommandeCreateC classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandCreateC implements CommandCreate<Cercle> {

  /**
   * nom du cercle.
   */
  private String name;

  /**
   * le rayon du cercle.
   */
  private double radius;

  /**
   * le centre du cercle.
   */
  private Point point;

  /**
   * id du groupe de cercle.
   */
  private int groupId;

  /**
   * Constructeur.
   * @param nameAtt nom du cercle.
   * @param pointAtt centre du cercle.
   * @param radiusAtt rayon du cerle.
   * @param groupIdAtt le id du groupe du cercle.
   */
  public CommandCreateC(String nameAtt,Point pointAtt,double radiusAtt,int groupIdAtt) {
    name = nameAtt;
    point = pointAtt;
    radius = radiusAtt;
    groupId = groupIdAtt;
  }

  /**
   * methode pour creer nouvelle cercle.
   */
  @Override
  public Cercle execute() {
    return new Cercle(name,point,radius,groupId);
  }
}
