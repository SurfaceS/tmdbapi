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
package net.ums.tmdbapi.schema.collection;

import net.ums.tmdbapi.schema.image.ImageLanguageSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Collection Images Schema.
 *
 * @author SurfaceS
 */
public class CollectionImagesSchema {

	@SerializedName("backdrops")
	private List<ImageLanguageSchema> backdrops;
	@SerializedName("posters")
	private List<ImageLanguageSchema> posters;

	public List<ImageLanguageSchema> getBackdrops() {
		return backdrops;
	}

	public List<ImageLanguageSchema> getPosters() {
		return posters;
	}

	public void setBackdrops(List<ImageLanguageSchema> value) {
		this.backdrops = value;
	}

	public void setPosters(List<ImageLanguageSchema> value) {
		this.posters = value;
	}

}
