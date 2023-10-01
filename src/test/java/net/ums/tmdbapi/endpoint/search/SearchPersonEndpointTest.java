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
import net.ums.tmdbapi.schema.person.PersonResultsSchema;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
public class SearchPersonEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "Brad Pitt";
	static String SEARCH_LANGUAGE = "fr";
	static String SEARCH_REGION = "FR";
	static int SEARCH_PAGE = 2;

	public SearchPersonEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchPersonEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchPeopleEndpoint getResults");
		PersonResultsSchema result = tmdb.search(SEARCH_QUERY).forPerson().getResults();
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is empty");
		assertParsedObject(result);
	}

	/**
	 * Test of includeAdultContent method, of class SearchPersonEndpoint.
	 */
	@Test
	public void testIncludeAdultContent() {
		System.out.println("SearchPersonEndpoint includeAdultContent");
		PersonResultsSchema result = tmdb.search(SEARCH_QUERY).forPerson().includeAdultContent(true).getResults();
		assertParsedObject(result);
	}

	/**
	 * Test of setLanguage method, of class SearchPersonEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("SearchPersonEndpoint setLanguage");
		PersonResultsSchema result = tmdb.search(SEARCH_QUERY).forPerson().setLanguage(SEARCH_LANGUAGE).getResults();
		assertParsedObject(result);
	}

	/**
	 * Test of setPage method, of class SearchPersonEndpoint.
	 */
	@Test
	public void testSetPage() {
		System.out.println("SearchPersonEndpoint setPage");
		PersonResultsSchema result = tmdb.search(SEARCH_QUERY).forPerson().setPage(SEARCH_PAGE).getResults();
		assertParsedObject(result);
	}

	/**
	 * Test of setRegion method, of class SearchPersonEndpoint.
	 */
	@Test
	public void testSetRegion() {
		System.out.println("SearchPersonEndpoint setRegion");
		PersonResultsSchema result = tmdb.search(SEARCH_QUERY).forPerson().setRegion(SEARCH_REGION).getResults();
		assertParsedObject(result);
	}

}
