package com.fujitsu.fs.javalab.poll.model;

import java.io.Serializable;

public abstract class AbstractModel implements Serializable {

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
