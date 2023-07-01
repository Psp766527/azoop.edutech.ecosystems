package com.pradeep.emp.demo.application.exception;


public class InvalidArgumentException extends RuntimeException {

    /**
     * If invalid value is entered in the field in request body payload then this Constructor will throw the error.
     *
     * @param field the error message.
     */
    public InvalidArgumentException(String field) {
        //passed field , null to throwable to not stack trace.
        super(field, null, true, false);

    }
}
