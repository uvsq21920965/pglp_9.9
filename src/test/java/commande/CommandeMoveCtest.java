package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import shape.Cercle;
import shape.Point;

public class CommandeMoveCtest {

	Point point = new Point(5.2,7);
	Cercle c = new Cercle("c1",point,4.0,1);
	CommandMoveC mvc = new CommandMoveC(c,1,1);

	@Test 
	  public void executeTest() {
	    mvc.execute();
	    assertEquals(c.getName(),"c1");
	    Double x = point.getX();
	    Double y = point.getY();
	    Double rayon = c.getRadius();
	    assertTrue(x.equals(6.2));
	    assertTrue(y.equals(8.0));
	    assertTrue(rayon.equals(4.0));
	    assertEquals(c.getGroupId(),1);
	  }
}
