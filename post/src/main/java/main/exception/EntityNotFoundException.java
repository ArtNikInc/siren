package main.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entityClass, String searchValue) {
        super("Couldn't find " + entityClass.getName() + " by " + searchValue);
    }

    public EntityNotFoundException(Class entityClass, UUID searchValue) {
        this(entityClass, searchValue.toString());
    }
}
