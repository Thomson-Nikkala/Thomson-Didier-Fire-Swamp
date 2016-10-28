/***************************************************
 * Question Class                                  *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Question implements Serializable{
    
    // class instance variables
    private String question;
    private double answer;

    public Question() {
    }
    
    

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.question);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.answer) ^ (Double.doubleToLongBits(this.answer) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (Double.doubleToLongBits(this.answer) != Double.doubleToLongBits(other.answer)) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Question{" + "question=" + question + ", answer=" + answer + '}';
    }
    
    
    
}
