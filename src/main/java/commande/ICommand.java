package commande;

/**
 * interface Commande.
 * @author Sarra Belmahdi.
 *
 */
public interface ICommand extends Command {

  /**
   * appliquer une commande move.
   */
  void execute();
}
