package com.fujitsu.fs.javalab.poll.model;

/**
 * Represents the Poll.
 *
 * @see PollChoice
 */
public class Poll extends AbstractModel {

    private Long id;

    private String title;

    private String description;

    public Poll() {
    }

    public Poll(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Poll poll = (Poll) o;

        return !(title != null ? !title.equals(poll.title) : poll.title != null);

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
