package com.example.notes.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notes.models.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    long[] insertNotes(Note... notes);
    /** Note... -> Note[]
     *  If insert rows 2, 3, 4 then it will return those numbers.
     *  If some reason insertion fails it will return -1
     *  void also acceptable for return value
     */

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Query("SELECT * FROM notes WHERE id = :id")
    List<Note> getNotesWithCustomQuery(int id);

    @Query("SELECT * FROM notes WHERE  title LIKE :title")
    List<Note> getNotesWithTitle(String title);

    @Delete
    int delete(Note... notes);

    @Update
    int update(Note... notes); // it will return how many rows have been effected

}
