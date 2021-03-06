package shape;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import shape.Point;
import shape.Triangle;

public class TriangleTest {

	 Point point = new Point(0,0);
	 Triangle  t1= new Triangle("t1",point,4,5,1);
	 Point p1 = new Point(5,8);
	 Triangle  t4 = new Triangle("t4",p1,2.5,5,4);

	  @Test
	  public void movetest() {
	    t1.move(2, 3);
	    Double x = t1.getTop().getX();
	    Double y = t1.getTop().getY();
	    assertTrue(x.equals(2.0));
	    assertTrue(y.equals(3.0));
	   }

	  @Test
	  public void getNametest( ) {
	    assertTrue(t1.getName().equals("t1"));
	    t1.setName("t2");
	    assertTrue(t1.getName().equals("t2"));
	   }

	  @Test
	  public void getPointRefTest( ) {
	    Point p = new Point(5,8);
	    Triangle  t3= new Triangle("t3",p,8.3,5,3);
	    Double x = t3.getTop().getX();
	    Double y = t3.getTop().getY();
	    assertTrue(x.equals(5.0));
	    assertTrue(y.equals(8.0));
	    p = new Point(3.5,7);
	    t3.setTop(p);
	    x = t3.getTop().getX();
	    y = t3.getTop().getY();
	    assertTrue(x.equals(3.5));
	    assertTrue(y.equals(7.0));
	   }

	  @Test
	  public void getBaseTest( ) {
		Double base = t4.getBase();
	    assertTrue(base.equals(2.5));
	   }

	  @Test
	  public void getHeightTest( ) {
		Double height = t4.getHeight();
	    assertTrue(height.equals(5.0));
	   }

	  @Test
	  public void getTopTest( ) {
		Point top = t4.getTop();
		Double x = top.getX();
	    Double y = top.getY();
	    assertTrue(x.equals(5.0));
	    assertTrue(y.equals(8.0));
	   }


}
