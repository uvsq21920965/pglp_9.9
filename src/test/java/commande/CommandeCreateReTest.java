package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import shape.Rectangle;

import org.junit.Test;

import shape.Point;


public class CommandeCreateReTest {
	Point point = new Point(5.2,7);
	  CommandCreateRe mcre = new CommandCreateRe("re1",point,4.0,3.5,2);

	  @Test 
	  public void executeTest() {
	    Rectangle r = mcre.execute();
	    assertEquals(r.getName(),"re1");
	    Double x = point.getX();
	    Double y = point.getY();
	    Double length = r.getLength();
	    Double width = r.getWidth();
	    assertTrue(x.equals(5.2));
	    assertTrue(y.equals(7.0));
	    assertTrue(length.equals(4.0));
	    assertTrue(width.equals(3.5));
	    assertEquals(r.getGroupId(),2);
	  }

}
