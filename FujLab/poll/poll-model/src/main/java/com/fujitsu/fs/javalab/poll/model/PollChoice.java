package com.fujitsu.fs.javalab.poll.model;

/**
 * Represents the choice of the Poll.
 *
 * @see Poll
 */
public class PollChoice extends AbstractModel {

    private Long id;

    private String choiceText;

    private int votes;

    /**
     * Reference to the parent poll. Refers {@link Poll}.
     *
     * Not null.
     */
    private Long pollId;

    public PollChoice() {
    }

    public PollChoice(Long id, String choiceText, int votes, Long pollId) {
        this.id = id;
        this.choiceText = choiceText;
        this.votes = votes;
        this.pollId = pollId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    @Override
    public String toString() {
        return "PollChoice{" +
                "id=" + id +
                ", choiceText='" + choiceText + '\'' +
                ", votes=" + votes +
                ", pollId=" + pollId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PollChoice that = (PollChoice) o;

        if (choiceText != null ? !choiceText.equals(that.choiceText) : that.choiceText != null) return false;
        return !(pollId != null ? !pollId.equals(that.pollId) : that.pollId != null);

    }

    @Override
    public int hashCode() {
        int result = choiceText != null ? choiceText.hashCode() : 0;
        result = 31 * result + (pollId != null ? pollId.hashCode() : 0);
        return result;
    }

}
