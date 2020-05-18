package commande;

public interface ICommandAffiche extends Command {
  /**
   * appliquer une commande affiche.
   */
	  String execute();
}
