package commande;

public class CommandExit implements CommandMove{

  /**
   * methode pour fermer le programme.
   */
  @Override
  public void execute() {
    Runtime.getRuntime().exit(0);	
  }
}
