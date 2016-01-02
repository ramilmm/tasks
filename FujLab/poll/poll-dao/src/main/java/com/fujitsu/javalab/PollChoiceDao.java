package main.java.com.fujitsu.javalab;

import com.fujitsu.javalab.Poll;
import com.fujitsu.javalab.PollChoice;

import java.util.List;


public interface PollChoiceDao {

    PollChoice get(long id);

    List<PollChoice> getAll();

    Poll update(Poll poll);

    long add(Poll poll);

    boolean remove(long id);

    long getCount();
}
