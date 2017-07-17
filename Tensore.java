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
	/**
	 * calcola la somma dei determinanti delle matrici facenti parte di un tensore
	 * @return somma
	 */
	public int calcSommaDetLaplace()
	{
		int somma=0;
		for(int i =0;i<matrici.size();i++)//scorro tutte le matrici del tensore
		{
			somma += Matrice.calcDetLaplace(matrici.get(i).getMat(), matrici.get(i).getDim());
		}
		return somma;
	}
}
