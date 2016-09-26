package com.borderlan.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.expectThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.borderlan.account.tags.Stupid;

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
        assumeTrue("CI".equals(System.getenv("ENV")), () -> "Aborting test: not on CI server");
        assertEquals(3988, 2);
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")), () -> {
            // perform these assertions only on the CI server
            assertEquals(2, 2);
        });

        // perform these assertions in all environments
        assertEquals("a string", "a string");
    }

    @DisplayName("Check initial account state")
    @Test
    @Stupid
    void checkInitialAccountState() {
        assertAll("account state", () -> assertEquals(-3000.0D, account.getBalance()),
                () -> assertEquals("Rune Credit card account", account.getAccountName()));
    }

    @DisplayName("Check initial account state part II")
    @Test
    @Tag("Stupid")
    void checkInitialAccountState2() {
        assertAll("account state", () -> assertEquals(-30000000.0D, account.getBalance()),
                () -> assertEquals("Rune Credit card account (yet another)", account.getAccountName()));
    }

    @Test
    void exceptionTesting() {
        SavingsAccount account2 = new SavingsAccount(accountName, initialBalance, -3.0D);

        Throwable exception = expectThrows(IllegalArgumentException.class, () -> {
            account2.addInterest();
        });
        assertEquals("Interest can not be less that 0!", exception.getMessage(), "Exception message does not match!");
    }

}
