package commande;

import shape.Carre;

/**
 * CommnandMoveCa classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandMoveCa implements ICommand {

  /**
   * attribut carre.
   */
  private Carre ca;

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
   * @param caAtt objet carre.
   * @param x1Att coordonnée x du deplacement.
   * @param y1Att coordonnée y du deplacement.
   */
  public CommandMoveCa(Carre caAtt,double x1Att,double y1Att) {
    ca = caAtt;
    x1 = x1Att;
    y1 = y1Att;
  }

  /**
   * methode pour deplacer le carre.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    ca.move(x1, y1);
  }
}