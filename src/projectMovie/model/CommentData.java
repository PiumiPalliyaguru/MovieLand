package projectMovie.model;

public class CommentData {
	
	private int movieId;
	private String userName;
	private String comment;
	private int rate;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CommentData [movieId=" + movieId + ", userName=" + userName + ", comment=" + comment + ", rate=" + rate
				+ "]";
	}
	
	
}
