package br.com.beneditorodrigo.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Teste {

	@Test
	void testarSeIgualADois() {
		int a = 1 + 1;
		assertEquals(2, a);
	}

	@Test
	void testarSeIgualATres() {
		int x = 10 - 5 - 2;
		assertEquals(3, x);
	}
}
