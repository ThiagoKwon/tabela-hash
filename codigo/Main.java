package codigo;

public class Main {

	public static void main(String[] args) {
		LeitorCsv leitor = new LeitorCsv();
		String[] listaNomes = leitor
				.lerNomes("C:\\Users\\felip\\OneDrive\\Documentos\\JavaProjs\\Estrutura_Dados\\female_names.txt");

		TabelaHashFunc1 tabela1 = new TabelaHashFunc1(20);
		TabelaHashFunc2 tabela2 = new TabelaHashFunc2(200);

		tabela1.put(listaNomes);
		tabela1.mostrarColisoesPorIndex();
		tabela1.buscar("Tatum");
		tabela1.buscar("Ana");
		tabela1.buscar("Luisa");
		System.out.println();
		tabela2.put(listaNomes);
		tabela2.mostrarColisoesPorIndex();
		tabela2.buscar("Tatum");
		tabela2.buscar("Ana");
		tabela2.buscar("Luisa");

	}

}
