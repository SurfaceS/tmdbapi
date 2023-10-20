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
package com.universalmediaserver.tmdbapi.schema.collection;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Collection Details Schema.
 *
 * @author SurfaceS
 */
public class CollectionDetailsSchema extends CollectionSchema {

	@SerializedName("images")
	private CollectionImagesSchema images;
	@SerializedName("translations")
	private CollectionTranslationsSchema translations;

	public CollectionImagesSchema getImages() {
		return images;
	}

	public CollectionTranslationsSchema getTranslations() {
		return translations;
	}

	public void setImages(CollectionImagesSchema value) {
		this.images = value;
	}

	public void setTranslations(CollectionTranslationsSchema value) {
		this.translations = value;
	}

}
