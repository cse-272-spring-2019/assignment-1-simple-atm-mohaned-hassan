package mypackage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
@SuppressWarnings("unused")
public class Atm extends Application {
static String b;
static int i=-1;

	@Override
	public void start(Stage mainwindow) throws Exception {
		Stage history_stage=new Stage();
		Accounts account1=new Accounts(12345,9999,15000);
		//menu stage:
		Stage menu_stage=new Stage();
		menu_stage.setTitle("Main Menu");
		GridPane menu_layout=new GridPane();
		menu_layout.setPadding(new Insets(10,10,10,10));
		menu_layout.setVgap(8);
		menu_layout.setHgap(8);
		
		Button history=new Button("History");
		history.setOnAction(e->history_stage.show());

		
		Button withdraw=new Button("Withdraw");
		withdraw.setOnAction(e->Inputbox.display("withdraw menu","enter amount to withdraw","withdraw",account1,'w'));
		
		
		Button deposit=new Button("Deposit");
		deposit.setOnAction(e->Inputbox.display("deposit menu","enter amount to deposit","deposit",account1,'d'));

		
		Button inquiry=new Button("Inquiry");
		inquiry.setOnAction(e->{Alertbox.display("balance check","your current balance is "+account1.balance+"$");
		account1.history("balance check:"+account1.balance);
		});

			
		
		
		
		Button logout=new Button("Logout");
		logout.setOnAction(e->{
			menu_stage.close();
			mainwindow.show();
		});
		
		
		
		
		
		GridPane.setConstraints(withdraw,4,7);
		GridPane.setConstraints(deposit,17,7);
		GridPane.setConstraints(inquiry,4,12);
		GridPane.setConstraints(logout,9,15);
		GridPane.setConstraints(history,17,12);


		
	
		menu_layout.getChildren().addAll(withdraw,history,logout,inquiry,deposit);
		Scene menu_scene=new Scene(menu_layout,535,320);
		menu_scene.getStylesheets().add("theme.css");
        menu_stage.setScene(menu_scene);
////////////
mainwindow.setTitle("LogIn page");
//login scene:
GridPane loglayout=new GridPane();
loglayout.setPadding(new Insets(10,10,10,10));
loglayout.setVgap(8);
loglayout.setHgap(8);

TextField card_input=new TextField();
PasswordField pin_input=new PasswordField();
Label card_label=new Label("card number:");
Label pin_label=new Label("pin:");
Button login_btn=new Button("LogIn");
login_btn.setOnAction(e->Accounts.verify(menu_stage,mainwindow,card_input.getText(),pin_input.getText(),account1));

GridPane.setConstraints(card_label, 6,8 );
GridPane.setConstraints(card_input, 7,8 );
GridPane.setConstraints(pin_label, 6,9 );
GridPane.setConstraints(pin_input, 7,9 );
GridPane.setConstraints(login_btn, 6,10 );

loglayout.getChildren().addAll(card_label,pin_label,card_input,pin_input,login_btn);
Scene login_scene=new Scene(loglayout,500,320);
login_scene.getStylesheets().add("theme.css");

mainwindow.setScene(login_scene);
mainwindow.show();

//history stage:

history_stage.setTitle("History");
history_stage.initModality(Modality.APPLICATION_MODAL);

Button next=new Button("next");
Button prev=new Button("previous");
Label curr_his=new Label(" history is shown here    ");


next.setOnAction(e->{
	if(i>=4) {
i=i-1;
}
	
		i+=1;
curr_his.setText(account1.history[i]);

//if(i==5)
//i=i-1;

	
});
prev.setOnAction(e->{
	if(i<1) {
i=i+1;
}
	
		i-=1;

curr_his.setText(account1.history[i]);
//if(i==-1)
	//i=i+1;


	
});


GridPane history_layout=new GridPane();
history_layout.setPadding(new Insets(10,10,10,10));
history_layout.setVgap(8);
history_layout.setHgap(8);



GridPane.setConstraints(next,12,11);
GridPane.setConstraints(prev, 2,11 );
GridPane.setConstraints(curr_his, 7,8 );

history_layout.getChildren().addAll(next,prev,curr_his);
Scene history_scene=new Scene(history_layout,520,230);
history_scene.getStylesheets().add("theme.css");

history_stage.setScene(history_scene);






	
		
		
	}

}
