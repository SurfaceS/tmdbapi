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
package net.ums.tmdbapi.schema.tv.episode;

import net.ums.tmdbapi.schema.IntegerIdSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Episode Base Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeBaseSchema extends IntegerIdSchema {

	@SerializedName("episode_number")
	private Long episodeNumber;
	@SerializedName("season_number")
	private Long seasonNumber;

	public Long getEpisodeNumber() {
		return episodeNumber;
	}

	public Long getSeasonNumber() {
		return seasonNumber;
	}

	public void setEpisodeNumber(Long value) {
		this.episodeNumber = value;
	}

	public void setSeasonNumber(Long value) {
		this.seasonNumber = value;
	}

}
