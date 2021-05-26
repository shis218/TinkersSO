
public class Blocos {
//Blocos s�o um tipo especial de partes que n�o podem ser montados, eles apenas existem e n�o tem uma receita para crialos
//Blocos podem ser utilizados como receita de parts/items
//Blocos podem ser colocados no mundo
//Algumas partes podem ser transformadas em blocos	
	private int ingameID; //Codigo fixo definido pelo protocolo,desta forma pe�as do mesmo tipo tem o mesmo ID. � definida no construtor e pode apenas ser consultada
	private int codigoDesteBloco; //Codigo deste blcoo gerado na inicializa��o, cuidado, maquinas diferentes podem gerar o mesmo codigo
	private String nome; //String do nome deste bloco, n�o � possivel mudar o nome do bloco ap�s criado
	

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
		Mundo.plano[x][y][z]=bloco.getIngameID; //Quando bloco � colocado, ele perde seu Id unico Anterior, j� que seu objeto vai ser destruido para evitar duplica��o
		String strRet="Bloco"+ bloco.getNome()+"Id("+bloco.getId()+") adicionado no mundo na posi��o"+x+", "+y+", "+z;
		bloco.finalize();
		return strRet;
		}
	}
	*/
		
	}



