package implementacao3;

public class BrincandoComPilhaEFila {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Brincando com PilhaComArray...");
		Pilha_IF minhaPilha1 = new PilhaComArray();
		minhaPilha1.push(100);
		minhaPilha1.push(200);
		System.out.println(minhaPilha1.top() == 200);
		System.out.println(minhaPilha1.pop() == 200);
		System.out.println(minhaPilha1.pop() == 100);
		System.out.println(minhaPilha1.isEmpty());
		System.out.println();
//		
		System.out.println("Brincando com PilhaComFilas...");
		Pilha_IF minhaPilha2 = new PilhaComFilas();
		minhaPilha2.push(100);
		minhaPilha2.push(200);
		System.out.println(minhaPilha2.top() == 200);
		System.out.println(minhaPilha2.pop() == 200);
		System.out.println(minhaPilha2.pop() == 100);
		System.out.println(minhaPilha2.isEmpty());
		System.out.println();
////		
		System.out.println("Brincando com FilaComArray...");
		Fila_IF minhaFila1 = new FilaComArray();
		minhaFila1.enqueue(100);
		minhaFila1.enqueue(200);
		System.out.println(minhaFila1.head() == 100);
		System.out.println(minhaFila1.dequeue() == 100);
		System.out.println(minhaFila1.dequeue() == 200);
		System.out.println(minhaFila1.isEmpty());
		System.out.println();
//		
		System.out.println("Brincando com FilaComPilhas...");
		Fila_IF minhaFila2 = new FilaComPilhas();
		minhaFila2.enqueue(100);
		minhaFila2.enqueue(200);
		System.out.println(minhaFila2.head() == 100);
		System.out.println(minhaFila2.dequeue() == 100);
		System.out.println(minhaFila2.dequeue() == 200);
		System.out.println(minhaFila2.isEmpty());
		System.out.println();
		
		//OBS.: Espera-se que nenhum print mostre 'false' na tela! 

	}

}
