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
package com.universalmediaserver.tmdbapi.endpoint.movie;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.change.ChangesIdsSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieShortDatedResultsSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieShortResultsSchema;
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
public class MovieEndpointTest extends BaseTestClass {

	public MovieEndpointTest() {
	}

	/**
	 * Test of getChanges method, of class MovieEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("MovieEndpoint getChanges");
		ChangesIdsSchema result = tmdb.movie().getChanges();
		assertParsedObject(result);
	}

	/**
	 * Test of getLatest method, of class MovieEndpoint.
	 */
	@Test
	public void testGetLatest() {
		System.out.println("MovieEndpoint getLatest");
		MovieSchema result = tmdb.movie().getLatest();
		assertParsedObject(result);
	}

	/**
	 * Test of getNowPlaying method, of class MovieEndpoint.
	 */
	@Test
	public void testGetNowPlaying() {
		System.out.println("MovieEndpoint getNowPlaying");
		MovieShortDatedResultsSchema result = tmdb.movie().getNowPlaying();
		assertParsedObject(result);
	}

	/**
	 * Test of getPopular method, of class MovieEndpoint.
	 */
	@Test
	public void testGetPopular() {
		System.out.println("MovieEndpoint getPopular");
		MovieShortResultsSchema result = tmdb.movie().getPopular();
		assertParsedObject(result);
	}

	/**
	 * Test of getTopRated method, of class MovieEndpoint.
	 */
	@Test
	public void testGetTopRated() {
		System.out.println("MovieEndpoint getTopRated");
		MovieShortResultsSchema result = tmdb.movie().getTopRated();
		assertParsedObject(result);
	}

	/**
	 * Test of getUpcoming method, of class MovieEndpoint.
	 */
	@Test
	public void testGetUpcoming() {
		System.out.println("MovieEndpoint getUpcoming");
		MovieShortDatedResultsSchema result = tmdb.movie().getUpcoming();
		assertParsedObject(result);
	}

}
