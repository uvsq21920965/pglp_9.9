package Drawing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import drawing.Cercle;
import drawing.Point;

public class CercleTest {

	  Point point = new Point(0,0);
	  Cercle c1= new Cercle("c1",point,4.0);

	  @Test
	  public void movetest() {
	    c1.move(2, 3);
	    Double x = c1.getPointRef().getX();
	    Double y = c1.getPointRef().getY();
	    assertTrue(x.equals(2.0));
	    assertTrue(y.equals(3.0));
	   }

	  @Test
	  public void getNametest( ) {
	    assertTrue(c1.getName().equals("c1"));
	    c1.setName("c2");
	    assertTrue(c1.getName().equals("c2"));
	   }
	  @Test
	  public void getPointRefTest( ) {
	    Point p = new Point(5,8);
	    Cercle  c3= new Cercle("c3",p,8.3);
	    Double x = c3.getPointRef().getX();
	    Double y = c3.getPointRef().getY();
	    assertTrue(x.equals(5.0));
	    assertTrue(y.equals(8.0));
	    c3.setPointRef(3.5, 7);
	    x = c3.getPointRef().getX();
	    y = c3.getPointRef().getY();
	    assertTrue(x.equals(3.5));
	    assertTrue(y.equals(7.0));
	   }
	  @Test
	  public void getRediusTest( ) {
		Double rayon = c1.getRedius();
	    assertTrue(rayon.equals(4.0));
	   }
	  @Test
	  public void getcentreTest( ) {
		Point p1 = new Point(4,7);
		Cercle  c4= new Cercle("c4",p1,6);
		Point centre = c4.getCentre();
		Double x = centre.getX();
		Double y = centre.getY();
		assertTrue(x.equals(4.0));
	    assertTrue(y.equals(7.0));
	   }

}
