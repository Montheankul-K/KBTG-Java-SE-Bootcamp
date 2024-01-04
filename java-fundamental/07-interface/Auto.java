public class Auto implements Loan {
    private String applicationName;
    private double loanAmount;
    private float interestRate;

    public Auto(String applicationName) {
        this.applicationName = applicationName;
    }

    public Auto(String applicationName, double loanAmount, float interestRate) {
        this.applicationName = applicationName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        System.out.println("Auto:: calculateInterest()");
        return 4.4d;
    }

    @Override
    public String toString() {
        return "Application Name: " + applicationName + "\nLoan Amount: " + loanAmount + "\nInterest Rate: "
                + interestRate;
    }
}
