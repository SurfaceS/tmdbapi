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
package com.universalmediaserver.tmdbapi.endpoint.account.movie;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.movie.MovieShortResultsSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieTypedResultsSchema;
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
public class AccountMovieV4EndpointTest extends BaseTestClass {

	public AccountMovieV4EndpointTest() {
	}

	/**
	 * Test of getFavorites method, of class AccountMovieV4Endpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbAccount",
			disabledReason = TMDB_ACCOUNT_MISSING
	)
	public void testGetFavorites() {
		System.out.println("AccountMovieV4Endpoint getFavorites");
		MovieShortResultsSchema result = tmdb.accountV4(getTmdbAccount()).forMovie().getFavorites();
		assertParsedObject(result);
	}

	/**
	 * Test of getRecommendations method, of class AccountMovieV4Endpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbAccount",
			disabledReason = TMDB_ACCOUNT_MISSING
	)
	public void testGetRecommendations() {
		System.out.println("AccountMovieV4Endpoint getRecommendations");
		MovieTypedResultsSchema result = tmdb.accountV4(getTmdbAccount()).forMovie().getRecommendations();
		assertParsedObject(result);
	}

	/**
	 * Test of getWatchlist method, of class AccountMovieV4Endpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbAccount",
			disabledReason = TMDB_ACCOUNT_MISSING
	)
	public void testGetWatchlist() {
		System.out.println("AccountMovieV4Endpoint getWatchlist");
		MovieShortResultsSchema result = tmdb.accountV4(getTmdbAccount()).forMovie().getWatchlist();
		assertParsedObject(result);
	}

	/**
	 * Test of getRated method, of class AccountMovieV4Endpoint.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbAccount",
			disabledReason = TMDB_ACCOUNT_MISSING
	)
	public void testGetRated() {
		System.out.println("AccountMovieV4Endpoint getRated");
		MovieShortResultsSchema result = tmdb.accountV4(getTmdbAccount()).forMovie().getRated();
		assertParsedObject(result);
	}

}
