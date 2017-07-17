package Esame;

import java.util.ArrayList;

public class NodoTensore {
	private ArrayList<Tensore>tensori;
	private ArrayList<NodoTensore>nodi;
	private String nome;
	public NodoTensore(ArrayList<Tensore>tensori,ArrayList<NodoTensore>nodi,String nome)
	{
		this.tensori=tensori;
		this.nodi=nodi;
		this.setNome(nome);
	}
	public NodoTensore(ArrayList<Tensore>tensori,String nome)
	{
		this.tensori=tensori;
		nodi=new ArrayList<NodoTensore>();
		this.setNome(nome);
	}
	
	public int calcTensorUnit(){
		if(nodi.size()==0)
		{
			int max=Math.max(tensori.get(0). calcSommaDetLaplace(), tensori.get(1).calcSommaDetLaplace());
			for(int i =2;i<tensori.size();i++)
			{
				max=Math.max(max,tensori.get(i).calcSommaDetLaplace() );
			}
			return max;
		}
		else
		{
			int max1=Math.max(nodi.get(0).calcTensorUnit(), nodi.get(1).calcTensorUnit());
			for(int i=2;i<nodi.size();i++)
			{
					max1=Math.max(max1,nodi.get(i).calcTensorUnit() );
			}
			int max2=Math.max(tensori.get(0).calcSommaDetLaplace(), tensori.get(1).calcSommaDetLaplace());
			for(int i =2;i<tensori.size();i++)
			{
				max2=Math.max(max2,tensori.get(i).calcSommaDetLaplace() );
			}
			return Math.max(max1, max2);
			
		}
		
		
	}
	public ArrayList<Tensore> getTensori() {
		return tensori;
	}
	public void setTensori(ArrayList<Tensore> tensori) {
		this.tensori = tensori;
	}
	public ArrayList<NodoTensore> getNodi() {
		return nodi;
	}
	public void setNodi(ArrayList<NodoTensore> nodi) {
		this.nodi = nodi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
