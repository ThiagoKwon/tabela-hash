package codigo;

public class TabelaHashFunc2 extends TabelaHash {

	public int separador = -1;
	public int diferencialImpar = -1;
	public int diferencialPar = (getTamanho() / 2) + 1;

	public TabelaHashFunc2(int tamanho) {
		super(tamanho);
	}

	@Override
	public int funcaoHash(String nome) {
		this.separador++;
		this.diferencialImpar++;
		if (this.diferencialImpar > getTamanho() / 2) {
			this.diferencialImpar = 0;
		}
		this.diferencialPar++;
		if (this.diferencialPar > getTamanho()) {
			this.diferencialPar = 0;
		}
		int valorNome = 0;
		for (int i = 0; i < nome.length(); i++) {
			char letra = Character.toUpperCase(nome.charAt(i));
			if (letra == '-') {
				valorNome += 45;
			} else {
				int valorIndice = getIndiceAlfabeto(letra);
				valorNome += valorIndice;
			}
		}
		if (this.separador % 2 == 0) {
			return this.diferencialPar;
		} else {
			return this.diferencialImpar;
		}
	}

	private int getIndiceAlfabeto(char letra) {
		if (letra >= 'A' && letra <= 'Z') {
			return letra - 'A' + 1;
		}
		return 0;
	}
}
