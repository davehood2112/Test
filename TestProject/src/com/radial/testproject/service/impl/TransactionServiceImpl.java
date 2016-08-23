/**
 * 
 */
package com.radial.testproject.service.impl;

import com.radial.testproject.dao.TransactionDao;
import com.radial.testproject.dao.impl.TransactionDaoImpl;
import com.radial.testproject.domain.Account;
import com.radial.testproject.service.TransactionService;

/**
 * Class to provide implementation for the TransactionService interface
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 * @author David Hood
 *
 */
public class TransactionServiceImpl implements TransactionService {

	private TransactionDao transactionDao = new TransactionDaoImpl();
	

	/* (non-Javadoc)
	 * @see com.radial.testproject.service.TransactionService#insertNewAccount(com.radial.testproject.domain.Account)
	 */
	@Override
	public boolean insertNewAccount(Account acct){
		return transactionDao.insertNewAccount(acct);
	}

	/* (non-Javadoc)
	 * @see com.radial.testproject.service.TransactionService#updateBalance(com.radial.testproject.domain.Account, float)
	 */
	@Override
	public float updateBalance(Account acct, float amount) throws Exception {
		float currentBal = acct.getBalance();
		acct.setBalance(calculateBalance(currentBal, amount));
		
		if(transactionDao.updateBalance(acct)){
			return acct.getBalance();
		}
		else{
			acct.setBalance(currentBal);
			throw new Exception("Error in TransactionService::updateBalance: balance not updated.");
		}
	}
	
	private float calculateBalance(float currentBal, float amount){
		return currentBal += amount;
	}

	@Override
	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	@Override
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
}
