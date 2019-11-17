
package tartenda;


public class Empregado {
    
    private String nomeEmp;
    private String apeEmp;

    public Empregado(String nomeE, String apeE) {
        this.nomeEmp = nomeE;
        this.apeEmp = apeE;
    }

    public String getNomeEmp() {
        return nomeEmp;
    }

    public void setNomeEmp(String nomeEmp) {
        this.nomeEmp = nomeEmp;
    }

    public String getApeEmp() {
        return apeEmp;
    }

    public void setApeEmp(String apeEmp) {
        this.apeEmp = apeEmp;
    }
    
    //Metodo que pasa a JSON
    public String toJSON(){
        String json = new String();
        json = json + "{ ";
        json = json + "\"nome\" : \"" + this.nomeEmp + "\",";
        json = json + "\"apelidos\" : \"" + this.apeEmp + "\" }";
        return json;
    }
}
