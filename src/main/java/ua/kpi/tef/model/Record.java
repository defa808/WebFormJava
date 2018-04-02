package main.java.ua.kpi.tef.model;

import main.java.ua.kpi.tef.exceptions.DataBaseException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class Record {

    public static ArrayList<Record> bookNotes = new ArrayList<Record>();

    private Subscriber author;
    private Date dateCreation;
    private Date dateEditing;


    public Record(Subscriber author) {
        this.author = author;
        this.dateCreation = new Date();
        this.dateEditing = new Date();
    }

    public Subscriber getAuthor() {
        return author;
    }

    public void setAuthor(Subscriber author) {
        this.author = author;
        this.dateEditing = new Date();
    }

    public static boolean tryAddRecord(Record record) {
        try {
            Record.addRecord(record);
            return true;
        } catch (NullPointerException e) {
            System.out.println(e);
            return false;

        } catch (DataBaseException e) {
            System.out.println(e);
            return false;

        }
    }


    private static void addRecord(Record item)throws DataBaseException{

        if(item == null){
            throw new NullPointerException("Null pointer Exception");
        }

        for(Record r : bookNotes){
            if(item.getAuthor().getNickName().equals(r.getAuthor().getNickName())){
                throw new DataBaseException("This nickname has already taken");
            }
        }

        bookNotes.add(item);
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEditing() {
        return dateEditing;
    }

    public void setDateEditing(Date dateEditing) {
        this.dateEditing = dateEditing;
    }


    @Override
    public String toString() {
        return "Record{" +
                "author=" + author +
                ", dateCreation=" + dateCreation +
                ", dateEditing=" + dateEditing +
                '}';
    }
}
