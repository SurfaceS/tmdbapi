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
package com.universalmediaserver.tmdbapi.endpoint.collection;

import com.universalmediaserver.tmdbapi.BaseTestClass;
import com.universalmediaserver.tmdbapi.schema.collection.CollectionDetailsSchema;
import com.universalmediaserver.tmdbapi.schema.collection.CollectionImagesResponseSchema;
import com.universalmediaserver.tmdbapi.schema.collection.CollectionTranslationsResponseSchema;
import com.universalmediaserver.tmdbapi.schema.image.ImageLanguageSchema;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

/**
 * CollectionEndpoint Tests
 *
 * @author SurfaceS
 */
@EnabledIf(
		value = "haveTmdbReadAccess",
		disabledReason = BaseTestClass.TMDB_API_ENV_MISSING
)
public class CollectionEndpointTest extends BaseTestClass {

	public CollectionEndpointTest() {
	}

	/**
	 * Test of getDetails method, of class CollectionEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("CollectionEndpoint getDetails");
		CollectionDetailsSchema result = tmdb.collection(422837).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertEquals(result.getName(), "Blade Runner Collection");
	}

	/**
	 * Test of getImages method, of class CollectionEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("CollectionEndpoint getImages");
		CollectionImagesResponseSchema result = tmdb.collection(422837).getImages();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertNotNull(result.getBackdrops(), "Backdrops is null");
		assertFalse(result.getBackdrops().isEmpty(), "Backdrops is empty");
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
	}

	/**
	 * Test of getTranslations method, of class CollectionEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("CollectionEndpoint getTranslations");
		CollectionTranslationsResponseSchema result = tmdb.collection(422837).getTranslations();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertFalse(result.getTranslations().isEmpty(), "Translations is empty");
	}

	/**
	 * Test of setLanguage method, of class CollectionEndpoint.
	 */
	@Test
	public void testSetLanguage() {
		System.out.println("CollectionEndpoint setLanguage");
		CollectionDetailsSchema result = tmdb.collection(422837).setLanguage("fr").getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertEquals(result.getName(), "Blade Runner - Saga");
	}

	/**
	 * Test of appendToResponse method, of class CollectionEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("CollectionEndpoint appendToResponse");
		CollectionDetailsSchema result = tmdb.collection(422837)
				.appendToResponse(
						CollectionAppendToResponse.IMAGES,
						CollectionAppendToResponse.TRANSLATIONS
				).getDetails();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertNotNull(result.getImages(), "Images is null");
		assertNotNull(result.getImages().getBackdrops(), "Backdrops Images is null");
		assertFalse(result.getImages().getBackdrops().isEmpty(), "Backdrops Images is empty");
		assertNotNull(result.getImages().getPosters(), "Posters Images is null");
		assertFalse(result.getImages().getPosters().isEmpty(), "Posters Images is empty");
		assertNotNull(result.getTranslations(), "Translations is null");
		assertFalse(result.getTranslations().getTranslations().isEmpty(), "Translations Translations is empty");
	}

	/**
	 * Test of includeImageLanguage method, of class CollectionEndpoint.
	 */
	@Test
	public void testIncludeImageLanguage() {
		System.out.println("CollectionEndpoint includeImageLanguage");
		CollectionImagesResponseSchema result = tmdb.collection(422837).getImages();
		assertParsedObject(result);
		assertEquals(result.getId(), 422837, "Wrong Id");
		assertNotNull(result.getBackdrops(), "Backdrops is null");
		assertFalse(result.getBackdrops().isEmpty(), "Backdrops is empty");
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
		int allPosterCount = result.getPosters().size();
		result = tmdb.collection(422837).setLanguage("pl").getImages();
		assertParsedObject(result);
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
		int onePosterCount = result.getPosters().size();
		//should find only pl language.
		for (ImageLanguageSchema poster : result.getPosters()) {
			assertEquals(poster.getIso639Part1(), "pl");
		}
		result = tmdb.collection(422837).setLanguage("pl").includeImageLanguage("en", "null").getImages();
		assertParsedObject(result);
		assertNotNull(result.getPosters(), "Posters is null");
		assertFalse(result.getPosters().isEmpty(), "Posters is empty");
		int multiPosterCount = result.getPosters().size();
		assertTrue(onePosterCount < allPosterCount);
		assertTrue(onePosterCount < multiPosterCount);
		assertTrue(multiPosterCount < allPosterCount);
		//pl language should be overrided.
		for (ImageLanguageSchema poster : result.getPosters()) {
			assertNotEquals(poster.getIso639Part1(), "pl");
		}
	}

}
