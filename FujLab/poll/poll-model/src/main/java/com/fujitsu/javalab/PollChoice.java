package com.fujitsu.javalab;

/**
 * Represents he choice of the poll.
 */
public class PollChoice extends AbstractModel{

    private Long id;

    private String choiceText;

    private int votes;

    private Long poll_id;

    public PollChoice() {
    }

    public PollChoice(Long id, String choiceText, int votes, Long poll_id) {
        this.id = id;
        this.choiceText = choiceText;
        this.votes = votes;
        this.poll_id = poll_id;
    }

    public Long getId() {
        return id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public int getVotes() {
        return votes;
    }

    public Long getPoll_id() {
        return poll_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setPoll_id(Long poll_id) {
        this.poll_id = poll_id;
    }

    @Override
    public String toString() {
        return "PollChoice{" +
                "id=" + id +
                ", choiceText='" + choiceText + '\'' +
                ", votes=" + votes +
                ", poll_id=" + poll_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollChoice that = (PollChoice) o;

        if (choiceText != null ? !choiceText.equals(that.choiceText) : that.choiceText != null) return false;
        return !(poll_id != null ? !poll_id.equals(that.poll_id) : that.poll_id != null);

    }

    @Override
    public int hashCode() {
        int result = choiceText != null ? choiceText.hashCode() : 0;
        result = 31 * result + (poll_id != null ? poll_id.hashCode() : 0);
        return result;
    }
}
