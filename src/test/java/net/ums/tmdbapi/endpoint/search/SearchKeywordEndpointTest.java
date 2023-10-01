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
import net.ums.tmdbapi.schema.search.SearchKeywordSchema;
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
public class SearchKeywordEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "alien";

	public SearchKeywordEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchKeywordEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchKeywordEndpoint getResults");
		SearchKeywordSchema result = tmdb.search(SEARCH_QUERY).forKeyword().getResults();
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is empty");
		assertParsedObject(result);
	}

}
