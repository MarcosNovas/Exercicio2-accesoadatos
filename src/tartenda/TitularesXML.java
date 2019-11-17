/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tartenda;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Marcos
 */
public class TitularesXML  extends DefaultHandler{
    
    private ArrayList<Titulares> listaTitulares = new ArrayList();
    
    private Titulares titularesAux;
    
    private String cadeaTexto;
    
    private boolean boolItem = false;
    private boolean boolTitle = false;
    
    public TitularesXML(){
        super();
    }

       
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        
        if(localName == "item"){
            boolItem= true;
            this.listaTitulares = new ArrayList<>(); 
        }  
        else if(localName == "title"){
            boolTitle = true;            
            this.titularesAux = new Titulares();
        }        
    }

    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
        if((localName == "title") && boolTitle){
            this.titularesAux.setTitulo(cadeaTexto);
            boolTitle=false;
        }
        else if((localName == "item") && boolItem){
            this.listaTitulares.add(this.titularesAux);
            boolItem=false;
        }        
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        
        if(boolTitle && boolItem){
        this.cadeaTexto = new String(ch,start,length);
        System.out.println(cadeaTexto);
        }
    }

    public ArrayList<Titulares> getTitulares() {
        return listaTitulares;
    }
    
}
