package commande;

/**
 * ICommandAffiche interface.
 * @author sarre Belmahdi.
 *
 */
public interface ICommandAffiche extends Command {

  /**
   * appliquer une commande affiche.
   */
  String execute();
}
