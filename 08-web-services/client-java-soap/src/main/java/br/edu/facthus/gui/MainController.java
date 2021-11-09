package br.edu.facthus.gui;

import br.edu.facthus.service.CalculadoraService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField n1;

	@FXML
	private TextField n2;

	@FXML
	private Label lblSaida;

	private CalculadoraService service = new CalculadoraService();

	@FXML
	private void calcula() {
		try {
			lblSaida.setText(String.format("Soma = %d", 
					service.somaSoap(Integer.parseInt(n1.getText()),
							Integer.parseInt(n2.getText()))));
		} catch (RuntimeException e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR,
					e.getMessage());
            alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR,
					"Ocorreu um erro inesperado.");
            alert.showAndWait();
		}
	}
	
	@FXML
	private void calculaRest() {
		/*
		try {
			lblSaidaRest.setText(String.format("Soma = %d", 
					service.somaRest(Integer.parseInt(n1.getText()),
							Integer.parseInt(n2.getText()))));
		} catch (RuntimeException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR,
					e.getMessage());
            alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.ERROR,
					"Ocorreu um erro inesperado.");
            alert.showAndWait();
		}
		*/
	}

}
