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
package com.universalmediaserver.tmdbapi.schema.person;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.IntegerIdNameSchema;

/**
 * TMDb Creator Schema.
 *
 * @author SurfaceS
 */
public class CreatorSchema extends IntegerIdNameSchema {

	@SerializedName("credit_id")
	private String creditId;
	@SerializedName("gender")
	private Long gender;
	@SerializedName("original_name")
	private String originalName;
	@SerializedName("profile_path")
	private String profilePath;

	public String getCreditId() {
		return creditId;
	}

	public Long getGender() {
		return gender;
	}

	public String getOriginalName() {
		return originalName;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setCreditId(String value) {
		this.creditId = value;
	}

	public void setGender(Long value) {
		this.gender = value;
	}

	public void setOriginalName(String value) {
		this.originalName = value;
	}

	public void setProfilePath(String value) {
		this.profilePath = value;
	}

}
