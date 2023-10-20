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
package com.universalmediaserver.tmdbapi.schema.tv.episode;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Episode Simple Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeSimpleSchema extends TvEpisodeShortSchema {

	@SerializedName("episode_type")
	private String episodeType;

	@SerializedName("show_id")
	private Long showId;

	public String getEpisodeType() {
		return episodeType;
	}

	public Long getShowId() {
		return showId;
	}

	public void setEpisodeType(String value) {
		this.episodeType = value;
	}

	public void setShowId(Long value) {
		this.showId = value;
	}

}
