
package tartenda;

import java.util.ArrayList;


public class Datos {
    
    ArrayList<Tenda> listaTendas = new ArrayList();
    ArrayList<Cliente> listaClientes = new ArrayList();
    
    public Datos(){}
    
    public Datos(ArrayList<Tenda> listaTendas,ArrayList<Cliente> listaClientes){
        this.listaTendas = listaTendas;
        this.listaClientes = listaClientes;
    }

    public ArrayList<Tenda> getListaTendas() {
        return listaTendas;
    }

    public void setListaTendas(ArrayList<Tenda> listaTendas) {
        this.listaTendas = listaTendas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
        
}
