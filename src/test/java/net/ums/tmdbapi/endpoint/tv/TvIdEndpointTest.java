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
package net.ums.tmdbapi.endpoint.tv;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.credit.AggregateCreditsResponseSchema;
import net.ums.tmdbapi.schema.credit.MediaCreditsResponseSchema;
import net.ums.tmdbapi.schema.reviews.ReviewsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvAlternativeTitlesResponseSchema;
import net.ums.tmdbapi.schema.tv.TvContentRatingsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvDetailsSchema;
import net.ums.tmdbapi.schema.tv.TvEpisodeGroupsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvKeywordsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvScreenedTheatricallyResponseSchema;
import net.ums.tmdbapi.schema.tv.TvSimpleResultsSchema;
import net.ums.tmdbapi.schema.tv.TvTranslationsResponseSchema;
import net.ums.tmdbapi.schema.tv.TvTypedResultsSchema;
import net.ums.tmdbapi.schema.video.VideosResponseSchema;
import net.ums.tmdbapi.schema.watchproviders.WatchProvidersResponseSchema;
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
public class TvIdEndpointTest extends BaseTestClass {

	static int TV_ID = 30983;
	static String TV_NAME = "Case Closed";
	static String TEST_LANG = "fr";
	static String TV_NAME_TEST_LANG = "Détective Conan";
	static String TV_OVERVIEW_TEST_LANG = "Shinichi Kudo est un jeune lycéen";

	public TvIdEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("TvIdEndpoint getDetails");
		TvDetailsSchema result = tmdb.tv(TV_ID).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertEquals(result.getName(), TV_NAME);
	}

	/**
	 * Test of getAggregateCredits method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetAggregateCredits() {
		System.out.println("TvIdEndpoint getAggregateCredits");
		AggregateCreditsResponseSchema result = tmdb.tv(TV_ID).getAggregateCredits();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getCast(), "Cast is null");
		assertNotNull(result.getCrew(), "Crew is null");
	}

	/**
	 * Test of getAlternativeTitles method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetAlternativeTitles() {
		System.out.println("TvIdEndpoint getAlternativeTitles");
		TvAlternativeTitlesResponseSchema result = tmdb.tv(TV_ID).getAlternativeTitles();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getChanges method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("TvIdEndpoint getChanges");
		ChangesSchema result = tmdb.tv(TV_ID).getChanges();
		assertParsedObject(result);
		assertNotNull(result.getChanges(), "Changes is null");
	}

	/**
	 * Test of getContentRatings method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetContentRatings() {
		System.out.println("TvIdEndpoint getContentRatings");
		TvContentRatingsResponseSchema result = tmdb.tv(TV_ID).getContentRatings();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getCredits method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetCredits() {
		System.out.println("TvIdEndpoint getCredits");
		MediaCreditsResponseSchema result = tmdb.tv(TV_ID).getCredits();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getCast(), "Cast is null");
		assertNotNull(result.getCrew(), "Crew is null");
	}

	/**
	 * Test of getEpisodeGroups method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetEpisodeGroups() {
		System.out.println("TvIdEndpoint getEpisodeGroups");
		TvEpisodeGroupsResponseSchema result = tmdb.tv(TV_ID).getEpisodeGroups();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getExternalIds method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetExternalIds() {
		System.out.println("TvIdEndpoint getExternalIds");
		TvExternalIdsResponseSchema result = tmdb.tv(TV_ID).getExternalIds();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
	}

	/**
	 * Test of getKeywords method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetKeywords() {
		System.out.println("TvIdEndpoint getImages");
		TvKeywordsResponseSchema result = tmdb.tv(TV_ID).getKeywords();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getRecommendations method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetRecommendations() {
		System.out.println("TvIdEndpoint getRecommendations");
		TvTypedResultsSchema result = tmdb.tv(TV_ID).getRecommendations();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getReviews method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetReviews() {
		System.out.println("TvIdEndpoint getReviews");
		ReviewsResponseSchema result = tmdb.tv(TV_ID).getReviews();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getScreenedTheatrically method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetScreenedTheatrically() {
		System.out.println("TvIdEndpoint getScreenedTheatrically");
		TvScreenedTheatricallyResponseSchema result = tmdb.tv(TV_ID).getScreenedTheatrically();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getSimilar method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetSimilar() {
		System.out.println("TvIdEndpoint getSimilar");
		TvSimpleResultsSchema result = tmdb.tv(TV_ID).getSimilar();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getTranslations method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("TvIdEndpoint getTranslations");
		TvTranslationsResponseSchema result = tmdb.tv(TV_ID).getTranslations();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertFalse(result.getTranslations().isEmpty(), "Translations is empty");
	}

	/**
	 * Test of getVideos method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetVideos() {
		System.out.println("TvIdEndpoint getVideos");
		VideosResponseSchema result = tmdb.tv(TV_ID).getVideos();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getWatchProviders method, of class TvIdEndpoint.
	 */
	@Test
	public void testGetWatchProviders() {
		System.out.println("TvIdEndpoint getWatchProviders");
		WatchProvidersResponseSchema result = tmdb.tv(TV_ID).getWatchProviders();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of setLanguage method, of class TvIdEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("TvIdEndpoint setLanguage");
		TvDetailsSchema result = tmdb.tv(TV_ID).setLanguage(TEST_LANG).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertEquals(result.getName(), TV_NAME_TEST_LANG);
		assertTrue(result.getOverview().startsWith(TV_OVERVIEW_TEST_LANG), "Tv details is not in asked language");
	}

	/**
	 * Test of appendToResponse method, of class TvIdEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("TvIdEndpoint appendToResponse");
		TvDetailsSchema result = tmdb.tv(TV_ID)
				.appendToResponse(
						TvIdAppendToResponse.ACCOUNT_STATES,
						TvIdAppendToResponse.AGGREGATE_CREDITS,
						TvIdAppendToResponse.ALTERNATIVE_TITLES,
						TvIdAppendToResponse.CHANGES,
						TvIdAppendToResponse.CONTENT_RATINGS,
						TvIdAppendToResponse.CREDITS,
						TvIdAppendToResponse.EPISODE_GROUPS,
						TvIdAppendToResponse.EXTERNAL_IDS,
						TvIdAppendToResponse.IMAGES,
						TvIdAppendToResponse.KEYWORDS,
						TvIdAppendToResponse.RECOMMENDATIONS,
						TvIdAppendToResponse.REVIEWS,
						TvIdAppendToResponse.SCREENED_THEATRICALLY,
						TvIdAppendToResponse.SIMILAR,
						TvIdAppendToResponse.TRANSLATIONS,
						TvIdAppendToResponse.VIDEOS,
						TvIdAppendToResponse.WATCH_PROVIDERS
				).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), TV_ID, "Wrong Id");
		assertEquals(result.getName(), TV_NAME, "Wrong Name");
		assertNotNull(result.getAggregateCredits(), "AggregateCredits is null");
		assertNotNull(result.getAlternativeTitles(), "AggregateCredits is null");
		assertNotNull(result.getChanges(), "Changes is null");
		assertNotNull(result.getContentRatings(), "ContentRatings is null");
		assertNotNull(result.getCredits(), "Credits is null");
		assertNotNull(result.getEpisodeGroups(), "EpisodeGroups is null");
		assertNotNull(result.getExternalIds(), "ExternalIds is null");
		assertNotNull(result.getImages(), "Images is null");
		assertNotNull(result.getKeywords(), "Keywords is null");
		assertNotNull(result.getRecommendations(), "Recommendations is null");
		assertNotNull(result.getReviews(), "Recommendations is null");
		assertNotNull(result.getScreenedTheatrically(), "ScreenedTheatrically is null");
		assertNotNull(result.getSimilar(), "Similar is null");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertNotNull(result.getVideos(), "Videos is null");
		assertNotNull(result.getWatchProviders(), "WatchProviders is null");
	}

}
