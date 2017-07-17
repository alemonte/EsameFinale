package Esame;

import java.util.ArrayList;

public class Albero {
	private ArrayList<NodoTensore>albero;
	
	public Albero(ArrayList<NodoTensore>tuttiNodi){
		
		setAlbero(tuttiNodi);
		
	}
	/**
	 * calcola l'unita tensore per la radice(dando per scontato che la radice sia il primo nodo letto)
	 * @return
	 */
	public int calcTensorUnitRadice()
	{
		NodoTensore radice=albero.get(0);

		if(radice.getNodi().size()==0)
		{
			if(radice.getTensori().size()==1)return radice.getTensori().get(0).calcSommaDetLaplace();//se la radice ha un solo tensore , il minimo sarà il suo determinante totale
			
			int min=Math.min(radice.getTensori().get(0). calcSommaDetLaplace(), radice.getTensori().get(1).calcSommaDetLaplace());
			for(int i =2;i<radice.getTensori().size();i++)
			{
				min=Math.min(min,radice.getTensori().get(i).calcSommaDetLaplace() );
			}
			return min;
		}
		else
		{
			int max1=Math.max(radice.getNodi().get(0).calcTensorUnit(), radice.getNodi().get(1).calcTensorUnit());
			for(int i=2;i<radice.getNodi().size();i++)
			{
					max1=Math.min(max1,radice.getNodi().get(i).calcTensorUnit() );
			}
			int min2=Math.max(radice.getTensori().get(0).calcSommaDetLaplace(), radice.getTensori().get(1).calcSommaDetLaplace());
			for(int i =2;i<radice.getTensori().size();i++)
			{
				min2=Math.min(min2,radice.getTensori().get(i).calcSommaDetLaplace() );
			}
			return Math.min(max1, min2);
			
		}
	}
	public ArrayList<NodoTensore> getAlbero() {
		return albero;
	}
	public void setAlbero(ArrayList<NodoTensore> albero) {
		this.albero = albero;
	}

}
