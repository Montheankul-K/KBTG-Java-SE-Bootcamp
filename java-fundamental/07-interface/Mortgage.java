public class Mortgage implements Loan {
    private String applicationName;
    private double loanAmount;
    private float interestRate;

    public Mortgage(String applicationName) {
        this.applicationName = applicationName;
    }

    public Mortgage(String applicationName, double loanAmount, float interestRate) {
        this.applicationName = applicationName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        System.out.println("Mortgage:: calculateInterest()");
        return 3.4d;
    }

    @Override
    public String toString() {
        return "Application Name: " + applicationName + "\nLoan Amount: " + loanAmount + "\nInterest Rate: "
                + interestRate;
    }
}
