module br.edu.facthus.gui {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.net.http;
	
	
	opens br.edu.facthus.gui to javafx.fxml;
	exports br.edu.facthus.gui;
}