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
import com.universalmediaserver.tmdbapi.schema.media.MediaTypedResultsSchema;
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
public class SearchMultiEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "alien";
	static String SEARCH_LANGUAGE = "fr";
	static int SEARCH_PAGE = 2;
	static String SEARCH_REGION = "FR";

	public SearchMultiEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchMultiEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchMultiEndpoint getResults");
		MediaTypedResultsSchema result = tmdb.search(SEARCH_QUERY).forMulti().getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
	}

	/**
	 * Test of includeAdultContent method, of class SearchMultiEndpoint.
	 */
	@Test
	public void testIncludeAdultContent() {
		System.out.println("SearchMultiEndpoint includeAdultContent");
		MediaTypedResultsSchema result = tmdb.search(SEARCH_QUERY).forMulti().includeAdultContent(true).getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
	}

	/**
	 * Test of setLanguage method, of class SearchMultiEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("SearchMultiEndpoint setLanguage");
		MediaTypedResultsSchema result = tmdb.search(SEARCH_QUERY).forMulti().setLanguage(SEARCH_LANGUAGE).getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
	}

	/**
	 * Test of setPage method, of class SearchMultiEndpoint.
	 */
	@Test
	public void testSetPage() {
		System.out.println("SearchMultiEndpoint setPage");
		MediaTypedResultsSchema result = tmdb.search(SEARCH_QUERY).forMulti().setPage(SEARCH_PAGE).getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
	}

	/**
	 * Test of setRegion method, of class SearchMultiEndpoint.
	 */
	@Test
	public void testSetRegion() {
		System.out.println("SearchMultiEndpoint setRegion");
		MediaTypedResultsSchema result = tmdb.search(SEARCH_QUERY).forMulti().setRegion(SEARCH_REGION).getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
	}

}
