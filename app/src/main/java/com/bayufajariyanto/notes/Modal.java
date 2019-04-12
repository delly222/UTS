package com.bayufajariyanto.notes;

public class Modal {
//    private int id;
    private String id,text;

    public Modal(String id, String text){
        this.id=id;
        this.text=text;
    }
    public Modal(){

    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    public void setText(String text){
        this.text=text;
    }
    public String getText(){
        return this.text;
    }
}
