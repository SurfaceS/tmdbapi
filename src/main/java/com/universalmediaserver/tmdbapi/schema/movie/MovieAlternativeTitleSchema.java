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
package com.universalmediaserver.tmdbapi.schema.movie;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Movie Alternative Title Schema.
 *
 * @author SurfaceS
 */
public class MovieAlternativeTitleSchema {

	@SerializedName("iso_3166_1")
	private String iso3166Part1;
	@SerializedName("title")
	private String title;
	@SerializedName("type")
	private String type;

	public String getIso3166Part1() {
		return iso3166Part1;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public void setIso3166Part1(String value) {
		this.iso3166Part1 = value;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public void setType(String value) {
		this.type = value;
	}

}
