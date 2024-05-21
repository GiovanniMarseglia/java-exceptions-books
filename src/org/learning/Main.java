package org.learning;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quanti libri vuoi inserire?");
        int counter =  Integer.parseInt(scanner.nextLine());
        Book[] book = new Book[counter];

        for (int i = 0; i < counter; i++) {

            try {
                System.out.println("Inserimento libro numero " + (i+1));
                System.out.println("Inserisci il nome del libro");
                String bookTitle = scanner.nextLine();
                System.out.println("Inserisci il numero di pagine");
                int bookPage = Integer.parseInt(scanner.nextLine());
                System.out.println("Inserisci il nome dell'autore");
                String bookAuthor = scanner.nextLine();
                System.out.println("Inserisci il nome dell'editore");
                String bookEditor = scanner.nextLine();
                book[i]= new Book(bookTitle,bookPage,bookAuthor,bookEditor);
            } catch (NumberFormatException e) {
                System.out.println("Non stai inserendo un integer");
                i--;
            } catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        File file = new File("./Resources/text.txt");

        try (FileWriter fileWriter = new FileWriter(file)){
            for (int i = 0; i < counter; i++) {
                fileWriter.write("Libro numero: " + (i + 1) + "\n");
                fileWriter.write("Titolo: " + book[i].getTitle() + "\n");
                fileWriter.write("Numero di pagine: " + book[i].getNumberPage() + "\n");
                fileWriter.write("Autore: " + book[i].getAuthor() + "\n");
                fileWriter.write("Editore: " + book[i].getEditor() + "\n");
                fileWriter.write("\n");
            }

        } catch (IOException e){
            System.out.println("Impossibile scrivere nel file");
        }

        Scanner scannerReader = null;
        try {
            scannerReader = new Scanner(file);
            while (scannerReader.hasNextLine()){
                String line = scannerReader.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e){
            System.out.println("Impossibile leggere nel file");
        }finally {
            if (scannerReader!=null){
                scannerReader.close();
            }
        }








        scanner.close();
    }
}
