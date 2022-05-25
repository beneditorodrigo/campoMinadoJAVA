package br.com.beneditorodrigo.cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

	private int quantidadeDeLinhas;
	private int quantidadeDeColunas;
	private int quantidadeDeMinas;

	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int quantidadeDelinhas, int quantidadeDecolunas, int quantidadeDeMinas) {
		this.quantidadeDeLinhas = quantidadeDelinhas;
		this.quantidadeDeColunas = quantidadeDecolunas;
		this.quantidadeDeMinas = quantidadeDeMinas;

		gerarCampos();
		associarVizinhos();
		sortearMinas();
	}

	private void gerarCampos() {
		for (int linha = 0; linha < quantidadeDeLinhas; linha++) {
			for (int coluna = 0; coluna < quantidadeDeColunas; coluna++) {
				campos.add(new Campo(linha, coluna));
			}
		}
	}

	private void associarVizinhos() {
		for (Campo c1 : campos) {
			for (Campo c2 : campos) {
				c1.adicionarVizinho(c2);
			}
		}
	}

	private void sortearMinas() {
		long minasArmadas = 0;

		Predicate<Campo> minado = c -> c.isMinado();

		do {
			minasArmadas = campos.stream().filter(minado).count();
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();
		} while (minasArmadas < quantidadeDeMinas);
	}

	public boolean objetivoAlcancado() {
		return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}

	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

//	public String toString() {
//		
//	}
}
