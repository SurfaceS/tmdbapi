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
import com.universalmediaserver.tmdbapi.schema.collection.CollectionSimpleResultsSchema;
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
public class SearchCollectionEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "Blade Runner";
	static long COLLECTION_ID = 422837;
	static String COLLECTION_NAME = "Blade Runner Collection";
	static String SEARCH_LANGUAGE = "fr";
	static int SEARCH_PAGE = 2;
	static String COLLECTION_NAME_SEARCH_LANGUAGE = "Blade Runner - Saga";

	public SearchCollectionEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchCollectionEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchCollectionEndpoint getResults");
		CollectionSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forCollection().getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertEquals(result.getResults().get(0).getId(), COLLECTION_ID, "Wrong Id");
		assertEquals(result.getResults().get(0).getName(), COLLECTION_NAME, "Wrong Name");
	}

	/**
	 * Test of setLanguage method, of class SearchCollectionEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("SearchCollectionEndpoint setLanguage");
		CollectionSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forCollection().setLanguage(SEARCH_LANGUAGE).getResults();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is null");
		assertEquals(result.getResults().get(0).getId(), COLLECTION_ID, "Wrong Id");
		assertEquals(result.getResults().get(0).getName(), COLLECTION_NAME_SEARCH_LANGUAGE, "Wrong Name");
	}

	/**
	 * Test of setPage method, of class SearchCollectionEndpoint.
	 */
	@Test
	public void testSetPage() {
		System.out.println("SearchCollectionEndpoint setPage");
		CollectionSimpleResultsSchema result = tmdb.search(SEARCH_QUERY).forCollection().setPage(SEARCH_PAGE).getResults();
		assertParsedObject(result);
		assertEquals(result.getPage(), SEARCH_PAGE);
	}

}
