package ordenadora;

import java.io.*;

public class Ordenadora {

	public static int[] cargarVector(String pathArchivo) {
		int[] vector = null;
		int posicion = 0;
		File archivoEntrada = null;
		FileReader fileReaderEntrada = null;
		BufferedReader bufferedReaderEntrada = null;

		String linea = null;

		try {
			archivoEntrada = new File(pathArchivo);
			fileReaderEntrada = new FileReader(archivoEntrada);
			bufferedReaderEntrada = new BufferedReader(fileReaderEntrada);

			vector = new int[Integer.parseInt(bufferedReaderEntrada.readLine())];

			while (posicion < vector.length && (linea = bufferedReaderEntrada.readLine()) != null) {
				vector[posicion] = Integer.parseInt(linea);
				posicion++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReaderEntrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return vector;
	}

	public static void grabarVector(int[] vector, String pathArchivo) {
		FileWriter fileWriterSalida = null;
		PrintWriter printWriterSalida = null;

		try {
			fileWriterSalida = new FileWriter(new File(pathArchivo));
			printWriterSalida = new PrintWriter(fileWriterSalida);

			for (int i = 0; i < vector.length; i++) {
				printWriterSalida.println(vector[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				printWriterSalida.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void ordenarPorBurbujeo(int[] vector) {
		// Se implementa la Mejora del burbujeo.

	}

	public static void ordenarPorSeleccion(int[] vector) {

	}

	public static void ordenarPorInsercion(int[] vector) {
		// Separar en el gráfico la implementación con y sin centinela.

	}

	public static void ordenarPorInsercionConCentinela(int[] vector) {

	}

	public static void shell(int[] vector) {
		// Shell tendrá gráfico aparte.
		int n = vector.length, i = 0, j, br = 0, h = 0, p, pos, paux, aux; // n=cantidad
																			// de
		// numeros que
		// tiene vector.
		// cargo la serie h(i) = h(i-1)*3 + 1.
		int[] vecSerie = { 1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524 };
		while (vecSerie[i] < n) {
			i++; // quiero saber desde qué H empezar a hacer el método.
		}
		p = i - 1;
		System.out.println("holu");
		// con este for recorro los h para saber cómo dividir al vector.
		for (i = p; i > -1; i--) {
			h = vecSerie[i];
			// este for recorre las posiciones del vector a ordenar de un mismo
			// grupo.
			for (j = 0; j < h; j++) {
				pos = j;
				while (pos < n) {
					br = 0;
					paux = pos;
					aux = vector[paux];
					while (paux - h >= 0 && br == 0) { // acá voy a comparar con
														// los elementos y
														// desplazar en caso de
														// que se pueda.
						if (aux < vector[paux - h]) {
							vector[paux] = vector[paux - h];
							paux = paux - h;
						} else
							br = 1;
						vector[paux] = aux;
					}

					pos += h;
				}

			}
		}

	}

	public static void quickSort(int[] vector) {

	}

	public static void quickSortMejorado(int[] vector) {
		// Con eleccion del pivote entre 3 elementos

	}

	public static void fusion(int[] vector) {

	}

	public static void main(String[] arg) {
		int[] array = cargarVector("myArrayInt.in");
		// ordenarPorBurbujeo(array);
		shell(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		grabarVector(array, "myArrayInt.out");
	}
}
