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
package net.ums.tmdbapi.endpoint.find;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.find.FindSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Find endpoint. The find method makes it easy to search for objects in our
 * database by an external id. This method will search all objects (movies, TV
 * shows and people) and return the results in a single response.
 *
 * @author SurfaceS
 */
public class FindEndpoint extends Endpoint {

	private static final String V3_FIND_ENDPOINT = V3_ENDPOINT + "find/";

	private final String externalId;
	private final FindExternalSource externalSource;
	private String language;

	public FindEndpoint(TMDbClient tmdbClient, String externalId, FindExternalSource externalSource) {
		super(tmdbClient);
		this.externalId = externalId;
		this.externalSource = externalSource;
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this request
	 */
	public FindEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Find results by external Id.
	 *
	 * @return all results (movies, TV shows and people)
	 */
	public FindSchema getResults() {
		Map<String, String> query = new HashMap<>();
		query.put(QUERY_EXTERNAL_SOURCE, externalSource.toString());
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_FIND_ENDPOINT + externalId, FindSchema.class, query);
	}

}
