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
package com.universalmediaserver.tmdbapi.schema.watchproviders;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.country.CountrySchema;
import java.util.List;

/**
 * TMDb Watch Provider Regions Response Schema.
 *
 * @author SurfaceS
 */
public class WatchProviderRegionsResponseSchema {

	@SerializedName("results")
	private List<CountrySchema> results;

	public List<CountrySchema> getResults() {
		return results;
	}

	public void setResults(List<CountrySchema> value) {
		this.results = value;
	}

}
