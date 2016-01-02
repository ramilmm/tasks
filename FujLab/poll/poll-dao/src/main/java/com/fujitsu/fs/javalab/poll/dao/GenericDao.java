package com.fujitsu.fs.javalab.poll.dao;

import com.fujitsu.fs.javalab.poll.model.AbstractModel;

import java.util.List;

public interface GenericDao<T extends AbstractModel> {

    /**
     * Returns the specified object.
     *
     * @param id the identifier (primary key) of the object to get
     * @return the object or {@code null} if nothing found
     */
    T get(long id);

    /**
     * Returns all the objects.
     *
     * @return list contains all the objects, may be empty
     */
    List<T> getAll();

    /**
     * Updates the specified object
     * @param poll the object which is to update
     */
    T update(T poll);

    /**
     * Addes a new specified object in the  table
     * @param poll the object to add
     * @return id of the added poll
     */
    long add(T poll);

    /**
     * Removes the specified object from the table
     * @param id the identifier (primary key) of the object to remove
     * @return true in case poll was removed
     */
    boolean remove(long id);

    /**
     * Counts objects (Polls or Poll Choices)
     * @return long variable containing the rows(polls) in the table
     */
    long getCount();

}
