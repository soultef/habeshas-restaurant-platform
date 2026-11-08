package com.habeshas.brandlocationservice.exception;

import java.util.UUID;

public class BrandNotFoundException extends RuntimeException{

    BrandNotFoundException(UUID id)
    {
        super("Restaurant brand not found with id " + id);
    }
}
