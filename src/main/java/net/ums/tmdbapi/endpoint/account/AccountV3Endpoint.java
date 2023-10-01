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
import net.ums.tmdbapi.schema.account.AccountDetailsSchema;
import java.util.HashMap;
import java.util.Map;

/**
 * Account endpoint (V3). User Account.
 *
 * @author SurfaceS
 */
public class AccountV3Endpoint extends Endpoint {

	private static final String V3_ACCOUNT_ENDPOINT = V3_ENDPOINT + "account";

	public AccountV3Endpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Get account details.
	 *
	 * @return Account details.
	 */
	public AccountDetailsSchema getDetails() {
		Map<String, String> query = new HashMap<>();
		addQueryString(query, QUERY_SESSION_ID, tmdbClient.getSessionId());
		return tmdbClient.get(V3_ACCOUNT_ENDPOINT, AccountDetailsSchema.class, query);
	}

}
