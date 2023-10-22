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
package com.universalmediaserver.tmdbapi.endpoint.list;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.StatusSchema;
import com.universalmediaserver.tmdbapi.schema.list.ListV4ClearStatusSchema;
import com.universalmediaserver.tmdbapi.schema.list.ListV4StatusSchema;
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
public class ListV4EndpointTest extends BaseTestClass {

	public ListV4EndpointTest() {
	}

	/**
	 * Test of setDescription method, of class ListV4Endpoint.
	 */
	@Test
	public void testSetDescription() {
		System.out.println("ListV4Endpoint create");
		ListV4StatusSchema result = tmdb
				.listV4("Test list", "en")
				.setDescription("A test list")
				.setIso3166Part1("US")
				.setPublic(true)
				.setSortBy(ListSortBy.TITLE_ASCENDING)
				.create();
		assertParsedObject(result);
		if (result.getId() != null) {
			System.out.println("ListV4Endpoint clear");
			ListV4ClearStatusSchema clearResult = tmdb.listV4(result.getId()).clear();
			assertParsedObject(clearResult);
			System.out.println("ListV4Endpoint delete");
			StatusSchema deleteResult = tmdb.listV4(result.getId()).delete();
			assertParsedObject(deleteResult);
		} else {
			System.out.println("ListV4Endpoint has fail ?");
		}
	}

}
