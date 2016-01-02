package com.fujitsu.javalab;

/**
 * Represents the polls.
 */
public class Poll extends AbstractModel{

    private Long id;

    private String tittle;

    private String description;

    public Poll() {
    }

    public Poll(Long id, String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "tittle='" + tittle + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poll poll = (Poll) o;

        if (id != null ? !id.equals(poll.id) : poll.id != null) return false;
        if (tittle != null ? !tittle.equals(poll.tittle) : poll.tittle != null) return false;
        return !(description != null ? !description.equals(poll.description) : poll.description != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
