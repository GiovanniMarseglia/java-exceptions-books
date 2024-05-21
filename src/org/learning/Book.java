package org.learning;

public class Book {
    private String title;
    private int numberPage;
    private String author;
    private String editor;

    public Book(String title,int numberPage,String author,String editor) throws IllegalArgumentException{
        validateString(title);
        validateString(author);
        validateString(editor);
        validateInt(numberPage);
        this.title=title;
        this.numberPage=numberPage;
        this.author=author;
        this.editor=editor;

    }



    public void validateString(String value){
        if(value.isEmpty()){
            throw new IllegalArgumentException("I campi sono obbligatori");
        }
    }

    public void validateInt(int value) throws IllegalAccessError {
        if(value <= 0){
            throw new IllegalArgumentException ("Il valore delle pagine deve essere maggiore di 0");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
