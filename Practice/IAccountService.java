package Practice;

public interface IAccountService 
{
	public boolean verifyPassword();          //Method used to verify PAssword
	public double getBalance();               //Method used to check the balance of account
	public void withdrawAmount(int amount) throws Exception;     //Method used to withdraw amount
	public void depositAmount(int amount) throws NegativeAmount;       //Method used to deposit amount
	public void getAccountDetails();          //Method used to get Account details 
	public void getMiniStatement();           //Method used to get mini statement
}