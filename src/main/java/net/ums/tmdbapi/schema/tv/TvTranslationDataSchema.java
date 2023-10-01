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
package net.ums.tmdbapi.schema.tv;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Show Translation Data Schema.
 *
 * @author SurfaceS
 */
public class TvTranslationDataSchema {

	@SerializedName("homepage")
	private String homepage;
	@SerializedName("name")
	private String name;
	@SerializedName("overview")
	private String overview;
	@SerializedName("tagline")
	private String tagline;

	public String getHomepage() {
		return homepage;
	}

	public String getName() {
		return name;
	}

	public String getOverview() {
		return overview;
	}

	public String getTagline() {
		return tagline;
	}

	public void setHomepage(String value) {
		this.homepage = value;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setOverview(String value) {
		this.overview = value;
	}

	public void setTagline(String value) {
		this.tagline = value;
	}

}
