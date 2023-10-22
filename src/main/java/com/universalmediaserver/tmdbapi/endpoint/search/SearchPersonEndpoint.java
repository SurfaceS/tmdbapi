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
import com.universalmediaserver.tmdbapi.schema.person.PersonResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Search for person.
 *
 * @author SurfaceS
 */
public class SearchPersonEndpoint extends Endpoint {

	private static final String V3_SEARCH_PERSON_ENDPOINT = V3_ENDPOINT + "search/person";

	private final String searchQuery;
	private boolean includeAdult;
	private String language;
	private int page;
	private String region;

	public SearchPersonEndpoint(TMDbClient tmdbClient, String searchQuery) {
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
	public SearchPersonEndpoint includeAdultContent(boolean value) {
		this.includeAdult = value;
		return this;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public SearchPersonEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public SearchPersonEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Set query Region. Specify a ISO 3166-1 code to filter release dates. Must
	 * be uppercase. pattern: ^[A-Z]{2}$
	 *
	 * @param value query Region
	 * @return this request
	 */
	public SearchPersonEndpoint setRegion(String value) {
		this.region = value.toUpperCase();
		return this;
	}

	/**
	 * Search for a person.
	 *
	 * @return collections Results
	 */
	public PersonResultsSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_QUERY, searchQuery);
		addQueryBoolean(query, QUERY_INCLUDE_ADULT, includeAdult, false);
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_REGION, region);
		return tmdbClient.get(V3_SEARCH_PERSON_ENDPOINT, PersonResultsSchema.class, query);
	}

}
