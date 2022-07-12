package antifraud;

public class Transaction {
    private long amount;
    private String transactionValidity;

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
        setTransactionValidity();
    }

    public void setTransactionValidity() {
        if (this.amount <= 200) {
            this.transactionValidity = "ALLOWED";
        } else if (this.amount > 200 && this.amount <= 1500) {
            this.transactionValidity = "MANUAL_PROCESSING";
        } else {
            this.transactionValidity = "PROHIBITED";
        }
    }

    public String getTransactionValidity() {
        return this.transactionValidity;
    }

}
