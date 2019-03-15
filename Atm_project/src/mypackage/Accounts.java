
package mypackage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


@SuppressWarnings("unused")
public class Accounts {
long cardnumber;
int pin;
long  balance;
String[] history=new String[5];



  public Accounts(long number,int pass,long credit) {
	  cardnumber=number;
	  pin=pass;
	  balance=credit;
  }

  
  
  
public static void verify(Stage menu_stage,Stage main_stage,String in_card,String in_pin,Accounts vaccount) {
	if(in_card.isEmpty()||in_pin.isEmpty()) {
		Alertbox.display("error","please enter  card number and pin");
	}
	else {
	
	try {
	long cardno=Long.parseLong(in_card);
	int pass=Integer.parseInt(in_pin);

	if(cardno==vaccount.cardnumber&&pass==vaccount.pin) {
		menu_stage.show();
		main_stage.close();
		
	}
	else
		Alertbox.display("LogIn error","please enter correct card number and pin");
	
	
	
}catch (NumberFormatException e) {
	
	Alertbox.display("LogIn error","card number and pin must consist of numbers only");

	
	
}
		
	}
}
public boolean withdraw(String samount,Accounts acc) {
	int amount=Integer.parseInt(samount);
	if(amount>acc.balance) {
		Alertbox.display("withdraw error", "insufficient funds");
	return false;
	}
	else {
	acc.balance=acc.balance-amount;
	Alertbox.display("Withdraw","successfully withdrawed "+amount+"$ your current balance = "+acc.balance);

return true;
}
}

public long deposit(String samount,Accounts acc) {
	int amount=Integer.parseInt(samount);
	acc.balance=acc.balance+amount;
return balance;
	
}

public void history(String sentence) {
	
for(int i=4;i>0;i--) {
history[i]=history[i-1];	
}
history[0]=sentence;
	
}

}
