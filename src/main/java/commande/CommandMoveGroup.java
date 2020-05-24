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
  private double x1;

  /**
   * l'attribut de coordonnée y du deplacement.
   */
  private double y1;

  /**
   * constructeur.
   * @param gsAtt objet roupe.
   * @param x1Att coordonnée x du deplacement.
   * @param y1Att coordonnée y du deplacement.
   */
  public CommandMoveGroup(GroupShapes gsAtt,double x1Att,double y1Att) {
    gs = gsAtt;
    x1 = x1Att;
    y1 = y1Att;
  }

  /**
   * methode pour deplacer le groupe de formes.
   */
  @Override
  public void execute() {
    // TODO Auto-generated method stub
    gs.move(x1, y1);
  }
}
