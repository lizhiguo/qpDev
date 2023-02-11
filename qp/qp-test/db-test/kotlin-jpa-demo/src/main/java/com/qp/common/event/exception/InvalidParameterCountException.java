package com.qp.common.event.exception;

/**
 * Exception for when a method has in incorrect number of parameters defined.
 *
 * @author Tyler Eastman
 */
public class InvalidParameterCountException extends Exception {

    private static final long serialVersionUID = 3220358137554570705L;

    public InvalidParameterCountException() {
    }

    public InvalidParameterCountException(String message) {
        super(message);
    }
}
