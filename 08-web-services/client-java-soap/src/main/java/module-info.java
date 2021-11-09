module br.edu.facthus.gui {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.jws;
	requires java.xml.bind;
	requires java.xml.ws;
	
	opens br.edu.facthus.client;
	opens br.edu.facthus.gui to javafx.fxml;
	exports br.edu.facthus.gui;
}