package commande;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class CommandExitTest {
    CommandExit ce = new CommandExit();
	@Rule
	 public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	 
	 @Test
	 public void applyQuitTest() {
	   exit.expectSystemExitWithStatus(0);
	   ce.execute();
	   System.out.println("This is NEVER executed.");
	 }
}
