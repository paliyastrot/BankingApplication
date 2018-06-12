package Practice;
import java.util.*;
public class ClassMain 
{
	public static void main(String args[])
	{
		AccountServiceImplementation arr[] = new AccountServiceImplementation[5];
		for(int i=0;i<5;i++)
		{
			arr[i] = new AccountServiceImplementation();
		}
		System.out.println("Enter your Customer ID(Less than 5):");
		Scanner scan = new Scanner(System.in);
		int accindex = scan.nextInt();
		if(!(arr[accindex].verifyPassword()))
			System.exit(0);
		while(true)
		{
			System.out.println("\n\n1.Account Details\n2.Withdraw Money\n3.Deposit Money\n4.Mini Statement\n5.Exit\n\n");
			System.out.println("Enter your Choice:");
			int ch = scan.nextInt();
			switch(ch)
			{	
			case 1: 
				arr[accindex].getAccountDetails();
				break;
			case 2:
				System.out.println("Enter the amount to be withdraw:");
				int amount=scan.nextInt();
				try
				{
					arr[accindex].withdrawAmount(amount);
					
				}
				catch( BalanceLessThanZero ex)
				{
					System.out.println("Withdrawal Failed..!!!!");
					System.out.println("Exception Occured: "+ ex);
				}
				catch( NegativeAmount ex)
				{
					System.out.println("Withdrawal Failed..!!!");
					System.out.println("Exception Occured : "+ ex);
				}
				catch(MaxAmount ex)
				{
					System.out.println("Withdrawal Failed..!!!");
					System.out.println("Exception Occured : "+ ex);
				}
				catch (Exception e)
				{
					System.out.println("Unknown Exception Occurred..!!!!");
				} 
				break;
			case 3:
				System.out.println("Enter the amount to be Deposited: ");
				int amnt=scan.nextInt();
				try
				{
					arr[accindex].depositAmount(amnt);
				}
				catch(NegativeAmount ex)
				{
					System.out.println("Deposit Failed...!!!!!");
					System.out.println("Exception Occurred is : "+ ex);
				}
					break;
			case 4:
				arr[accindex].getMiniStatement();
				break;
			case 5:
				System.out.println("<<Exiting>>");
				System.exit(0);
				break;
			}
		}
	}
}
