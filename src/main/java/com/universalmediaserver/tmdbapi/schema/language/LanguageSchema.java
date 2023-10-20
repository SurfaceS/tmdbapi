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
package com.universalmediaserver.tmdbapi.schema.language;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Language Schema.
 *
 * @author SurfaceS
 */
public class LanguageSchema {

	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("english_name")
	private String englishName;
	@SerializedName("name")
	private String name;

	public String getEnglishName() {
		return englishName;
	}

	public String getIso639Part1() {
		return iso639Part1;
	}

	public String getName() {
		return name;
	}

	public void setEnglishName(String value) {
		this.englishName = value;
	}

	public void setIso639Part1(String value) {
		this.iso639Part1 = value;
	}

	public void setName(String value) {
		this.name = value;
	}

}
