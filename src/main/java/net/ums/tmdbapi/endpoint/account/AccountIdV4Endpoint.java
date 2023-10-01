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
package net.ums.tmdbapi.endpoint.account;

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.endpoint.account.movie.AccountMovieV4Endpoint;
import net.ums.tmdbapi.endpoint.account.tv.AccountTvV4Endpoint;
import net.ums.tmdbapi.schema.list.ListV4SimpleResultsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Account Id endpoint (V4). User Account.
 *
 * @author SurfaceS
 */
public class AccountIdV4Endpoint extends Endpoint {

	private static final String V4_ACCOUNT_ENDPOINT = V4_ENDPOINT + "account/";
	private static final String LISTS_ENDPOINT = "/lists";

	private final String accountId;
	private int page;

	public AccountIdV4Endpoint(TMDbClient tmdbClient, String accountId) {
		super(tmdbClient);
		this.accountId = accountId;
	}

	/**
	 * Get movie results.
	 *
	 * @return Account movie endpoint
	 */
	public AccountMovieV4Endpoint forMovie() {
		return new AccountMovieV4Endpoint(tmdbClient, accountId);
	}

	/**
	 * Get TV show results.
	 *
	 * @return TV show endpoint
	 */
	public AccountTvV4Endpoint forTv() {
		return new AccountTvV4Endpoint(tmdbClient, accountId);
	}

	/**
	 * Specify which page to query.
	 *
	 * @param value page number
	 * @return this endpoint
	 */
	public AccountIdV4Endpoint setPage(int value) {
		this.page = value;
		return this;
	}

	/**
	 * Get all of the lists you've created.
	 *
	 * @return Lists.
	 */
	public ListV4SimpleResultsSchema getLists() {
		Map<String, String> query = new HashMap<>();
		addQueryNumber(query, QUERY_PAGE, page);
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT + accountId + LISTS_ENDPOINT, ListV4SimpleResultsSchema.class, query);
	}

}
