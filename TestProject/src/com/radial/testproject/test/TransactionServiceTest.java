package com.radial.testproject.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Capturing;
import mockit.Expectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.radial.testproject.dao.TransactionDao;
import com.radial.testproject.domain.Account;
import com.radial.testproject.service.TransactionService;
import com.radial.testproject.service.impl.TransactionServiceImpl;

@RunWith(JMockit.class)
public class TransactionServiceTest {

	@Tested	TransactionService transactionService;
	@Capturing	TransactionDao transactionDao;
	
	@Test
	public void testInsertNewAccount() {
		final Account account = new Account();
		account.setAcctNum("9999");
		account.setBalance(0);
		
		TransactionService transactionService = new TransactionServiceImpl();
		new Expectations(){
			{
				transactionDao.insertNewAccount(account);
				returns(true);
			}
		};
		
		assertTrue(transactionService.insertNewAccount(account));
		
	}

	@Test
	public void testInsertNewAccount_FailedTransaction() {
		
	
		final Account account = new Account();
		account.setAcctNum("-1");
		account.setBalance(0);
		
		TransactionService transactionService = new TransactionServiceImpl();
		new Expectations(){
			{
				transactionDao.insertNewAccount(account);
				returns(false);
			}
		};
		
		assertFalse(transactionService.insertNewAccount(account));
	}
	
	@Test
	public void testUpdateBalance() throws Exception {
		final Account account = new Account();
		account.setAcctNum("9999");
		account.setBalance(0);
		
		TransactionService transactionService = new TransactionServiceImpl();
		
		new Expectations(){
			{
				transactionDao.updateBalance(account);
				returns(true);
			}
		};
		
		float result = transactionService.updateBalance(account, 500f);
		assertEquals(500f, result, 0);
	}

	@Test(expected=Exception.class)
	public void testUpdateBalance_FailedTransaction() throws Exception {
		final Account account = new Account();
		account.setAcctNum("9999");
		account.setBalance(0);
		
		TransactionService transactionService = new TransactionServiceImpl();
		
		new Expectations(){
			{
				transactionDao.updateBalance(account);
				returns(new Exception());
			}
		};
		//should throw exception due to failed db transaction. account balance should not be updated
		transactionService.updateBalance(account, 500f);
		assertEquals(0, account.getBalance(), 0);
	}
}
