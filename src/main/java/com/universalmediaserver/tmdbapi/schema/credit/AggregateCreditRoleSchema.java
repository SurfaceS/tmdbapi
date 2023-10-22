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
package com.universalmediaserver.tmdbapi.schema.credit;

import com.google.gson.annotations.SerializedName;

/**
 * TMDb AggregateCredit Role Schema.
 *
 * @author SurfaceS
 */
public class AggregateCreditRoleSchema {

	@SerializedName("character")
	private String character;
	@SerializedName("credit_id")
	private String creditId;
	@SerializedName("episode_count")
	private Long episodeCount;

	public String getCharacter() {
		return character;
	}

	public String getCreditId() {
		return creditId;
	}

	public Long getEpisodeCount() {
		return episodeCount;
	}

	public void setCharacter(String value) {
		this.character = value;
	}

	public void setCreditId(String value) {
		this.creditId = value;
	}

	public void setEpisodeCount(Long value) {
		this.episodeCount = value;
	}

}
