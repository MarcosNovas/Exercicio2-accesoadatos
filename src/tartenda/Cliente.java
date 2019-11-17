
package tartenda;

import java.util.ArrayList;
import java.util.Iterator;


public class Cliente {
    
    private String nomeCliente;
    private String apeCliente;
    private String emailCliente;

    public Cliente(String nomeCliente, String apeCliente, String emailCliente) {
        this.nomeCliente = nomeCliente;
        this.apeCliente = apeCliente;
        this.emailCliente = emailCliente;
    }   

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
    
    //Metodo que pasa a JSON
    public String toJSON(){
        String json = new String();
        json = json + "{ ";
        json = json + "\"nome\" : \"" + this.nomeCliente + "\",";
        json = json + "\"apelidos\" : \"" + this.apeCliente + "\",";
        json = json + "\"email\" : " + this.emailCliente + " }";
        return json;
    }
    
    public static void verCliente(ArrayList clientes){
        
        Iterator<Cliente> IteratorC = clientes.iterator();
        short contador=0;
        while(IteratorC.hasNext()){
            Cliente elemento = IteratorC.next();
            System.out.println(contador+"- "+elemento.nomeCliente);
            contador++;            
        }        
    }
    
}
