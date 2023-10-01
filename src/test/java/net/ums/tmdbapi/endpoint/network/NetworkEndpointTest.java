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
package net.ums.tmdbapi.endpoint.network;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.network.NetworkAlternativeNamesResponseSchema;
import net.ums.tmdbapi.schema.network.NetworkDetailsSchema;
import net.ums.tmdbapi.schema.network.NetworkImagesResponseSchema;
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
public class NetworkEndpointTest extends BaseTestClass {

	static int NETWORK_ID = 213;

	public NetworkEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class NetworkEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("NetworkEndpoint getDetails");
		NetworkDetailsSchema result = tmdb.network(NETWORK_ID).getDetails();
		assertParsedObject(result);
	}

	/**
	 * Test of getImages method, of class NetworkEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("NetworkEndpoint getImages");
		NetworkImagesResponseSchema result = tmdb.network(NETWORK_ID).getImages();
		assertParsedObject(result);
	}

	/**
	 * Test of getAlternativeNames method, of class NetworkEndpoint.
	 */
	@Test
	public void testGetAlternativeNames() {
		System.out.println("NetworkEndpoint getAlternativeNames");
		NetworkAlternativeNamesResponseSchema result = tmdb.network(NETWORK_ID).getAlternativeNames();
		assertParsedObject(result);
	}

	/**
	 * Test of appendToResponse method, of class NetworkEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("NetworkEndpoint appendToResponse");
		NetworkDetailsSchema result = tmdb.network(NETWORK_ID)
				.appendToResponse(
						NetworkAppendToResponse.ALTERNATIVE_NAMES,
						NetworkAppendToResponse.IMAGES
				).getDetails();
		assertParsedObject(result);
	}

}
