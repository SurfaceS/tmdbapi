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
package net.ums.tmdbapi.endpoint.movie;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.credit.MediaCreditsResponseSchema;
import net.ums.tmdbapi.schema.image.ImagesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieAlternativeTitlesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieDetailsSchema;
import net.ums.tmdbapi.schema.movie.MovieExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieKeywordsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieReleaseDatesResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieShortResultsSchema;
import net.ums.tmdbapi.schema.movie.MovieTranslationsResponseSchema;
import net.ums.tmdbapi.schema.movie.MovieTypedResultsSchema;
import net.ums.tmdbapi.schema.reviews.ReviewsResponseSchema;
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
public class MovieIdEndpointTest extends BaseTestClass {

	static int MOVIE_ID = 1413;
	static String MOVIE_TITLE = "M. Butterfly";
	static String TEST_LANGUAGE = "fr-FR";
	static String MOVIE_TITLE_TEST_LANGUAGE = "M. Butterfly";
	static String MOVIE_OVERVIEW_TEST_LANGUAGE = "En Chine, dans les années 60";

	public MovieIdEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("MovieIdEndpoint getDetails");
		MovieDetailsSchema result = tmdb.movie(MOVIE_ID).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertEquals(result.getTitle(), MOVIE_TITLE, "Fail on title");
	}

	/**
	 * Test of getAlternativeTitles method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetAlternativeTitles() {
		System.out.println("MovieIdEndpoint getAlternativeTitles");
		MovieAlternativeTitlesResponseSchema result = tmdb.movie(MOVIE_ID).getAlternativeTitles();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getTitles(), "Titles is null");
	}

	/**
	 * Test of getChanges method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("MovieIdEndpoint getChanges");
		ChangesSchema result = tmdb.movie(MOVIE_ID).getChanges();
		assertParsedObject(result);
		assertNotNull(result.getChanges(), "Changes is null");
	}

	/**
	 * Test of getCredits method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetCredits() {
		System.out.println("MovieIdEndpoint getCredits");
		MediaCreditsResponseSchema result = tmdb.movie(MOVIE_ID).getCredits();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getCast(), "Cast is null");
		assertNotNull(result.getCrew(), "Crew is null");
	}

	/**
	 * Test of getExternalIds method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetExternalIds() {
		System.out.println("MovieIdEndpoint getExternalIds");
		MovieExternalIdsResponseSchema result = tmdb.movie(MOVIE_ID).getExternalIds();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
	}

	/**
	 * Test of getImages method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("MovieIdEndpoint getImages");
		ImagesResponseSchema result = tmdb.movie(MOVIE_ID).getImages();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getBackdrops(), "Backdrops is null");
		assertFalse(result.getBackdrops().isEmpty(), "Backdrops is empty");
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
	}

	/**
	 * Test of getKeywords method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetKeywords() {
		System.out.println("MovieIdEndpoint getKeywords");
		MovieKeywordsResponseSchema result = tmdb.movie(MOVIE_ID).getKeywords();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getKeywords(), "Keywords is null");
	}

	/**
	 * Test of getRecommendations method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetRecommendations() {
		System.out.println("MovieIdEndpoint getRecommendations");
		MovieTypedResultsSchema result = tmdb.movie(MOVIE_ID).getRecommendations();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getReleaseDates method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetReleaseDates() {
		System.out.println("MovieIdEndpoint getReleaseDates");
		MovieReleaseDatesResponseSchema result = tmdb.movie(MOVIE_ID).getReleaseDates();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getReviews method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetReviews() {
		System.out.println("MovieIdEndpoint getReviews");
		ReviewsResponseSchema result = tmdb.movie(MOVIE_ID).getReviews();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getSimilar method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetSimilar() {
		System.out.println("MovieIdEndpoint getSimilar");
		MovieShortResultsSchema result = tmdb.movie(MOVIE_ID).getSimilar();
		assertParsedObject(result);
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getTranslations method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("MovieIdEndpoint getTranslations");
		MovieTranslationsResponseSchema result = tmdb.movie(MOVIE_ID).getTranslations();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertFalse(result.getTranslations().isEmpty(), "Translations is empty");
	}

	/**
	 * Test of getVideos method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetVideos() {
		System.out.println("MovieIdEndpoint getVideos");
		VideosResponseSchema result = tmdb.movie(MOVIE_ID).getVideos();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of getWatchProviders method, of class MovieIdEndpoint.
	 */
	@Test
	public void testGetWatchProviders() {
		System.out.println("MovieIdEndpoint getWatchProviders");
		WatchProvidersResponseSchema result = tmdb.movie(MOVIE_ID).getWatchProviders();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getResults(), "Results is null");
	}

	/**
	 * Test of setLanguage method, of class MovieIdEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("MovieIdEndpoint setLanguage");
		MovieDetailsSchema result = tmdb.movie(MOVIE_ID).setLanguage(TEST_LANGUAGE).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertEquals(result.getTitle(), MOVIE_TITLE_TEST_LANGUAGE, "Movie title is not in asked language");
		assertTrue(result.getOverview().startsWith(MOVIE_OVERVIEW_TEST_LANGUAGE), "Movie overview is not in asked language");
	}

	/**
	 * Test of appendToResponse method, of class MovieIdEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("MovieIdEndpoint appendToResponse");
		MovieDetailsSchema result = tmdb.movie(MOVIE_ID)
				.appendToResponse(
						MovieIdAppendToResponse.ACCOUNT_STATES,
						MovieIdAppendToResponse.ALTERNATIVE_TITLES,
						MovieIdAppendToResponse.CHANGES,
						MovieIdAppendToResponse.CREDITS,
						MovieIdAppendToResponse.EXTERNAL_IDS,
						MovieIdAppendToResponse.IMAGES,
						MovieIdAppendToResponse.KEYWORDS,
						MovieIdAppendToResponse.LISTS,
						MovieIdAppendToResponse.RECOMMENDATIONS,
						MovieIdAppendToResponse.RELEASE_DATES,
						MovieIdAppendToResponse.REVIEWS,
						MovieIdAppendToResponse.SIMILAR,
						MovieIdAppendToResponse.TRANSLATIONS,
						MovieIdAppendToResponse.VIDEOS,
						MovieIdAppendToResponse.WATCH_PROVIDERS
				).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), MOVIE_ID, "Wrong Id");
		assertNotNull(result.getAlternativeTitles(), "Fail on AlternativeTitles");
		assertNotNull(result.getChanges(), "Fail on Changes");
		assertNotNull(result.getCredits(), "Fail on Credits");
		assertNotNull(result.getExternalIds(), "Fail on ExternalIds");
		assertNotNull(result.getImages(), "Fail on Images");
		assertNotNull(result.getKeywords(), "Fail on Keywords");
		assertNotNull(result.getRecommendations(), "Fail on Recommendations");
		assertNotNull(result.getReleaseDates(), "Fail on ReleaseDates");
		assertNotNull(result.getReviews(), "Fail on Reviews");
		assertNotNull(result.getSimilar(), "Fail on Similar");
		assertNotNull(result.getTranslations(), "Fail on Translations");
		assertNotNull(result.getVideos(), "Fail on Videos");
		assertNotNull(result.getWatchProviders(), "Fail on WatchProviders");
	}

}
