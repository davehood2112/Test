package com.radial.testproject.dao;

import java.sql.SQLException;
import java.util.List;

import com.radial.testproject.domain.Account;

/**
 * Interface to model standard DAO class.
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 * **No actual database transactions are created in this class**
 * @author David Hood
 *
 */
public interface TransactionDao {

	/**
	 * Inserts a new account into the database
	 * @param acct
	 * @return true if transaction is successful
	 * @throws SQLException
	 */
	boolean insertNewAccount(Account acct);
	
	/**
	 * Updates the balance of the specified account
	 * @param acct
	 * @return true if transaction is successful
	 * @throws SQLException
	 */
	boolean updateBalance(Account acct)throws SQLException;
}
