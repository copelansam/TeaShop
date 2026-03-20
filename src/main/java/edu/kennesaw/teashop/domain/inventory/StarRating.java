package edu.kennesaw.teashop.domain.inventory;

public class StarRating {

    private int rating;

    public StarRating(int rating){

        setRating(rating);
    }

    public void setRating(int rating) {
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

    public String getRatingAsStars(){
        StringBuilder ratingAsStars = new StringBuilder();
        for (int i = 0; i < getRating(); i++){
            ratingAsStars.append("*");
        }
        return  ratingAsStars.toString();
    }

}
