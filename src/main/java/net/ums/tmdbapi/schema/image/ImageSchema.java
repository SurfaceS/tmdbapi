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
package net.ums.tmdbapi.schema.image;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Image Schema.
 *
 * @author SurfaceS
 */
public class ImageSchema {

	@SerializedName("aspect_ratio")
	private Double aspectRatio;
	@SerializedName("file_path")
	private String filePath;
	@SerializedName("height")
	private Long height;
	@SerializedName("vote_average")
	private Double voteAverage;
	@SerializedName("vote_count")
	private Long voteCount;
	@SerializedName("width")
	private Long width;

	public Double getAspectRatio() {
		return aspectRatio;
	}

	public String getFilePath() {
		return filePath;
	}

	public Long getHeight() {
		return height;
	}

	public Double getVoteAverage() {
		return voteAverage;
	}

	public Long getVoteCount() {
		return voteCount;
	}

	public Long getWidth() {
		return width;
	}

	public void setAspectRatio(Double value) {
		this.aspectRatio = value;
	}

	public void setFilePath(String value) {
		this.filePath = value;
	}

	public void setHeight(Long value) {
		this.height = value;
	}

	public void setVoteAverage(Double value) {
		this.voteAverage = value;
	}

	public void setVoteCount(Long value) {
		this.voteCount = value;
	}

	public void setWidth(Long value) {
		this.width = value;
	}

}
