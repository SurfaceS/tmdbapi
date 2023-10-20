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
package com.universalmediaserver.tmdbapi.endpoint.tv.season;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.change.ChangesSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Tv Season by Season Id Endpoint.
 *
 * @author SurfaceS
 */
public class TvSeasonIdEndpoint extends Endpoint {

	private static final String V3_TV_SEASON_ENDPOINT = V3_ENDPOINT + "tv/season/";
	private static final String CHANGES_ENDPOINT = "/changes";

	private final long seasonId;
	private String startDate;
	private String endDate;
	private int page;

	public TvSeasonIdEndpoint(TMDbClient tmdbClient, long seasonId) {
		super(tmdbClient);
		this.seasonId = seasonId;
	}

	/**
	 * You can query up to 14 days in a single query by using the startDate and
	 * endDate query parameters.
	 *
	 * @param value start date
	 * @return this request
	 */
	public TvSeasonIdEndpoint setStartDate(String value) {
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
	public TvSeasonIdEndpoint setEndDate(String value) {
		this.endDate = value;
		return this;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public TvSeasonIdEndpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Get the changes for a TV season. By default only the last 24 hours are
	 * returned.
	 *
	 * @return TV season Changes.
	 */
	public ChangesSchema getChanges() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_START_DATE, startDate);
		addQueryString(query, QUERY_END_DATE, endDate);
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V3_TV_SEASON_ENDPOINT + seasonId + CHANGES_ENDPOINT, ChangesSchema.class, query);
	}

}
