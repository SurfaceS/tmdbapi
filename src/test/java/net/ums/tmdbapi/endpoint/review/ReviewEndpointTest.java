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
package net.ums.tmdbapi.endpoint.review;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.reviews.ReviewSchema;
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
public class ReviewEndpointTest extends BaseTestClass {

	static String REVIEW_ID = "58aa82f09251416f92006a3a";

	public ReviewEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class ReviewEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("ReviewEndpoint getDetails");
		ReviewSchema result = tmdb.review(REVIEW_ID).getDetails();
		assertParsedObject(result);
	}

}
