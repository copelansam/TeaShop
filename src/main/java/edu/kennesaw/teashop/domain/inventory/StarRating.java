package edu.kennesaw.teashop.domain.inventory;

public class StarRating {

    private int rating;

    public StarRating(int rating){

        setRating(rating);
    }

    public void setRating(int rating) {
        // Rating must be between 1 and 5, throw an exception if anything else is input
        if (rating <= 0 || rating >5){
            throw new IllegalArgumentException("Ratings must be between 1 and 5!");
        }
        else {
            this.rating = rating;
        }
    }

    public int getRating(){
        return this.rating;
    }

    @Override
    public String toString(){
        return rating + " star(s)";
    }

}
