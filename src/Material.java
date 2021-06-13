
public class Material {
	public String getNome() {
		return nome;
	}
	public int getDurabilityOnHead() {
		return durabilityOnHead;
	}
	public Encantamento getEnchant1OnHead() {
		return enchant1OnHead;
	}
	public Encantamento getEnchant2OnHead() {
		return enchant2OnHead;
	}
	public int getDurabilityOnParts() {
		return durabilityOnParts;
	}

	public int getDurabilityOnHandle() {
		return durabilityOnHandle;
	}
	public float getDurabilityMultiplierOnHandle() {
		return durabilityMultiplierOnHandle;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDurabilityOnHead(int durabilityOnHead) {
		this.durabilityOnHead = durabilityOnHead;
	}
	public void setEnchant1OnHead(Encantamento enchant1OnHead) {
		this.enchant1OnHead = enchant1OnHead;
	}
	public void setEnchant2OnHead(Encantamento enchant2OnHead) {
		this.enchant2OnHead = enchant2OnHead;
	}
	public void setDurabilityOnParts(int durabilityOnParts) {
		this.durabilityOnParts = durabilityOnParts;
	}

	public void setDurabilityOnHandle(int durabilityOnHandle) {
		this.durabilityOnHandle = durabilityOnHandle;
	}
	public void setDurabilityMultiplierOnHandle(float durabilityMultiplierOnHandle) {
		this.durabilityMultiplierOnHandle = durabilityMultiplierOnHandle;
	}
	public Encantamento getEnchant1OnPartsHandle() {
		return enchant1OnPartsHandle;
	}
	public Encantamento getEnchant2OnPartsHandle() {
		return enchant2OnPartsHandle;
	}
	public void setEnchant1OnPartsHandle(Encantamento enchant1OnPartsHandle) {
		this.enchant1OnPartsHandle = enchant1OnPartsHandle;
	}
	public void setEnchant2OnPartsHandle(Encantamento enchant2OnPartsHandle) {
		this.enchant2OnPartsHandle = enchant2OnPartsHandle;
	}
	private String nome;

	//infos da cabeça da ferramenta, responsavel pela durabilidade principal além de qual material ela precisara para reparar
	private int durabilityOnHead;
	private Encantamento enchant1OnHead;
	private Encantamento enchant2OnHead;

	//Essas parts não são a mesma da classe Parts e sim todos adicionais de uma ferramenta(Item) que não é cabo nem cabeça
	private int durabilityOnParts;
	
	//A handle(Cabo) dos equipamentos tem função de aumentar ou reduzir a durabilidade da ferramenta final
	private int durabilityOnHandle;
	private float durabilityMultiplierOnHandle;

	//Tanto a handle quanto parts possuem encantamentos iguais
	private Encantamento enchant1OnPartsHandle;
	private Encantamento enchant2OnPartsHandle;
	

}
