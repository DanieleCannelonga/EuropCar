package main.java.controller.generation;

public class FatturaElettronica {
		
	//Attributi
    private FatturaElettronicaHeader header;
    private FatturaElettronicaBody body;
	    
    //Getters & Setters
    public FatturaElettronicaHeader getHeader() {
        return header;
    }
    public void setHeader(FatturaElettronicaHeader header) {
        this.header = header;
    }
    public FatturaElettronicaBody getBody() {
        return body;
    }
    public void setBody(FatturaElettronicaBody body) {
        this.body = body;
    }
}


