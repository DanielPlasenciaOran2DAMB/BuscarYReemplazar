package dad.javafx.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class BuscarYReemplazarApp extends Application {

	private TextField buscarText, reemplazarText;
	private Button buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton;
	private CheckBox mayusMinCheck, expresionCheck, buscarAtrasCheck, resaltarCheck;

	@Override
	public void start(Stage primaryStage) throws Exception {
		buscarText = new TextField();

		reemplazarText = new TextField();

		buscarButton = new Button("Buscar");
		buscarButton.setMaxWidth(Double.MAX_VALUE);

		reemplazarButton = new Button("Reemplazar");
		reemplazarButton.setMaxWidth(Double.MAX_VALUE);

		reemplazarTodoButton = new Button("Reemplazar todo");
		reemplazarTodoButton.setMaxWidth(Double.MAX_VALUE);

		cerrarButton = new Button("Cerrar");
		cerrarButton.setMaxWidth(Double.MAX_VALUE);

		ayudaButton = new Button("Ayuda");
		ayudaButton.setMaxWidth(Double.MAX_VALUE);

		mayusMinCheck = new CheckBox("May�sculas y min�sculas");

		expresionCheck = new CheckBox("Expresi�n regular");

		buscarAtrasCheck = new CheckBox("Buscar hacia atr�s");

		resaltarCheck = new CheckBox("Resaltar resultados");

		GridPane buscarPane = new GridPane();
		buscarPane.setPadding(new Insets(5));
		buscarPane.setHgap(5);
		buscarPane.setVgap(5);
		buscarPane.addRow(0, new Label("Buscar:"), buscarText);
		buscarPane.addRow(1, new Label("Reemplazar con:"), reemplazarText);
		buscarPane.add(mayusMinCheck, 1, 2);
		buscarPane.add(buscarAtrasCheck, 2, 2);
		buscarPane.add(expresionCheck, 1, 3);
		buscarPane.add(resaltarCheck, 2, 3);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints(), };
		buscarPane.getColumnConstraints().setAll(cols);

		cols[2].setHgrow(Priority.ALWAYS);
		cols[2].setFillWidth(true);

		GridPane.setColumnSpan(buscarText, 2);
		GridPane.setColumnSpan(reemplazarText, 2);

		FlowPane botonesFlow = new FlowPane();
		botonesFlow.setHgap(2);
		botonesFlow.setVgap(2);
		botonesFlow.setAlignment(Pos.TOP_CENTER);
		botonesFlow.setOrientation(Orientation.VERTICAL);
		botonesFlow.setPadding(new Insets(5));
		botonesFlow.getChildren().addAll(buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton,
				ayudaButton);

		BorderPane root = new BorderPane();
		root.setCenter(buscarPane);
		root.setRight(botonesFlow);

		Scene scene = new Scene(root, 500, 200);

		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
