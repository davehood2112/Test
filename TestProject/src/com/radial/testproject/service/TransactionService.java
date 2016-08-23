package com.radial.testproject.service;

import java.util.List;

import com.radial.testproject.dao.TransactionDao;
import com.radial.testproject.domain.Account;

/**
 * Interface to model standard service class.
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 * @author David Hood
 *
 */
public interface TransactionService {

	/**
	 * Inserts a new account into the database
	 * @param acct
	 * @return true if transaction is successful
	 * @throws Exception
	 */
	boolean insertNewAccount(Account acct);
	
	/**
	 * Calculates and updates the current balance for the specified account
	 * @param acct
	 * @param amount positive for credit, negative for debit
	 * @return new balance after calculation and successful transaction, original balance if transaction unsuccessful
	 * @throws Exception
	 */
	float updateBalance(Account acct, float amount)throws Exception;
	
	TransactionDao getTransactionDao();
	
	void setTransactionDao(TransactionDao transactionDao);
}
