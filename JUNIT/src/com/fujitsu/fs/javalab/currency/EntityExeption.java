package com.fujitsu.fs.javalab.currency;


public class EntityExeption extends Exception {
    public EntityExeption(String message) {
        super(message);
    }
    public EntityExeption(String message, Throwable cause) {
        super(message, cause);
    }
    public EntityExeption(Throwable cause) {
        super( cause);
    }
}
