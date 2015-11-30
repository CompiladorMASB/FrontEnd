package Symbol;

public class SymbolTable {

  //Nested classes
  public class tableEntry{
    //Fields
    public String entryType ;
    public String entryId   ;
    public double  entryValue;
    public int    entryScope;

    //Constructors
    public tableEntry(int scope, String type, String id, double value){
      this.entryScope=scope;
      this.entryValue=value;
      this.entryType =type ;
      this.entryId   =id   ;
    }

    //Prints
    public void printEntry(){
      if (entryScope!=-1) System.out.println(entryScope + "|" + entryType + "|" +entryId + "|" + entryValue);
    }
  }


  //Fields
  private int index;
  private int scope;
  private static final int MAX=1000000;
  public tableEntry[] table;

  //Constructors
  public SymbolTable(){
    table = new tableEntry[MAX];  
    scope=0;
    index=0;
  }

  //Field checking
  public int currentScope(){
    return this.scope;
  }

  //Symbol Management
  public void addSymbol(String type, String id, double value){
    tableEntry entry = new tableEntry(scope,type,id,value);
    table[index] = entry;
    index++;
  }

  public double getEntry(int symScope, String symId){
    int i=0;
    while (i < index){
      if ((table[i].entryId == symId) && (table[i].entryScope == symScope)) return table[i].entryValue;
      i++;
    }
    return -1;
  }

  //Scopes
  public void beginScope(){
  	scope++;
  }

  public void endScope(){
  	tableEntry entry = new tableEntry(-1,"-1","-1",-1);
  	table[index]=entry;
  	index++;
  	scope--;
  }

  //Print
  public void printTable(){
  	int i=0;
    System.out.println("Scope|type|id");
  	while (i < index){
  		table[i].printEntry();
      i++;
  	}
  }

}