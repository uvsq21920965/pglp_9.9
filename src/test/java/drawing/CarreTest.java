package drawing;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import drawing.Carre;
import drawing.Point;


public class CarreTest {

	  Point point = new Point(0,0);
	  Carre  ca1= new Carre("ca1",point,4,1);

	  @Test
	  public void movetest() {
	    ca1.move(2, 3);
	    Double x = ca1.getLeftTop().getX();
	    Double y = ca1.getLeftTop().getY();
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
	    Carre  ca3= new Carre("ca3",p,8.3,2);
	    Double x = ca3.getLeftTop().getX();
	    Double y = ca3.getLeftTop().getY();
	    assertTrue(x.equals(5.0));
	    assertTrue(y.equals(8.0));
	    p = new Point(3.5,7);
	    ca3.setLeftTop(p);
	    x = ca3.getLeftTop().getX();
	    y = ca3.getLeftTop().getY();
	    assertTrue(x.equals(3.5));
	    assertTrue(y.equals(7.0));
	   }
	  @Test
	  public void getSideTest( ) {
		Double side = ca1.getSide();
	    assertTrue(side.equals(4.0));
	   }
}
