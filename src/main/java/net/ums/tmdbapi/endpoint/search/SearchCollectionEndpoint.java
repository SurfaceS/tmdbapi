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
import net.ums.tmdbapi.schema.collection.CollectionSimpleResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Search Collections.
 *
 * @author SurfaceS
 */
public class SearchCollectionEndpoint extends Endpoint {

	private static final String V3_SEARCH_COLLECTION_ENDPOINT = V3_ENDPOINT + "search/collection";

	private final String searchQuery;
	private String language;
	private int page;

	public SearchCollectionEndpoint(TMDbClient tmdbClient, String searchQuery) {
		super(tmdbClient);
		this.searchQuery = searchQuery;
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this request
	 */
	public SearchCollectionEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param page
	 * @return this endpoint
	 */
	public SearchCollectionEndpoint setPage(int page) {
		this.page = page;
		return this;
	}

	/**
	 * Search for a collection.
	 *
	 * @return collections Results
	 */
	public CollectionSimpleResultsSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_QUERY, searchQuery);
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_SEARCH_COLLECTION_ENDPOINT, CollectionSimpleResultsSchema.class, query);
	}

}
