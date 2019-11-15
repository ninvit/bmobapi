package tests;

import java.io.IOException;

public class TestaURLTest {

	static Long inicio;
	static Long fim;

	public static void main(String[] args) {
		URLTest test = new URLTest();
		int response;

		inicio = System.nanoTime();
		try {

			response = test.getResponseCode("http://www.globo.com");
			
		} catch (IOException e) {
			response = 404;

		} finally {
			fim = System.nanoTime();
		}
		System.out.println(response);
		System.out.println((fim - inicio) / 1000000 + " ms para processar o teste");
	}

}
