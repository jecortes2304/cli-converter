package com.cortestudios.cliconverter.exception;

import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionHandler {

    @ExceptionResolver({ RuntimeException.class })
    public CommandHandlingResult resolve(Exception exception) {

        // Return a friendly error message
        return CommandHandlingResult.of(
                "An error occurred: " + exception.getMessage()
        );
    }
}
