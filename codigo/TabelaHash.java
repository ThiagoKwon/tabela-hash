package codigo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class TabelaHash {

	private int colisoes;
	private int tamanho;
	private List<LinkedList<String>> lista;
	private double tempoExec;
	private int numIndices;

	public TabelaHash(int tamanho) {
		this.tamanho = tamanho;
		this.colisoes = 0;
		this.lista = new ArrayList<>(tamanho);
		for (int i = 0; i < tamanho; i++) {
			lista.add(new LinkedList<String>());
		}
	}

	public abstract int funcaoHash(String key);

	public void put(String[] listaCSV) {
		Long tempoInicio = System.nanoTime();
		if (listaCSV != null) {
			for (int i = 0; i < listaCSV.length; i++) {
				int index = funcaoHash(listaCSV[i]);
				LinkedList<String> listaEncadeada = getLista().get(index);

				listaEncadeada.add(listaCSV[i]);
				if (listaEncadeada.size() > 1) {
					setColisoes(getColisoes() + 1);
				} else {
					setNumIndices(getNumIndices() + 1);
				}
			}
		}
		Long tempoFim = System.nanoTime();

		setTempoExec((tempoFim - tempoInicio) / 1_000_000.0);
		gerarRelatorio();
	}

	public boolean buscar(String key) {
		Long tempoInicio = System.nanoTime();
		int index = funcaoHash(key);
		LinkedList<String> listaEncadeada = lista.get(index);
		Long tempoFim = System.nanoTime();

		if (listaEncadeada.contains(key)) {
			System.out.println(
					"Tempo de busca da chave " + key + " --> " + ((tempoFim - tempoInicio) / 1_000_000.0) + " ms");
		}
		return listaEncadeada.contains(key);
	}

	public void gerarRelatorio() {
		System.out.println("O tempo de execução desta tabela foi --> " + getTempoExec() + " ms");
		System.out.println("Total de colisões: " + getColisoes());
		System.out.println("Total de índices utilizados: " + getNumIndices());
	}

	public void mostrarColisoesPorIndex() {
		System.out.println("\nColisões por índice (clusterização):");
		for (int i = 0; i < lista.size(); i++) {
			LinkedList<String> listaEncadeada = lista.get(i);
			if (listaEncadeada.size() > 1) {
				System.out.println("Índice " + i + ": " + listaEncadeada.size() + " colisões");
			} else {
				System.out.println("VAZIO");
			}
		}
	}

	public int getColisoes() {
		return colisoes;
	}

	public void setColisoes(int colisoes) {
		this.colisoes = colisoes;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public List<LinkedList<String>> getLista() {
		return lista;
	}

	public void setLista(List<LinkedList<String>> lista) {
		this.lista = lista;
	}

	public Double getTempoExec() {
		return tempoExec;
	}

	public void setTempoExec(double d) {
		this.tempoExec = d;
	}

	public int getNumIndices() {
		return numIndices;
	}

	public void setNumIndices(int numIndices) {
		this.numIndices = numIndices;
	}
}
