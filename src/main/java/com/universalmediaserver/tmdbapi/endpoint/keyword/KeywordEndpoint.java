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
package com.universalmediaserver.tmdbapi.endpoint.keyword;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.keyword.KeywordDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.keyword.KeywordMoviesResponseSchema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keyword endpoint. Get keyword details.
 *
 * @author SurfaceS
 */
public class KeywordEndpoint extends Endpoint {

	private static final String V3_KEYWORD_ENDPOINT = V3_ENDPOINT + "keyword/";
	private static final String MOVIES_ENDPOINT = "/" + KeywordAppendToResponse.MOVIES;

	private final long keywordId;
	private final List<KeywordAppendToResponse> appendToResponse = new ArrayList<>();
	private String language;

	public KeywordEndpoint(TMDbClient tmdbClient, long keywordId) {
		super(tmdbClient);
		this.keywordId = keywordId;
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public KeywordEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	public KeywordEndpoint appendToResponse(KeywordAppendToResponse... values) {
		if (values != null) {
			for (KeywordAppendToResponse value : values) {
				if (!appendToResponse.contains(value)) {
					appendToResponse.add(value);
				}
			}
		}
		return this;
	}

	/**
	 * Get keyword details.
	 *
	 * @return Keyword details.
	 */
	public KeywordDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryEnums(query, QUERY_APPEND_TO_RESPONSE, appendToResponse);
		return tmdbClient.get(V3_KEYWORD_ENDPOINT + keywordId, KeywordDetailsSchema.class, query);
	}

	/**
	 * Get the movies that belong to a keyword. TMDB highly recommend using
	 * discover endpoint instead of this method as it is much more flexible.
	 *
	 * @return Movies that belong to the keyword.
	 */
	public KeywordMoviesResponseSchema getMovies() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(V3_KEYWORD_ENDPOINT + keywordId + MOVIES_ENDPOINT, KeywordMoviesResponseSchema.class, null);
	}

}
