package Esame;

public class Matrice {
	private int [][] mat;
	private int dim;
	
	public Matrice(int [][]valori){
		setMat(valori);
		setDim(valori.length);
	}
	public static int calcDetLaplace(int mat[][], int dim) 
		{
			int det = 0;
			if(dim == 1)
			det = mat[0][0];
			else if(dim == 2)
			{
			det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
			} 
			else
			{
				int mat1[][] = new int[dim - 1][dim - 1];
				for(int k = 0; k < dim; k++)
				{
					for(int i1 = 1; i1 < dim; i1++)
					{
						int j = 0;
						
						for(int j1 = 0; j1 < dim; j1++)
						if(j1 != k)
						{
							mat1[i1 - 1][j] = mat[i1][j1];
							j++;
						}
				
					}		
			
					if(k % 2 == 0)
					det += (int)mat[0][k] * calcDetLaplace(mat1, dim - 1);
					else
					det -= (int)mat[0][k] * calcDetLaplace(mat1, dim - 1);
				}
	
			}
			return det;
			}
	public int getDim() {
		return dim;
	}
	public void setDim(int dim) {
		this.dim = dim;
	}
	public int [][] getMat() {
		return mat;
	}
	public void setMat(int [][] mat) {
		this.mat = mat;
	}
		}