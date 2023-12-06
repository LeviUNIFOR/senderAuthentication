package Entidades;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID; //Example: 54947df80e9e4471a2f99af509fb5889

public class Mensagem {
    protected String remetente;
    protected String corpo;
    protected Pessoa pessoa;
    protected String token;
    protected String contactType; // Informar se o contato é via email ou telefone(sms).
    protected HashMap<String,Mensagem> mensagensEnviadas;
    protected Date date = new java.util.Date(System.currentTimeMillis());
    protected Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public Mensagem(String remetente, String corpo, Pessoa pessoa, String contactType, HashMap<String,Mensagem> mensagensEnviadasDB) {
        this.remetente = remetente;
        this.corpo = corpo;
        this.pessoa = pessoa;
        this.contactType = contactType;
        this.mensagensEnviadas = mensagensEnviadasDB;

        String tryToken = UUID.randomUUID().toString().replaceAll("-", "");
        
        while (mensagensEnviadas.containsKey(tryToken)){
            tryToken = UUID.randomUUID().toString().replaceAll("-", "");
        }

        this.token = tryToken;

        this.corpo = corpo + " Token:" + token;

    }

    public List<String> toList(){
        List<String> lista = List.of(pessoa.nome, formatter.format(date), contactType, corpo, token);
        return lista;
    }
    
    @Override
    public String toString() {
        return "Mensagem [remetente=" + remetente + ", corpo=" + corpo + ", pessoa=" + pessoa + ", token=" + token
                + ", date=" + date + ", contactType=" + contactType + "]";
    }

    public Date getDate() {
        return date;
    }

    public String getDateString(){
        return formatter.format(date);

    }

    
}