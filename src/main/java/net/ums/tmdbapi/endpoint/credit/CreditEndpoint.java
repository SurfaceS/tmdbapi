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
package net.ums.tmdbapi.endpoint.credit;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.credit.CreditSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Credit endpoint.
 *
 * @author SurfaceS
 */
public class CreditEndpoint extends Endpoint {

	private static final String V3_CREDIT_ENDPOINT = V3_ENDPOINT + "credit/";

	private final String creditId;
	private String language;

	public CreditEndpoint(TMDbClient tmdbClient, String creditId) {
		super(tmdbClient);
		this.creditId = creditId;
	}

	/**
	 * Set query language.
	 *
	 * @param language query language
	 * @return this request
	 */
	public CreditEndpoint setLanguage(String language) {
		this.language = language;
		return this;
	}

	/**
	 * Get a movie or TV credit details by id.
	 *
	 * @return credit details
	 */
	public CreditSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_CREDIT_ENDPOINT + creditId, CreditSchema.class, query);
	}

}
