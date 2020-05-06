package Drawing;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import drawing.Carre;
import drawing.Point;


public class CarreTest {

	  Point point = new Point(0,0);
	  Carre  ca1= new Carre("ca1",point,4);

	  @Test
	  public void movetest() {
	    ca1.move(2, 3);
	    Double x = ca1.getPointRef().getX();
	    Double y = ca1.getPointRef().getY();
	    assertTrue(x.equals(2.0));
	    assertTrue(y.equals(3.0));
	   }

	  @Test
	  public void getNametest( ) {
	    assertTrue(ca1.getName().equals("ca1"));
	    ca1.setName("ca2");
	    assertTrue(ca1.getName().equals("ca2"));
	   }
	  @Test
	  public void getPointRefTest( ) {
	    Point p = new Point(5,8);
	    Carre  ca3= new Carre("ca3",p,8.3);
	    Double x = ca3.getPointRef().getX();
	    Double y = ca3.getPointRef().getY();
	    assertTrue(x.equals(5.0));
	    assertTrue(y.equals(8.0));
	    ca3.setPointRef(3.5, 7);
	    x = ca3.getPointRef().getX();
	    y = ca3.getPointRef().getY();
	    assertTrue(x.equals(3.5));
	    assertTrue(y.equals(7.0));
	   }
	  @Test
	  public void getSideTest( ) {
		Double side = ca1.getSide();
	    assertTrue(side.equals(4.0));
	   }
}
