package Practice;
import java.lang.*;
import java.util.*;

public class AccountServiceImplementation implements IAccountService
{
	private int accountno;
	private int password;
	double balance;
	ArrayList<Integer> miniStatement = new ArrayList<Integer>();            //data structure used for storing the details of last five transactions 
	static int i=0;        //used for increasing the account number's count;
	public AccountServiceImplementation()
	{
		this.accountno=10000000+(i++); 
		this.password=(this.accountno%1000);   //Initializing password of the account as last 4 digits of the account number
		this.balance=0.00;
	}
	public boolean verifyPassword()         //Method for verifying password 
	{
		int count=3;
		while(count!=0)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your password");
			int pin = scan.nextInt();
			if(pin==this.password)
				return true;
			else
			{
				count--;
				continue;
			}
		}
		return false;
	}
	@Override
	public void getAccountDetails()
	{
		System.out.println("<<<<Account Details>>>>");
		System.out.println("Account Number : "+ this.accountno);
		System.out.println("Balance :  "+ this.balance);
	}
	public double getBalance()
	{
		return this.balance;
		
	}
	@Override
	public void withdrawAmount(int amount) throws Exception          //Method for Withdrawing amount
	{
		if(this.balance==0)
			throw new BalanceLessThanZero("Account Balance is  : 0.00$ \nWithdrawal Unsuccessfull....!!!!");  //throwing customized exception
		if(amount<0)
			throw new NegativeAmount("Amount can not be Negative...!!!!");      //throwing customized exception
		if(amount>30000)
			throw new MaxAmount("Maximum Amount Limit Exceeded.  Amount should be less than 30,000");         //throwing customized exception
		else 
		{
			int count=3;
			while(true)
			{
				if(verifyPassword())  //verifying password
				{
					System.out.println("Withdrawal Successfull....!!!!!");
					this.balance-=amount;
					if(this.miniStatement.size()>4)
						this.miniStatement.remove(0);
					miniStatement.add(-1*amount);
					System.out.println("Remaining Balance = :"+this.balance);
					break;
				}
				else 
					count--;
				if(count==0)
				{
					System.out.println("Number of Attempts Exceeded...!!!!");
					return;
				}
			}
		}
	}
	@Override
	public void depositAmount(int amount) throws NegativeAmount      //Method for Depositing Amount
	{
		if(amount<0)
			throw new NegativeAmount("Amount Deposited Cannnot be Negative....!!!!");
		System.out.println("Deposit Successfull");
		this.balance+=amount;
		System.out.println("Balance is : "+ this.balance);
		if(this.miniStatement.size()>4)
			this.miniStatement.remove(0);
		this.miniStatement.add(amount);
	}
	@Override
	public void getMiniStatement()     //Method for Mini Statement 
	{
		this.getAccountDetails();
		System.out.println("Details of Last Five Transactions is shown:");
		Iterator<Integer> itr = this.miniStatement.iterator();
		while(itr.hasNext())
		{
			int current =(int)itr.next();
			if(current>0)
				System.out.println(current+" Deposited");
			else
				System.out.println((-1)*current+" Withdrawal");
		}
	}
}
