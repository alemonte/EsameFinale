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
		int s=0;
		File file;
		Albero Albero1;
		ArrayList<Integer>valoriarray= new ArrayList<Integer>();
		ArrayList<NodoTensore>tuttiNodi= new ArrayList<NodoTensore>();
		ArrayList<Tensore>tensori= new ArrayList<Tensore>();
		ArrayList<Matrice>matrici= new ArrayList<Matrice>();
		ArrayList<NodoTensore>nodiTensori= new ArrayList<NodoTensore>();
		NodoTensore nodoten;
		Tensore tensore;
		Matrice mat;
		int [][]valori;
		int j=0;
		int k=0;		
	
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
							else if("TensorNode".equals(reader.getLocalName())){
								readTensorNode=true;
							  s= s+1;
							}
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

							if(readLabel){
								nome=reader.getText().toString().trim();
								System.out.println(nome);

								readLabel=false;
							}
			
							if(readColumn){
								
								String l=reader.getText().trim();
								int elemento=Integer.parseInt(l);
								valoriarray.add(elemento);						
								readColumn=false;
								
							}
							if(readRow){
								k++;
								readRow=false;
							}
							break;
			

						case XMLStreamConstants.END_ELEMENT:
							switch(reader.getLocalName())
							{

								case "matrix":
									System.out.println(k);

									valori= new int [k][k];
									int z=k;
									for(int w=0;w<valoriarray.size();w++)
									{ j=0;
									  k=0;
										valori[j][k]=valoriarray.get(w);
										k++;
										if(w==z-1){
											j++;
											k=0;
										}
									}
									mat= new Matrice(valori);
									matrici.add(mat);
									readMatrix=false;
									k=0;
									j=0;
									
									break;
								case "tensor":
									tensore=new Tensore(matrici);
									readTensor=false;
									tensori.add(tensore);
									matrici.clear();
									break;
								case "TensorNode":
									
								if(readTensorNode)
								{
									
									nodoten= new NodoTensore(tensori, nome);
								    tuttiNodi.add(nodoten);
								    //tensori.clear();
								    s=0;
								    readTensorNode=false;
								}
								
							/*	else 
								{
									nodoten=new NodoTensore(tensori,nodiTensori,nome);
									tuttiNodi.add(nodoten);
									s--;
								}*/
							}
							break;
			
						case XMLStreamConstants.END_DOCUMENT:
							System.out.println("end reading");
							break;
					}
		}
		return Albero1=new Albero(tuttiNodi);
		
	}
}	
					
	