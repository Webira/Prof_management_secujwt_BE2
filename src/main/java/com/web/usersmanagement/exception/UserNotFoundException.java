package com.web.usersmanagement.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Impossible de trouver un utilisateur avec un identifiant"+ id);
    }
}
