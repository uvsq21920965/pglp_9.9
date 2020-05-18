package commande;

import shape.GroupShapes;

public class CommandAfficheGroup implements ICommandAffiche {

  /**
   * attribut groupe de formes.
   */
  private GroupShapes gs;

  /**
   * constructeur.
   * @param gsAtt le groupe à afficher.
   */
  public CommandAfficheGroup(GroupShapes gsAtt) {
    this.gs = gsAtt;	
  }

  /**
   * méthode pour afficher le groupe de formes.
   */
  @Override
  public String execute() {
    return gs.Affiche();
  }
}