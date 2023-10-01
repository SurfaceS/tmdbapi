/*
 * Copyright (C) 2023 Universal Media Server
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.ums.tmdbapi.endpoint.account.movie;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import net.ums.tmdbapi.schema.movie.MovieTypedResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Account movies endpoint (V4).
 *
 * @author SurfaceS
 */
public class AccountMovieV4Endpoint extends Endpoint {

	private static final String V4_ACCOUNT_ENDPOINT = V4_ENDPOINT + "account/";
	private static final String V4_ACCOUNT_MOVIE_ENDPOINT = "/movie/";
	private static final String MOVIE_FAVORITES_ENDPOINT = V4_ACCOUNT_MOVIE_ENDPOINT + "favorites";
	private static final String MOVIE_RECOMMENDATIONS_ENDPOINT = V4_ACCOUNT_MOVIE_ENDPOINT + "recommendations";
	private static final String MOVIE_WATCHLIST_ENDPOINT = V4_ACCOUNT_MOVIE_ENDPOINT + "watchlist";
	private static final String MOVIE_RATED_ENDPOINT = V4_ACCOUNT_MOVIE_ENDPOINT + "rated";

	private final String accountId;
	private String sortBy;
	private int page;

	public AccountMovieV4Endpoint(TMDbClient tmdbClient, String accountId) {
		super(tmdbClient);
		this.accountId = accountId;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public AccountMovieV4Endpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Set sort option for the list of tv shows.
	 *
	 * @param value sort option
	 * @return this endpoint
	 */
	public AccountMovieV4Endpoint sortBy(MovieSortBy value) {
		this.sortBy = value != null ? value.toString() : null;
		return this;
	}

	/**
	 * Get the list of movies you have marked as a favorite.
	 *
	 * @return Favorite movies.
	 */
	public MovieShortResultsSchema getFavorites() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + MOVIE_FAVORITES_ENDPOINT, MovieShortResultsSchema.class, query);
	}

	/**
	 * Get a list of your personal movie recommendations.
	 *
	 * @return Movie Recommendations.
	 */
	public MovieTypedResultsSchema getRecommendations() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + MOVIE_RECOMMENDATIONS_ENDPOINT, MovieTypedResultsSchema.class, query);
	}

	/**
	 * Get the list of movies you have added to your watchlist.
	 *
	 * @return Movie Watchlist.
	 */
	public MovieShortResultsSchema getWatchlist() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + MOVIE_WATCHLIST_ENDPOINT, MovieShortResultsSchema.class, query);
	}

	/**
	 * Get the list of movies you have rated.
	 *
	 * @return Rated Movies.
	 */
	public MovieShortResultsSchema getRated() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + MOVIE_RATED_ENDPOINT, MovieShortResultsSchema.class, query);
	}

}
