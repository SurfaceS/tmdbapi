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

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Person Schema.
 *
 * @author SurfaceS
 */
public class PersonSchema extends PersonBaseSchema {

	@SerializedName("also_known_as")
	private List<String> alsoKnownAs;
	@SerializedName("biography")
	private String biography;
	@SerializedName("birthday")
	private String birthday;
	@SerializedName("deathday")
	private String deathday;
	@SerializedName("homepage")
	private String homepage;
	@SerializedName("imdb_id")
	private String imdbId;
	@SerializedName("place_of_birth")
	private String placeOfBirth;

	public List<String> getAlsoKnownAs() {
		return alsoKnownAs;
	}

	public String getBiography() {
		return biography;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getDeathday() {
		return deathday;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getImdbId() {
		return imdbId;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setAlsoKnownAs(List<String> value) {
		this.alsoKnownAs = value;
	}

	public void setBiography(String value) {
		this.biography = value;
	}

	public void setBirthday(String value) {
		this.birthday = value;
	}

	public void setDeathday(String value) {
		this.deathday = value;
	}

	public void setHomepage(String value) {
		this.homepage = value;
	}

	public void setImdbId(String value) {
		this.imdbId = value;
	}

	public void setPlaceOfBirth(String value) {
		this.placeOfBirth = value;
	}

}
