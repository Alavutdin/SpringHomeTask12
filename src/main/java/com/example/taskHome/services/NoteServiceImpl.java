package com.example.taskHome.services;

import org.springframework.stereotype.Service;
import com.example.taskHome.model.Note;
import com.example.taskHome.repositories.NoteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    /**
     * Интерфейс взаимодействия с базой данных
     */
    private final NoteRepository noteRepository;

    /**
     * Получение всех заметок через базу данных
     * @return список заметок
     */
    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Получение заметки по идентификатору в базе данных
     * @param id уникальный идентификатор
     * @return заметка
     */
    @Override
    public Note getById(long id) {
        return noteRepository.findById(id).orElse(null);
    }

    /**
     * Создание заметки в базе данных
     * @param note заметка из запроса
     * @return новая заметка
     */
    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Обновление заметки в базе данных
     * @param note заметка из запроса
     * @return обновленная заметка
     */
    @Override
    public Optional<Note> editNote(Long id, Note note) {
        Optional<Note> existingNote = noteRepository.findById(id);
        if (existingNote.isPresent()) {
            note.setId(id);
            return Optional.of(noteRepository.save(note));
        } else {
            return Optional.empty();
        }
    }
    /**
     * Удаление заметки из базы данных
     * @param id уникальный идентификатор заметки
     */
    @Override
    public void delete(long id) {
        noteRepository.deleteById(id);
    }
}
