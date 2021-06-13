import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeMateriais {



private ArrayList<Material> vector=new ArrayList<Material>(); 

public String getNomeByID(int id) {
	return vector.get(id).getNome();
}

public int getIdByNome(String Nome) {
	Iterator<Material> iv=vector.iterator();
	int count=0;
	while(iv.hasNext()) {
		if(iv.next().getNome().equals(Nome)) {
			return count;
		}
		count++;
			
	}
	return -1;
}

public String  listMats() {
	StringBuilder resp=new StringBuilder();
	int numero=0;
	Iterator<Material> iv=vector.iterator();
	resp.append("\n");
	while(iv.hasNext()) {
	Material a=iv.next();
	resp.append(a.getNome()+"---"+a.getDurabilityOnHead()+"\n");
	numero++;
	}
	return resp.toString();
}


//Retorna ID do item caso já exista, senão retorna aonde foi colocado
public int Adiciona(String nome,int Headdurabilidade,Encantamento  Headenchant1,Encantamento  Headenchant2,int Partsdurabilidade,Encantamento  Partenchant1,Encantamento  Partenchant2,int handleDurabilidade,float durabilityModifier) {
	if(getIdByNome(nome)==-1) {
		Material novo=new Material();
		novo.setNome(nome);

			novo.setDurabilityOnHead(Headdurabilidade);
			novo.setEnchant1OnHead(Headenchant1);
			novo.setEnchant2OnHead(Headenchant2);
			novo.setDurabilityOnParts(Partsdurabilidade);
			novo.setEnchant1OnPartsHandle(Partenchant1);
			novo.setEnchant2OnPartsHandle(Partenchant2);

			novo.setDurabilityOnHandle(handleDurabilidade);
			novo.setDurabilityMultiplierOnHandle(durabilityModifier);

		vector.add(novo);
	}
	return getIdByNome(nome);
	
}
}
