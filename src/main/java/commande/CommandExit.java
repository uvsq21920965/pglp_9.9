package commande;

/**
 * CommandExit Classe.
 * @author sarre Belmahdi.
 *
 */
public class CommandExit implements ICommand {

  /**
   * methode pour fermer le programme.
   */
  @Override
  public void execute() {
    Runtime.getRuntime().exit(0);
  }
}
