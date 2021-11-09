package br.edu.facthus.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CalculadoraService {
	
	public int somaRest(int n1, int n2) {
		try {
			HttpClient client = HttpClient
					.newBuilder()
					.build();
			
			HttpRequest request = HttpRequest
					.newBuilder(new URI(String.format(
							"http://localhost:8080/08-web-services/api/calculadora/soma/%d/%d", 
							n1,
							n2)))
					.GET()
					.build();
			
			HttpResponse<String> response = 
					client.send(request, BodyHandlers.ofString());

			if (response.statusCode() != 200)
				throw new RuntimeException("Erro acessando Web Service.");
			
			return Integer.parseInt(response.body());
		} catch (Exception e) {
			throw new RuntimeException("Erro acessando Web Service.");
		}
	}
	
}