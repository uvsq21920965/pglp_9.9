package commande;

import shape.GroupShapes;

/**
 * CommandeMoveGroupe Classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandMoveGroup implements ICommand {

  /**
   * attribut groupe de formes.
   */
  private GroupShapes gs;

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
   * @param gsAtt objet carre.
   * @param xAtt coordonnée x du deplacement.
   * @param yAtt coordonnée y du deplacement.
   */
  public CommandMoveGroup(GroupShapes gsAtt,double xAtt,double yAtt) {
    gs = gsAtt;
    x = xAtt;
    y = yAtt;
  }

  /**
   * methode pour deplacer le groupe de formes.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    gs.move(x, y);
  }
}
