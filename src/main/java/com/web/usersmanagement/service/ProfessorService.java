package com.web.usersmanagement.service;

import com.web.usersmanagement.model.Professor;
import java.util.List;

public interface ProfessorService {
    public Professor creatProfessor(Professor professor);
    public Professor getProfessorById(Long id);
    public List<Professor> getAllProfessors();
    public Professor updateProfessor(Long id, Professor professor);
    public String deleteProfessor(Long id);

}

