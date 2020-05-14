package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import shape.Point;
import shape.Rectangle;

public class RectangleJdbcTest {

	RectangleJdbc rjdbc=new RectangleJdbc();

	@Before
	public void deleteTable() {
		//vider le tabelau Personnels
		  Connection connexion = Dao.getConnection();
		  String deleteTableString = "delete from rectangles";
		  try {
			  connexion.createStatement().execute(deleteTableString);
			  connexion.close();
			} catch (SQLException e1) {
			  e1.printStackTrace();
			} 
	}

	  /**
	   * teste de la metheode create.
	   */
	  @Test
	  public void Test1create() {
		Point point = new Point(0,0);
		Rectangle  r1= new Rectangle("r1",point,5,4,1); 
	    assertNotNull(rjdbc.create(r1));
	  }
	  /**
	   * teste de la metheode find.
	   */
	  @Test
	  public void Test2find() {
	    Point point = new Point(0,0);
		Rectangle  r2= new Rectangle("r2",point,2,3,2);
		rjdbc.create(r2);
	    Rectangle r=rjdbc.find("r2");
	    assertEquals(r.getName(),"r2");
	    Double x = r.getLeftTop().getX();
	    Double y = r.getLeftTop().getY();
	    Double length = r.getLength();
	    Double width = r.getWidth();
	    assertTrue(x.equals(0.0));
	    assertTrue(y.equals(0.0));
	    assertTrue(length.equals(2.0));
	    assertTrue(width.equals(3.0));
	    assertEquals(r.getGroupId(),2);
	  }

	  /**
	   * teste de la metheode update.
	   */
	  @Test
	  public void Test3upDate() {
		  Point p = new Point(5,8);
		  Rectangle  r3= new Rectangle("r3",p,8.3,4,2);
		  rjdbc.create(r3);
		  Rectangle  rs = new Rectangle("r3",p,5,6,3);
		  rjdbc.update(rs);
		  Rectangle r = rjdbc.find("r3");
		  assertEquals(r.getName(),"r3");
		  Double x = r.getLeftTop().getX();
		  Double y = r.getLeftTop().getY();
		  Double length = r.getLength();
		  Double width = r.getWidth();
		  assertTrue(x.equals(5.0));
		  assertTrue(y.equals(8.0));
		  assertTrue(length.equals(5.0));
		  assertTrue(width.equals(6.0));
		  assertEquals(r.getGroupId(),3);
	  }

	  /**
	   * teste de la metheode delete.
	   */
	  @Test
	  public void Test4delete() {
		  Point point3 = new Point(2,2);
		  Rectangle r4 = new Rectangle("r4",point3,5.0,2.0,2);
		  rjdbc.create(r4);
		  rjdbc.delete(r4);
		  assertNull(rjdbc.find("r4"));
	  }
}
