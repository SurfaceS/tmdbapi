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
package net.ums.tmdbapi.schema.reviews;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Review Author Details Schema.
 *
 * @author SurfaceS
 */
public class ReviewAuthorDetailsSchema {

	@SerializedName("avatar_path")
	private String avatarPath;
	@SerializedName("name")
	private String name;
	@SerializedName("rating")
	private Long rating;
	@SerializedName("username")
	private String username;

	public String getAvatarPath() {
		return avatarPath;
	}

	public String getName() {
		return name;
	}

	public Long getRating() {
		return rating;
	}

	public String getUsername() {
		return username;
	}

	public void setAvatarPath(String value) {
		this.avatarPath = value;
	}

	public void setName(String value) {
		this.name = value;
	}

	public void setRating(Long value) {
		this.rating = value;
	}

	public void setUsername(String value) {
		this.username = value;
	}

}
