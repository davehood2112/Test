/**
 * 
 */
package com.radial.testproject.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.radial.testproject.dao.TransactionDao;
import com.radial.testproject.domain.Account;

/**
 * Class to provide implementation for the TransactionDao interface.
 * **All classes are intentionally kept as simple as possible with only enough complexity to allow for testing scenarios**
 * **No actual database transactions are created in this class**
 * 
 * @author David Hood
 *
 */
public class TransactionDaoImpl implements TransactionDao {

	/* (non-Javadoc)
	 * @see com.radial.testproject.dao.TransationDao#insertNewAccount(com.radial.testproject.domain.Account)
	 */
	@Override
	public boolean insertNewAccount(Account acct){
		//for the sake of simply testing the flow-through of this method without a database connection:
		if(Integer.valueOf(acct.getAcctNum()) < 0){
			return false;
		} else{
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see com.radial.testproject.dao.TransationDao#updateBalance(com.radial.testproject.domain.Account, float)
	 */
	@Override
	public boolean updateBalance(Account acct) throws SQLException{
		//for the sake of simply testing the flow-through of this method without a database connection:
		if(Integer.valueOf(acct.getAcctNum()) < 0){
			throw new SQLException("Error: TransactionDao::updateBalance: Invalid account number");
		} else{
			return true;
		}
	}

}
