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
import net.ums.tmdbapi.schema.company.CompanyResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Search for companies.
 *
 * @author SurfaceS
 */
public class SearchCompanyEndpoint extends Endpoint {

	private static final String V3_SEARCH_COMPANY_ENDPOINT = V3_ENDPOINT + "search/company";

	private final String searchQuery;
	private int page;

	public SearchCompanyEndpoint(TMDbClient tmdbClient, String searchQuery) {
		super(tmdbClient);
		this.searchQuery = searchQuery;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public SearchCompanyEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Search for a company.
	 *
	 * @return Companies
	 */
	public CompanyResultsSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_QUERY, searchQuery);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_SEARCH_COMPANY_ENDPOINT, CompanyResultsSchema.class, query);
	}

}
