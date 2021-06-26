
public interface Item {

	boolean isFerramenta();

	int getIngameID();

	Material[] getMaterialTraits();

	Encantamento[] getEnchants();

	int getCodigoDesteitem();

	String getNome();

	boolean isExiste();

	Part[] getParteUsadas();
	 int getDurabilidade() ;
	 void setDurabilidade(int i) ;
	 int getDurabilidadeMax() ;
	
	
	

	void setFerramenta(boolean isFerramenta);

	void setIngameID(int ingameID);

	void setMaterialTraits(Material[] materialTraits);

	void setEnchants(Encantamento[] enchants);

	void setCodigoDesteitem(int codigoDesteitem);

	void setNome(String nome);

	void setExiste(boolean existe);

	void setParteUsadas(Part[] parteUsadas);

}