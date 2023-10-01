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

import net.ums.tmdbapi.schema.person.PersonRoleCreditSchema;
import net.ums.tmdbapi.schema.person.PersonJobCreditSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * TMDb Tv Episode Schema.
 *
 * @author SurfaceS
 */
public class TvEpisodeSchema extends TvEpisodeShortSchema {

	@SerializedName("crew")
	private List<PersonJobCreditSchema> crew;
	@SerializedName("guest_stars")
	private List<PersonRoleCreditSchema> guestStars;

	public List<PersonJobCreditSchema> getCrew() {
		return crew;
	}

	public List<PersonRoleCreditSchema> getGuestStars() {
		return guestStars;
	}

	public void setCrew(List<PersonJobCreditSchema> value) {
		this.crew = value;
	}

	public void setGuestStars(List<PersonRoleCreditSchema> value) {
		this.guestStars = value;
	}

}
