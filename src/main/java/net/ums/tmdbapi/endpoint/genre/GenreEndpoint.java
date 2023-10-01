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
package net.ums.tmdbapi.endpoint.genre;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.genre.GenresSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Genre endpoint. Get the list of official genres for movies/tv.
 *
 * @author SurfaceS
 */
public class GenreEndpoint extends Endpoint {

	private static final String V3_GENRE_ENDPOINT = V3_ENDPOINT + "genre/";
	private static final String LIST_ENDPOINT = V3_GENRE_ENDPOINT + "list";
	private static final String MOVIE_LIST_ENDPOINT = V3_GENRE_ENDPOINT + "movie/list";
	private static final String TV_LIST_ENDPOINT = V3_GENRE_ENDPOINT + "tv/list";

	private String language;

	public GenreEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this endpoint
	 */
	public GenreEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Get the list of official genres for movies. Undocumented on TMDB api.
	 *
	 * @return Movie genres list.
	 */
	public GenresSchema getList() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(LIST_ENDPOINT, GenresSchema.class, query);
	}

	/**
	 * Get the list of official genres for movies.
	 *
	 * @return Movie genres list.
	 */
	public GenresSchema getMovieList() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(MOVIE_LIST_ENDPOINT, GenresSchema.class, query);
	}

	/**
	 * Get the list of official genres for TV shows.
	 *
	 * @return TV genres list.
	 */
	public GenresSchema getTvList() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(TV_LIST_ENDPOINT, GenresSchema.class, query);
	}

}
