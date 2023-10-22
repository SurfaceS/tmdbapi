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
package com.universalmediaserver.tmdbapi.schema.country;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Country Schema.
 *
 * @author SurfaceS
 */
public class CountrySchema {

	@SerializedName("english_name")
	private String englishName;
	@SerializedName("iso_3166_1")
	private String iso3166Part1;
	@SerializedName("native_name")
	private String nativeName;

	public String getEnglishName() {
		return englishName;
	}

	public String getIso3166Part1() {
		return iso3166Part1;
	}

	public String getNativeName() {
		return nativeName;
	}

	public void setEnglishName(String value) {
		this.englishName = value;
	}

	public void setIso3166Part1(String value) {
		this.iso3166Part1 = value;
	}

	public void setNativeName(String value) {
		this.nativeName = value;
	}

}
