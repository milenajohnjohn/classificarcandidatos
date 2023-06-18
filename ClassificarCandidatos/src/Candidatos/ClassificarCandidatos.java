package Candidatos;
/* package whatever; // não coloque o nome do pacote! */
/* package whatever; // não coloque o nome do pacote! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* O nome da classe deve ser "ClassificarCandidatos" somente se a classe for pública. */
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        try (// Seu código vai aqui
		Scanner scanner = new Scanner(System.in)) {
			int numCandidatos = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha após o número de candidatos

			List<Candidato> candidatos = new ArrayList<>();

			for (int i = 0; i < numCandidatos; i++) {
			    String linha = scanner.nextLine();
			    String[] partes = linha.split(" ");

			    String nome = partes[0];
			    int experiencia = Integer.parseInt(partes[1]);
			    int habilidades = Integer.parseInt(partes[2]);
			    int realizacoes = Integer.parseInt(partes[3]);

			    Candidato candidato = new Candidato(nome, experiencia, habilidades, realizacoes);
			    candidatos.add(candidato);
			}

			// Classificar os candidatos
			Collections.sort(candidatos);

			// Imprimir os nomes dos candidatos classificados
			for (Candidato candidato : candidatos) {
			    System.out.println(candidato.nome);
			}
		}
    }
}

class Candidato implements Comparable<Candidato> {
    String nome;
    int experiencia;
    int habilidades;
    int realizacoes;
    int pontuacaoTotal;

    public Candidato(String nome, int experiencia, int habilidades, int realizacoes) {
        this.nome = nome;
        this.experiencia = experiencia;
        this.habilidades = habilidades;
        this.realizacoes = realizacoes;
        this.pontuacaoTotal = experiencia + habilidades + realizacoes;
    }

    @Override
    public int compareTo(Candidato outro) {
        if (this.pontuacaoTotal != outro.pontuacaoTotal) {
            // Classificar por pontuação total em ordem decrescente
            return Integer.compare(outro.pontuacaoTotal, this.pontuacaoTotal);
        } else {
            // Se houver empate na pontuação total, classificar por ordem alfabética
            return this.nome.compareTo(outro.nome);
        }
    }
}
