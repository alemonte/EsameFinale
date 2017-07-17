package Esame;

import java.util.ArrayList;

public class Tensore {

	private ArrayList <Matrice>matrici;
	
	public ArrayList<Matrice> getMatrici() {
		return matrici;
	}
	public void setMatrici(ArrayList<Matrice> matrici) {
		this.matrici = matrici;
	}
	public Tensore(ArrayList<Matrice>matrici){
		this.matrici=matrici;
	}
	public int calcSommaDetLaplace()
	{
		int somma=0;
		for(int i =0;i<matrici.size();i++)
		{
			somma += Matrice.calcDetLaplace(matrici.get(i).getMat(), matrici.get(i).getDim());
		}
		return somma;
	}
}
