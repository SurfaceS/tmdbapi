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
package com.universalmediaserver.tmdbapi.endpoint.search;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.tv.TvSimpleResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Search TV Shows.
 *
 * @author SurfaceS
 */
public class SearchTvEndpoint extends Endpoint {

	private static final String V3_SEARCH_TV_ENDPOINT = V3_ENDPOINT + "search/tv";

	private final String searchQuery;
	private boolean includeAdult;
	private int firstAirDateYear;
	private String language;
	private int page;

	public SearchTvEndpoint(TMDbClient tmdbClient, String searchQuery) {
		super(tmdbClient);
		this.searchQuery = searchQuery;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public SearchTvEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public SearchTvEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Specify First Air Date Year to query.
	 *
	 * @param value Year
	 * @return this endpoint
	 */
	public SearchTvEndpoint setFirstAirDateYear(int value) {
		this.firstAirDateYear = value;
		return this;
	}

	/**
	 * Specify include adult content to query.
	 *
	 * @param value includeAdult
	 * @return this endpoint
	 */
	public SearchTvEndpoint includeAdultContent(boolean value) {
		this.includeAdult = value;
		return this;
	}

	/**
	 * Search for TV shows.
	 *
	 * @return TV Shows
	 */
	public TvSimpleResultsSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_QUERY, searchQuery);
		addQueryNumber(query, QUERY_FIRST_AIR_DATE_YEAR, firstAirDateYear);
		addQueryBoolean(query, QUERY_INCLUDE_ADULT, includeAdult, false);
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_SEARCH_TV_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

}
