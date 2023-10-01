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
package net.ums.tmdbapi.schema.tv.episodegroups;

import net.ums.tmdbapi.schema.StringIdNameSchema;
import net.ums.tmdbapi.schema.tv.episode.TvEpisodeOrderedSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Tv Episode Group schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeGroupSchema extends StringIdNameSchema {

	@SerializedName("episodes")
	private List<TvEpisodeOrderedSchema> episodes;
	@SerializedName("order")
	private Long order;
	@SerializedName("locked")
	private Boolean locked;

	public List<TvEpisodeOrderedSchema> getEpisodes() {
		return episodes;
	}

	public Long getOrder() {
		return order;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setEpisodes(List<TvEpisodeOrderedSchema> value) {
		this.episodes = value;
	}

	public void setOrder(Long value) {
		this.order = value;
	}

	public void setLocked(Boolean value) {
		this.locked = value;
	}

}
