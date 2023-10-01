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
import net.ums.tmdbapi.schema.company.CompanyResultsSchema;
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
public class SearchCompanyEndpointTest extends BaseTestClass {

	static String SEARCH_QUERY = "Sony Pictures";

	public SearchCompanyEndpointTest() {
	}

	/**
	 * Test of getResults method, of class SearchCompanyEndpoint.
	 */
	@Test
	public void testGetResults() {
		System.out.println("SearchCompanyEndpoint getResults");
		CompanyResultsSchema result = tmdb.search(SEARCH_QUERY).forCompany().getResults();
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is empty");
		assertParsedObject(result);
	}

}
