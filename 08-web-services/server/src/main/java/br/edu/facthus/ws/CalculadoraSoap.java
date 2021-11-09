package br.edu.facthus.ws;

import javax.jws.WebService;

@WebService
public class CalculadoraSoap {
	
	public int soma(int a, int b) {
		System.out.println("Calculando (SOAP)...");
		return a + b;
	}

}
