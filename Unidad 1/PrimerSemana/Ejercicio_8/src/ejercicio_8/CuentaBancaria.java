package ejercicio_8;

public class CuentaBancaria {
    private String accountOwner;
    private float balance;
    private int accountNumber;
    
    public CuentaBancaria(String accountOwner,float balance,int accountNumber) {
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    
    public String getAccountOwner() {
        return this.accountOwner;
    }
    public float getBalance() {
        return this.balance;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountOwner(String newOwner) {
        this.accountOwner = newOwner;
    }
    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }
    public void setAccountNumber(int newAccountNumber) {
        this.accountNumber = newAccountNumber;
    }
    
    public String makeDeposit(float deposit) {
        this.balance += deposit;
        return "Deposito realizado con exito su saldo es : " + this.balance;            
    }
    
    public String makeWithdrawal(float withdraw) {
        if(this.balance - withdraw <= 0) {
            return "La extraccion que intenta hacer supera el monto en la cuenta,"
                    + "su balance es: " + this.balance;
        }
        else {
            this.balance -= withdraw;
            return "Extraccion exitosa, balance actual: " + this.balance;
        }
    }
}
