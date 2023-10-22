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
package com.universalmediaserver.tmdbapi.schema.reviews;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.StringIdSchema;

/**
 * TMDb Review Base Schema.
 *
 * @author SurfaceS
 */
public class ReviewBaseSchema extends StringIdSchema {

	@SerializedName("author")
	private String author;
	@SerializedName("author_details")
	private ReviewAuthorDetailsSchema authorDetails;
	@SerializedName("content")
	private String content;
	@SerializedName("created_at")
	private String createdAt;
	@SerializedName("updated_at")
	private String updatedAt;
	@SerializedName("url")
	private String url;

	public String getAuthor() {
		return author;
	}

	public ReviewAuthorDetailsSchema getAuthorDetails() {
		return authorDetails;
	}

	public String getContent() {
		return content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String value) {
		this.url = value;
	}

	public void setAuthor(String value) {
		this.author = value;
	}

	public void setAuthorDetails(ReviewAuthorDetailsSchema value) {
		this.authorDetails = value;
	}

	public void setContent(String value) {
		this.content = value;
	}

	public void setCreatedAt(String value) {
		this.createdAt = value;
	}

	public void setUpdatedAt(String value) {
		this.updatedAt = value;
	}

}
