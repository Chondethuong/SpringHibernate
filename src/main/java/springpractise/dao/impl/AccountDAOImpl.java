package springpractise.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import springpractise.dao.AccountDAO;
import springpractise.entity.Account;

@Transactional
public class AccountDAOImpl extends BaseDAOImpl implements AccountDAO{

	public Account getAccountByUsername(String username) {
		Criteria cr = getSession().createCriteria(Account.class);
		cr.add(Restrictions.eq("username", username));
		List<Account> result = cr.list();
		if(null == result || result.isEmpty()){
			return null;
		}
		return result.get(0);
	}

	public boolean validateAccount(String username, String password) {
		Criteria cr = getSession().createCriteria(Account.class);
		cr.add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password));
		if (null == cr.list() || cr.list().isEmpty())
			return false;
		return true;
	}
}
