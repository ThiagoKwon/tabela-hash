package codigo;

public class TabelaHashFunc1 extends TabelaHash {

	public TabelaHashFunc1(int tamanho) {
		super(tamanho);
	}

	@Override
	public int funcaoHash(String key) {
		return key.length() % getTamanho();
	}

}
