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
   * id du groupe de cercle;
   */
  private int groupId;

  /**
   * Constructeur.
   * @param nameCatt nom du cercle.
   * @param pointC centre du cercle.
   * @param radiusAtt rayon du cerle.
   * @param groupId le id du groupe du cercle.
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
	// TODO Auto-generated method stub
    return new Cercle(name,point,radius,groupId);
  }
}
