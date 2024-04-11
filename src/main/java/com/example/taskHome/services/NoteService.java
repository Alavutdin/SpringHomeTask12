package com.example.taskHome.services;

import com.example.taskHome.model.Note;

import java.util.List;
import java.util.Optional;

/**
 * Для улучшения архитектуры и расширяемости кода, применен паттерн проектирования
 * **Service Layer** (Сервисный слой). этот шаблон проектирования разделяет бизнес-логику
 * и операции с данными от контроллера, что сделает код более чистым и модульным.
 * Созданы интерфейс NoteService и класс NoteServiceImpl
 */

public interface NoteService {
    List<Note> getAllNotes();
    Note getById(long id);
    Note create(Note note);
    Optional<Note> editNote(Long id, Note note);
    void delete(long id);
}
