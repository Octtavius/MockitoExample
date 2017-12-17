package home.ie;

import javax.persistence.EntityManager;

public class CustomerReader {
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public String findFullName(Long customerID) {
		Customer customer = entityManager.find(Customer.class, customerID);
		if( customer != null) {
			return customer.getFirstName() + " " + customer.getLastName();
		} else { return ""; }
	}
}
