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
package com.universalmediaserver.tmdbapi.schema.movie;

import com.google.gson.annotations.SerializedName;
import com.universalmediaserver.tmdbapi.schema.PagedResultsSchema;
import com.universalmediaserver.tmdbapi.schema.list.ListV3SimpleSchema;
import java.util.List;

/**
 * TMDb Movie List Schema.
 *
 * @author SurfaceS
 */
public class MovieListsSchema extends PagedResultsSchema {

	@SerializedName("results")
	private List<ListV3SimpleSchema> results;

	public List<ListV3SimpleSchema> getResults() {
		return results;
	}

	public void setResults(List<ListV3SimpleSchema> value) {
		this.results = value;
	}

}
