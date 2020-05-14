package commande;

public class CommandExit implements Command{

  /**
   * methode pour fermer le programme.
   */
  @Override
  public void execute() {
    Runtime.getRuntime().exit(0);	
  }
}
