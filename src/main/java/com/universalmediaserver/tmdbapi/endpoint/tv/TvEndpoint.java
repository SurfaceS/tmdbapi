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
package com.universalmediaserver.tmdbapi.endpoint.tv;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.change.ChangesIdsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvSimpleResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Tv Endpoint. Get the TV show Endpoint.
 *
 * @author SurfaceS
 */
public class TvEndpoint extends Endpoint {

	private static final String V3_TV_ENDPOINT = V3_ENDPOINT + "tv/";
	private static final String CHANGES_ENDPOINT = V3_TV_ENDPOINT + "changes";
	private static final String LATEST_ENDPOINT = V3_TV_ENDPOINT + "latest";
	private static final String AIRING_TODAY_ENDPOINT = V3_TV_ENDPOINT + "airing_today";
	private static final String ON_THE_AIR_ENDPOINT = V3_TV_ENDPOINT + "on_the_air";
	private static final String POPULAR_ENDPOINT = V3_TV_ENDPOINT + "popular";
	private static final String TOP_RATED_ENDPOINT = V3_TV_ENDPOINT + "top_rated";

	private String endDate;
	private String language;
	private int page;
	private String startDate;

	public TvEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Set query language.
	 *
	 * @param value query language
	 * @return this request
	 */
	public TvEndpoint setLanguage(String value) {
		this.language = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public TvEndpoint setPage(int value) {
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
	public TvEndpoint setStartDate(String value) {
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
	public TvEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Get a list of all of the movie ids that have been changed in the past 24
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
	 * Get the most newly created TV show. This is a live response and will
	 * continuously change.
	 *
	 * @return TV shows details.
	 */
	public TvSchema getLatest() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		return tmdbClient.get(LATEST_ENDPOINT, TvSchema.class, query);
	}

	/**
	 * Get a list of TV shows that are airing today. This query is purely day
	 * based as we do not currently support airing times.
	 *
	 * @return TV shows list.
	 */
	public TvSimpleResultsSchema getAiringToday() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(AIRING_TODAY_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get a list of shows that are currently on the air. This query looks for
	 * any TV show that has an episode with an air date in the next 7 days.
	 *
	 * @return TV shows list.
	 */
	public TvSimpleResultsSchema getOnTheAir() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(ON_THE_AIR_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get a list of the current popular TV shows on TMDB. This list updates
	 * daily.
	 *
	 * @return TV shows list.
	 */
	public TvSimpleResultsSchema getPopular() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(POPULAR_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get a list of the current popular TV shows on TMDB. This list updates
	 * daily.
	 *
	 * @return TV shows list.
	 */
	public TvSimpleResultsSchema getTopRated() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_LANGUAGE, language, tmdbClient.getDefaultLanguage());
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(TOP_RATED_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

}
