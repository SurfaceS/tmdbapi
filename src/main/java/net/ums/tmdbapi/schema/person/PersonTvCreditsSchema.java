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
package net.ums.tmdbapi.schema.person;

import net.ums.tmdbapi.schema.tv.TvJobCreditedSchema;
import net.ums.tmdbapi.schema.tv.TvRoleCreditedSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Person Tv Credits Schema.
 *
 * @author SurfaceS
 */
public class PersonTvCreditsSchema {

	@SerializedName("cast")
	private List<TvRoleCreditedSchema> cast;
	@SerializedName("crew")
	private List<TvJobCreditedSchema> crew;

	public List<TvRoleCreditedSchema> getCast() {
		return cast;
	}

	public List<TvJobCreditedSchema> getCrew() {
		return crew;
	}

	public void setCast(List<TvRoleCreditedSchema> value) {
		this.cast = value;
	}

	public void setCrew(List<TvJobCreditedSchema> value) {
		this.crew = value;
	}

}
