package ordenadora;

import java.io.*;
import java.util.Random;

public class GeneradorVector {
	private int[] vector;
	private int tamaño;

	public GeneradorVector(int tam, int tipo) {
		// tipo es: 1:ordenado; -1:desordenado; 0: aleatorio.
		vector = new int[tam];
		this.tamaño = tam;
		Random rnd = new Random();

		/*
		 * switch (tipo) { case 1: int valor = rnd.nextInt(99); for (int i = 0;
		 * i < this.tamaño; i++) { vector[i] = valor; valor = valor +
		 * rnd.nextInt(99); } break; case -1: int valor1 = rnd.nextInt(99); for
		 * (int i = this.tamaño - 1; i >= 0; i--) { vector[i] = valor1; valor1 =
		 * valor1 + rnd.nextInt(99); } break; case 0: for (int i = 0; i <
		 * this.tamaño; i++) { vector[i] = rnd.nextInt(99); } break;
		 * 
		 * default: break; }
		 */
		if (tipo == 1) { // esto es para un vector Ordenado.

			int valor = rnd.nextInt(99);
			for (int i = 0; i < this.tamaño; i++) {
				vector[i] = valor;
				valor = valor + rnd.nextInt(99);
			}
		}
		if (tipo == -1) { // esto es para vector Desordenado.
			int valor = rnd.nextInt(99);
			for (int i = this.tamaño - 1; i >= 0; i--) {
				vector[i] = valor;
				valor = valor + rnd.nextInt(99);
			}
		}
		if (tipo == 0) { //esto es para vector Aleatorio.
			for (int i = 0; i < this.tamaño; i++) {
				vector[i] = rnd.nextInt(99);
			}
		}

	}

	public void grabarVector(String salida) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(salida);
			pw = new PrintWriter(fw);
			pw.println(this.tamaño);
			for (int i = 0; i < this.tamaño; i++) {
				pw.println(this.vector[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
