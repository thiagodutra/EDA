package implementacao3;

public class FilaComArray implements Fila_IF {

	private int maxSize;
	private int[] queueArray;
	private int head;
	private int back;
	private int nItems;

	public FilaComArray() {
		this.maxSize = 10; // tamanho do array
		this.queueArray = new int[maxSize]; // criando array
		this.head = 0; // inicializando o inicio da fila com 0
		this.back = -1; // fim da fila = -1
		this.nItems = 0; // n de itens = 0
	}

	// Tirando da fila
	public int dequeue() throws Exception {
		int temp = 0;

		try {
			temp = queueArray[head]; // Temp recebe o elemento na cabeça da lista
		} catch (Exception e) { // Se houver exceção será pega
			System.out.println("Erro: " + e.getMessage()); // Imprime o erro
		}

		head++; // Incrementa a cabeça, ou seja o próximo elemente será o próximo da fila
		if (head == maxSize - 1) // Checa se a cabeça éstá no final do array
			head = 0; // Volta a cabeça para o começo, assim podemos inserir novos elementos
		nItems--; // Decrementa o n de elementos na fila

		return temp; // Retorna o elemento que era o cabeça

	}

	// Adicionado a fila
	public void enqueue(int j) throws Exception {
		if (back == maxSize - 1) { // Abordagem circular
			back = -1; // Se exceder o tamanho máximo da fila
		} // o primeiro elemento éh sobrescrito
		back++; // Incrementa o fim da fila, pois estamos adicionando mais um elemento
		try {
			queueArray[back] = j; // Insere no fim da lista
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		nItems++; // incrementa o numero de itens

	}

	// Obtendo valor do primeiro elemento (cabeça)
	public int head() throws Exception {
		int temp = 0;
		try {
			temp = queueArray[head]; // temp recebe o elemento da frente
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return temp; // retorna o elemento da cabeça
	}

	// Verifica Fila Vazia
	public boolean isEmpty() {
		return (nItems == 0); // se o n de items = 0 a fila esta vazia
	}

	// Verifica Fila Cheia
	public boolean isFull() {
		return (maxSize == nItems); // se n de items = maxSize a fila esta cheia
	}

	public int back() {
		try {
			if (!isEmpty())
				return queueArray[back];
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
}
