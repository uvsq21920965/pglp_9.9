package commande;

import shape.Point;
import shape.Triangle;

/**
 * CommandeCreateT classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandCreateT implements Command {

  /**
   * le nom du triangle.
   */
   private String name;

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
  private Point point;

  /**
   * id du groupe de cercle;
   */
   private int groupId;

  /**
   * constructeur.
   * @param nameRatt nom du triangle.
   * @param pointT point de reference.
   * @param lengthAtt la longueur du triangle.
   * @param widthAtt la largeur du triangle.
   * @param groupId le id du groupe du triangle.
   */
  public CommandCreateT(String nameAtt,Point pointAtt ,double baseAtt,double heightAtt,int groupIdAtt) {
    name = nameAtt;
    point = pointAtt;
    base = baseAtt;
    height = heightAtt;
    groupId = groupIdAtt;
  }

  /**
   * methode pour creer nouvelle cercle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    new Triangle(name,point,base,height,groupId);
  }
}
