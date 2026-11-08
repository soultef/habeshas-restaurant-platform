package com.habeshas.brandlocationservice.exception;

import java.util.UUID;

public class LocationAlreadyExistException extends RuntimeException{

    LocationAlreadyExistException(UUID id)
    {
        super("Restaurant location already exist with id" + id);
    }
}
