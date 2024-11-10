package codigo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class TabelaHash {

	private int colisoes;
	private int tamanho;
	private List<LinkedList<String>> lista;
	private Long tempoExec;

	public TabelaHash(int tamanho) {
		this.tamanho = tamanho;
		this.colisoes = 0;
		this.lista = new ArrayList<>(tamanho);
		for (int i = 0; i < tamanho; i++) {
			lista.add(new LinkedList<String>());
		}
	}

	public void gerarRelatorio() {
		System.out.println("O tempo de execução desta tabela foi --> " + getTempoExec() + " milissegundos");
		System.out.println("Total de colisões: " + getColisoes());
	}

	public abstract int funcaoHash(String key);

	public void put(String[] listaCSV) {
		Long tempoInicio = System.currentTimeMillis();
		if (listaCSV != null) {
			for (int i = 0; i < listaCSV.length; i++) {
				int index = funcaoHash(listaCSV[i]);
				LinkedList<String> listaEncadeada = getLista().get(index);

				listaEncadeada.add(listaCSV[i]);
				if (listaEncadeada.size() > 1) {
					setColisoes(getColisoes() + 1);
				}
			}
		}
		Long tempoFim = System.currentTimeMillis();

		setTempoExec(tempoFim - tempoInicio);
		gerarRelatorio();
	}

	public void mostrarDados() {
		int index = 0;
		for (LinkedList<String> listaEncadeada : getLista()) {
			System.out.print("INDEX " + index + " --> ");
			if (listaEncadeada.isEmpty()) {
				System.out.println("vazio");
			} else {
				for (String elemento : listaEncadeada) {
					System.out.print(elemento + " ");
				}
				System.out.println();
			}
			index++;
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

	public Long getTempoExec() {
		return tempoExec;
	}

	public void setTempoExec(Long tempoExec) {
		this.tempoExec = tempoExec;
	}
}
