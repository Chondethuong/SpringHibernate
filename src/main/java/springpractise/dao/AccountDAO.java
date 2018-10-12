package springpractise.dao;

import springpractise.entity.Account;

public interface AccountDAO extends BaseDAO{
	Account getAccountByUsername(String username);
	boolean validateAccount(String username, String password);
}
