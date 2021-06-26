import java.rmi.RemoteException;

public class Items implements Item {
//Items são partes especiais que não podem ser colocados no mundo, no entanto elas podem ser geradas por resultados de ações em maquinas
//Items podem ser encantados em maquinas que possuem suas propias listas de encantamento e não necessitam de serem unificadas com o mundo
	
	private boolean isFerramenta; //Se é um item basico ou ferramenta
	private int ingameID; //Itens basicos possuem ingameID, ferramentas complexas não possuem 

	private Material[] materialTraits; //De quais material é feito o item
	private Encantamento[] enchants; //Lista de encantamentos, inicialmente com os vindo de materiais e podem ter extras adicionados por maquinas

	//Se é ferramenta, entao tem durabilidadeMaxima somada
	private int DurabilidadeMax;
	private int Durabilidade;
	
	private int codigoDesteitem; //Codigo unico deste item
	private String nome; //String do nome deste item, é possivel alterar seu nome após criada por meio do uso de maquinas
	

	private boolean existe;  //Todos itens criados existem, caso delete o item, pode-se apenas deletar sua existencia, mas o programa atual nao lida com isso
	private Part[] parteUsadas; //Guarda informações das peças usads para criação da ferramenta, incluindo os ids unicos. Isso pode ser util numa maquina de desmontar.

	public int getDurabilidade() {
		return this.Durabilidade;
	}
	public void setDurabilidade(int i) {
		System.out.println("Durabilidade trocada");
		this.Durabilidade=i;
		return;
	}
	public int getDurabilidadeMax() {
		return this.DurabilidadeMax;
	}
	
	@Override
	public boolean isFerramenta() {
		return isFerramenta;
	}
	@Override
	public int getIngameID() {
		return ingameID;
	}
	@Override
	public Material[] getMaterialTraits() {
		return materialTraits;
	}
	@Override
	public Encantamento[] getEnchants() {
		return enchants;
	}
	@Override
	public int getCodigoDesteitem() {
		return codigoDesteitem;
	}
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public boolean isExiste() {
		return existe;
	}
	@Override
	public Part[] getParteUsadas() {
		return parteUsadas;
	}
	@Override
	public void setFerramenta(boolean isFerramenta) {
		this.isFerramenta = isFerramenta;
	}
	@Override
	public void setIngameID(int ingameID) {
		this.ingameID = ingameID;
	}
	@Override
	public void setMaterialTraits(Material[] materialTraits) {
		this.materialTraits = materialTraits;
	}
	@Override
	public void setEnchants(Encantamento[] enchants) {
		this.enchants = enchants;
	}
	@Override
	public void setCodigoDesteitem(int codigoDesteitem) {
		this.codigoDesteitem = codigoDesteitem;
	}
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	@Override
	public void setParteUsadas(Part[] parteUsadas) {
		this.parteUsadas = parteUsadas;
	}

	
	
	public Items(boolean isFerramenta, int ingameID, Material[] materialTraits, Encantamento[] enchants,
			int codigoDesteitem, String nome, Part[] parteUsadas) throws RemoteException {
		super();
		this.isFerramenta = isFerramenta;
		this.ingameID = ingameID;
		
		this.codigoDesteitem = codigoDesteitem;
		this.nome = nome;
		this.existe = true;
		if(isFerramenta) {
			this.materialTraits = materialTraits;
			this.enchants = enchants;
			
			//Uma ferramenta é formada pelo material da cabeça,da parte e do cabo e sua durabilidade é a soma deles multiplicado o modificidador de handle
			this.parteUsadas = parteUsadas;
			int a=materialTraits[0].getDurabilityOnHead();
			int b=materialTraits[1].getDurabilityOnParts();
			int c=materialTraits[2].getDurabilityOnHandle();
			this.DurabilidadeMax=a+b+c;
			this.DurabilidadeMax=(int) Math.floor(this.DurabilidadeMax*materialTraits[2].getDurabilityMultiplierOnHandle());
			this.Durabilidade=this.DurabilidadeMax;
			
		}
		else {
			
			Part[] vetvazio1=new Part[3];
			Encantamento[] vetvazio2=new Encantamento[3];
			Material[] vetvazio3=new Material[3];
			for(int i=0;i<3;i++) {
					Parts p=new Parts(0, "", null, null, null);
					Encantamento z=new Encantamento();
					Material m=new Material();
					vetvazio1[i]=p;
					vetvazio2[i]=z;
					vetvazio3[i]=m;
			}
			this.parteUsadas=vetvazio1;
			this.enchants=vetvazio2;
			this.materialTraits=vetvazio3;
			this.DurabilidadeMax=0;
			this.Durabilidade=0;
		}
	}
	
}
