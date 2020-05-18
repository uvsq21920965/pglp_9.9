package commande;

import shape.Triangle;

/**
 * CommandMoveT classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandMoveT implements ICommand {

  /**
   * attribut triangle.
   */
  private Triangle t;

  /**
   * l'attribut de coordonnée x du deplacement.
   */
  private double x;

  /**
   * l'attribut de coordonnée y du deplacement.
   */
  private double y;

  /**
   * constructeur.
   * @param caAtt objet rectangle.
   * @param xAtt coordonnée x du deplacement.
   * @param yAtt coordonnée y du deplacement.
   */
  public CommandMoveT(Triangle tAtt,double xAtt,double yAtt) {
    t = tAtt;
    x = xAtt;
    y = yAtt;
  }

  /**
   * methode pour deplacer le retangle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    t.move(x, y);
  }
}