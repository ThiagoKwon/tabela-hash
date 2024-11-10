package codigo;

public class TabelaHashFunc2 extends TabelaHash {

	private static final int DIF = 21;

	public TabelaHashFunc2(int tamanho) {
		super(tamanho);
	}

	@Override
	public int funcaoHash(String nome) {
		int hash = 0;

		for (int i = 0; i < nome.length(); i++) {
			char letra = Character.toUpperCase(nome.charAt(i));
			hash = DIF * hash + letra;
		}

		return Math.abs(hash) % getTamanho();
	}

}
