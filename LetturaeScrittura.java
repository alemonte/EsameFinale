package Esame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
public class LetturaeScrittura{

	
	public static Albero lettura(String filename) throws NumberFormatException, XMLStreamException, FileNotFoundException
	{
		File file;
		Albero Albero1;
		ArrayList<NodoTensore>tuttiNodi= new ArrayList<NodoTensore>();
		ArrayList<Tensore>tensori= new ArrayList<Tensore>();
		
	
		try
		{
			file=new File(filename);
		}
		catch(Exception e)
		{
			System.out.println("File at "+ filename +" is not avaiable or correctly patthed");
		}
				
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filename));
					
		
		
		String nome="";
		
		boolean readLabel = false, readTensorNode=false, readMatrix=false,
				readTensor = false, readRow = false, readColumn=false, readTTree=false;
		
		
		while(reader.hasNext())
		{
					
					switch (reader.next())
					{
						case XMLStreamConstants.START_DOCUMENT:
							System.out.println("Start reading document");
							break;
			
						case XMLStreamConstants.START_ELEMENT:
							if("label".equals(reader.getLocalName())){
								readLabel=true;
							}
							else if("TTree".equals(reader.getLocalName()))
								readTTree=true;
							else if("TensorNode".equals(reader.getLocalName()))
								readTensorNode=true;
							else if("Tensor".equals(reader.getLocalName()))
								readTensor=true;
							else if("row".equals(reader.getLocalName()))
								readRow=true;
							else if("column".equals(reader.getLocalName()))
								readColumn=true;
							//TODO if start_element == name => boolean readname==true
							break;
			
						case XMLStreamConstants.CHARACTERS:
						
							//TODO if readname nome=reader.getText().trim() readname=false;
							if(readTTree){
							System.out.println("inizio lettura albero");;
								readTTree=false;
							}
							if(readLabel){
								nome=reader.getText().toString().trim();
								readLabel=false;
							}
							if(readTensorNode){
								String stringa=reader.getText().toString().trim();
								if(!stringa.isEmpty()) qnt=Integer.parseInt(stringa);
								readQnt=false;
							}
			
							if(read){
								annata=Integer.parseInt(reader.getText().toString().trim());
								readAnnata=false;
							}
			
							if(readRegione){
								regione=reader.getText().trim();
							}
			
							if(readProduttore){
								produttore=reader.getText().trim();
								readProduttore=false;
							}
							break;

						case XMLStreamConstants.END_ELEMENT:
							switch(reader.getLocalName())
							{
								case "wine":
									Vino vino= new Vino(nome, prezzo, annata, regione, produttore, qnt);
									if(vini.add(vino))
									{
										//System.out.println("vino aggiunto  -" +vino.getNome());
										nome=""; produttore=""; regione=""; valuta="";
										annata=0; qnt=0;
										numero=0;
										prezzo=null;
									}
				
									break;
								case "wines":
									stampaVini();
									break;
							}
							break;
			
						case XMLStreamConstants.END_DOCUMENT:
							System.out.println("end reading");
							break;
					}
		}
		
	}
}	
					
	