/*
 RESUMO		 : 2. Biblioteca de String, Classe Fila
 PROGRAMADORA: Luiza Felix
 DATA		 : 04/04/2023
 */

package br.edu.fateczl.filas;


public class StringFila {

	private StringNo inicio, fim;

	public StringFila() {
		inicio = null;
		fim = null;
	}

	public boolean vazia() {
		if ((inicio == null) && (fim == null)) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(String valor){
//		clase usada para inserir valores na fila, sempre entram pelo fim e saem pelo come�o
		StringNo novo = new StringNo();
		novo.dado = valor;
		novo.proximo = null; //aponto para o fim da minha fila
		
		if (vazia()) {
//			carrego pela primeira vez;
			inicio = novo;
			fim = novo;
		}  else {
			if (inicio == fim && inicio != null) {
//			se eu tiver apenas um elemento na minha fila
				fim = novo;
				inicio.proximo = fim; //meu novo valor fica ao final da fila
			} else {
//				adiciono ele ao fim da fila normalmente
				fim.proximo = novo;
				fim = novo; 
			}
		}
	}
	
	public String remove() throws Exception {
		if (vazia()) {
			throw new Exception("N�o h� elementos para desenfileilar!");
		} else {
			String valor = inicio.dado; //dado que vai sair da fila
			if (inicio == fim && inicio != null) { //fila s� tem um elemento
//				??????
				inicio = null;
				fim = null;
			} else { //esse valor some e meu novo inic�o � o pr�ximo valor
				inicio = inicio.proximo;
			}
			return valor;
		}
	}
	
	public void lista() throws Exception {
//		para listar eu mostro os dados
		if (vazia()) {
			throw new Exception("N�o h� elementos para listar");
		} else {
			StringNo aux = inicio;
			while (aux != null) {
				System.out.print(aux.dado + "	");
				aux = aux.proximo;
			}
		}
	}
	public int size() {
		int i = 0;
		if(!vazia()) {
			StringNo aux = inicio;
			while (aux != null) {
				i++;
				aux = aux.proximo;
			}
		}
		return i;
	}
	
	public String toString() { // exemplo de polimorfismo de inclus�o
		// conversor da fila para leitura em string, por padr�o o objeto faz a convers�o, mas nesssa filha a aplica��o deve ser feita de um amaneira diferente
		StringBuffer buffer = new StringBuffer();
		StringNo aux = inicio;
		int i = 0; 
		while (i < size()) { // seguindo a ordem de entrada da fila, o mais recente deve sair na frente
			buffer.append("	" + aux.dado);
			aux = aux.proximo;
			
			i++;
		}
		return buffer.toString();
	}
	
}
