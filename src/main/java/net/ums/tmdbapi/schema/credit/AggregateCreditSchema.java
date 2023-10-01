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
package net.ums.tmdbapi.schema.credit;

import net.ums.tmdbapi.schema.person.PersonShortSchema;
import com.google.gson.annotations.SerializedName;

/**
 * TMDb Aggregate Credit Schema.
 *
 * @author SurfaceS
 */
public class AggregateCreditSchema extends PersonShortSchema {

	@SerializedName("total_episode_count")
	private Long totalEpisodeCount;

	public Long getTotalEpisodeCount() {
		return totalEpisodeCount;
	}

	public void setTotalEpisodeCount(Long value) {
		this.totalEpisodeCount = value;
	}

}
