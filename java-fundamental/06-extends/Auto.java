public class Auto extends Loan {

    public Auto(String applicationName) {
        super(applicationName);
    }

    public Auto(String applicationName, double loanAmount, float interestRate) {
        super(applicationName, loanAmount, interestRate);
    }

    @Override
    public double calculateInterest() {
        System.out.println("Auto:: calculateInterest()");
        return 4.0d;
    }
}
