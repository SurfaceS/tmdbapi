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
package net.ums.tmdbapi.endpoint.tv.episode;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeCreditsResponseSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeDetailsSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeImagesResponseSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeTranslationsResponseSchema;
import net.ums.tmdbapi.schema.video.VideosResponseSchema;
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
public class TvEpisodeTvIdEndpointTest extends BaseTestClass {

	public TvEpisodeTvIdEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("TvEpisodeTvIdEndpoint getDetails");
		TvEpisodeDetailsSchema result = tmdb.tvEpisode(1413, 1, 1).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), 64144);
		assertEquals(result.getName(), "Pilot");
	}

	/**
	 * Test of getCredits method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetCredits() {
		System.out.println("TvEpisodeTvIdEndpoint getCredits");
		TvEpisodeCreditsResponseSchema result = tmdb.tvEpisode(1413, 1, 1).getCredits();
		assertParsedObject(result);
	}

	/**
	 * Test of getExternalIds method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetExternalIds() {
		System.out.println("TvEpisodeTvIdEndpoint getExternalIds");
		TvEpisodeExternalIdsResponseSchema result = tmdb.tvEpisode(1413, 1, 1).getExternalIds();
		assertParsedObject(result);
	}

	/**
	 * Test of getImages method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("TvEpisodeTvIdEndpoint getImages");
		TvEpisodeImagesResponseSchema result = tmdb.tvEpisode(1413, 1, 1).getImages();
		assertParsedObject(result);
	}

	/**
	 * Test of getTranslations method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("TvEpisodeTvIdEndpoint getTranslations");
		TvEpisodeTranslationsResponseSchema result = tmdb.tvEpisode(1413, 1, 1).getTranslations();
		assertParsedObject(result);
	}

	/**
	 * Test of getVideos method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testGetVideos() {
		System.out.println("TvEpisodeTvIdEndpoint getVideos");
		VideosResponseSchema result = tmdb.tvEpisode(1413, 1, 1).getVideos();
		assertParsedObject(result);
	}

	/**
	 * Test of getDetails method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("TvEpisodeTvIdEndpoint appendToResponse");
		TvEpisodeDetailsSchema result = tmdb.tvEpisode(1413, 1, 1)
				.appendToResponse(
						TvEpisodeAppendToResponse.ACCOUNT_STATES,
						TvEpisodeAppendToResponse.CREDITS,
						TvEpisodeAppendToResponse.EXTERNAL_IDS,
						TvEpisodeAppendToResponse.IMAGES,
						TvEpisodeAppendToResponse.TRANSLATIONS,
						TvEpisodeAppendToResponse.VIDEOS
				).getDetails();
		assertParsedObject(result);
		assertNotNull(result.getCredits(), "Fail on Credits");
		assertNotNull(result.getExternalIds(), "Fail on ExternalIds");
		assertNotNull(result.getImages(), "Fail on Images");
		assertNotNull(result.getTranslations(), "Fail on Translations");
		assertNotNull(result.getVideos(), "Fail on Videos");
	}

	/**
	 * Test of setLanguage method, of class TvEpisodeTvIdEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("TvEpisodeTvIdEndpoint setLanguage");
		TvEpisodeDetailsSchema result = tmdb.tvEpisode(1413, 1, 1).setLanguage("fr").getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), 64144);
		assertEquals(result.getName(), "La maison");
	}

}
