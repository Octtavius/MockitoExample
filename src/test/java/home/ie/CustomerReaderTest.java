package home.ie;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class CustomerReaderTest {
	
	// Class to be tested
	private CustomerReader customerReader;
	
	//Dependencies
	private EntityManager entityManager;
	
	@Before
	public void setup() {
		customerReader = new CustomerReader();
		
		entityManager = mock(EntityManager.class);
		customerReader.setEntityManager(entityManager);
	}

	@Test
    public void happyPathScenario(){
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("Susan");
        sampleCustomer.setLastName("Ivanova");

        when(entityManager.find(Customer.class,1L)).thenReturn(sampleCustomer);

        String fullName = customerReader.findFullName(1L);
        assertThat("Susan Ivanova",equalTo(fullName));
    }

    @Test
    public void customerNotPresentInDb(){
        when(entityManager.find(Customer.class,1L)).thenReturn(null);

        String fullName = customerReader.findFullName(1L);
        assertThat("", equalTo(fullName));
    }   

}
