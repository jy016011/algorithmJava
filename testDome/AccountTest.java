package testDome;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void cannotDepositAndWithdrawUnderZero() {
        Account account = new Account(20);
        account.deposit(10_000);
        Assert.assertFalse(account.deposit(-1));
        Assert.assertFalse(account.withdraw(-1));
    }

    @Test
    public void depositAndWithdrawOverZero() {
        Account account = new Account(0);
        Assert.assertTrue(account.deposit(10_000));
        Assert.assertTrue(account.withdraw(1_000));
    }

    @Test
    public void cannotWithdrawOverOverdraftLimit() {
        Account account = new Account(10_000);
        Assert.assertFalse(account.withdraw(10_001));
    }

    @Test
    public void checkAmountAfterDepositAndWithdraw() {
        Account account = new Account(10_000);
        account.deposit(1_000);
        Assert.assertEquals(account.getBalance(), 1_000d, epsilon);
        account.withdraw(1_000);
        Assert.assertEquals(account.getBalance(), 0d, epsilon);
    }


}
