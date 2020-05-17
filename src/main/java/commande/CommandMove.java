package commande;

/**
 * interface Commande.
 * @author Sarra Belmahdi.
 *
 */
public interface CommandMove extends Command {

  /**
   * appliquer une commande move.
   */
  void execute();
}
