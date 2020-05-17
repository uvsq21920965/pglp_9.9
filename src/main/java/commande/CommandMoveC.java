package commande;

import shape.Cercle;

/**
 * CommandMoveC classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandMoveC implements CommandMove {

  /**
   * attribut cercle.
   */
  private Cercle c;

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
   * @param cAtt objet cercle.
   * @param xAtt coordonnée x du deplacement.
   * @param yAtt coordonnée y du deplacement.
   */
  public CommandMoveC(Cercle cAtt,double xAtt,double yAtt) {
    c = cAtt;
    x = xAtt;
    y = yAtt;
  }

  /**
   * methode pour deplacer une cercle.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    c.move(x, y);
  }
}
