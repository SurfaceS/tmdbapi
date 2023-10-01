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
package net.ums.tmdbapi.endpoint.trending;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.movie.MovieTypedResultsSchema;
import net.ums.tmdbapi.schema.person.PersonTypedResultsSchema;
import net.ums.tmdbapi.schema.media.MediaTypedResultsSchema;
import net.ums.tmdbapi.schema.tv.TvTypedResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Trending endpoint.
 *
 * @author SurfaceS
 */
public class TrendingEndpoint extends Endpoint {

	private static final String V3_TRENDING_ENDPOINT = V3_ENDPOINT + "trending/";
	private static final String TRENDING_ALL_ENDPOINT = V3_TRENDING_ENDPOINT + "all/";
	private static final String TRENDING_MOVIE_ENDPOINT = V3_TRENDING_ENDPOINT + "movie/";
	private static final String TRENDING_TV_ENDPOINT = V3_TRENDING_ENDPOINT + "tv/";
	private static final String TRENDING_PERSON_ENDPOINT = V3_TRENDING_ENDPOINT + "person/";

	private final TrendingTimeWindow timeWindow;
	private String language;

	public TrendingEndpoint(TMDbClient tmdbClient, TrendingTimeWindow timeWindow) {
		super(tmdbClient);
		this.timeWindow = timeWindow;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this endpoint
	 */
	public TrendingEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Get all movies, TV shows and people in the results as a global trending
	 * list.
	 *
	 * @return Global trending list.
	 */
	public MediaTypedResultsSchema getAllResults() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(TRENDING_ALL_ENDPOINT + timeWindow.toString(), MediaTypedResultsSchema.class, query);
	}

	/**
	 * Get the trending movies in the results.
	 *
	 * @return Trending movies list.
	 */
	public MovieTypedResultsSchema getMovieResults() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(TRENDING_MOVIE_ENDPOINT + timeWindow.toString(), MovieTypedResultsSchema.class, query);
	}

	/**
	 * Get the trending TV shows in the results.
	 *
	 * @return Trending TV shows list.
	 */
	public TvTypedResultsSchema getTvResults() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(TRENDING_TV_ENDPOINT + timeWindow.toString(), TvTypedResultsSchema.class, query);
	}

	/**
	 * Get the trending people in the results.
	 *
	 * @return Trending people list.
	 */
	public PersonTypedResultsSchema getPersonResults() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(TRENDING_PERSON_ENDPOINT + timeWindow.toString(), PersonTypedResultsSchema.class, query);
	}

}
