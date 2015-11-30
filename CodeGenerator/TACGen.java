//=======================================================//
// Currently working on:                                 //
// processDecl -> getIdVal                               //
//=======================================================//
package CodeGenerator;

public class TACGen{
  public int scope=0;

  private int isInt(String string, int offset){
  	if((string.charAt(offset) == 'i') && (string.charAt(offset+1) == 'n') && (string.charAt(offset+2) == 't') && (string.charAt(offset+3) == ' ')) return 1;
  	else return 0;
  }

  private int isFloat(String string, int offset){
  	if((string.charAt(offset) == 'f') && (string.charAt(offset+1) == 'l') && (string.charAt(offset+2) == 'o') && (string.charAt(offset+3) == 'a') && (string.charAt(offset+4) == 't') && (string.charAt(offset+5) == ' ')) return 1;
  	else return 0;
  }

  private int isBool(String string, int offset){
  	if ((string.charAt(offset) == 'b') && (string.charAt(offset+1) == 'o') && (string.charAt(offset+2) == 'o') && (string.charAt(offset+3) == 'l') && (string.charAt(offset+4) == ' ')) return 1;
  	else return 0;
  }

  private int isChar(String string, int offset){
  	if ((string.charAt(offset) == 'c') && (string.charAt(offset+1) == 'h') && (string.charAt(offset+2) == 'a') && (string.charAt(offset+3) == 'r') && (string.charAt(offset+4) == ' ')) return 1;
  	else return 0;
  }

  private int isBasic(String string, int offset){
    if(isInt(string,offset)) return 1;
    else if(isFloat(string,offset)) return 1;
    else if(isBool(string,offset)) return 1;
    else if(isChar(string,offset)) return 1;
    else return 0;
  }

  private int isCmd(String string, int offset){
    if((string.charAt(offset) == 'i') && (string.charAt(offset+1) == 'f') && (string.charAt(offset+2) == '(')) return 1;
    else if((string.charAt(offset) == 'd') && (string.charAt(offset+1) == 'o') && (string.charAt(offset+2) == ' ')) return 1;
    else if((string.charAt(offset) == 'w') && (string.charAt(offset+1) == 'h') && (string.charAt(offset+2) == 'i') && (string.charAt(offset+3) == 'l') && (string.charAt(offset+4) == 'e') && (string.charAt(offset+5) == '(')) return 1;
    else if((string.charAt(offset) == 'b') && (string.charAt(offset+1) == 'r') && (string.charAt(offset+2) == 'e') && (string.charAt(offset+3) == 'a') && (string.charAt(offset+4) == 'k') && (string.charAt(offset+5) == ';')) return 1;
    else return 0;
  }

  private int isId(String string, int offset){
  	char c=0;
  	if (!Character.isLetter(c)) return 0;
  	while (Character.isLetter(c) || Character.isLetter(c)){
      c=string.charAt(offset);
      offset++;
    }
    return 1;
  }

  private int getIntVal(String string, int offset){
  	int offsetBegin=offset;
  	int offsetEnd;
  	while (string.charAt(offset != ' '))
  		offset++;
  	offsetEnd=offset;
  	String stringInt = string.substring(offsetBegin, offsetEnd);
  	return Integer.parseInt(stringInt);
  }

  private int processDecl(String string, int offset){
  	double floatVal;
  	String idVal   ;
  	char   charVal ;
  	int    boolVal ;
  	int    intVal  ;

  	while (1){
  		if (isInt(string,offset)){
  			offset = offset + 4;
  			idVal  = getIdVal(string,offset);
  			addSymbol("int", idVal, 0);
  		}
  	}
  }

  private int processDecls(String string, int offset){
  	while (1){
      if (string.charAt(offset) == ' ') offset++;
      else if (isBasic) offset = processDecl(string,offset);
      else return offset;
  	}
  }


  private int processBlock (String string, int offset){
  	while(1){
      if (string.charAt(offset) == ' ') offset++;
      else if (isBasic(string,offset)) offset = processDecls(string,offset);
      else if ((isCmd(string,offset)) || (isId(string,offset)) || (string.charAt(offset) == '{')) offset = processStmts(string,offset);
      else if (string.charAt(offset) == '}') return offset+1;
      else{
      	System.out.println("Unexpected token:" + string.charAt(offset));
      	return offset;
      }
    }
  }
  


}