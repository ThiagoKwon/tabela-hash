package codigo;

public class Main {

	public static void main(String[] args) {
		LeitorCsv leitor = new LeitorCsv();
		String[] listaNomes = leitor
				.lerNomes("C:\\Users\\felip\\OneDrive\\Documentos\\JavaProjs\\Estrutura_Dados\\female_names.txt");

		//TabelaHashFunc1 tabela1 = new TabelaHashFunc1(20);
		TabelaHashFunc2 tabela2 = new TabelaHashFunc2(listaNomes.length);

		//tabela1.put(listaNomes);
		tabela2.put(listaNomes);
		// tabela1.mostrarDados();
		//tabela2.mostrarDados();
	}

}
