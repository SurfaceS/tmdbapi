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
package net.ums.tmdbapi.endpoint.movie;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.change.ChangesIdsSchema;
import net.ums.tmdbapi.schema.movie.MovieSchema;
import net.ums.tmdbapi.schema.movie.MovieShortDatedResultsSchema;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Tv Endpoint. Get the TV show Endpoint.
 *
 * @author SurfaceS
 */
public class MovieEndpoint extends Endpoint {

	private static final String V3_MOVIE_ENDPOINT = V3_ENDPOINT + "movie/";
	private static final String CHANGES_ENDPOINT = V3_MOVIE_ENDPOINT + "changes";
	private static final String LATEST_ENDPOINT = V3_MOVIE_ENDPOINT + "latest";
	private static final String NOW_PLAYING_ENDPOINT = V3_MOVIE_ENDPOINT + "now_playing";
	private static final String POPULAR_ENDPOINT = V3_MOVIE_ENDPOINT + "popular";
	private static final String TOP_RATED_ENDPOINT = V3_MOVIE_ENDPOINT + "top_rated";
	private static final String UPCOMING_ENDPOINT = V3_MOVIE_ENDPOINT + "upcoming";

	private String endDate;
	private String language;
	private int page;
	private String region;
	private String startDate;

	public MovieEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this endpoint
	 */
	public MovieEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public MovieEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Specify which region to query. ISO 3166-1 code to filter release dates.
	 * Must be uppercase. pattern: ^[A-Z]{2}$
	 *
	 * @param value query region
	 * @return this endpoint
	 */
	public MovieEndpoint setRegion(String value) {
		this.region = value.toUpperCase();
		return this;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value start date
	 * @return this request
	 */
	public MovieEndpoint setStartDate(String value) {
		this.startDate = value;
		return this;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value end date
	 * @return this request
	 */
	public MovieEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Get a list of all of the movie ids that have been changed in the past 24
	 * hours. You can query it for up to 14 days worth of changed IDs at a time
	 * with the setStartDate and setEndDate query parameters. 100 items are
	 * returned per page.
	 *
	 * @return Latest movie details.
	 */
	public ChangesIdsSchema getChanges() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_START_DATE, startDate);
		addQueryString(query, QUERY_END_DATE, endDate);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(CHANGES_ENDPOINT, ChangesIdsSchema.class, query);
	}

	/**
	 * Get the most newly created movie. This is a live response and will
	 * continuously change.
	 *
	 * @return Latest movie details.
	 */
	public MovieSchema getLatest() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(LATEST_ENDPOINT, MovieSchema.class, query);
	}

	/**
	 * Get a list of movies in theatres. This is a release type query that looks
	 * for all movies that have a release type of 2 or 3 within the specified
	 * date range.
	 *
	 * You can optionally specify a region prameter which will narrow the search
	 * to only look for theatrical release dates within the specified country.
	 *
	 * @return List of movies in theatres.
	 */
	public MovieShortDatedResultsSchema getNowPlaying() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_REGION, region);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(NOW_PLAYING_ENDPOINT, MovieShortDatedResultsSchema.class, query);
	}

	/**
	 * Get a list of the current popular movies on TMDB. This list updates
	 * daily.
	 *
	 * @return List of popular movies.
	 */
	public MovieShortResultsSchema getPopular() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_REGION, region);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(POPULAR_ENDPOINT, MovieShortResultsSchema.class, query);
	}

	/**
	 * Get the top rated movies on TMDB.
	 *
	 * @return List of top rated movies.
	 */
	public MovieShortResultsSchema getTopRated() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_REGION, region);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(TOP_RATED_ENDPOINT, MovieShortResultsSchema.class, query);
	}

	/**
	 * Get a list of upcoming movies in theatres. This is a release type query
	 * that looks for all movies that have a release type of 2 or 3 within the
	 * specified date range.
	 *
	 * You can optionally specify a region prameter which will narrow the search
	 * to only look for theatrical release dates within the specified country.
	 *
	 * @return List of upcoming movies.
	 */
	public MovieShortDatedResultsSchema getUpcoming() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryString(query, QUERY_REGION, region);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(UPCOMING_ENDPOINT, MovieShortDatedResultsSchema.class, query);
	}

}
