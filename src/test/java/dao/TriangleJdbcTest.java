package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import drawing.Point;
import drawing.Triangle;

public class TriangleJdbcTest {

	TriangleJdbc trjdbc=new TriangleJdbc();

	@Before
	public void deleteTable() {
		//vider le tabelau Personnels
		  Connection connexion = Dao.getConnection();
		  String deleteTableString = "delete from triangles";
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
		Triangle  tr1= new Triangle("tr1",point,5,4,1); 
	    assertNotNull(trjdbc.create(tr1));
	  }
	  /**
	   * teste de la metheode find.
	   */
	  @Test
	  public void Test2find() {
	    Point point = new Point(0,0);
		Triangle  tr2= new Triangle("tr2",point,2,3,2);
		trjdbc.create(tr2);
	    Triangle tr = trjdbc.find("tr2");
	    assertEquals(tr.getName(),"tr2");
	    Double x = tr.getTop().getX();
	    Double y = tr.getTop().getY();
	    Double base = tr.getBase();
	    Double height = tr.getHeight();
	    assertTrue(x.equals(0.0));
	    assertTrue(y.equals(0.0));
	    assertTrue(base.equals(2.0));
	    assertTrue(height.equals(3.0));
	    assertEquals(tr.getGroupId(),2);
	  }

	  /**
	   * teste de la metheode update.
	   */
	  @Test
	  public void Test3upDate() {
		  Point p = new Point(5,8);
		  Triangle  tr3= new Triangle("tr3",p,8.3,4,2);
		  trjdbc.create(tr3);
		  Triangle  rs = new Triangle("tr3",p,5,6,3);
		  trjdbc.update(rs);
		  Triangle tr = trjdbc.find("tr3");
		  assertEquals(tr.getName(),"tr3");
		  Double x = tr.getTop().getX();
		  Double y = tr.getTop().getY();
		  Double base = tr.getBase();
		  Double height = tr.getHeight();
		  assertTrue(x.equals(5.0));
		  assertTrue(y.equals(8.0));
		  assertTrue(base.equals(5.0));
		  assertTrue(height.equals(6.0));
		  assertEquals(tr.getGroupId(),3);
	  }

	  /**
	   * teste de la metheode delete.
	   */
	  @Test
	  public void Test4delete() {
		  Point point3 = new Point(2,2);
		  Triangle tr4 = new Triangle("tr4",point3,5.0,2.0,2);
		  trjdbc.create(tr4);
		  trjdbc.delete(tr4);
		  assertNull(trjdbc.find("tr4"));
	  }

}
