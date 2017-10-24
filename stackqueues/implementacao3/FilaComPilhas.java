package implementacao3;

public class FilaComPilhas implements Fila_IF {
	private PilhaComArray stackInput = new PilhaComArray();				//Criando a pilha de input
	private PilhaComArray stackOutput = new PilhaComArray();			//Criando a pilha de output

	public void enqueue(int element) throws Exception {					//Operação de enfileirar
		try {
			stackInput.push(element);									//Coloca na pilha de input
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public int dequeue() throws Exception {								//Desenfileirar: desempilha os elementos da pilha input
		try {															//e enquanto não estiver vazia, empilhe na pilha de output
			while (!stackInput.isEmpty()) {								//dessa forma se 'vira' a pilha, deixando na ordem de uma fila
				stackOutput.push(stackInput.pop());						//
			}															//
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());					
		}
		return stackOutput.pop();										//retorne o topo da pilha output (head da fila)
	}

	public int head() throws Exception {								//retorna a cabeça da lista
		try {
			if (stackOutput.isEmpty() && !stackInput.isEmpty()) {		//se a pilha de output estiver vazia, retorna o bottom da pilha input
				return stackInput.bottom();
			} else if (!stackOutput.isEmpty() && stackInput.isEmpty()) {//se a pilha de output não estiver vazia, retorna seu topo
				return stackOutput.top();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return -1;														//se as duas pilhas estierem vazias, retorna-se -1
	}
	

	public boolean isEmpty() {
		return stackInput.isEmpty();
	}

	public boolean isFull() {
		return stackInput.isFull();
	}

}
