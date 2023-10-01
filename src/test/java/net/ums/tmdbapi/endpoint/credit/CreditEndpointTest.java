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
package net.ums.tmdbapi.endpoint.credit;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.credit.CreditSchema;
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
public class CreditEndpointTest extends BaseTestClass {

	static String CREDIT_CAST_MOVIE_TYPE_ID = "52fe420fc3a36847f8000b53";
	static String CREDIT_CAST_TV_TYPE_ID = "634ea06689f749007ae1e06a";
	static String CREDIT_CREW_MOVIE_TYPE_ID = "5ebdf4f1bc8abc0022c2e548";
	static String CREDIT_CREW_TV_TYPE_ID = "5256c8c619c2956ff6048758";

	public CreditEndpointTest() {
	}

	/**
	 * Test of setLanguage method, of class CreditEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("CreditEndpoint setLanguage");
		CreditSchema result = tmdb.credit(CREDIT_CAST_TV_TYPE_ID).setLanguage("fr").getDetails();
		assertParsedObject(result);
	}

	/**
	 * Test of getDetails method, of class CreditEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("CreditEndpoint getDetails");
		CreditSchema result = tmdb.credit(CREDIT_CREW_TV_TYPE_ID).getDetails();
		assertParsedObject(result);
		result = tmdb.credit(CREDIT_CREW_MOVIE_TYPE_ID).getDetails();
		assertParsedObject(result);
		result = tmdb.credit(CREDIT_CAST_TV_TYPE_ID).getDetails();
		assertParsedObject(result);
		result = tmdb.credit(CREDIT_CAST_MOVIE_TYPE_ID).getDetails();
		assertParsedObject(result);
	}

}
