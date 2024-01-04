// extends : สืบทอด
public class Mortgage extends Loan {

    public Mortgage(String applicationName) {
        // super : เรียก constructor ของ class แม่
        super(applicationName);
    }

    public Mortgage(String applicationName, double loanAmount, float interestRate) {
        super(applicationName, loanAmount, interestRate);
    }

    @Override // ใส่ anotation เพื่อบอกว่า override method
    public double calculateInterest() {
        System.out.println("Mortgage:: calculateInterest()");
        return 3.4d;
    }
}
