import java.util.Iterator;
import java.util.ArrayList;
import java.util.Vector;

public class ListaDeIdsENomesOficial {

	private ArrayList<String> vector=new ArrayList<String>(); 
	
	public String getNomeByID(int id) {
		return vector.get(id);
	}
	
	public int getIdByNome(String Nome) {
		return vector.indexOf(Nome);
	}
	
	public String  listItems() {
		StringBuilder resp=new StringBuilder();
		int numero=0;
		Iterator<String> iv=vector.iterator();
		while(iv.hasNext()) {
		resp.append(numero+" - "+iv.next()+"\n");
		numero++;
		}
		return resp.toString();
	}
	//Retorna ID do item caso já exista, senão retorna aonde foi colocado
	public int AdicionaItem(String nome) {
		if(getIdByNome(nome)==-1) {
			vector.add(nome);
		}
		return getIdByNome(nome);
		
	}
	
	public static void main(String Args[]) {
		ListaDeIdsENomesOficial ls=new ListaDeIdsENomesOficial();
		
		System.out.println(ls.AdicionaItem("wood"));
		System.out.println(ls.AdicionaItem("wood plank"));
		System.out.println(ls.AdicionaItem("Stick"));
		System.out.println(ls.AdicionaItem("wood plank"));
		
		System.out.println(ls.listItems());
		System.out.println(ls.getIdByNome("Stick"));
	}
}
