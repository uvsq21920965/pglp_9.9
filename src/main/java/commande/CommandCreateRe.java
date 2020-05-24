package commande;

import shape.Point;
import shape.Rectangle;

/**
 * CommandCreateRe classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandCreateRe implements CommandCreate<Rectangle> {

  /**
   * nom du rectangle.
   */
  private String name;

  /**
   * le point leftTop du rectangle.
   */
  private Point point;

  /**
   * id du groupe de rectangle.
   */
  private int groupId;

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
   * @param nameAtt nom du rectangle.
   * @param pointAtt point de reference.
   * @param lengthAtt la longueur du rectangle.
   * @param widthAtt la largeur du rectangle.
   * @param groupIdAtt le id du groupe du rectangle.
   */
  public CommandCreateRe(String nameAtt,Point pointAtt,double lengthAtt,
      double widthAtt,int groupIdAtt) {
    name = nameAtt;
    point = pointAtt;
    length = lengthAtt;
    width = widthAtt;
    groupId = groupIdAtt;
  }

  /**
   * methode pour appliquer creer un nouveau rectangle .
   */
  @Override
  public Rectangle execute() {
    // TODO Auto-generated method stub
    return new Rectangle(name,point,length,width,groupId);
  }
}
