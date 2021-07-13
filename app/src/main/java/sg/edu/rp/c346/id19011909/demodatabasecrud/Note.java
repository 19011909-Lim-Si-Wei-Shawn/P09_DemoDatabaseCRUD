package sg.edu.rp.c346.id19011909.demodatabasecrud;

import java.io.Serializable;

public class Note implements Serializable {

    private int ID;
    private String noteContent;

    public Note(int ID, String noteContent) {
        this.ID = ID;
        this.noteContent = noteContent;
    }

    public int getID() {    return ID;      }

    public String getNoteContent() {    return noteContent;     }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    @Override
    public String toString() {  return "ID:" + ID + ", " + noteContent;     }

}