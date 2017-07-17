package Esame;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

public class EsameMain 
{
	public static String filename="input_0.xml";
	static Albero albero1;
	
	public static void main(String args[]) throws NumberFormatException, FileNotFoundException, XMLStreamException
	{
		
		albero1=LetturaeScrittura.lettura(filename);
		int unitRadice=albero1.calcTensorUnitRadice();
		System.out.println("il tensor unit del nodo radice è :"+unitRadice);
		for(int i =0;i<albero1.getAlbero().size();i++)
		{
			System.out.println("il tensor unit del nodo tensore"+albero1.getAlbero().get(i).getNome()+" è: "+albero1.getAlbero().get(i).calcTensorUnit());
		}
		
	}

}
