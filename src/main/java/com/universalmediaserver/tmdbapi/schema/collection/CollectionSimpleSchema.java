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
 * TMDb Collection Simple Schema.
 *
 * @author SurfaceS
 */
public class CollectionSimpleSchema extends CollectionBaseSchema {

	@SerializedName("adult")
	private Boolean adult;
	@SerializedName("original_language")
	private String originalLanguage;
	@SerializedName("original_name")
	private String originalName;
	@SerializedName("overview")
	private String overview;

	public Boolean getAdult() {
		return adult;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getOverview() {
		return overview;
	}

	public void setAdult(Boolean value) {
		this.adult = value;
	}

	public void setOriginalLanguage(String value) {
		this.originalLanguage = value;
	}

	public void setOriginalName(String value) {
		this.originalName = value;
	}

	public void setOverview(String value) {
		this.overview = value;
	}

}
