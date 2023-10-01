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
package net.ums.tmdbapi.endpoint.person;

import net.ums.tmdbapi.BaseTestClass;
import net.ums.tmdbapi.schema.change.ChangesSchema;
import net.ums.tmdbapi.schema.person.PersonCombinedCreditsResponseSchema;
import net.ums.tmdbapi.schema.person.PersonDetailsSchema;
import net.ums.tmdbapi.schema.person.PersonExternalIdsResponseSchema;
import net.ums.tmdbapi.schema.person.PersonImagesResponseSchema;
import net.ums.tmdbapi.schema.person.PersonMovieCreditsResponseSchema;
import net.ums.tmdbapi.schema.person.PersonTaggedImagesResponseSchema;
import net.ums.tmdbapi.schema.person.PersonTranslationsResponseSchema;
import net.ums.tmdbapi.schema.person.PersonTvCreditsResponseSchema;
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
public class PersonIdEndpointTest extends BaseTestClass {

	static int PERSON_ID = 287;

	public PersonIdEndpointTest() {
	}

	/**
	 * Test of PersonIdEndpoint method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetDetails() {
		System.out.println("PersonIdEndpoint PersonIdEndpoint");
		PersonDetailsSchema result = tmdb.person(PERSON_ID).getDetails();
		assertParsedObject(result);
	}

	/**
	 * Test of getChanges method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetChanges() {
		System.out.println("PersonIdEndpoint getChanges");
		ChangesSchema result = tmdb.person(PERSON_ID).getChanges();
		assertParsedObject(result);
	}

	/**
	 * Test of getCombinedCredits method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetCombinedCredits() {
		System.out.println("PersonIdEndpoint getCombinedCredits");
		PersonCombinedCreditsResponseSchema result = tmdb.person(PERSON_ID).getCombinedCredits();
		assertParsedObject(result);
	}

	/**
	 * Test of getExternalIds method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetExternalIds() {
		System.out.println("PersonIdEndpoint getExternalIds");
		PersonExternalIdsResponseSchema result = tmdb.person(PERSON_ID).getExternalIds();
		assertParsedObject(result);
	}

	/**
	 * Test of getImages method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetImages() {
		System.out.println("PersonIdEndpoint getImages");
		PersonImagesResponseSchema result = tmdb.person(PERSON_ID).getImages();
		assertParsedObject(result);
	}

	/**
	 * Test of getMovieCredits method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetMovieCredits() {
		System.out.println("PersonIdEndpoint getMovieCredits");
		PersonMovieCreditsResponseSchema result = tmdb.person(PERSON_ID).getMovieCredits();
		assertParsedObject(result);
	}

	/**
	 * Test of getTaggedImages method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetTaggedImages() {
		System.out.println("PersonIdEndpoint getTaggedImages");
		PersonTaggedImagesResponseSchema result = tmdb.person(PERSON_ID).getTaggedImages();
		assertParsedObject(result);
	}

	/**
	 * Test of getTranslations method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetTranslations() {
		System.out.println("PersonIdEndpoint getTranslations");
		PersonTranslationsResponseSchema result = tmdb.person(PERSON_ID).getTranslations();
		assertParsedObject(result);
	}

	/**
	 * Test of getTvCredits method, of class PersonIdEndpoint.
	 */
	@Test
	public void testGetTvCredits() {
		System.out.println("PersonIdEndpoint getTvCredits");
		PersonTvCreditsResponseSchema result = tmdb.person(PERSON_ID).getTvCredits();
		assertParsedObject(result);
	}

	/**
	 * Test of appendToResponse method, of class PersonIdEndpoint.
	 */
	@Test
	public void testAppendToResponse() {
		System.out.println("PersonIdEndpoint appendToResponse");
		PersonDetailsSchema result = tmdb.person(PERSON_ID)
				.appendToResponse(
						PersonIdAppendToResponse.CHANGES,
						PersonIdAppendToResponse.COMBINED_CREDITS,
						PersonIdAppendToResponse.EXTERNAL_IDS,
						PersonIdAppendToResponse.IMAGES,
						PersonIdAppendToResponse.MOVIE_CREDITS,
						PersonIdAppendToResponse.TAGGED_IMAGES,
						PersonIdAppendToResponse.TRANSLATIONS,
						PersonIdAppendToResponse.TV_CREDITS
				).getDetails();
		assertParsedObject(result);
	}

}
