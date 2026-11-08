package com.habeshas.brandlocationservice.exception;

import java.util.UUID;

public class LocationNotFoundException extends RuntimeException{


    LocationNotFoundException(UUID id)
    {
        super("Restaurant location not found with id" + id);
    }
}

