
public class Blocos {
//Blocos são um tipo especial de partes que não podem ser montados, eles apenas existem e não tem uma receita para crialos
//Blocos podem ser utilizados como receita de parts/items
//Blocos podem ser colocados no mundo
//Algumas partes podem ser transformadas em blocos	
	private int ingameID; //Codigo fixo definido pelo protocolo,desta forma peças do mesmo tipo tem o mesmo ID. É definida no construtor e pode apenas ser consultada
	private int codigoDesteBloco; //Codigo deste blcoo gerado na inicialização, cuidado, maquinas diferentes podem gerar o mesmo codigo
	private String nome; //String do nome deste bloco, não é possivel mudar o nome do bloco após criado
	

	private boolean existe=true;  //O bloco existe e tem dados atrelados a ela
	

	//Getter-setters
	public int getIngameID() {
		return ingameID;
	}

	public int getcodigoDesteBloco() {
		return codigoDesteBloco;
	}

	public String getNome() {
		return nome;
	}

	//Afirma existencia do bloco
	public boolean getExiste() {
		return this.existe;
	}

	//Construtor:
	public Blocos(int ingameID, int codigoDesteBloco, String nome) {
		super();
		this.ingameID = ingameID;
		this.codigoDesteBloco = codigoDesteBloco;
		this.nome = nome;
	}

	public Blocos ClonaBloco(int NovoCodigoDeBloco) {
		Blocos ret= new Blocos(this.ingameID,NovoCodigoDeBloco,this.nome);
			return ret;
		}
/*Metodo externo		
	public String posicionaNoMundo(Blocos bloco,int x, int y, Mundo mundo) {
		Mundo.plano[x][y][z]==0){
		Mundo.plano[x][y][z]=bloco.getIngameID; //Quando bloco é colocado, ele perde seu Id unico Anterior, já que seu objeto vai ser destruido para evitar duplicação
		String strRet="Bloco"+ bloco.getNome()+"Id("+bloco.getId()+") adicionado no mundo na posição"+x+", "+y+", "+z;
		bloco.finalize();
		return strRet;
		}
	}
	*/
		
	}



