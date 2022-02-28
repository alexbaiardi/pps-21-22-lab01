import lab01.example.model.AccountHolder;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends AbstractBankAccountTest {

    private static final int FEE=1;

    @Override
    @BeforeEach
    public void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100-FEE, bankAccount.getBalance());
    }

    @Test
    public void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), 100);
        assertEquals(100-FEE, bankAccount.getBalance());
        bankAccount.deposit(2, 50);
        assertEquals(100-FEE, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 70);
        assertEquals(30-FEE-FEE, bankAccount.getBalance());
    }
}
