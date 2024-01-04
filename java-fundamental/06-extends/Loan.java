public class Loan {
    private String applicationName;
    private double loanAmount;
    private float interestRate;

    public Loan(String applicationName, double loanAmount, float interestRate) {
        this.applicationName = applicationName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public Loan(String applicationName) {
        this.applicationName = applicationName;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        System.out.println("Loan:: calculateInterest()");
        return this.loanAmount * this.interestRate / 100;
    }

    public String toString() {
        return "Application Name: " + applicationName + "\nLoan Amount: " + loanAmount + "\nInterest Rate: "
                + interestRate;
    }
}
