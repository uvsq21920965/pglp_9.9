package commande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import shape.Point;
import shape.Rectangle;

public class CommandMoveRetest {
	Point point = new Point(5.2,7);
	Rectangle r = new Rectangle("r1",point,4.0,3.5,1);
	CommandMoveRe mvr = new CommandMoveRe(r,1,1);

	@Test 
	  public void executeTest() {
	    mvr.execute();
	    assertEquals(r.getName(),"r1");
	    Double x = point.getX();
	    Double y = point.getY();
	    Double length = r.getLength();
	    Double width = r.getWidth();
	    assertTrue(x.equals(6.2));
	    assertTrue(y.equals(8.0));
	    assertTrue(length.equals(4.0));
	    assertTrue(width.equals(3.5));
	    assertEquals(r.getGroupId(),1);
	  }
}
