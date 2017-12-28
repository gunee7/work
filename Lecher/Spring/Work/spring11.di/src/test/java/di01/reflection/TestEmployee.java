package di01.reflection;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import di01.model.Employee;

public class TestEmployee {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_make_instance_with_new() {
		
		di01.model.Employee emp1 = new Employee();
		emp1.setAddress("emp1 address");
		emp1.setName("emp1 nmme");
		emp1.setRrn("emp1rrn");
	    emp1.setSalary(10000);
	    
	    Employee emp2 = new Employee("emp2 name", "emp2 address", 1000, "emp2 rrn");
	    assertEquals("emp2 address", emp2.getAddress() );
	    
	}
	
	@Test
	public void test_make_instance_with_reflection() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		
		Class klass = Class.forName("di01.model.Employee"); 
		
		Class [] paramTypes = { String.class, String.class, Integer.class, String.class };
		
		Object[] dbjs = { "emp2 name", "emp2 address", 1000 , "emp2 rrn" };
	    
		//생성자 메서드 가져오기.
		Constructor cons = klass.getConstructor( paramTypes );
		
		//인스턴스 만들기
		Object intance = cons.newInstance( objs ) ;
		
		System.out.println(intance.toString());
		assertEquals ("emp2 address", ((di01.model.Employee)intance).getAddress());
		
		
		Method m = klass.getMethod("setName" String.class);
		
		Object [] params = {"hello"};
		
		m.invoke(intance, params);
		assertEquals ("hello", ((di01.model.Employee)intance).getAddress() );
		}
	     
        
	m = klass.getMethod("getName");
	Object result = m.invoke(intance);
	
	assertEquals("hello", result;)
		
		
		
	}

}
