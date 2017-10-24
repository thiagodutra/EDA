package implementacao3;

public class PilhaComArray implements Pilha_IF{
	private int maxSize;
	private int[] stackArray;
	private int top;
	private int bottom = 0;
	
	public PilhaComArray () {
		this.maxSize = 10;						//tamanho da pilha
		this.stackArray = new int[maxSize];		//criando o array do tamanho da pilha
		this.top = -1;							//topo = -1
	}
												//Desempilhando
	public int pop() throws Exception {			
		try {
			int old_top = top;					//seta o old_top com o valor do elemento a ser retirado
			top--;								//decrementa o topo
			return stackArray[old_top];			//retorna o antigo topo da lista (elemento a ser retirado)
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage() + " - pop");
		}
		return -1;								//se a pilha esta vazia ou se não puder acessar a posição do array, será retornado -1
	}
	
												//Empilhando
	public void push(int j) throws Exception {
												// Adicionando no topo da pilha
												// Incrementa o topo. se pilha vazia, então top = -1,colocará o elemento na
												// posição 0 e assim sucessivamente
			try {
				top++;
				stackArray[top] = j;

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage() + " - push");
			} 
//			finally { 							//// Se descomentar Volta o topo para o 
//				if (top >= maxSize)				//// tamanho máximo - 1;
//				top = maxSize - 1;				//// Sobrescrevendo o topo da pilha
//												//// pelo ultimo elemento adicionado.
//			}
	}
														//Acessando o topo, sem retirá-lo
	public int top() throws Exception {
														//Retorna o elemento na posição do topo
														//Se a pilha estiver vazia, retorna -1
		try {
			return stackArray[top];						//Se possível, retorna o topo da pilha
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage() + " - top");
		}
		return -1;										//Retorna -1 se não for possível acessar o topo
	}
														//Verifica Pilha Vazia
	public boolean isEmpty() {
		return (top <= -1);
	}
														//Verifica Pilha Cheia
	public boolean isFull() {
		return (maxSize - 1 == top);
	}
	
	public int bottom() throws Exception {				//Método auxiliar para retorno da cabeça em filas com pilhas
		if (!isEmpty()) {
			try {
				return stackArray[bottom];
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		return -1;
	}

	
}
