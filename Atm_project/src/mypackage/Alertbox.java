package mypackage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class Alertbox {
	public static void display(String title,String msg){
		Stage newstage=new Stage();
		newstage.initModality(Modality.APPLICATION_MODAL);
		newstage.setTitle(title);
		Label label1=new Label(msg);
		Button button1=new Button("close");
		button1.setOnAction(e->newstage.close());
		VBox layout1=new VBox(20);
		layout1.getChildren().addAll(label1,button1);
		layout1.setAlignment(Pos.CENTER);
		Scene scene1=new Scene(layout1,700,150);
		scene1.getStylesheets().add("theme.css");

		newstage.setScene(scene1);
		newstage.show();
		
	}
	}
		