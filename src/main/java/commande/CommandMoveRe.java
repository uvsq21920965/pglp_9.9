package commande;

import shape.Rectangle;

/**
 * CommandMoveRe Classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandMoveRe implements Command {

  /**
   * attribut rectangle.
   */
  private Rectangle r;

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
  public CommandMoveRe(Rectangle rAtt,double xAtt,double yAtt) {
    r = rAtt;
    x = xAtt;
    y = yAtt;
  }

  /**
   * methode pour deplacer le retangle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    r.move(x, y);
  }
}
