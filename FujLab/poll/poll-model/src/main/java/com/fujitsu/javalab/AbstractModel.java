package com.fujitsu.javalab;


import java.io.Serializable;

public abstract class AbstractModel implements Serializable{

    public abstract int hashCode();

    public abstract String toString();

    public abstract boolean equals(Object obj);
}
