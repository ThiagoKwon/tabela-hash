package codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

	public String[] lerNomes(String caminhoArquivo) {
		List<String> nomes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				nomes.add(linha.trim());
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}
		return nomes.toArray(new String[0]);
	}
}
