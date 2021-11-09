package br.edu.facthus.service;

import br.edu.facthus.client.CalculadoraSoap;
import br.edu.facthus.client.CalculadoraSoapService;

public class CalculadoraService {
	
	public int somaSoap(int n1, int n2) {
		try {
			CalculadoraSoapService service = new CalculadoraSoapService();
			CalculadoraSoap port = service.getCalculadoraSoapPort();
			
			return port.soma(n1, n2);
		} catch (Exception e) {
			throw new RuntimeException("Erro acessando Web Service.");
		}
	}

}