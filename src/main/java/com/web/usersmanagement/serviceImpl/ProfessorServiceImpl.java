package com.web.usersmanagement.serviceImpl;

import com.web.usersmanagement.exception.UserNotFoundException;
import com.web.usersmanagement.model.Professor;
import com.web.usersmanagement.repository.ProfessorRepository;
import com.web.usersmanagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor creatProfessor(Professor professor){
        Professor newProfessor = new Professor();
        newProfessor.setFirstname(professor.getFirstname());
        newProfessor.setSurname(professor.getSurname());
        newProfessor.setEmail(professor.getEmail());
        newProfessor.setTypeSubject(professor.getTypeSubject());
        newProfessor.setTypeClient(professor.getTypeClient());
        newProfessor.setAddress(professor.getAddress());
        newProfessor.setVille(professor.getVille());
        return professorRepository.save(newProfessor);
    }

    @Override
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
    @Override
    public Professor updateProfessor(Long id, Professor newProfessor) {

        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setFirstname(newProfessor.getFirstname());
                    professor.setSurname(newProfessor.getSurname());
                    professor.setTypeSubject(newProfessor.getTypeSubject());
                    professor.setTypeClient(newProfessor.getTypeClient());
                    professor.setEmail(newProfessor.getEmail());
                    professor.setAddress(newProfessor.getAddress());
                    professor.setVille(newProfessor.getVille());
                    return professorRepository.save(professor);
                }).orElseThrow(() ->new UserNotFoundException(id));
    }
    @Override
    public String deleteProfessor(Long id) {
        if(!professorRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        professorRepository.deleteById(id);
        return "Informations sur le Professeur avec id: "+id+"a supprimé avec succès.";
    }

}
