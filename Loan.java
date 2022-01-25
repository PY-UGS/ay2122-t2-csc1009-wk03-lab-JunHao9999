import java.util.*;
import java.lang.Math;

public class Loan {
    Scanner sc=new Scanner(System.in);
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    //default constructor
    public Loan(){
        this.annualInterestRate=2.5;
        this.numberOfYears=1;
        this.loanAmount=1000;
    }

    public Loan(double annualInterestRate,int numberOfYears,double loanAmount){
        this.annualInterestRate=annualInterestRate;
        this.numberOfYears=numberOfYears;
        this.loanAmount=loanAmount;
    }

    //getters and setters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }
    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    public java.util.Date getLoanDate(){
        //convert to edt ?
        //get current local time
        Date date=new Date();
        return date;
    }

    public double getMonthlyPayment(double annualInterestRate,int numberOfYears,double loanAmount){
        //convert to percentage, divide by 12 for % per month
        double monthlyInterestRate=(annualInterestRate/100)/12;
        double monthlyPayment=(loanAmount*monthlyInterestRate)/(1-(1/(Math.pow((1+monthlyInterestRate),(numberOfYears*12)))));
        return monthlyPayment;
    }

    public double getTotalPayment(double getMonthlyPayment,int numberOfYears){
        return getMonthlyPayment*numberOfYears*12;

    }

    public void setDetails(){
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        //use sc.nextLine to detect when user "enter" <<to use default>>
        String temp=sc.nextLine();
        if (temp!="") {
            setAnnualInterestRate(Double.parseDouble(temp));
        }
        System.out.print("Enter number of years as an integer: ");
        String temp2=sc.nextLine();
        if (temp2!="") {
            setNumberOfYears(Integer.parseInt(temp2));
        }
        System.out.print("Enter loan amount, for example, 120000.95: ");
        String temp3=sc.nextLine();
        if (temp3!=""){
            setLoanAmount(Double.parseDouble(temp3));
        }

    }

    public void printDetails(){
        System.out.println("The loan was created on "+getLoanDate());
        double monthlyPayment=getMonthlyPayment(this.annualInterestRate,this.numberOfYears,this.loanAmount);
        System.out.printf("The monthly payment is %.2f\n",monthlyPayment);
        double totalPayment=getTotalPayment(monthlyPayment,this.numberOfYears);
        System.out.printf("The total payment is %.2f\n",totalPayment);
    }
}
