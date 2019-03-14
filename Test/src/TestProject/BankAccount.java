package TestProject;
public class BankAccount {
private double balance;
private int pinCode;
String[]array=new String[20];
int length=0;
public int countArrayElements(){
	int actualLength=0;
	for(int i=0;i<5;i++)
	{
		if(array[i]!=null)
		{
			actualLength++;
		}
		else
			continue;
	}
	return actualLength;
}
public String getTransaction(int index)
{	
		return array[index];	
}
public int addInArray(String amount,int count)
{	

	if(count>4)
	{
		for(int i=0;i<5;i++)
		{
			array[i]=array[i+1];
		}
		array[count-1]=amount;
		
	}
	else
	{
	array[count]=amount;
	}
	length++;
	return length;
}
public int getPinCode(){
	return pinCode;
}
public void setPinCode(int pinCode)
{
	this.pinCode=pinCode;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double depositInAccount(double amount)
{
	balance=balance+amount;
	return balance;
}
public double withdrawFromAccount(double amount)
{
	balance=balance-amount;
	return balance;
}
}
