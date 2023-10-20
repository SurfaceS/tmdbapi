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
package com.universalmediaserver.tmdbapi.schema.tv;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.media.MediaTypeInterface;
import com.universalmediaserver.tmdbapi.schema.tv.episode.TvEpisodeSimpleSchema;
import com.universalmediaserver.tmdbapi.schema.tv.season.TvSeasonSimpleSchema;
import java.util.List;

/**
 * TMDb Tv Typed schema.
 *
 * @author SurfaceS
 */
public class TvPlainSchema extends TvTypedSchema implements MediaTypeInterface {

	@SerializedName("episodes")
	private List<TvEpisodeSimpleSchema> episodes;
	@SerializedName("seasons")
	private List<TvSeasonSimpleSchema> seasons;

	public List<TvEpisodeSimpleSchema> getEpisodes() {
		return episodes;
	}

	public List<TvSeasonSimpleSchema> getSeasons() {
		return seasons;
	}

	public void setEpisodes(List<TvEpisodeSimpleSchema> value) {
		this.episodes = value;
	}

	public void setSeasons(List<TvSeasonSimpleSchema> value) {
		this.seasons = value;
	}

}
