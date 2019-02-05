package projectMovie.model;

public class MovieData {
	
	public MovieData() {
		super();
		
	}
	
	private int id;
	private String name;
	private String year;
	private String director;
	private String description;
	private String cover_img;
	private String gallery_img;
	private String trailer;
	private int current_rate;
	private int num_of_rate;
	private String genre1;
	private String genre2;
	
	private int movieId;
	private int userId;
	private String comment;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCover_img() {
		return cover_img;
	}
	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}
	public String getGallery_img() {
		return gallery_img;
	}
	public void setGallery_img(String gallery_img) {
		this.gallery_img = gallery_img;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public int getCurrent_rate() {
		return current_rate;
	}
	public void setCurrent_rate( int current_rate) {
		this.current_rate = current_rate;
	}
	public int getNum_of_rate() {
		return num_of_rate;
	}
	public void setNum_of_rate( int no_of_rate) {
		this.num_of_rate = no_of_rate;
	}
	public String getGenre1() {
		return genre1;
	}
	public void setGenre1(String genre1) {
		this.genre1 = genre1;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "MovieData [id=" + id + ", name=" + name + ", year=" + year + ", director=" + director + ", description="
				+ description + ", cover_img=" + cover_img + ", gallery_img=" + gallery_img + ", trailer=" + trailer
				+ ", current_rate=" + current_rate + ", num_of_rate=" + num_of_rate + ", genre1=" + genre1 + ", genre2="
				+ genre2 + ", movieId=" + movieId + ", userId=" + userId + ", comment=" + comment + "]";
	}
}
