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
package com.universalmediaserver.tmdbapi.endpoint.tv.season;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.credit.AggregateCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.image.ImageLanguageSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonCreditsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonExternalIdsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonTranslationsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideoSchema;
import com.universalmediaserver.tmdbapi.schema.video.VideosResponseSchema;
import static org.junit.jupiter.api.Assertions.*;
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
public class TvSeasonTvIdEndpointTest extends BaseTestClass {

	static int TV_ID = 71712;
	static int SEASON_NUMBER = 1;
	static int TV_SEASON_ID = 88380;
	static String SEASON_NAME = "Season 1";
	static String TEST_LANGUAGE = "es";
	static String SEASON_NAME_TEST_LANGUAGE = "Temporada 1";
	static String SEASON_OVERVIEW_TEST_LANGUAGE = "Un prodigioso cirujano";

	public TvSeasonTvIdEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("TvSeasonTvIdEndpoint getDetails");
		TvSeasonDetailsSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertEquals(result.getName(), SEASON_NAME, "Wrong name");
	}

	/**
	 * Test of getAggregateCredits method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetAggregateCredits() {
		System.out.println("TvSeasonTvIdEndpoint getAggregateCredits");
		AggregateCreditsResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getAggregateCredits();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getCast(), "Fail on Cast");
		assertNotNull(result.getCrew(), "Fail on Crew");
	}

	/**
	 * Test of getCredits method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetCredits() {
		System.out.println("TvSeasonTvIdEndpoint getCredits");
		TvSeasonCreditsResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getCredits();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getCast(), "Cast is null");
		assertNotNull(result.getCrew(), "Crew is null");
	}

	/**
	 * Test of getExternalIds method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetExternalIds() {
		System.out.println("TvSeasonTvIdEndpoint getExternalIds");
		TvSeasonExternalIdsResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getExternalIds();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
	}

	/**
	 * Test of getImages method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("TvSeasonTvIdEndpoint getImages");
		TvSeasonImagesResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getImages();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
	}

	/**
	 * Test of getTranslations method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("TvSeasonTvIdEndpoint getTranslations");
		TvSeasonTranslationsResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getTranslations();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertFalse(result.getTranslations().isEmpty(), "Translations is empty");
	}

	/**
	 * Test of getVideos method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testGetVideos() {
		System.out.println("TvSeasonTvIdEndpoint getVideos");
		VideosResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getVideos();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of setLanguage method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("TvSeasonTvIdEndpoint setLanguage");
		TvSeasonDetailsSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).setLanguage(TEST_LANGUAGE).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertEquals(result.getName(), SEASON_NAME_TEST_LANGUAGE);
		assertTrue(result.getOverview().startsWith(SEASON_OVERVIEW_TEST_LANGUAGE));
	}

	/**
	 * Test of getDetails method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("TvSeasonTvIdEndpoint appendToResponse");
		TvSeasonDetailsSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER)
				.appendToResponse(
						TvSeasonAppendToResponse.ACCOUNT_STATES,
						TvSeasonAppendToResponse.AGGREGATE_CREDITS,
						TvSeasonAppendToResponse.CREDITS,
						TvSeasonAppendToResponse.EXTERNAL_IDS,
						TvSeasonAppendToResponse.IMAGES,
						TvSeasonAppendToResponse.TRANSLATIONS,
						TvSeasonAppendToResponse.VIDEOS
				).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getAggregateCredits(), "Fail on AggregateCredits");
		assertNotNull(result.getCredits(), "Fail on Credits");
		assertNotNull(result.getExternalIds(), "Fail on ExternalIds");
		assertNotNull(result.getImages(), "Fail on Images");
		assertNotNull(result.getTranslations(), "Fail on Translations");
		assertNotNull(result.getVideos(), "Fail on Videos");
	}

	/**
	 * Test of includeImageLanguage method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testIncludeImageLanguage() {
		System.out.println("TvSeasonTvIdEndpoint includeImageLanguage");
		TvSeasonImagesResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getImages();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getPosters(), "Posters is null");
		if (result.getPosters().isEmpty()) {
			//we cannot check
			return;
		}
		int allPosterCount = result.getPosters().size();
		result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).setLanguage(TEST_LANGUAGE).getImages();
		assertParsedObject(result);
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
		int onePosterCount = result.getPosters().size();
		//should find only test language.
		for (ImageLanguageSchema poster : result.getPosters()) {
			assertEquals(poster.getIso639Part1(), TEST_LANGUAGE);
		}
		result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).setLanguage(TEST_LANGUAGE).includeImageLanguage("en", "null").getImages();
		assertParsedObject(result);
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
		int multiPosterCount = result.getPosters().size();
		assertTrue(onePosterCount < allPosterCount);
		assertTrue(onePosterCount < multiPosterCount);
		assertTrue(multiPosterCount < allPosterCount);
		//test language should be overrided.
		for (ImageLanguageSchema poster : result.getPosters()) {
			assertNotEquals(poster.getIso639Part1(), TEST_LANGUAGE);
		}
	}

	/**
	 * Test of includeVideoLanguage method, of class TvSeasonTvIdEndpoint.
	 */
	@Test
	public void testIncludeVideoLanguage() {
		System.out.println("TvSeasonTvIdEndpoint includeVideoLanguage");
		VideosResponseSchema result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).getVideos();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_SEASON_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
		if (result.getResults().isEmpty()) {
			//we cannot check
			return;
		}
		int allResultsCount = result.getResults().size();
		result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).setLanguage(TEST_LANGUAGE).getVideos();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is empty");
		int oneResultsCount = result.getResults().size();
		//should find only test language.
		for (VideoSchema video : result.getResults()) {
			assertEquals(video.getIso639Part1(), TEST_LANGUAGE);
		}
		result = tmdb.tvSeason(TV_ID, SEASON_NUMBER).setLanguage(TEST_LANGUAGE).includeVideoLanguage("en", "null").getVideos();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
		assertFalse(result.getResults().isEmpty(), "Results is empty");
		int multiResultsCount = result.getResults().size();
		assertTrue(oneResultsCount < allResultsCount);
		assertTrue(oneResultsCount < multiResultsCount);
		assertTrue(multiResultsCount < allResultsCount);
		//test language should be overrided.
		for (VideoSchema video : result.getResults()) {
			assertNotEquals(video.getIso639Part1(), TEST_LANGUAGE);
		}
	}

}
