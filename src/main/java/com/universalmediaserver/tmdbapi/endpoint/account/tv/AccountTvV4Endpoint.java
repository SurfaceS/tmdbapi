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
package com.universalmediaserver.tmdbapi.endpoint.account.tv;

import com.universalmediaserver.tmdbapi.TMDbClient;
import com.universalmediaserver.tmdbapi.endpoint.Endpoint;
import com.universalmediaserver.tmdbapi.schema.tv.TvShortResultsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvSimpleResultsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvTypedResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Account TV shows endpoint (V4).
 *
 * @author SurfaceS
 */
public class AccountTvV4Endpoint extends Endpoint {

	private static final String V4_ACCOUNT_ENDPOINT = V4_ENDPOINT + "account/";
	private static final String V4_ACCOUNT_TV_ENDPOINT = "/tv/";
	private static final String TV_FAVORITES_ENDPOINT = V4_ACCOUNT_TV_ENDPOINT + "favorites";
	private static final String TV_RECOMMENDATIONS_ENDPOINT = V4_ACCOUNT_TV_ENDPOINT + "recommendations";
	private static final String TV_WATCHLIST_ENDPOINT = V4_ACCOUNT_TV_ENDPOINT + "watchlist";
	private static final String TV_RATED_ENDPOINT = V4_ACCOUNT_TV_ENDPOINT + "rated";

	private final String accountId;
	private String sortBy;
	private int page;

	public AccountTvV4Endpoint(TMDbClient tmdbClient, String accountId) {
		super(tmdbClient);
		this.accountId = accountId;
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public AccountTvV4Endpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Set sort option for the list of TV shows.
	 *
	 * @param value sort option
	 * @return this endpoint
	 */
	public AccountTvV4Endpoint sortBy(TvSortBy value) {
		this.sortBy = value != null ? value.toString() : null;
		return this;
	}

	/**
	 * Get the list of TV shows you have marked as a favorite.
	 *
	 * @return Favorite TV shows.
	 */
	public TvSimpleResultsSchema getFavorites() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + TV_FAVORITES_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get a list of your personal TV shows recommendations.
	 *
	 * @return TV shows Recommendations.
	 */
	public TvTypedResultsSchema getRecommendations() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + TV_RECOMMENDATIONS_ENDPOINT, TvTypedResultsSchema.class, query);
	}

	/**
	 * Get the list of TV shows you have added to your watchlist.
	 *
	 * @return TV shows Watchlist.
	 */
	public TvSimpleResultsSchema getWatchlist() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + TV_WATCHLIST_ENDPOINT, TvSimpleResultsSchema.class, query);
	}

	/**
	 * Get the list of TV shows you have rated.
	 *
	 * @return Rated TV shows.
	 */
	public TvShortResultsSchema getRated() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		addQueryString(query, QUERY_SORT_BY, sortBy);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + TV_RATED_ENDPOINT, TvShortResultsSchema.class, query);
	}

}
