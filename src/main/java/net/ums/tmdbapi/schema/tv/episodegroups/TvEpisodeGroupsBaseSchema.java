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
import net.ums.tmdbapi.schema.network.NetworkBaseSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Tv Episode Groups Base schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeGroupsBaseSchema extends StringIdNameSchema {

	@SerializedName("description")
	private String description;
	@SerializedName("episode_count")
	private Long episodeCount;
	@SerializedName("group_count")
	private Long groupCount;
	@SerializedName("network")
	private NetworkBaseSchema network;
	@SerializedName("type")
	private Long type;

	public String getDescription() {
		return description;
	}

	public Long getEpisodeCount() {
		return episodeCount;
	}

	public Long getGroupCount() {
		return groupCount;
	}

	public NetworkBaseSchema getNetwork() {
		return network;
	}

	public Long getType() {
		return type;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public void setEpisodeCount(Long value) {
		this.episodeCount = value;
	}

	public void setGroupCount(Long value) {
		this.groupCount = value;
	}

	public void setNetwork(NetworkBaseSchema value) {
		this.network = value;
	}

	public void setType(Long value) {
		this.type = value;
	}

}
