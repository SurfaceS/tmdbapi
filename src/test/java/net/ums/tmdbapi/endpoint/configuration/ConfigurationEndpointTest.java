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
package net.ums.tmdbapi.endpoint.configuration;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.configuration.ConfigurationJobSchema;
import net.ums.tmdbapi.schema.configuration.ConfigurationSchema;
import net.ums.tmdbapi.schema.configuration.ConfigurationTimezoneSchema;
import net.ums.tmdbapi.schema.country.CountrySchema;
import net.ums.tmdbapi.schema.language.LanguageSchema;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class ConfigurationEndpointTest extends BaseTestClass {

	public ConfigurationEndpointTest() {
	}

	/**
	 * Test of getConfiguration method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetConfiguration() {
		System.out.println("ConfigurationEndpoint getConfiguration");
		ConfigurationSchema result = tmdb.configuration().getConfiguration();
		assertParsedObject(result);
		assertNotNull(result.getChangeKeys(), "ChangeKeys on Crew");
		assertNotNull(result.getImages(), "Images on Crew");
	}

	/**
	 * Test of getCountries method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetCountries() {
		System.out.println("ConfigurationEndpoint getCountries");
		List<CountrySchema> result = tmdb.configuration().getCountries();
		assertParsedObject(result);
	}

	/**
	 * Test of getJobs method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetJobs() {
		System.out.println("ConfigurationEndpoint getJobs");
		List<ConfigurationJobSchema> result = tmdb.configuration().getJobs();
		assertParsedObject(result);
	}

	/**
	 * Test of getLanguages method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetLanguages() {
		System.out.println("ConfigurationEndpoint getLanguages");
		List<LanguageSchema> result = tmdb.configuration().getLanguages();
		assertParsedObject(result);
	}

	/**
	 * Test of getPrimaryTranslations method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetPrimaryTranslations() {
		System.out.println("ConfigurationEndpoint getPrimaryTranslations");
		List<String> result = tmdb.configuration().getPrimaryTranslations();
		assertParsedObject(result);
	}

	/**
	 * Test of getTimezones method, of class ConfigurationEndpoint.
	 */
	@Test
	public void testGetTimezones() {
		System.out.println("ConfigurationEndpoint getTimezones");
		List<ConfigurationTimezoneSchema> result = tmdb.configuration().getTimezones();
		assertParsedObject(result);
	}

}
