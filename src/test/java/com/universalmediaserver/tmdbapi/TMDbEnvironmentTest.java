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
package com.universalmediaserver.tmdbapi;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
public class TMDbEnvironmentTest extends BaseTestClass {

	private static final Logger LOGGER = Logger.getLogger(TMDbEnvironmentTest.class.getName());

	public TMDbEnvironmentTest() {
	}

	/**
	 * Test Tmdb Client Prospective.
	 */
	@Test
	@DisabledIf(
			value = "haveTmdbReadAccess"
	)
	public void testTmdbClientProspective() {
		LOGGER.warning("TMDB_API_KEY and TMDB_API_READ_TOKEN are not defined in the system environment.");
		LOGGER.info("All tests will be skipped.");
	}

	/**
	 * Test Tmdb Client V3.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbReadAccess"
	)
	@DisabledIf(
			value = "haveTmdbApiKey"
	)
	public void testTmdbClientV3() {
		LOGGER.warning("TMDB_API_KEY is not defined in the system environment.");
		LOGGER.info("Test running under api V3 mode will be skipped.");
	}

	/**
	 * Test Tmdb Client V4.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbReadAccess"
	)
	@DisabledIf(
			value = "haveTmdbApiReadToken"
	)
	public void testTmdbClientV4() {
		LOGGER.warning("TMDB_API_READ_TOKEN is not defined in the system environment.");
		LOGGER.info("Test running under api V4 mode will be skipped.");
	}

	/**
	 * Test Tmdb Session V3.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbReadAccess"
	)
	@DisabledIf(
			value = "haveTmdbCredential"
	)
	public void testTmdbSessionV3() {
		LOGGER.warning("TMDB_USERNAME and/or TMDB_PASSWORD are not defined in the system environment.");
		LOGGER.info("Test requiring api V3 session will be skipped.");
	}

	/**
	 * Test Tmdb account V4.
	 */
	@Test
	@EnabledIf(
			value = "haveTmdbReadAccess"
	)
	@DisabledIf(
			value = "haveTmdbAccount"
	)
	public void testTmdbAccountV4() {
		LOGGER.warning("TMDB_ACCOUNT is not defined in the system environment.");
		LOGGER.info("Test requiring api V4 account will be skipped.");
	}

}
