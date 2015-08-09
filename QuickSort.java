/**
 * QuickSort
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

public class QuickSort {
    private File archivo = null;
    private FileReader lector = null;
    private BufferedReader buffer = null;
    private ArrayList<String> palabras = new ArrayList<String>();
    private String[] palabrasArray = new String[palabras.size()];
    private String tempString;
    
    public QuickSort(String rutaArchivo) {
        try {
            archivo = new File(rutaArchivo);
            lector = new FileReader(archivo);
            buffer = new BufferedReader(lector);
        } catch (Exception ex) {
            System.err.println("Error: "+ex);
        }
    }

    public void sorting(String array[], int start, int end) {
        int i = start;
        int k = end;
        if (end - start >= 1) {
            String pivot = array[start];
            while (k > i) {
                while (array[i].compareTo(pivot) <= 0 && i <= end && k > i)
                    i++;
                while (array[k].compareTo(pivot) > 0 && k >= start && k >= i)
                    k--;
                if (k > i)
                    swap(array, i, k);
            }
            swap(array, start, k);
            sorting(array, start, k - 1);
            sorting(array, k + 1, end);
        } else { return; }
    }
    public void swap(String array[], int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
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
            String []palabrasArray = new String[palabras.size()];
            palabras.toArray(palabrasArray);
            sorting(palabrasArray, 0, palabrasArray.length - 1);
            String outFile = "QSoutput3.txt";
            File file = new File(outFile);
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            for(int j = 0; j < palabrasArray.length - 1; j++){
                bw.write(palabrasArray[j] + "\n");
            }
            bw.close();
            System.out.println("QSF: Quick Sorting Finish");
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
    }
    
    public static void main(String []args) {
        QuickSort archivo = new QuickSort("3.txt");
        archivo.leerDatos();
    }
}