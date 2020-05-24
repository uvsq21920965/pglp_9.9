package commande;

import dao.GroupShapesJdbc;
import shape.GroupShapes;

/**
 * CoammndSave Classe.
 * @author Sarra Belmahdi.
 *
 */
public class CommandSave implements ICommand {
  /**
   * l'attribut groupe de formes.
   */
  private GroupShapes gs;

  /**
   * l'attribut groupeJdbc.
   */
  private GroupShapesJdbc gsj;

  /**
   * Constructeur.
   * @param gsAtt la groupe à sauvegarder.
   */
  public CommandSave(GroupShapes gsAtt) {
    this.gs = gsAtt;
    gsj = new GroupShapesJdbc();
  }

  /**
   * methode pour sauvgarder un dessin.
   */
  @Override
  public void execute() {
    gsj.create(gs);
  }
}
