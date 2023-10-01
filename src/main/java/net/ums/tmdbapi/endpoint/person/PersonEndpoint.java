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
package net.ums.tmdbapi.endpoint.person;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.change.ChangesIdsSchema;
import net.ums.tmdbapi.schema.person.PersonResultsSchema;
import net.ums.tmdbapi.schema.person.PersonSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Person Endpoint.
 *
 * @author SurfaceS
 */
public class PersonEndpoint extends Endpoint {

	private static final String V3_PERSON_ENDPOINT = V3_ENDPOINT + "person/";
	private static final String CHANGES_ENDPOINT = V3_PERSON_ENDPOINT + "changes";
	private static final String LATEST_ENDPOINT = V3_PERSON_ENDPOINT + "latest";
	private static final String POPULAR_ENDPOINT = V3_PERSON_ENDPOINT + "popular";

	private String endDate;
	private String language;
	private int page;
	private String startDate;

	public PersonEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this endpoint
	 */
	public PersonEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public PersonEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value start date
	 * @return this request
	 */
	public PersonEndpoint setStartDate(String value) {
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
	public PersonEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Get a list of all of the person ids that have been changed in the past 24
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
	 * Get the most newly created person. This is a live response and will
	 * continuously change.
	 *
	 * @return Latest person details.
	 */
	public PersonSchema getLatest() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(LATEST_ENDPOINT, PersonSchema.class, query);
	}

	/**
	 * Get the list of popular people on TMDB. This list updates daily.
	 *
	 * @return List of popular people.
	 */
	public PersonResultsSchema getPopular() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(POPULAR_ENDPOINT, PersonResultsSchema.class, query);
	}

}
