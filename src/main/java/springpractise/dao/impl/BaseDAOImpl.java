package springpractise.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;

import springpractise.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO{

	private SessionFactory sessionFactory;

	@Required
	public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
