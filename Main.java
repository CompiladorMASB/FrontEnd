import Symbol.*;

public class Main{

  public static void main(String[] args){
    SymbolTable table = new SymbolTable();
    CodeFile code = new CodeFile();
    code.preProcess("test");
  }

}