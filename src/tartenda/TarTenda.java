
package tartenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.DataOutputStream;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class TarTenda {
    
    public static void main(String[] args) {
        
        ArrayList<Tenda> listaTendas = new ArrayList();    
        ArrayList<Produto> listaProdutos = new ArrayList();
        ArrayList<Empregado> listaEmpregados = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();  
        
        File arquivo = new File("datosTenda.json");
        Gson gson = new Gson();
        if(arquivo.exists()){
            
            ////lectura json        
            try {

                //Creamos un fluxo de entrada para o arquivo
                FileReader fluxoDatos;
                fluxoDatos = new FileReader(arquivo);

                //Creamos o bufer de entrada
                BufferedReader buferEntrada = new BufferedReader(fluxoDatos);

                //Imos lendo linea a linea
                StringBuilder jsonBuilder = new StringBuilder();
                String linea;
                while ((linea=buferEntrada.readLine()) != null) {
                    jsonBuilder.append(linea).append("\n");
                }

                //Temos que cerrar sempre o ficheiro
                buferEntrada.close();

                String jsonLectura = jsonBuilder.toString();

                Datos datos = gson.fromJson(jsonLectura, Datos.class); 
                
                listaTendas = datos.listaTendas;
                listaClientes = datos.listaClientes;
                

            } catch (FileNotFoundException e) {
                System.out.println("Non se encontra o arquivo");
            } catch (IOException e) {
                System.out.println("Erro de entrada saída");
            }
        } 
        
        
        Scanner teclado = new Scanner(System.in);
        short opcion=-1;        
        
        while(opcion!=0){
            System.out.println("1- Engadir tenda.");
            System.out.println("2- Eliminar tenda");
            System.out.println("3- Crear un produto e engadilo a unha tenda.");
            System.out.println("4- Eliminar un produto dunha tenda.");
            System.out.println("5- Crear un empregado e engadilo a unha tenda.");
            System.out.println("6- Eliminar un empregado dunha tenda.");
            System.out.println("7- Crear un cliente.");
            System.out.println("8- Eliminar un cliente."); 
            System.out.println("9- Crear unha copia de seguridade dos datos.");
            System.out.println("10- Ler os titulares do periódico El País.");
            System.out.println("0- Sair do programa.");
            System.out.println("Escolle unha das opcións anteriores.\n");
            opcion = teclado.nextShort();

            switch(opcion){
                case 1:
                    //Engadir tenda
                    //basura
                    teclado.nextLine();
                    //basura
                    System.out.println("Introduce o nome da tenda");
                    String nomeT = teclado.nextLine();
                    System.out.println("Introduce en que cidade está a tenda");
                    String cidadeT = teclado.nextLine();
                    Tenda novaTenda = new Tenda(nomeT,cidadeT);
                    listaTendas.add(novaTenda);
                    System.out.println("Tenda engadida correctamente\n");
                break;

                case 2:
                    //Eliminar tenda
                    boolean flagT = true;
                    teclado.nextLine();
                    System.out.println("Que tenda queres eliminar?");
                    Tenda.verTenda(listaTendas);                                    

                    int borrar = teclado.nextInt();

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j==borrar){
                            flagT = false;
                            listaTendas.remove(borrar);
                            System.out.println("Tenda borrada correctamente.\n");
                        }
                    }

                    if(flagT){
                        System.out.println("Non se atopou a tenda\n");
                    }

                break;
                case 3:
                    //Crear un produto e engadilo a unha tenda
                    boolean flag = true;

                    System.out.println("Introduce o id do produto (int)");
                    int idP = teclado.nextInt();
                    //basura
                    teclado.nextLine();
                    System.out.println("Describe o produto");
                    String descP = teclado.nextLine();
                    System.out.println("Prezo do produto");
                    int prezoP = teclado.nextInt();
                    System.out.println("Cantidade do produto");
                    int cantP= teclado.nextInt();

                    Produto novoProduto = new Produto(idP,descP,prezoP,cantP);
                    listaProdutos.add(novoProduto);                    

                    teclado.nextLine();
                    System.out.println("En que tenda queres engadir o produto?");
                    Tenda.verTenda(listaTendas);

                    int engadir = teclado.nextInt(); 

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j == engadir){
                            flag = false;                            
                            listaTendas.get(engadir).produtos.add(novoProduto);                            
                            System.out.println("Produto engadido correctamente en "+listaTendas.get(j).getNomeTenda()+".\n");
                        }
                    }  

                    if(flag){
                        System.out.println("Non se atopou a tenda.\n");
                    }

                break;
                case 4:
                    //Eliminar un produto dunha tenda
                    teclado.nextLine();
                    System.out.println("De que tenda queres borrar o produto?");
                    Tenda.verTenda(listaTendas); 
                    int escolleTenda = teclado.nextInt();

                    System.out.println("Que produto queres borrar?");

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j == escolleTenda){
                            int contador=0;
                            for(int x=0; x<listaTendas.get(j).produtos.size(); x++){
                                System.out.println(contador+" - id: "+listaTendas.get(j).produtos.get(x).getIdP()+": Descripción:"+listaTendas.get(j).produtos.get(x).getDescP());
                                contador++;
                            }
                        }
                    }  

                    int escolleProduto = teclado.nextInt();                    

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j == escolleTenda){
                            for(int x=0; x<listaTendas.get(j).produtos.size(); x++){
                                if(x==escolleProduto){
                                    String nomeP = listaTendas.get(j).produtos.get(escolleProduto).getDescP();
                                    listaTendas.get(j).produtos.remove(escolleProduto);
                                    System.out.println("O produto "+nomeP+" foi borrado correctamente\n");
                                }
                            }
                        }
                    } 


                break;
                case 5:
                    //Crear un empregado e engadilo a unha tenda
                    boolean bandeiraE= true;
                    teclado.nextLine();
                    System.out.println("Introduce o nome do empregado.");
                    String nomeE = teclado.nextLine();
                    System.out.println("Introduce os apelidos do empregado.");
                    String apeE = teclado.nextLine();

                    Empregado novoEmpregado = new Empregado(nomeE,apeE);
                    listaEmpregados.add(novoEmpregado);                    

                    System.out.println("En que tenda queres engadir o empregado?");
                    Tenda.verTenda(listaTendas);                    
                    int engadirE = teclado.nextInt(); 

                    for(int j=0; j<listaTendas.size(); j++){                        
                        if(j == engadirE){
                            bandeiraE = false;
                            listaTendas.get(j).setEmpregados(novoEmpregado);
                            System.out.println("Empregado engadido correctamente en "+listaTendas.get(j).getNomeTenda()+".\n");
                        }                        
                    }                    

                    if(bandeiraE){
                        System.out.println("Non se atopou a tenda.\n");
                    }

                break;
                case 6:
                    //Eliminar un empregado dunha tenda
                    teclado.nextLine();
                    System.out.println("De que tenda queres borrar o empregado?");
                    Tenda.verTenda(listaTendas);
                    int borrarE = teclado.nextInt();

                    System.out.println("Que empregado queres borrar?");                    

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j == borrarE){
                            int contador=0;
                            for(int x=0; x<listaTendas.get(j).empregados.size(); x++){
                                System.out.println(contador+" - "+listaTendas.get(j).empregados.get(x).getNomeEmp());
                                contador++;
                            }
                        }
                    }      

                    int escolleE = teclado.nextInt();

                    for(int j=0; j<listaTendas.size(); j++){
                        if(j == borrarE){
                            for(int x=0; x<listaTendas.get(j).empregados.size(); x++){
                                if(x==escolleE){
                                    String nomeEmp = listaTendas.get(j).empregados.get(x).getNomeEmp();
                                    listaTendas.get(j).empregados.remove(escolleE);
                                    System.out.println("O empregado "+nomeEmp+" borrouse correctamente da tenda "+listaTendas.get(j).getNomeTenda()+"\n");
                                }
                            }
                        }
                    } 

                break;
                case 7:
                    //Crear un cliente
                    teclado.nextLine();
                    System.out.println("Nome do cliente:");
                    String nomeC = teclado.nextLine();
                    System.out.println("Apelidos do cliente:");
                    String apeC = teclado.nextLine();
                    System.out.println("Email do cliente:");
                    String emailC = teclado.nextLine();

                    Cliente novoCliente = new Cliente(nomeC,apeC,emailC);
                    listaClientes.add(novoCliente);
                    System.out.println("Cliente engadido correctamente\n");

                break;
                case 8:
                    //Eliminar un cliente
                    teclado.nextLine();
                    System.out.println("Que cliente queres eliminar?");
                    Cliente.verCliente(listaClientes);
                    int borrarC = teclado.nextInt();

                    for(int j=0; j<listaClientes.size(); j++){
                        if(j == borrarC){                            
                            listaClientes.remove(j);
                            System.out.println("Cliente borrado correctamente.\n");
                        }
                    }  

                break;  
                case 9:
                    //Crear unha copia de seguridade dos datos
                    File ficheroBackup = new File(arquivo+".backup");                    
                    
                    try{
                        FileOutputStream fileOut = new FileOutputStream(ficheroBackup);
                        DataOutputStream fluxoDatos = new DataOutputStream(fileOut);
                        
                        for(int x=0; x<listaTendas.size(); x++){
                            Tenda tendaAux = listaTendas.get(x);
                            fluxoDatos.writeUTF(tendaAux.getNomeTenda());
                            fluxoDatos.writeUTF(tendaAux.getCidadeTenda());                            
                            for(int j= 0; j<tendaAux.produtos.size(); j++){
                                Produto produtoAux = listaProdutos.get(j);
                                fluxoDatos.writeInt(produtoAux.getIdP());
                                fluxoDatos.writeUTF(produtoAux.getDescP());
                                fluxoDatos.writeInt(produtoAux.getCantP());
                                fluxoDatos.writeInt(produtoAux.getPrezoP());
                            }
                            for(int y=0; y<tendaAux.empregados.size(); y++){
                                Empregado empregadoAux = listaEmpregados.get(y);
                                fluxoDatos.writeUTF(empregadoAux.getNomeEmp());
                                fluxoDatos.writeUTF(empregadoAux.getApeEmp());
                            }
                            
                        }
                        
                        for(int z=0; z<listaClientes.size(); z++){
                            Cliente clienteAux = listaClientes.get(z);
                            fluxoDatos.writeUTF(clienteAux.getNomeCliente());
                            fluxoDatos.writeUTF(clienteAux.getApeCliente());
                            fluxoDatos.writeUTF(clienteAux.getEmailCliente());
                        }
                        
                        //Temos que cerrar sempre o ficheiro
                        fluxoDatos.close();

                    }catch(FileNotFoundException e){
                        System.out.println("Non se encontra o arquivo");
                    }catch(IOException e){
                        System.out.println("Erro de entrada saída");
                    }
                    
                break;
                
                case 10:
                     
                    XMLReader procesadorXML = null;
                    try {


                        procesadorXML = XMLReaderFactory.createXMLReader();            
                        TitularesXML titularesXML = new TitularesXML();            
                        procesadorXML.setContentHandler(titularesXML);

                        InputSource arquivoXML = new InputSource("http://ep00.epimg.net/rss/elpais/portada.xml");
                        procesadorXML.parse(arquivoXML);

                        ArrayList<Titulares> listaTitulares = titularesXML.getTitulares();
                        for(int i=0;i<listaTitulares.size();i++){
                            Titulares titularesAux = listaTitulares.get(i);
                            System.out.println("Titular: " + titularesAux.getTitulo());
                        }

                    } catch (SAXException e) {
                        System.out.println("Ocurriu un erro ao ler o arquivo XML");
                    } catch (IOException e) {
                        System.out.println("Ocurriu un erro ao ler o arquivo XML");
                    }
                    
                break;
                
                case 0:
                    System.out.println("Saindo do programa...");
                break;
            }
            
            try{
                //Creamos o fluxo de saida
                FileWriter fluxoDatos = new FileWriter(arquivo);
                BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);

                Datos datos = new Datos(listaTendas,listaClientes);
                String json = gson.toJson(datos);
                buferSaida.write(json);    
                //Cerramos o arquivo
                buferSaida.close();
            
            }catch(IOException e){
                System.out.println("Non se pode escribir no arquivo");
            }  
        
        }
        
        //punto borrado
        
    }    
}
