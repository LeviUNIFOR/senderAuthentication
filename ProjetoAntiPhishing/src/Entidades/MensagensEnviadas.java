package Entidades;

import java.util.HashMap;

public class MensagensEnviadas {
    HashMap<String,Mensagem> mensagensEnviadas = new HashMap<String,Mensagem>();

    public MensagensEnviadas(){
	
    }
    
    public HashMap<String, Mensagem> getMensagensEnviadas() {
        return mensagensEnviadas;
    }
    
}
