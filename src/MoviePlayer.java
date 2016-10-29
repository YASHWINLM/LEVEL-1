
public class MoviePlayer {
	public static void main(String[] args) {
		Movie movie1=new Movie("movie  ", 360);
		Movie movie2=new Movie("m2 ", 720);
		Movie movie3=new Movie("m3 last stand ", 180);
		Movie movie4=new Movie("movie first class ", 840);
		Movie movie5=new Movie("movie days of future past ", 10);
		Movie movie6=new Movie("movie apocalypse ", 8);
		NetflixQueue q=new NetflixQueue();
		q.addMovie(movie1);
		q.addMovie(movie2);
		q.addMovie(movie3);
		q.addMovie(movie4);
		q.addMovie(movie5);
		q.addMovie(movie6);
		q.printMovies();
		q.sortMoviesByRating();
		System.out.println("The best movie is, "+q.getBestMovie());
		
		
		String s=movie4.getTicketPrice();
		System.out.println(s);
	}
}
