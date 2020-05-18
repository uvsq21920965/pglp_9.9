package commande;

import shape.Carre;

/**
 * CommnandMoveCa classe.
 * @author sarra Belmahdi.
 *
 */
public class CommandMoveCa implements ICommand{

  /**
   * attribut carre.
   */
  private Carre ca;

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
   * @param caAtt objet carre.
   * @param xAtt coordonnée x du deplacement.
   * @param yAtt coordonnée y du deplacement.
   */
  public CommandMoveCa(Carre caAtt,double xAtt,double yAtt) {
    ca = caAtt;
    x = xAtt;
    y = yAtt;
  }

  /**
   * methode pour deplacer le carre.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    ca.move(x, y);
  }
}