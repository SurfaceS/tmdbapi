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
package com.universalmediaserver.tmdbapi.endpoint.search;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.movie.MovieShortResultsSchema;
import static org.junit.jupiter.api.Assertions.*;
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
public class SearchMovieEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "M. Butterfly";
	static String MOVIE_NAME = "M. Butterfly";
	static String SEARCH_LANGUAGE = "fr";
	static String MOVIE_OVERVIEW_SEARCH_LANGUAGE = "En Chine, dans les années 60";
	static int SEARCH_PAGE = 2;

	public SearchMovieEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchMovieEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchMovieEndpoint getResults");
		MovieShortResultsSchema result = tmdb.search(SEARCH_QUERY).forMovie().getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertEquals(result.getResults().get(0).getId(), 1413, "Fail on id");
		assertEquals(result.getResults().get(0).getTitle(), MOVIE_NAME, "Fail on title");
	}

	/**
	 * Test of setLanguage method, of class SearchMovieEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("SearchMovieEndpoint setLanguage");
		MovieShortResultsSchema result = tmdb.search(SEARCH_QUERY).forMovie().setLanguage(SEARCH_LANGUAGE).getResults();
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertTrue(result.getResults().get(0).getOverview().startsWith(MOVIE_OVERVIEW_SEARCH_LANGUAGE));
	}

	/**
	 * Test of setPage method, of class SearchMovieEndpoint.
	 */
	@Test
	public void testSetPage() {
		System.out.println("SearchMovieEndpoint setPage");
		MovieShortResultsSchema result = tmdb.search(SEARCH_QUERY).forMovie().setPage(SEARCH_PAGE).getResults();
		assertEquals(result.getPage(), SEARCH_PAGE);
	}

}
