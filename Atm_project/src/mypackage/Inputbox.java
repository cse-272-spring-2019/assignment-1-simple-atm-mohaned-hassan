package mypackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
@SuppressWarnings("unused")

public class Inputbox {
	static String a;

	public static void  display(String title,String msg,String btnname,Accounts acc,char c) {
		Stage window=new Stage();
		window.setTitle(title);
		
		window.initModality(Modality.APPLICATION_MODAL);
Label label1=new Label(msg);		
TextField input=new TextField();		
Button btn=new Button(btnname);
VBox window_layout=new VBox(20);
window_layout.getChildren().addAll(label1,input,btn);
Scene window_scene=new Scene(window_layout,300,250);
window_scene.getStylesheets().add("theme.css");

window.setScene(window_scene);
window.show();;

switch(c) {

case 'w':btn.setOnAction(e->{
	try { int x=Integer.parseInt(input.getText()); 
boolean a=acc.withdraw(input.getText(),acc);
if(a==true)
	acc.history("withdrawed "+ input.getText()+"$");
	}
	catch (NumberFormatException e1) {
	Alertbox.display("error","please enter numbers only");
	}
});break;




case 'd':btn.setOnAction(e->{
	try {int y=Integer.parseInt(input.getText());
long b=	acc.deposit(input.getText(),acc);
	Alertbox.display("deposit","successfully diposited "+input.getText()+" $ your current balance="+b);
	acc.history("deposited "+input.getText()+"$" );
	}catch (NumberFormatException e2) {
		Alertbox.display("error","please enter numbers only");

	}

});
	break;
	

}

}

}
