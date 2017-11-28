package ds.ht;

public class HashTable implements TabelaHash_IF{

	private HashItem[] hashTable;
	
	public  HashTable() {				//Metodo construtor da tabela
		hashTable = new HashItem[10];	//cria um array de tamanho 10
	}
	
	public void insert(int element) {			//insere elemento passando a key
		insert(hashFunction(element), element);	//calculado pela função hash
	}
	
	private void insert(int key, int element) {	//insere os elementos no idex do array de acordo com a função hash

		int hashArrayIndex = key;

		if (hashTable[hashArrayIndex] == null) {					//se o index estiver vazio, coloca-se o novo item lá
			hashTable[hashArrayIndex] = new HashItem(key, element);
		} else {
			HashItem hashItem = hashTable[hashArrayIndex];			//se não, percorrer a lista até o último elemento
																	//e insere no fim da lista, fazendo os apontamentos necessários
			while (hashItem.getNext() != null) {
				hashItem = hashItem.getNext();
			}
			hashItem.setNext(new HashItem(key, element));

		}

	}
	//Procura elemento na tabela
	public int search(int element) throws Exception {				//procura um elemento na tabela

		int generatedArrayIndex = hashFunction(element);			//recebe o resultado da tabela hash para efetuar o acesso em tempo contante

		if (hashTable[generatedArrayIndex] == null) {				//se o indice onde o elemento procurado deveria estar, está vazio, o elemento não se encontra na tabela
			throw new Exception("Elemento não está na Tabela Hash: (index Array não inicializado)");
		} else {
			HashItem hashItem = hashTable[generatedArrayIndex];		//cria apontador para o index de onde o elemento deveria estar

			while (hashItem != null && hashItem.getValue() != element) { //percorre a lista
				hashItem = hashItem.getNext();
			}
			if (hashItem == null) {										//se chegar ao fim, o elemento não está na tabela
				throw new Exception("Elemento não encontrado na Tabela Hash");
			} else {
				return hashItem.getValue();								// retorna o elemento encontrado
			}

		}
	}
	//Remove elemento da tabela
	@Override
	public void remove(int element) throws Exception {			
		int generatedArrayIndex = hashFunction(element);	//acessar o index de onde o elemento deveria estar

		if (hashTable[generatedArrayIndex] == null) {		//se o index estiver vazio, elemento não encontrado
			throw new Exception("Elemento não está na Tabela Hash: (index Array não inicializado)");
		} else {
			
			HashItem hashAux = hashTable[generatedArrayIndex];			//cria apontador para o index de onde o elemente deveria estar
			while (hashAux != null && hashAux.getValue() != element) {
				hashAux = hashAux.getNext();							//percorre a lista em busca do elemento
			}
			if (hashAux == null) {										//se chegar a null, o elemento não está na lista
				throw new Exception("Elemento não encontrado na Tabela Hash");
			} else {
				HashItem hashItem = hashTable[generatedArrayIndex];		//se achar o elemento, cria o novo apontador hashItem
				while (hashItem.getNext() != hashAux) {					//anda com ele ate antes do elemento a ser retirado
					hashItem = hashItem.getNext();						
				}
				hashItem.setNext(hashAux.getNext());					//faz o elemento anterior do que vai ser retirado, apontar para o proximo
				hashAux.setNext(null);									//elemento do elemento que irá ser retirado e faz o elemento a ser removido apontar para null
			}
		}
	}
	//Retorna um String com os elementos  da lista e seus indices
	@Override
	public String print() {
		
		StringBuilder hashPrint = new StringBuilder();					//cria um string builder
		
		for (int i = 0; i < hashTable.length; i++) {					//percorre os indices da tabela				
			HashItem aux = hashTable[i];								//cria apontador para os indices
			hashPrint.append(i+": ");									//adiciona o indice a string
			while (aux != null) {										//se o apontador não for null
				if (aux.getNext() == null) {							//adicione os valores da lista a seguir
					hashPrint.append(aux.getValue());
				} else {
				hashPrint.append(aux.getValue()+", ");
				}
				aux = aux.getNext();
			}
			hashPrint.append("\n");
		}
		return hashPrint.toString();									//retorna a string
	}
	//Função Hash
	private int hashFunction(int key) {
		return key % 10;
	}

	

}
