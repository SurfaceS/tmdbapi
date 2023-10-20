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
package com.universalmediaserver.tmdbapi.endpoint.watchproviders;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.watchproviders.WatchProviderRegionsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.watchproviders.WatchProviderResponseSchema;
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
public class WatchProvidersEndpointTest extends BaseTestClass {

	public WatchProvidersEndpointTest() {
	}

	/**
	 * Test of getRegions method, of class WatchProvidersEndpoint.
	 */
	@Test
	public void testGetRegions() {
		System.out.println("WatchProvidersEndpoint getRegions");
		WatchProviderRegionsResponseSchema result = tmdb.watchProviders().getRegions();
		assertParsedObject(result);
	}

	/**
	 * Test of forMovies method, of class WatchProvidersEndpoint.
	 */
	@Test
	public void testForMovies() {
		System.out.println("WatchProvidersEndpoint forMovies");
		WatchProviderResponseSchema result = tmdb.watchProviders().forMovies();
		assertParsedObject(result);
	}

	/**
	 * Test of forTv method, of class WatchProvidersEndpoint.
	 */
	@Test
	public void testForTv() {
		System.out.println("WatchProvidersEndpoint forTv");
		WatchProviderResponseSchema result = tmdb.watchProviders().forTv();
		assertParsedObject(result);
	}

}
