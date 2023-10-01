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
package net.ums.tmdbapi.endpoint.search;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Search for movies.
 *
 * @author SurfaceS
 */
public class SearchMovieEndpoint extends Endpoint {

	private static final String V3_SEARCH_MOVIE_ENDPOINT = V3_ENDPOINT + "search/movie";

	private final String searchQuery;
	private boolean includeAdult;
	private String language;
	private int page;
	private int primaryReleaseYear;
	private String region;
	private int year;

	public SearchMovieEndpoint(TMDbClient tmdbClient, String searchQuery) {
		super(tmdbClient);
		this.searchQuery = searchQuery;
	}

	/**
	 * Specify include adult content to query. Choose whether to inlcude adult
	 * (pornography) content in the results.
	 *
	 * @param value includeAdult
	 * @return this endpoint
	 */
	public SearchMovieEndpoint includeAdultContent(boolean value) {
		this.includeAdult = value;
		return this;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public SearchMovieEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public SearchMovieEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Specify Primary Release Year to query.
	 *
	 * @param value Year
	 * @return this endpoint
	 */
	public SearchMovieEndpoint setPrimaryReleaseYear(int value) {
		this.primaryReleaseYear = value;
		return this;
	}

	/**
	 * Set query Region. Specify a ISO 3166-1 code to filter release dates. Must
	 * be uppercase. pattern: ^[A-Z]{2}$
	 *
	 * @param value query Region
	 * @return this request
	 */
	public SearchMovieEndpoint setRegion(String value) {
		this.region = value.toUpperCase();
		return this;
	}

	/**
	 * Specify Year to query.
	 *
	 * @param value Year
	 * @return this endpoint
	 */
	public SearchMovieEndpoint setYear(int value) {
		this.year = value;
		return this;
	}

	/**
	 * Search for a collection.
	 *
	 * @return collections Results
	 */
	public MovieShortResultsSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_QUERY, searchQuery);
		addQueryBoolean(query, QUERY_INCLUDE_ADULT, includeAdult, false);
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryNumber(query, QUERY_PRIMARY_RELEASE_YEAR, primaryReleaseYear);
		addQueryString(query, QUERY_REGION, region);
		addQueryNumber(query, QUERY_YEAR, year);
		return tmdbClient.get(V3_SEARCH_MOVIE_ENDPOINT, MovieShortResultsSchema.class, query);
	}

}
