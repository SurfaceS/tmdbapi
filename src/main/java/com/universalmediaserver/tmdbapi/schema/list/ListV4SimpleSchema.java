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
package com.universalmediaserver.tmdbapi.schema.list;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.IntegerIdNameSchema;

/**
 * TMDb List V4 Simple Schema.
 *
 * @author SurfaceS
 */
public class ListV4SimpleSchema extends IntegerIdNameSchema {

	@SerializedName("account_object_id")
	private String accountObjectId;
	@SerializedName("description")
	private String description;
	@SerializedName("number_of_items")
	private Long numberOfItems;
	@SerializedName("iso_639_1")
	private String iso639Part1;
	@SerializedName("featured")
	private Long featured;
	@SerializedName("revenue")
	private String revenue;
	@SerializedName("public")
	private Long isPublic;
	@SerializedName("updated_at")
	private String updatedAt;
	@SerializedName("created_at")
	private String createdAt;
	@SerializedName("sort_by")
	private Long sortBy;
	@SerializedName("backdrop_path")
	private String backdropPath;
	@SerializedName("runtime")
	private Long runtime;
	@SerializedName("average_rating")
	private Long averageRating;
	@SerializedName("iso_3166_1")
	private String iso3166Part1;
	@SerializedName("adult")
	private Long adult;
	@SerializedName("poster_path")
	private String posterPath;

	public String getAccountObjectId() {
		return accountObjectId;
	}

	public String getDescription() {
		return description;
	}

	public Long getNumberOfItems() {
		return numberOfItems;
	}

	public String getIso639Part1() {
		return iso639Part1;
	}

	public Long getFeatured() {
		return featured;
	}

	public String getRevenue() {
		return revenue;
	}

	public Long getIsPublic() {
		return isPublic;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Long getSortBy() {
		return sortBy;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Long getRuntime() {
		return runtime;
	}

	public Long getAverageRating() {
		return averageRating;
	}

	public String getIso3166Part1() {
		return iso3166Part1;
	}

	public Long getAdult() {
		return adult;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setAccountObjectId(String accountObjectId) {
		this.accountObjectId = accountObjectId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNumberOfItems(Long numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public void setIso639Part1(String iso639Part1) {
		this.iso639Part1 = iso639Part1;
	}

	public void setFeatured(Long featured) {
		this.featured = featured;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public void setIsPublic(Long isPublic) {
		this.isPublic = isPublic;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public void setSortBy(Long sortBy) {
		this.sortBy = sortBy;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public void setRuntime(Long runtime) {
		this.runtime = runtime;
	}

	public void setAverageRating(Long averageRating) {
		this.averageRating = averageRating;
	}

	public void setIso3166Part1(String iso3166Part1) {
		this.iso3166Part1 = iso3166Part1;
	}

	public void setAdult(Long adult) {
		this.adult = adult;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

}
