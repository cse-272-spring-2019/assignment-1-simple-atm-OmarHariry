package TestProject;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
public class TestProject extends Application {
	int count=0;
	int index=0;
	int actualLength=0;
	public void start(Stage primaryStage){
		BankAccount client = new BankAccount();
		client.setBalance(0.0);
		client.setPinCode(1234);
		//FIRST STAGE (prompting the user to enter the pin code)
		Button enter = new Button("Enter");
		Button exit1 = new Button("Exit");
		Text txt1=new Text("Enter Your Pin Code");
		PasswordField pw=new PasswordField();
		pw.setPromptText("Enter 1234");
		GridPane gridPane1 = new GridPane();
		GridPane.setRowIndex(txt1, 0);
		GridPane.setColumnIndex(txt1, 0);
		
		GridPane.setRowIndex(pw, 1);
		GridPane.setColumnIndex(pw, 0);
		
		GridPane.setRowIndex(enter, 2);
		GridPane.setColumnIndex(enter, 0);
		
		GridPane.setRowIndex(exit1, 2);
		GridPane.setColumnIndex(exit1, 1);
		gridPane1.getChildren().addAll(txt1,pw,enter,exit1);
		Scene firstScene=new Scene(gridPane1,250,250);
		Stage firstStage=new Stage();
		firstStage.setScene(firstScene);
		firstStage.show();
		enter.setOnAction(e->{
			if(Integer.parseInt(pw.getText())==client.getPinCode())
			{
				primaryStage.show();
				firstStage.close();
			}
			else
				firstStage.close();
							;});
		//SECOND STAGE "MAIN STAGE"
		Button withdraw = new Button("Withdraw");
		Button deposit = new Button("Deposit");
		Button balance = new Button("Balance Inquiry");
		Button previous = new Button("Previous");
		Button next = new Button("Next");
		Button exit = new Button("Exit");
		Text txt = new Text("Welcome To 7era's ATM!");
		Text displayBalance = new Text();
		Text transactionText=new Text();
		displayBalance.setVisible(false);
		transactionText.setVisible(false);
		BorderPane bPane=new BorderPane();
		VBox vb=new VBox();
		VBox vb2=new VBox();
		VBox vb3=new VBox();
		vb.getChildren().addAll(balance,withdraw,previous,displayBalance,transactionText);
		vb2.getChildren().addAll(deposit,next,exit);
		vb3.getChildren().addAll(txt);
		vb.setSpacing(10);
		vb2.setSpacing(10);
		bPane.setLeft(vb);
		bPane.setRight(vb2);
		bPane.setTop(vb3);
		Scene mainScene = new Scene(bPane,350,200);
		primaryStage.setTitle("Main Menu");
		primaryStage.setScene(mainScene);
		//Main menu actions
		balance.setOnAction(e->{
			displayBalance.setVisible(true);
			displayBalance.setText("Your balance inquiry is "+Double.toString(client.getBalance()));
		;});
		Text depositDisplayText=new Text("Enter the amount you want to deposit");
		TextField depositTextField=new TextField();
		Button enter2=new Button("Enter");
		Button exit2=new Button("Exit");
		GridPane gridPane2 = new GridPane();
		BorderPane bPane2=new BorderPane();
		Button[] b=new Button[10];
		int k=1;
		for(Integer i=0;i<b.length;i++)
			b[i]=new Button(i.toString());
			for(int i=1;i<4;i++)
			{
				if(k<10);
				for(int j=1;j<4;j++)
				{
					 GridPane.setRowIndex(b[k], i-1);
				     GridPane.setColumnIndex(b[k], j-1);
				    k++;
				}
			}
			GridPane.setRowIndex(b[0], 3);
			GridPane.setColumnIndex(b[0],1);
			
			VBox vbForText=new VBox(depositDisplayText,depositTextField);
			VBox vbForButtons = new VBox(gridPane2);
			VBox vbRight = new VBox(enter2,exit2);
			vbRight.setSpacing(50);
			//ACTIONS FOR BUTTONS IN DEPOSIT STAGE
			b[0].setOnAction(e->{
					depositTextField.setText(depositTextField.getText()+b[0].getText());
				;});
			b[1].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[1].getText());
			;});
			b[2].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[2].getText());
			;});
			b[3].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[3].getText());
			;});
			b[4].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[4].getText());
			;});
			b[5].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[5].getText());
			;});
			b[6].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[6].getText());
			;});
			b[7].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[7].getText());
			;});
			b[8].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[8].getText());
			;});
			b[9].setOnAction(e->{
				depositTextField.setText(depositTextField.getText()+b[9].getText());
			;});
		
			
			
			
			gridPane2.getChildren().addAll(b[0],b[1],b[2],b[3],b[4],b[5],b[6],b[7],b[8],b[9]);
			
	
			bPane2.setTop(vbForText);
			bPane2.setRight(vbRight);
			bPane2.setCenter(vbForButtons);
			Scene depositScene = new Scene(bPane2);
			Stage depositStage=new Stage();
			depositStage.setScene(depositScene);
		
			//ACTIONS FOR DEPOSIT
			
			deposit.setOnAction(e->{
				depositStage.show();
			;});
			
			
			enter2.setOnAction(e->{
			client.setBalance(client.depositInAccount(Double.parseDouble(depositTextField.getText())));
			index=client.addInArray("Deposit : "+depositTextField.getText(),count++);
			depositTextField.setText("");
			actualLength=client.countArrayElements();
			;});
			previous.setOnAction(e->
			{
				transactionText.setVisible(true);
				if(index==0)
				{	
					transactionText.setText((client.getTransaction(index)));
				}
				else	
				transactionText.setText((client.getTransaction(--index)));
			;});
			next.setOnAction(e->
			{
				transactionText.setVisible(true);
				if(index==client.countArrayElements()-1)
				{
					
					//transactionText.setText("Balance inquiry : "+Double.toString(client.getBalance()));
					transactionText.setText((client.getTransaction(index)));
				}
				else
				transactionText.setText((client.getTransaction(++index)));
			;});
			
			exit2.setOnAction(e->{
				depositTextField.setText("");
				depositStage.close();
			;});
	
//			Withdraw Stage!
			Text withdrawDisplayText=new Text("Enter the amount you want to withdraw");
			TextField withdrawTextField=new TextField();
			Button enter3=new Button("Enter");
			Button exit3=new Button("Exit");
			GridPane gridPane4 = new GridPane();
			BorderPane bPane3=new BorderPane();
			Button[] b2=new Button[10];
			int k2=1;
			for(Integer i=0;i<b.length;i++)
				b2[i]=new Button(i.toString());
				for(int i=1;i<4;i++)
				{
					if(k<10);
					for(int j=1;j<4;j++)
					{
						 GridPane.setRowIndex(b2[k2], i-1);
					     GridPane.setColumnIndex(b2[k2], j-1);
					    k2++;
					}
				}
				GridPane.setRowIndex(b2[0], 3);
				GridPane.setColumnIndex(b2[0],1);
				
				VBox vbTop=new VBox(withdrawDisplayText,withdrawTextField);
				VBox vbCenter = new VBox(gridPane4);
				VBox vbRight2 = new VBox(enter3,exit3);
				vbRight2.setSpacing(50);
				//GridPane.setConstraints(emptyWithdraw,2, 4);
				
				b2[0].setOnAction(e->{
					withdrawTextField.setText(withdrawTextField.getText()+b[0].getText());
				;});
			b2[1].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[1].getText());
			;});
			b2[2].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[2].getText());
			;});
			b2[3].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[3].getText());
			;});
			b2[4].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[4].getText());
			;});
			b2[5].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[5].getText());
			;});
			b2[6].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[6].getText());
			;});
			b2[7].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[7].getText());
			;});
			b2[8].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[8].getText());
			;});
			b2[9].setOnAction(e->{
				withdrawTextField.setText(withdrawTextField.getText()+b[9].getText());
			;});
				
				gridPane4.getChildren().addAll(b2[0],b2[1],b2[2],b2[3],b2[4],b2[5],b2[6],b2[7],b2[8],b2[9]);
				bPane3.setTop(vbTop);
				bPane3.setRight(vbRight2);
				bPane3.setCenter(vbCenter);
				Scene withdrawScene = new Scene(bPane3);
				Stage withdrawStage=new Stage();
				withdrawStage.setScene(withdrawScene);
			
				
				//Error
				GridPane errorPane=new GridPane();
				Button ok = new Button("ok");
				//Text errorText=new Text("The maximum amount which you can withdraw is : "+client.getBalance());
				Text errorText=new Text("You can't withdraw this amount");
				
				GridPane.setConstraints(errorText,0,0);
				GridPane.setConstraints(ok,1,1);
				errorPane.getChildren().addAll(errorText,ok);
				Scene errorScene=new Scene(errorPane,200,150);
				Stage errorStage=new Stage();
				errorStage.setScene(errorScene);
				ok.setOnAction(e->{
					errorStage.close();
				;});
				
				
				//ACTIONS FOR WITHDRAW
				//emptyWithdraw.setVisible(false);
				withdraw.setOnAction(e->{
					withdrawStage.show();
				;});
				
				
				enter3.setOnAction(e->{
				if((Double.parseDouble(withdrawTextField.getText())>client.getBalance()))
						{
							errorStage.show();
							withdrawTextField.setText("");
						}
				else
				{
				client.setBalance(client.withdrawFromAccount(Double.parseDouble(withdrawTextField.getText())));
				index=client.addInArray("Withdraw : "+withdrawTextField.getText(),count++);
				withdrawTextField.setText("");
				}
				;});
				
				
				
			
				exit3.setOnAction(e->{
					withdrawTextField.setText("");
					withdrawStage.close();
				;});				
		//
		//Exit Actions
		Button yes =new Button("Yes");
		Button no = new Button("No");
		Text displayText=new Text("Are you sure you want to exit?");
		GridPane gridPane3=new GridPane();
		GridPane.setConstraints(displayText, 0, 0);
		GridPane.setConstraints(yes, 0, 1);
		GridPane.setConstraints(no, 1, 1);
		gridPane3.getChildren().addAll(displayText,yes,no);
		Scene exitScene=new Scene(gridPane3,194,150);
		Stage exitStage=new Stage();
		exitStage.setScene(exitScene);
		exit.setOnAction(e->{
			exitStage.show();
		;});
		yes.setOnAction(e->{
		exitStage.close();
		primaryStage.close();
		;});
		
		
		no.setOnAction(e->{exitStage.close();
			;});
		exit.setOnAction(e->{
			exitStage.show();
		;});
		yes.setOnAction(e->{
		exitStage.close();
		primaryStage.close();
		;});
		no.setOnAction(e->{
			exitStage.close();
			;});
		//Adjusting colors 
		displayBalance.setFont(Font.font("Bold",16));
		exit.setMinWidth(120);
		next.setMinWidth(120);
		enter2.setMinWidth(60);
		enter3.setMinWidth(60);
		exit.setMinWidth(120);
		exit2.setMinWidth(60);
		exit3.setMinWidth(60);
		balance.setMinWidth(120);
		withdraw.setMinWidth(120);
		previous.setMinWidth(120);
		deposit.setMinWidth(120);
		//
		transactionText.setFill(Color.WHITE);
		displayText.setFill(Color.WHITE);
		yes.setTextFill(Color.WHITE);
		no.setTextFill(Color.WHITE);
		txt.setFill(Color.WHITE);
		withdrawDisplayText.setFill(Color.WHITE);
		txt1.setFill(Color.WHITE);
		displayBalance.setFill(Color.WHITE);
		depositDisplayText.setFill(Color.WHITE);
		errorText.setFill(Color.WHITE);
		//
		balance.setStyle("-fx-background-color:red;-fx-text-fill:white");
		withdraw.setStyle("-fx-background-color:red;-fx-text-fill:white");
		deposit.setStyle("-fx-background-color:red;-fx-text-fill:white");
		previous.setStyle("-fx-background-color:red;-fx-text-fill:white");
		next.setStyle("-fx-background-color:red;-fx-text-fill:white");
		exit.setStyle("-fx-background-color:red;-fx-text-fill:white");
		enter.setStyle("-fx-background-color:red;-fx-text-fill:white");
		enter2.setStyle("-fx-background-color:red;-fx-text-fill:white");
		enter3.setStyle("-fx-background-color:red;-fx-text-fill:white");
		exit.setStyle("-fx-background-color:red;-fx-text-fill:white");
		exit1.setStyle("-fx-background-color:red;-fx-text-fill:white");
		exit2.setStyle("-fx-background-color:red;-fx-text-fill:white");
		exit3.setStyle("-fx-background-color:red;-fx-text-fill:white");
		ok.setStyle("-fx-background-color:red;-fx-text-fill:white");
		yes.setStyle("-fx-background-color:red");
		no.setStyle("-fx-background-color:red");
		
		gridPane1.setStyle("-fx-background-color:black");
		gridPane2.setStyle("-fx-background-color:black");
		gridPane3.setStyle("-fx-background-color:black");
		errorPane.setStyle("-fx-background-color:black");
		bPane.setStyle("-fx-background-color:black");
		bPane2.setStyle("-fx-background-color:black");
		bPane3.setStyle("-fx-background-color:black");
		
		
		
		for(int i=0;i<10;i++)
			b[i].setStyle("-fx-background-color:red;-fx-text-fill:white;");
		for(int i=0;i<10;i++)
			b2[i].setStyle("-fx-background-color:red;-fx-text-fill:white;");
	}
public static void main(String []args){
	Application.launch(args);
}
}
