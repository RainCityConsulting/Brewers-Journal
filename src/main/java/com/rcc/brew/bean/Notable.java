package com.rcc.brew.bean;

import java.util.List;

public interface Notable {
    public void addNote(Note note);
    public List<Note> getNotes();
    public boolean deleteNote(int id);
}
