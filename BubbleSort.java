/**
 * BubbleSort
 * 
 * @author Josue Bustamante and Santiago Baena
 * @version 08/August/2015
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class BubbleSort {
	private File archivo = null;
	private FileReader lector = null;
	private BufferedReader buffer = null;
	private ArrayList<String> palabras = new ArrayList<String>();
	private String tempString;
	
	public BubbleSort(String rutaArchivo) {
		try {
			archivo = new File(rutaArchivo);
			lector = new FileReader(archivo);
			buffer = new BufferedReader(lector);
		} catch (Exception ex) {
			System.err.println("Error: "+ex);
		}
	}

	public void leerDatos() {
		String linea = null;
		try{
			while(true){
				linea = buffer.readLine();
				if(linea == null)
					break;
				palabras.add(linea);
			}
			int lenPalabras = palabras.size();
            System.out.println("Palabras: " + lenPalabras);
            for (int t = 0; t < lenPalabras; t++) {
                for (int i = 0; i < lenPalabras - t -1; i++) {
                    if(palabras.get(i+1).compareTo(palabras.get(i)) < 0) {
                        tempString = palabras.get(i);
                        palabras.set(i, palabras.get(i+1));
                        palabras.set(i+1, tempString);
                    }
                }
            }
            String outFile = "BSoutput1.txt";
            File file = new File(outFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            for(int j = 0; j < lenPalabras; j++){
                bw.write(palabras.get(j) + "\n");
            }
            bw.close();
            System.out.println("BSF: Bubble Sorting Finish");
		}catch(Exception ex){
			System.err.println("Error: "+ex);
		}
	}
	
	public static void main(String []args) {
        BubbleSort archivo = new BubbleSort("1.txt");
        archivo.leerDatos();
    }
}