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
package net.ums.tmdbapi.endpoint.person;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.change.ChangesIdsSchema;
import net.ums.tmdbapi.schema.person.PersonResultsSchema;
import net.ums.tmdbapi.schema.person.PersonSchema;
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
public class PersonEndpointTest extends BaseTestClass {

	public PersonEndpointTest() {
	}

	/**
	 * Test of getChanges method, of class PersonEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("PersonEndpoint getChanges");
		ChangesIdsSchema result = tmdb.person().getChanges();
		assertParsedObject(result);
	}

	/**
	 * Test of getLatest method, of class PersonEndpoint.
	 */
	@Test
	public void testGetLatest() {
		System.out.println("PersonEndpoint getLatest");
		PersonSchema result = tmdb.person().getLatest();
		assertParsedObject(result);
	}

	/**
	 * Test of getPopular method, of class PersonEndpoint.
	 */
	@Test
	public void testGetPopular() {
		System.out.println("PersonEndpoint getPopular");
		PersonResultsSchema result = tmdb.person().getPopular();
		assertParsedObject(result);
	}

}
