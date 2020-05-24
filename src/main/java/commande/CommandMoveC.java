package commande;

import shape.Cercle;

/**
 * CommandMoveC classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandMoveC implements ICommand {

  /**
   * attribut cercle.
   */
  private Cercle ce;

  /**
   * l'attribut de coordonnée x du deplacement.
   */
  private double x1;

  /**
   * l'attribut de coordonnée y du deplacement.
   */
  private double y1;

  /**
   * constructeur.
   * @param c1Att objet cercle.
   * @param x1Att coordonnée x du deplacement.
   * @param y1Att coordonnée y du deplacement.
   */
  public CommandMoveC(Cercle c1Att,double x1Att,double y1Att) {
    ce = c1Att;
    x1 = x1Att;
    y1 = y1Att;
  }

  /**
   * methode pour deplacer une cercle.
   */
  @Override
  public void execute() {
    ce.move(x1, y1);
  }
}
