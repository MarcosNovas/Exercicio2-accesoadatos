
package tartenda;

import java.util.ArrayList;
import java.util.Iterator;


public class Tenda {
    
    private String nomeTenda;
    private String cidadeTenda;
    ArrayList<Produto> produtos;
    ArrayList<Empregado> empregados;

    public Tenda(String tenda, String cidade){    
        this.nomeTenda = tenda;
        this.cidadeTenda = cidade;
        produtos= new ArrayList();
        empregados = new ArrayList();
    }
    
    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Empregado empregado) {
        empregados.add(empregado);
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produto) {
        produtos.add(produto);
    }

    public String getNomeTenda() {
        return nomeTenda;
    }

    public void setNomeTenda(String nomeTenda) {
        this.nomeTenda = nomeTenda;
    }

    public String getCidadeTenda() {
        return cidadeTenda;
    }

    public void setCidadeTenda(String cidadeTenda) {
        this.cidadeTenda = cidadeTenda;
    }    
    
    //Metodo que pasa a JSON
//    public String toJSON(){
//        String json = new String();
//        json = json + "{ ";
//        json = json + "\"Nome Tenda\" : \"" + this.nomeTenda + "\",";
//        json = json + "\"Cidade\" : \"" + this.cidadeTenda + "\" ,";
//        json = json + "\"Produtos\" : [ ";
//        for(int i=0;i<produtos.size();i++){
//            if(i != 0) json = json +  " , ";
//            Produto prod = produtos.get(i);
//            json = json + prod.toJSON();
//        }
//        json = json + "] ";
//        json = json + "\"Empregados\" : [ ";
//        for(int i=0;i<empregados.size();i++){
//            if(i != 0) json = json +  " , ";
//            Empregado emp = empregados.get(i);
//            json = json + emp.toJSON();
//        }
//        json = json + " ] }";        
//        return json;
//    }
        
    //ver todas as tendas
    public static void verTenda(ArrayList tendas){
        
        Iterator<Tenda> IteratorT = tendas.iterator();
        int contador=0;
        while(IteratorT.hasNext()){
            Tenda elemento = IteratorT.next();
            System.out.println(contador+"- "+elemento.nomeTenda);
            contador++;
        }        
    }
    
}
