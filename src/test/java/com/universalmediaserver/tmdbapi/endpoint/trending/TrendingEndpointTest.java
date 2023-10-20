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
package com.universalmediaserver.tmdbapi.endpoint.trending;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.media.MediaTypedResultsSchema;
import com.universalmediaserver.tmdbapi.schema.movie.MovieTypedResultsSchema;
import com.universalmediaserver.tmdbapi.schema.person.PersonTypedResultsSchema;
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
public class TrendingEndpointTest extends BaseTestClass {

	public TrendingEndpointTest() {
	}

	/**
	 * Test of getAllResults method, of class TrendingEndpoint.
	 */
	@Test
	public void testGetAllResults() {
		System.out.println("TrendingEndpoint getAllResults");
		MediaTypedResultsSchema result = tmdb.trending(TrendingTimeWindow.DAY).getAllResults();
		assertParsedObject(result);
	}

	/**
	 * Test of getMovieResults method, of class TrendingEndpoint.
	 */
	@Test
	public void testGetMovieResults() {
		System.out.println("TrendingEndpoint getMovieResults");
		MovieTypedResultsSchema result = tmdb.trending(TrendingTimeWindow.DAY).getMovieResults();
		assertParsedObject(result);
	}

	/**
	 * Test of getTvResults method, of class TrendingEndpoint.
	 */
	@Test
	public void testGetTvResults() {
		System.out.println("TrendingEndpoint getTvResults");
		TvTypedResultsSchema result = tmdb.trending(TrendingTimeWindow.DAY).getTvResults();
		assertParsedObject(result);
	}

	/**
	 * Test of getPersonResults method, of class TrendingEndpoint.
	 */
	@Test
	public void testGetPersonResults() {
		System.out.println("TrendingEndpoint getPersonResults");
		PersonTypedResultsSchema result = tmdb.trending(TrendingTimeWindow.DAY).getPersonResults();
		assertParsedObject(result);
	}

	/**
	 * Test of setLanguage method, of class TrendingEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("TrendingEndpoint setLanguage");
		MediaTypedResultsSchema result = tmdb.trending(TrendingTimeWindow.DAY).setLanguage("fr").getAllResults();
		assertParsedObject(result);
	}

}
