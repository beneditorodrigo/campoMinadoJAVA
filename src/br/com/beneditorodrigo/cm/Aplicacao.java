package br.com.beneditorodrigo.cm;

import br.com.beneditorodrigo.cm.modelo.Tabuleiro;
import br.com.beneditorodrigo.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
		new TabuleiroConsole(tabuleiro);
	}

}
