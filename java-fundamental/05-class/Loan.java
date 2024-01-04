public class Loan {
    // field / attribute
    private String applicationName;
    private double loanAmount;
    private float interestRate;
    // ใส่ private เพื่อ encapsulation เพื่อให้ class Loan สามารแก้ได้อย่างเดียว

    // constructor
    public Loan(String applicationName, double loanAmount, float interestRate) {
        this.applicationName = applicationName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        // this. : หมายถึงของที่อยู่ภายใต้ class
    }
    // modifier ที่ใช้ส่วนใหญ่จะเป็น private / public

    // overload constructor : ชื่อเดียวกับแต่ parameter ต่างกัน
    public Loan(String applicationName) {
        this.applicationName = applicationName;
    }

    // getter
    public float getInterestRate() {
        return interestRate;
    }

    // setter
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    private double calculateInterest() {
        return this.loanAmount * this.interestRate / 100;
    }

    public double calInterest() {
        return this.calculateInterest();
    }

    // overload method
    public double calInterest(double loanAmount, float interestRate) {
        return loanAmount * interestRate / 100;
    }

    // method toString มีทุก object
    public String toString() {
        return "Application Name: " + applicationName + "\nLoan Amount: " + loanAmount + "\nInterest Rate: "
                + interestRate;
    }
}
