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
package net.ums.tmdbapi.endpoint.search;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.tv.TvSimpleResultsSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class SearchTvEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "Good Doctor";
	static String TV_NAME = "The Good Doctor";
	static String SEARCH_LANGUAGE = "fr";
	static int SEARCH_PAGE = 2;

	public SearchTvEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchTvEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchTvEndpoint getResults");
		TvSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forTvShow().getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertEquals(result.getResults().get(0).getName(), TV_NAME);
	}

	/**
	 * Test of setLanguage method, of class SearchTvEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("SearchTvEndpoint setLanguage");
		TvSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forTvShow().setLanguage(SEARCH_LANGUAGE).getResults();
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertNotEquals(result.getResults().get(0).getName(), result.getResults().get(0).getOriginalName());
	}

	/**
	 * Test of setPage method, of class SearchTvEndpoint.
	 */
	@Test
	public void testSetPage() {
		System.out.println("SearchTvEndpoint setPage");
		TvSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forTvShow().setPage(SEARCH_PAGE).getResults();
		assertEquals(result.getPage(), SEARCH_PAGE);
	}

}
