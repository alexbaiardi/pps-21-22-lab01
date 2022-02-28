package lab01.example.model;public abstract class AbstractBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    protected boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected abstract int getFee();

    @Override
    public final void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance = this.balance + amount - getFee();
        }
    }

    @Override
    public final void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - getFee();
        }
    }
}
