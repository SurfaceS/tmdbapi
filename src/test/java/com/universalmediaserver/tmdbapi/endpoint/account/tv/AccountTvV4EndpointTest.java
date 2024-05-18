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

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.tv.TvShortResultsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvSimpleResultsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.TvTypedResultsSchema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class AccountTvV4EndpointTest extends BaseTestClass {

	public AccountTvV4EndpointTest() {
	}

	/**
	 * Test of getFavorites method, of class AccountTvV4Endpoint.
	 */
	@Test
	public void testGetFavorites() {
		System.out.println("AccountTvV4Endpoint getFavorites");
		TvSimpleResultsSchema result = tmdb.accountV4(getTmdbAccount()).forTv().getFavorites();
		assertParsedObject(result);
	}

	/**
	 * Test of getRecommendations method, of class AccountTvV4Endpoint.
	 */
	@Test
	public void testGetRecommendations() {
		System.out.println("AccountTvV4Endpoint getRecommendations");
		TvTypedResultsSchema result = tmdb.accountV4(getTmdbAccount()).forTv().getRecommendations();
		assertParsedObject(result);
	}

	/**
	 * Test of getWatchlist method, of class AccountTvV4Endpoint.
	 */
	@Test
	public void testGetWatchlist() {
		System.out.println("AccountTvV4Endpoint getWatchlist");
		TvSimpleResultsSchema result = tmdb.accountV4(getTmdbAccount()).forTv().getWatchlist();
		assertParsedObject(result);
	}

	/**
	 * Test of getRated method, of class AccountTvV4Endpoint.
	 */
	@Test
	public void testGetRated() {
		System.out.println("AccountTvV4Endpoint getRated");
		TvShortResultsSchema result = tmdb.accountV4(getTmdbAccount()).forTv().getRated();
		assertParsedObject(result);
	}

}
