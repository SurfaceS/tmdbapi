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

import net.ums.tmdbapi.schema.IntegerIdNameSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Person Base Schema.
 *
 * @author SurfaceS
 */
public class PersonBaseSchema extends IntegerIdNameSchema {

	@SerializedName("adult")
	private Boolean adult;
	@SerializedName("gender")
	private Long gender;
	@SerializedName("known_for_department")
	private String knownForDepartment;
	@SerializedName("popularity")
	private Double popularity;
	@SerializedName("profile_path")
	private String profilePath;

	public boolean getAdult() {
		return adult;
	}

	public Long getGender() {
		return gender;
	}

	public String getKnownForDepartment() {
		return knownForDepartment;
	}

	public double getPopularity() {
		return popularity;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setAdult(boolean value) {
		this.adult = value;
	}

	public void setGender(Long value) {
		this.gender = value;
	}

	public void setKnownForDepartment(String value) {
		this.knownForDepartment = value;
	}

	public void setPopularity(Double value) {
		this.popularity = value;
	}

	public void setProfilePath(String value) {
		this.profilePath = value;
	}

}
