package com.borderlan.account;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.borderlan.account.tags.Stupid;
import com.borderlan.person.Person;

class SavingsAccountTest {

	private static SavingsAccount account;
	private final static String accountName = "Rune Savings Account";
	private final static double initialBalance = 30000.0D;
	private final static double initialInterest = 1.2D;
	
	@BeforeAll
	static void doBeforeAll() {
		account = new SavingsAccount(accountName, initialBalance, initialInterest);
	}
	
	@DisplayName("Check initial balance 😎")
	@Test
	void checkInitialBalance() {
		assertEquals(initialBalance, account.getBalance(), "Balance does not match!");
	}
	
	@DisplayName("Check initial account name 😎")
	@Test
	void checkInitialInterestState() {
		assertEquals(accountName, account.getAccountName(), "Account name does not match!");
	}
	
    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")),
                () -> "Aborting test: not on CI server");
        assertEquals(3988, 2);
    }
	
	@DisplayName("Check initial account state")
	@Test
	@Stupid
	void checkInitialAccountState() {
		assertAll("account state",
				() -> assertEquals(3000.0D, account.getBalance()),
				() -> assertEquals("Rune Account", account.getAccountName())
				);
	}
	
}
