package commande;

public interface CommandCreate<T> extends Command {

  /**
   * appliquer une commande create l'objet T.
   */
  T execute();
}
