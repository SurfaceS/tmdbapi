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

/**
 * Account endpoint (V3). User Account.
 *
 * @author SurfaceS
 */
public class AccountV4Endpoint extends Endpoint {

	private static final String V4_ACCOUNT_ENDPOINT = V4_ENDPOINT + "account/";

	public AccountV4Endpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Get account details.
	 *
	 * @return Account details.
	 */
	public AccountDetailsSchema getDetails() {
		return tmdbClient.get(V4_ACCOUNT_ENDPOINT, AccountDetailsSchema.class, null);
	}

}
