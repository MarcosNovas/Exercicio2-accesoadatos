
package tartenda;

import java.util.ArrayList;
import java.util.Iterator;


public class Produto {
    
    private int idP;
    private String descP;
    private int prezoP;
    private int cantP;

    public Produto(int idPro, String descPro, int prezoPro, int cantPro) {
        this.idP = idPro;
        this.descP = descPro;
        this.prezoP = prezoPro;
        this.cantP = cantPro;
    }    
    
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }

    public int getPrezoP() {
        return prezoP;
    }

    public void setPrezoP(int prezoP) {
        this.prezoP = prezoP;
    }

    public int getCantP() {
        return cantP;
    }

    public void setCantP(int cantP) {
        this.cantP = cantP;
    }
    
    //Metodo que pasa a JSON
    public String toJSON(){
        String json = new String();
        json = json + "{ ";
        json = json + "\"id\" : \"" + this.idP + "\",";
        json = json + "\"descrición\" : \"" + this.descP + "\",";
        json = json + "\"prezo\" : \"" + this.prezoP + "\",";
        json = json + "\"cantidade\" : " + this.cantP + " }";
        return json;
    }
        
    public static void verProduto(ArrayList produtos){
        
        Iterator<Produto> IteratorProd = produtos.iterator();
        short contador=0;
        while(IteratorProd.hasNext()){
            Produto elemento = IteratorProd.next();
            System.out.println(contador+"- "+elemento.idP);
            contador++;
        }        
    }
}
