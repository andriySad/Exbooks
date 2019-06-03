package exbooks.api.repositories;

import exbooks.api.entities.User;

public interface UserRepository {

    User insert(User user) throws ClassNotFoundException, Exception;

}