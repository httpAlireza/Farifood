package ir.ac.kntu.comment;

import ir.ac.kntu.customer.Customer;

public class Comment {
    private Customer customer;

    private String comment;

    private int score = 5;

    public Comment(int score, String comment, Customer customer) {
        this.comment = comment;
        this.customer = customer;
        if (1 <= score && score <= 5) {
            this.score = score;
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(int score) {
        if(1 <= score && score <= 5) {
            this.score = score;
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return customer.getUserName() + ":\n(" + score + "/5)" + "\n" + comment;
    }
}