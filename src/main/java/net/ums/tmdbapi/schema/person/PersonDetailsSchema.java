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
package net.ums.tmdbapi.schema.person;

import net.ums.tmdbapi.schema.change.ChangesSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Person Schema.
 *
 * @author SurfaceS
 */
public class PersonDetailsSchema extends PersonSchema {

	@SerializedName("changes")
	private ChangesSchema changes;
	@SerializedName("combined_credits")
	private PersonCombinedCreditsSchema combinedCredits;
	@SerializedName("external_ids")
	private PersonExternalIdsSchema externalIds;
	@SerializedName("images")
	private PersonImagesSchema images;
	@SerializedName("movie_credits")
	private PersonMovieCreditsSchema movieCredits;
	@SerializedName("tagged_images")
	private PersonTaggedImagesResultsSchema taggedImages;
	@SerializedName("translations")
	private PersonTranslationsSchema translations;
	@SerializedName("tv_credits")
	private PersonTvCreditsSchema tvCredits;

	public ChangesSchema getChanges() {
		return changes;
	}

	public PersonCombinedCreditsSchema getCombinedCredits() {
		return combinedCredits;
	}

	public PersonExternalIdsSchema getExternalIds() {
		return externalIds;
	}

	public PersonImagesSchema getImages() {
		return images;
	}

	public PersonMovieCreditsSchema getMovieCredits() {
		return movieCredits;
	}

	public PersonTaggedImagesResultsSchema getTaggedImages() {
		return taggedImages;
	}

	public PersonTranslationsSchema getTranslations() {
		return translations;
	}

	public PersonTvCreditsSchema getTvCredits() {
		return tvCredits;
	}

	public void setChanges(ChangesSchema value) {
		this.changes = value;
	}

	public void setCombinedCredits(PersonCombinedCreditsSchema value) {
		this.combinedCredits = value;
	}

	public void setExternalIds(PersonExternalIdsSchema value) {
		this.externalIds = value;
	}

	public void setImages(PersonImagesSchema value) {
		this.images = value;
	}

	public void setMovieCredits(PersonMovieCreditsSchema value) {
		this.movieCredits = value;
	}

	public void setTaggedImages(PersonTaggedImagesResultsSchema value) {
		this.taggedImages = value;
	}

	public void setTranslations(PersonTranslationsSchema value) {
		this.translations = value;
	}

	public void setTvCredits(PersonTvCreditsSchema value) {
		this.tvCredits = value;
	}

}
