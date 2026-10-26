import java.util.Random;

public class HashEncadeado {
	public static void main(String[] args) {
		// cria tabela de listas
		int tamanhoDaTabela = 100;
		
		ListaEncadeada[] matriz = new ListaEncadeada[tamanhoDaTabela];
		for (int i = 0; i < tamanhoDaTabela; i++) {
			matriz[i] = new ListaEncadeada();
		}

		Random random = new Random(1090); // seed
		
		int elementosAInserir = 1000;
		int maxRandom = 100000;
		
		int[] ultimosValores = new int[3];
		for (int i = 0; i < elementosAInserir; i++) {
			int numeroAleatorio = random.nextInt(maxRandom); 
			
			int posicao = numeroAleatorio % tamanhoDaTabela; 
			
			matriz[posicao].inserir(numeroAleatorio);
			
			ultimosValores[0] = ultimosValores[1];
			ultimosValores[2] = numeroAleatorio;
			ultimosValores[1] = ultimosValores[2];
		}

		// estatisticas
		ListaEncadeada maiorLista = matriz[0];
		int posicoesVazias = 0;
		int listasFeitas = 0;

		for (int i = 0; i < tamanhoDaTabela; i++) {
			ListaEncadeada listaAtual = matriz[i];
			
			if (listaAtual.tamanho > maiorLista.tamanho) {
				maiorLista = listaAtual;
			}
			
			if (listaAtual.tamanho > 0) {
				listasFeitas += 1;
			} else {
				posicoesVazias += 1;
			}
		}

		System.out.println("maior lista encadeada (tamanho " + maiorLista.tamanho + "): " + maiorLista);
		System.out.println("listas encadeadas geradas: " + listasFeitas);
		System.out.println("posições vazias: " + posicoesVazias);
		System.out.println("ultimos 3 valores inseridos em uma lista: " + ultimosValores[0] + ", " + ultimosValores[1] + ", " + ultimosValores[2]);
	}
}