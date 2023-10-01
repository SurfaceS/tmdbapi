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

import net.ums.tmdbapi.TMDbClient;
import net.ums.tmdbapi.endpoint.Endpoint;
import net.ums.tmdbapi.schema.language.LanguageSchemaArray;
import net.ums.tmdbapi.schema.language.LanguageSchema;
import net.ums.tmdbapi.schema.StringSchemaArray;
import net.ums.tmdbapi.schema.configuration.ConfigurationJobSchema;
import net.ums.tmdbapi.schema.configuration.ConfigurationJobSchemaArray;
import net.ums.tmdbapi.schema.configuration.ConfigurationSchema;
import net.ums.tmdbapi.schema.configuration.ConfigurationTimezoneSchema;
import net.ums.tmdbapi.schema.configuration.ConfigurationTimezoneSchemaArray;
import net.ums.tmdbapi.schema.country.CountrySchema;
import net.ums.tmdbapi.schema.country.CountrySchemaArray;
import java.util.List;

/**
 * System wide configuration information endpoint.
 *
 * Some elements of the API require some knowledge of this configuration data.
 * The purpose of this is to try and keep the actual API responses as light as
 * possible. It is recommended you cache this data within your application and
 * check for updates every few days.
 *
 * @author SurfaceS
 */
public class ConfigurationEndpoint extends Endpoint {

	private static final String V3_CONFIGURATION_ENDPOINT = V3_ENDPOINT + "configuration";
	private static final String COUNTRIES_ENDPOINT = V3_CONFIGURATION_ENDPOINT + "/countries";
	private static final String JOBS_ENDPOINT = V3_CONFIGURATION_ENDPOINT + "/jobs";
	private static final String LANGUAGES_ENDPOINT = V3_CONFIGURATION_ENDPOINT + "/languages";
	private static final String PRIMARY_TRANSLATIONS_ENDPOINT = V3_CONFIGURATION_ENDPOINT + "/primary_translations";
	private static final String TIMEZONES_ENDPOINT = V3_CONFIGURATION_ENDPOINT + "/timezones";

	public ConfigurationEndpoint(TMDbClient tmdbClient) {
		super(tmdbClient);
	}

	/**
	 * Get the system wide configuration information. This method currently
	 * holds the data relevant to building image URLs as well as the change key
	 * map.
	 *
	 * @return API Configuration
	 */
	public ConfigurationSchema getConfiguration() {
		return tmdbClient.get(V3_CONFIGURATION_ENDPOINT, ConfigurationSchema.class, null);
	}

	/**
	 * Get the list of countries (ISO 3166-1 tags) used throughout TMDB.
	 *
	 * @return Countries
	 */
	public List<CountrySchema> getCountries() {
		return tmdbClient.get(COUNTRIES_ENDPOINT, CountrySchemaArray.class, null);
	}

	/**
	 * Get a list of the jobs and departments used throughout TMDB.
	 *
	 * @return Jobs
	 */
	public List<ConfigurationJobSchema> getJobs() {
		return tmdbClient.get(JOBS_ENDPOINT, ConfigurationJobSchemaArray.class, null);
	}

	/**
	 * Get the list of languages (ISO 639-1 tags) used throughout TMDB.
	 *
	 * @return Languages
	 */
	public List<LanguageSchema> getLanguages() {
		return tmdbClient.get(LANGUAGES_ENDPOINT, LanguageSchemaArray.class, null);
	}

	/**
	 * Get a list of the officially supported translations on TMDB.
	 *
	 * @return Primary Translations
	 */
	public List<String> getPrimaryTranslations() {
		return tmdbClient.get(PRIMARY_TRANSLATIONS_ENDPOINT, StringSchemaArray.class, null);
	}

	/**
	 * Get the list of timezones used throughout TMDB.
	 *
	 * @return Timezones
	 */
	public List<ConfigurationTimezoneSchema> getTimezones() {
		return tmdbClient.get(TIMEZONES_ENDPOINT, ConfigurationTimezoneSchemaArray.class, null);
	}

}
