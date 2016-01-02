package com.fujitsu.fs.javalab.poll.dao;

import com.fujitsu.fs.javalab.poll.model.Poll;
import com.fujitsu.fs.javalab.poll.model.PollChoice;

public interface PollChoiceDao extends GenericDao<PollChoice> {
    /**
     *
     * @param id  the identifier (primary key) of the object
     * @return Poll of the object Poll Choice
     */
    public Poll getPoll(long id);
}
